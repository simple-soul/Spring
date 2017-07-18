package com.kotlin.Dao

import com.kotlin.Bean.User

/**
 * Created by simple_soul on 2017/7/18.
 */

interface UserMapper
{
    fun findUserById(id: Int): User
}