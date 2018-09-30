package com.kytc.system.quartz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.kytc.service.base.IUserPremissionService;

@Component
public class PremissionTask {
	@Autowired
	private IUserPremissionService userPremissionService;
	@Scheduled(cron = "0 0/1 * * * *")   
    public void show(){  
        System.out.println("正在同步权限中...");
        userPremissionService.syncUserPremissions();
    }  
}
