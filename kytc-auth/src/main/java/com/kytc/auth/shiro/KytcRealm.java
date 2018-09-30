package com.kytc.auth.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.kytc.common.shiro.SessionUtils;
import com.kytc.entity.base.LoginEntity;
import com.kytc.model.ResultModel;
import com.kytc.model.base.UserLoginModel;
import com.kytc.service.base.ILoginService;

public class KytcRealm extends AuthorizingRealm{
	private ILoginService loginService;
	public ILoginService getLoginService() {
		return loginService;
	}
	@Autowired
	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
	    return null;  
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		// TODO Auto-generated method stub
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken; 
		LoginEntity entity = new LoginEntity();
		entity.setPassword(String.valueOf(token.getPassword()));
		entity.setUserName(token.getUsername());
        ResultModel<UserLoginModel> result = loginService.login(entity);
        if(!result.getState()){
        	SessionUtils.setSession("loginError", result.getReason());
        	throw new UnknownAccountException();
        }
        SessionUtils.setSession("user", result.getData());
        return new SimpleAuthenticationInfo(entity.getUserName(),  
        		String.valueOf(token.getPassword()), getName());  
		/*return new SimpleAuthenticationInfo(token.getUsername(),  
				String.valueOf(token.getPassword()), getName());*/
	}
	public void clearCachedAuthorizationInfo(String principal) {  
        SimplePrincipalCollection principals = new SimplePrincipalCollection(  
                principal, getName());  
        clearCachedAuthorizationInfo(principals);  
    }  
}
