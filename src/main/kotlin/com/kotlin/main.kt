package com.kotlin

import com.kotlin.Bean.Book
import com.kotlin.Bean.Student
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
        val context = FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/AOP.xml")

//        val student = context.getBean("student") as Student
//        println(student)
//        student.print()


//        val service = context.getBean("studentService") as StudentService
//        service.add()

        val book = context.getBean("book") as Book
        book.add()

    }
}