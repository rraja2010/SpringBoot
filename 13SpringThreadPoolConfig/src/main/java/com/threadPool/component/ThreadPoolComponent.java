package com.threadPool.component;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component("ThreadPoolComponent")
public class ThreadPoolComponent {
	
	@Async("getDebitThreadPoolExecutor")
	public void debitDeatils(){
		String threadName = Thread.currentThread().getName();
		System.out.println(" ----Detbit Detials()-called------Running Thread Name : "+threadName);
		
	}
	
	@Async("getCreditThreadPoolExecutor")
	public void creditDeatils(){
		String threadName = Thread.currentThread().getName();
		System.out.println("########### Credit Detials() ### called ####### Running Thread Name : "+threadName);
	}
	
}
