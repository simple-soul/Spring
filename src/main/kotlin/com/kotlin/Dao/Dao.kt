package com.kotlin.Dao

import com.kotlin.annotations.Bean
import org.springframework.stereotype.Component

/**
 * Created by simple_soul on 2017/6/21.
 */

@Bean
@Component(value = "studentDao")
data class StudentDao(var name:String)
{
    fun add()
    {
        println("add in dao")
    }
}