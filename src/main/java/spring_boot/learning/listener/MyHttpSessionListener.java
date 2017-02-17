package spring_boot.learning.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
* @author DexterPoker
* @date 2017年1月22日-下午2:06:42
**/
@WebListener
public class MyHttpSessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("httpSession cteate");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("httpSession destroy");
	}

}
