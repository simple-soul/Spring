package javaa;

import org.springframework.stereotype.Component;

/**
 * Created by simple_soul on 2017/6/20.
 */

@Component(value = "user")
public class User
{
	public void add()
	{
		System.out.println("add");
	}

	public static void main(String[] args)
	{

	}
}
