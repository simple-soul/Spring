package com.kotlin.Bean

import com.kotlin.annotations.Bean
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

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
    fun around(pro : ProceedingJoinPoint)
    {
        //方法之前
        println("方法之前")
        pro.proceed()
        //方法之后
        println("方法之后")
    }
}

@Bean
data class User(var name: String, var age: Int)
