package spring_boot.learning.commandLineRunner;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
* @author DexterPoker
* @date 2017年1月22日-下午3:22:40
**/
@Component
@Order(value=2)
public class CommandLineRunner2 implements CommandLineRunner{

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("启动前加载run2");
		System.out.println(Arrays.asList(arg0));
	}

}
