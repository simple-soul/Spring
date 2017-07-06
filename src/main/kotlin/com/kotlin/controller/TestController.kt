package com.kotlin.controller

import com.kotlin.Bean.Student
import javaa.User
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.mvc.Controller
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class TestController : Controller
{
    override fun handleRequest(request: HttpServletRequest?, response: HttpServletResponse?): ModelAndView
    {
        var studentList = ArrayList<Student>()
        studentList.add(Student("小明"))

        var mav  = ModelAndView()
        //相当于request中的setAttribute，在jsp页面中获取
        mav.addObject("studentList", studentList)

        //指定视图
        mav.viewName = ""
        return mav
    }

}
