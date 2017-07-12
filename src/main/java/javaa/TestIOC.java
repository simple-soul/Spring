package javaa;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by simple_soul on 2017/6/20.
 */
public class TestIOC
{
	@Test
	public void test()
	{
		//1.加载Spring配置文件，创建对象
		ApplicationContext context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/applicationContext.xml");

		//2.
//				User user = (User) context.getBean("user");
//				System.out.println(user);
//				user.add();

//		Student student = (Student) context.getBean("student");
//		System.out.println(student);

		Book book = (Book) context.getBean("book");
		book.add();
	}
}
