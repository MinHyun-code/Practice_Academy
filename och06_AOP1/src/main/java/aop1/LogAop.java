package aop1;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {
	// Around Advice���� ����� ������ �޼����,��κ� �Ķ���ͷ� ���޹��� ProceedingJoinPoint�� proceed() �޼��常 ȣ��
	public Object loggerAop(ProceedingJoinPoint joinpoint) {
		String signatureStr = joinpoint.getSignature().toString();
		// �ٽ� ������ ���Ǵ� �޼ҵ�
		long st = System.currentTimeMillis();
		
		try {
			// �ٽ� ���� ����
			Object obj = joinpoint.proceed();
			return obj;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			long et = System.currentTimeMillis();
			System.out.println(signatureStr + "is finished.");
			System.out.println(signatureStr + "����ð� : " + (et - st));
		}
		return st;
	}
}
