package com.kotlin.Dao

import com.kotlin.annotations.Bean
import org.junit.Test
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.stereotype.Component

/**
 * Created by simple_soul on 2017/6/21.
 */

@Bean
@Component(value = "studentDao")
class StudentDao
{
    @Test
    fun add()
    {
        var dm = DriverManagerDataSource()
        dm.setDriverClassName("com.mysql.jdbc.Driver")
        dm.url = "jdbc:mysql://localhost:3306/test"
        dm.username = "root"
        dm.password = "gg123456"

        var template = JdbcTemplate(dm)

        var sql = "insert into user values(?, ?)"
        var raw = template.update(sql, "小明", 16)

        println("add $raw")
    }
}