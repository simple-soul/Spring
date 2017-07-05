package com.kotlin.Dao

import com.kotlin.annotations.Bean
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.datasource.DriverManagerDataSource
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
        var dm = DriverManagerDataSource()
        dm.setDriverClassName("com.mysql.jdbc.Driver")
        dm.url = "jdbc:mysql///test"
        dm.username = "root"
        dm.password = "gg123456"

        var template = JdbcTemplate(dm)

        println("add in dao")
    }
}