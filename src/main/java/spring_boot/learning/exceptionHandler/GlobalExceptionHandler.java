package spring_boot.learning.exceptionHandler;

import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* @author DexterPoker
* @date 2017年1月20日-下午5:00:33
**/
@ControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * domain字段校验异常
	 * @param request
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	@ResponseBody
	public Map<String,String> defaultErrorHandler(HttpServletRequest request,MethodArgumentNotValidException ex){
		String exDesc = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
		String clazz = ex.getBindingResult().getAllErrors().get(0).getObjectName();
		Map<String,String> ret = new TreeMap<>();
		if(clazz.equals("users")){
			ret.put("respCode", "1001");
			ret.put("respDesc", clazz + "." +exDesc);
		}
		return ret;
	}
	
}
