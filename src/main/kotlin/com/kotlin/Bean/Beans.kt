package com.kotlin.Bean

import com.kotlin.annotations.Bean
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.*
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import java.util.*

/**
 * Created by simple_soul on 2017/6/21.
 */

@Bean
@Component(value = "student")
@Scope(value = "singleton")
data class Student(var name: String)
{
    var age: Int = 0
    var array: Array<String>? = null
    var list: ArrayList<String>? = null
    var map: HashMap<String, String>? = null
    var pro: Properties? = null

    fun print()
    {
        println("name=$name, age=$age \narray=$array \nlist=$list \nmap=$map \npro=$pro")
    }

}

@Bean
data class Book(var name: String)
{
    fun add()
    {
        println("book add")
    }
}

@Aspect
@Bean
data class MyBook(var name: String)
{
    @Before(value = "execution(* com.kotlin.Bean.Book.*(..))")
    fun before()
    {
        println("MyBook before")
    }

    @AfterReturning(value = "execution(* com.kotlin.Bean.Book.*(..))")
    fun after()
    {
        println("MyBook after")
    }

    @Around(value = "execution(* com.kotlin.Bean.Book.*(..))")
    fun around(pro: ProceedingJoinPoint)
    {
        //方法之前
        println("方法之前")
        pro.proceed()
        //方法之后
        println("方法之后")
    }
}

@Bean
@Component(value = "user")
data class User(var name: String, var age: Int)
{
    var id: Int? = null

    fun add(): String
    {
        println("user add")
//        var s = 4 / 0
        return "你好"
    }
}

@Aspect
@Bean
@Component(value = "advice")
data class Advice(var content: String)
{
    @Before(value = "execution(* com.kotlin.Bean.User.*(..))")
    fun before()
    {
        println("前置通知")
    }

    @AfterReturning(value = "execution(* com.kotlin.Bean.User.*(..))", returning = "result")
    fun afterResult(result: Any)
    {
        println("后置通知  " + result)
    }

    @After(value = "execution(* com.kotlin.Bean.User.*(..))")
    fun after()
    {
        println("最终通知")
    }

    @Around(value = "execution(* com.kotlin.Bean.User.*(..))")
    fun around(pro: ProceedingJoinPoint): Any
    {
        //方法之前
        println("环绕通知 方法之前")

        //被增强的方法
        val any = pro.proceed()

        //方法之后
        println("环绕通知 方法之后")

        return any
    }

    @AfterThrowing(value = "execution(* com.kotlin.Bean.User.*(..))", throwing = "ex")
    fun exception(ex: Exception)
    {
        println("异常通知 " + ex)
    }
}
