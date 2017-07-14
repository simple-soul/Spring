package com.kotlin.controller

import com.kotlin.Bean.Student
import com.kotlin.Service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Controller
class TestController
{
    @RequestMapping(value = "/hello")
    fun handleRequest(@Autowired studentService: StudentService): ModelAndView
    {
        var studentList = ArrayList<Student>()
        studentList.add(Student("小明"))
        studentService.transferAccount()

        var mav  = ModelAndView()
        //相当于request中的setAttribute，在jsp页面中获取
        mav.addObject("studentList", studentList)
        mav.addObject("title", "我是标题")

        //指定视图
        mav.viewName = "index.jsp"
        return mav
    }

}
