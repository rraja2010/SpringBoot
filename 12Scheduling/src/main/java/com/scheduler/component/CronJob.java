package com.scheduler.component;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("CronJob")
public class CronJob {
	//*/10 -  means every 10 second
	@Scheduled(cron = "* 0/10 * * * ?")
	public void cronJobSch() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		String strDate = sdf.format(now);
		System.out.println("***cronJobSch*****Java cron job expression:: " + strDate);
	}
	
	//this method will being called every minute first time it will called just server has started
	@Scheduled(fixedDelay=60000)
	public void fixedDealyed(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		String strDate = sdf.format(now);
		System.out.println("Fixed Dealyed :: " + strDate);
	}
	
	//this method will being called every value mentioned in the properties file first time it will 
	//called just server startup,reading the values from the properties file
	@Scheduled(fixedDelayString="${schedule.fixedDelayTime}")
	public void fixedDealyString(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		String strDate = sdf.format(now);
		System.out.println("fixedDelayString Dealyed :: " + strDate);
	}
	
	/*
	 	this method will being called every value mentioned in the properties file once the server has started
		it will wait first time for 30 second.
	*/
	@Scheduled(fixedDelayString="${schedule.fixedDelayTime}" , initialDelay=30000)
	public void fixedDealyStringWithInitailDelay(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		String strDate = sdf.format(now);
		System.out.println("fixedDelayString with initial Delayed :: " + strDate);
	}
	
	@Scheduled(fixedDelayString="${schedule.fixedDelayTime}" , initialDelayString="${schedule.initialwaitTime}")
	public void fixedDealyStringWithInitailDelay11111111(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		String strDate = sdf.format(now);
		System.out.println("fixedDelayString with initial Delayed :: " + strDate);
	}

}

/*

Once the server start up then conJobSch() method will automatically called
  0/10 =  it will call the method in every 10 second
  
   @Scheduled(cron = "1 2 3 4 5 6 7")
  	Seconds 		YES 	0-59 	, 			- * /
	Minutes 		YES 	0-59 	, 			- * /
	Hours 			YES 	0-23 	, 			- * /
	Day of month 	YES 	1-31 	, 			- * ? / L W
	Month 			YES 	1-12 or JAN-DEC , 	- * /
	Day of week 	YES 	1-7 or SUN-SAT 	, 	- * ? / L #
	Year 			NO 		empty, 1970-2099 ,	- * /
	* (“all values”) 
	? (“no specific value”) 
	- used to specify ranges. For example, “10-12” in the hour field means “the hours 10, 11 and 12”.

*/
