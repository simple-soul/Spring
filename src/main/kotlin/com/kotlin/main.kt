package com.kotlin


import com.kotlin.Dao.UsersDao
import com.kotlin.Service.StudentService
import org.junit.Test
import org.springframework.context.support.FileSystemXmlApplicationContext

/**
 * Created by simple_soul on 2017/6/21.
 */

class main
{
    @Test
    fun test()
    {
        //加载Spring配置文件，创建对象
        val context = FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/applicationContext.xml")
        //service的id

        val studentService = context.getBean("studentService") as StudentService
        studentService.account()

//        val user = context.getBean("user") as User
//        user.add()

    }
}