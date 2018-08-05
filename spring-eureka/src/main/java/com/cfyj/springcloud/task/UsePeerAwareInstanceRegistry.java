package com.cfyj.springcloud.task;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.shared.Application;
import com.netflix.eureka.registry.PeerAwareInstanceRegistry;

//@Component
public class UsePeerAwareInstanceRegistry {

	private Logger log = Logger.getLogger(UsePeerAwareInstanceRegistry.class);

	private static int num = 0;

	@Autowired
	PeerAwareInstanceRegistry peerAwareInstanceRegistry;

	@Scheduled(fixedRate=25000)
	public void test1() {
		log.info("开始执行定时任务:" + (++num));
		// peerAwareInstanceRegistry.clearRegistry();
		// peerAwareInstanceRegistry.getSortedApplications()

		List<Application> appList = peerAwareInstanceRegistry.getSortedApplications();
		peerAwareInstanceRegistry.clearRegistry();
		
		for (Application application : appList) {

			List<InstanceInfo> appInfos = application.getInstances();

			int size = appInfos.size();
			for (int i = 0; i < size; i++) {
				InstanceInfo instanceInfo = appInfos.get(i);
				
				 String appName = instanceInfo.getAppName();
				log.info(i+"-------------getAppName:"+appName);
				
				long renewalTimestamp = instanceInfo.getLeaseInfo().getRenewalTimestamp();
//
//				if (System.currentTimeMillis() - renewalTimestamp > 15000) {
					application.removeInstance(instanceInfo);
//					peerAwareInstanceRegistry.cancel(application.getName(), instanceInfo.getId(), false);
					log.warn("移出应用实例：" + application.getName() + ":" + instanceInfo.getId() + "--距离上次心跳时间差为:"
							+ ((System.currentTimeMillis() - renewalTimestamp) / 1000) + "s");
//				}
			}

		}

		log.info("结束执行定时任务:");

	}

}
