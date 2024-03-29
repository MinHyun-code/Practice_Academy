package aop2;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {

	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
		String signatureStr = joinpoint.getSignature().toShortString();
		System.out.println(signatureStr + "is start.");
		long st = System.currentTimeMillis();
		
		try {
			Object obj = joinpoint.proceed();
			return obj;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			long et = System.currentTimeMillis();
			System.out.println(signatureStr + "is finished.");
			System.out.println(signatureStr + " ����ð� : " + (et - st));
		}
		return st;
	}
	
	public void beforeAdvice() {
		System.out.println("beforeAdvice()");
	}
	
	public void afterReturningAdvice() {
		System.out.println("afterReturningAdvice()");
	} 
	
	public void afterThrowingAdvice() {
		System.out.println("afterThrowingAdvice()");
	}
	
	public void afterAdvice() {
		System.out.println("afterAdvice()");
	}
}
