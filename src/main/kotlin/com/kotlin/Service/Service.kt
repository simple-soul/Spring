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

@Service(value = "studentService")
open class StudentService
{
    @Autowired lateinit var studentDao: StudentDao

    fun account()
    {
        studentDao.payMoney()

        studentDao.collectMoney()
    }
}
