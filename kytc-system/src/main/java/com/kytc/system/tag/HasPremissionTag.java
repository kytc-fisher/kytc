package com.kytc.system.tag;

import java.text.MessageFormat;

import javax.annotation.Resource;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.kytc.common.RedisService;
import com.kytc.system.shiro.SessionUtils;
@Resource(name="hasPremissionTag")
@Component
public class HasPremissionTag extends TagSupport {
	/**
	 * 
	 */
	private String USER_PREMISSION_KEY = "user:{0}:premission";
	private RedisService redisService;
	public RedisService getRedisService() {
		return redisService;
	}
	@Autowired
	public void setRedisService(RedisService redisService) {
		this.redisService = redisService;
	}
	private static final long serialVersionUID = -1403333615105548710L;
	private String premission;
    public String getPremission() {
		return premission;
	}
	public void setPremission(String premission) {
		this.premission = premission;
	}
	public int doStartTag() throws JspException {
		ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(pageContext.getServletContext());
		redisService = (RedisService) ac.getBean("redisService");
    	if(SessionUtils.getLoginUser().getUserName().equals("admin")||redisService.sismember(MessageFormat.format(USER_PREMISSION_KEY, SessionUtils.getUserId()), premission)){
    		return EVAL_PAGE;
    	}
    	return  SKIP_BODY;
    }
}
