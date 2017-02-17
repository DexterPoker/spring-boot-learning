package spring_boot.learning;

import java.util.concurrent.Future;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import spring_boot.learning.AsyncTask.AsyncTask;

/**
* @author DexterPoker
* @date 2017年2月16日-下午4:22:15
**/
@RunWith(SpringRunner.class)
@SpringBootTest
public class AsyncTaskTest {

	@Autowired
	private AsyncTask task;

	@Test
	public void test() throws Exception {
		long start = System.currentTimeMillis();
		Future<String> task1 = task.taskOne();
		Future<String> task2 = task.taskTwo();
		Future<String> task3 = task.taskThree();
		while(true) {
			if(task1.isDone() && task2.isDone() && task3.isDone()) {
				// 三个任务都调用完成，退出循环等待
				break;
			}
			Thread.sleep(1000);
		}
		long end = System.currentTimeMillis();
		System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
	}

}
