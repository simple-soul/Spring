package com.kotlin.Service

import com.kotlin.Dao.StudentDao
import com.kotlin.annotations.Bean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.annotation.Resource

/**
 * Created by simple_soul on 2017/6/21.
 */

@Bean
@Service(value = "studentService")
@Transactional
data class StudentService(@Resource(name = "studentDao")var dao: StudentDao)
{
//    @Autowired lateinit var dao: StudentDao

    fun add()
    {
        dao.add()
        println("add in service")
    }

    fun transferAccount()
    {

        dao.payMoney()

        dao.collectMoney()

    }
}
