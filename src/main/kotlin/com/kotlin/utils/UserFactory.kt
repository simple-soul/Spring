package com.kotlin.utils

import com.kotlin.Bean.User

inline fun getUser(): User
{
    return User("mike", 13)
}

class UserFactory
{
    companion object
    {
        @JvmStatic
        fun getUser(): User
        {
            return User("jack", 35)
        }
    }

    fun getUser2(): User
    {
        return User("rose", 28)
    }
}