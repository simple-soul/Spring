package javaa;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by simple_soul on 2017/6/25.
 */
@Aspect
@Component(value = "mybook")
public class MyBook
{
	public void before()
	{
		System.out.println("before");
	}

	@AfterReturning(value = "execution(public String javaa.Book.*(..))", returning = "obj")
	public void after(String obj)
	{
		System.out.println("后置通知");
		System.out.println(obj);
	}

	@Around(value = "execution(public String javaa.Book.*(..))")
	public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("之前");

		Object s = proceedingJoinPoint.proceed();

		System.out.println("之后");

		return s;
	}
}
