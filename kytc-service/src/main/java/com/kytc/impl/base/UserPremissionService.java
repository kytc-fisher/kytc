package com.kytc.impl.base;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kytc.common.RedisService;
import com.kytc.dao.base.UserPremissionDao;
import com.kytc.service.base.IUserPremissionService;
@Service("userPremissionService")
public class UserPremissionService implements IUserPremissionService {
	@Autowired
	private UserPremissionDao userPremissionDao;
	@Autowired
	private RedisService redisService;
	private String USER_PREMISSION_KEY = "user:{0}:premission";
	@Override
	public void syncUserPremissions() {
		// TODO Auto-generated method stub
		Integer page = 0;
		Integer pageSize = 15;
		List<Map<String,Object>> list = null;
		while((list = userPremissionDao.getAllUserPremissions(page*pageSize, pageSize))!=null){
			if(list!=null&&list.size()>0){
				for(Map<String,Object> map:list){
					String id = map.get("id")+"";
					String premission = ""+map.get("premission");
					redisService.del(MessageFormat.format(USER_PREMISSION_KEY, id));
					redisService.sadd(MessageFormat.format(USER_PREMISSION_KEY, id), premission.split(","));
				}
				page++;
			}else{
				return;
			}
		}
	}

}
