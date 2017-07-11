package com.kotlin.Dao

import com.kotlin.annotations.Bean
import org.springframework.stereotype.Component

@Bean
@Component(value = "userDao")
data class UserDao(var name : String)
{
    fun payMoney()
    {
        println("dao pay money")
    }
}