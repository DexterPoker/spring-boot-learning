package spring_boot.learning.webMvcConfigAdapter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import spring_boot.learning.interceptor.MyInterceptor2;

/**
* @author DexterPoker
* @date 2017年1月22日-下午2:41:27
**/
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MyInterceptor2()).addPathPatterns("/**");
//		registry.addInterceptor(new MyInterceptor1()).addPathPatterns("/**");
		super.addInterceptors(registry);
	}
	
}
