package com.kotlin.Bean

import com.kotlin.annotations.Bean
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

@Bean
data class MyBook(var name: String)
{
    fun before()
    {
        println("MyBook before")
    }
}