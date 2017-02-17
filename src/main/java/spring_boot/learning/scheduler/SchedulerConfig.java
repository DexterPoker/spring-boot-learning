package spring_boot.learning.scheduler;

import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
* @author DexterPoker
* @date 2017年1月22日-上午11:42:06
**/
@Configuration
@EnableScheduling
public class SchedulerConfig {

//	@Scheduled(fixedRate = 5000) ：上一次开始执行时间点之后5秒再执行
//	@Scheduled(fixedDelay = 5000) ：上一次执行完毕时间点之后5秒再执行
//	@Scheduled(initialDelay=1000, fixedRate=5000) ：第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
//	@Scheduled(cron="*/5 * * * * *") ：通过cron表达式定义规则
	@Scheduled(cron="*/5 * * * * *")
	public void scheduler(){
		System.out.println(new Date());
	}
	
}
