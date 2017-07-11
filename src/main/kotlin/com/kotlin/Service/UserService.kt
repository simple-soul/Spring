package com.kotlin.Service

import com.kotlin.Dao.UserDao
import com.kotlin.annotations.Bean
import org.springframework.stereotype.Service
import javax.annotation.Resource

@Bean
@Service(value = "userService")
data class UserService(@Resource(name = "userDao")var userDao: UserDao)
{
    fun payMoney()
    {
        userDao.payMoney()
        println("service pay money")
    }
}