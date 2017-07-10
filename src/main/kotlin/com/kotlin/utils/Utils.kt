package com.kotlin.utils

import org.springframework.jdbc.datasource.DriverManagerDataSource

inline fun DBUtils() : DriverManagerDataSource
{
    //设置数据库信息
    var dm = DriverManagerDataSource()
    dm.setDriverClassName("com.mysql.jdbc.Driver")
    dm.url = "jdbc:mysql://localhost:3306/test?useUnicode=true&amp;characterEncoding=UTF-8"
    dm.username = "root"
    dm.password = "gg123456"
    return dm
}