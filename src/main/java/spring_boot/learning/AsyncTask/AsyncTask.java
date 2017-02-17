package spring_boot.learning.AsyncTask;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

/**
* @author DexterPoker
* @date 2017年2月16日-下午2:39:36
**/
@Component
public class AsyncTask {//异步任务
	
	@Async
	public Future<String> taskOne(){
		System.out.println("开始做任务一");
	    long start = System.currentTimeMillis();
	    try {
			Thread.sleep((int)Math.random());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    long end = System.currentTimeMillis();
	    System.out.println("完成任务一，耗时：" + (end - start) + "毫秒");
	    return new AsyncResult<>("任务一完成");
	}
	
	@Async
	public Future<String> taskTwo(){
		System.out.println("开始做任务二");
	    long start = System.currentTimeMillis();
	    try {
			Thread.sleep((int)Math.random());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    long end = System.currentTimeMillis();
	    System.out.println("完成任务二，耗时：" + (end - start) + "毫秒");
	    return new AsyncResult<>("任务二完成");
	}
	
	@Async
	public Future<String> taskThree(){
		System.out.println("开始做任务三");
	    long start = System.currentTimeMillis();
	    try {
			Thread.sleep((int)Math.random());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    long end = System.currentTimeMillis();
	    System.out.println("完成任务三，耗时：" + (end - start) + "毫秒");
	    return new AsyncResult<>("任务三完成");
	}
}
