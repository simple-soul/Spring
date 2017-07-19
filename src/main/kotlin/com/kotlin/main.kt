package com.kotlin


import com.kotlin.Bean.User
import com.kotlin.Dao.UserMapper
import com.kotlin.Service.StudentService
import org.junit.Test
import org.springframework.context.support.ClassPathXmlApplicationContext

/**
 * Created by simple_soul on 2017/6/21.
 */

class main
{
    @Test
    fun test()
    {
        //加载Spring配置文件，创建对象
        val context = ClassPathXmlApplicationContext("config/spring/applicationContext.xml")
        //service的id

//        println(File("/").absolutePath)
//        println(File(".").absolutePath)
//        val studentService = context.getBean("studentService") as StudentService
//        studentService.account()

        val userMapper = context.getBean("userMapper") as UserMapper
        userMapper.insertUser(User("jerry",46))

//        val user = context.getBean("user") as User
//        user.add()

    }
}