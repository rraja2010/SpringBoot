package com.threadPool.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.threadPool.component.ThreadPoolComponent;

@Component("SpringBootScheduler")
public class SpringBootScheduler {
	
	@Value("${credit.delaytime}")
	String creditDelayTime;
	
	@Value("${credit.initialWaitTime}")
	String creditInitialWaitTime;
	
	@Autowired
	private ThreadPoolComponent theadPoolComponent;
	
	@Scheduled(fixedDelayString="${debit.delaytime}", initialDelayString="${debit.initialWaitTime}")
	public void debitScheduler(){
		theadPoolComponent.debitDeatils();
	}
	
	@Scheduled(fixedDelayString="${credit.delaytime}", initialDelayString="${credit.initialWaitTime}")
	public void creditScheduler(){
		System.out.println("Delay Time : "+creditDelayTime + " InitialWaitTime : "+creditInitialWaitTime);
		theadPoolComponent.creditDeatils();
	}
	
}