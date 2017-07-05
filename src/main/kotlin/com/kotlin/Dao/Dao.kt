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
        //设置数据库信息
        var dm = DriverManagerDataSource()
        dm.setDriverClassName("com.mysql.jdbc.Driver")
        dm.url = "jdbc:mysql://localhost:3306/test"
        dm.username = "root"
        dm.password = "gg123456"

        //创建JdbcTemplate对象，设置数据源
        var template = JdbcTemplate(dm)

        //使用JdbcTemplate对象的方法操作数据
        var sql = "insert into student value(?, ?)"
        val row = template.update(sql, "小黄", "fsfd")

        println("add $row")
    }
}