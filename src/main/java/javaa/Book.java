package javaa;

import org.springframework.stereotype.Component;

/**
 * Created by simple_soul on 2017/6/25.
 */

@Component(value = "book")
public class Book
{
	public String add()
	{
		System.out.println("book add");
		return "你好";
	}
}
