package com.fy.util.logAspect;

import com.fy.bean.MultipleDataSource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LogAspectController {

	public void doBefore(JoinPoint jp) {
//		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//		System.out.println(request.getRequestURI());
//		if(request.getRequestURL().indexOf("/login")<0){
//			request.getHeader("token");
//		}
		MultipleDataSource.setDataSourceKey(MultipleDataSource.DP);
	}

	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		//Long mills1 = System.currentTimeMillis();
		Object retVal;
//		try {
			retVal = pjp.proceed();
//		} catch (Exception e) {
//			return ResponseUtil.error(e.getClass().getName());
//		}
		//long interval = System.currentTimeMillis()-mills1;
//		if(interval>100){
//			System.out.println("方法"+pjp.getSignature().getName()+"---------执行时间:"+interval+"毫秒");
//		}
		return retVal;
	}

	public void doAfter(JoinPoint jp) {
		MultipleDataSource.clearDataSource();
	}

	public void doThrowing(JoinPoint jp, Throwable ex) {

	}

	public static void main(String[] args){

	}
}
