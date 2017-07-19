package com.kotlin.Dao

import com.kotlin.Bean.User
import com.kotlin.utils.DBUtils
import com.mchange.v2.c3p0.ComboPooledDataSource
import org.apache.ibatis.io.Resources
import org.apache.ibatis.session.SqlSession
import org.apache.ibatis.session.SqlSessionFactoryBuilder
import org.junit.Test
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository
import java.sql.ResultSet

/**
 * Created by simple_soul on 2017/6/21.
 */

@Repository(value = "studentDao")
open class StudentDao
{
//    @Resource(name = "template") lateinit var template: JdbcTemplate
    val template = JdbcTemplate(DBUtils())

    fun payMoney()
    {
        val sql = "update student set money=money-? where name=?"
        template.update(sql, 200, "小黄")
    }

    fun collectMoney()
    {
        val sql = "update student set money=money+? where name=?"
        template.update(sql, 200, "小明")
    }
}

@Repository(value = "usersDao")
open class UsersDao
{
    //    @Resource(name="template")private lateinit var template: JdbcTemplate
    val template = JdbcTemplate(DBUtils())

    fun add()
    {
        //设置数据库信息
//        val dm = DBUtils()
        //创建JdbcTemplate对象，设置数据源
//        var template = JdbcTemplate(dm)

        //使用JdbcTemplate对象的方法操作数据
        val sql = "insert into user value(?, ?)"
        val row = template.update(sql, "小军",18)

        println("add $row")
    }

    @Test
    fun update()
    {
        //设置数据库信息
        val dm = DBUtils()

        //创建对象
        val template = JdbcTemplate(dm)

        //修改
        val sql = "update user set age=? where name=?"
        val row = template.update(sql, 20, "小明")
        println(row)
    }

    @Test
    fun delete()
    {
        val dm = DBUtils()

        val template = JdbcTemplate(dm)

        val sql = "delete from user where name=?"
        val row = template.update(sql, "小明")
        println(row)
    }

    @Test
    fun query()
    {
        val dm = DBUtils()

        val template = JdbcTemplate(dm)

//        //1. 查询返回一个值
//        var sql = "select count(*) from user"
//        //(sql, 返回的类型的class)
//        val result = template.queryForObject(sql, Int::class.java)
//        println(result)

//        //2. 查询返回对象
//        var sql = "select * from user where name=?"
//
//        val result = template.queryForObject(sql, RowMapper<User>{
//            resultSet: ResultSet, i: Int ->
//            //1. 从结果集拿到数据
//            var name = resultSet.getString("name")
//            var age = resultSet.getInt("age")
//            //2. 将数据封装到对象中
//            var user = User(name, age)
//
//            return@RowMapper user
//        }, "小黄")
//        println(result)

        //3. 查询返回一个List
        val sql = "select * from user"
        val result = template.query(sql, MyRowMapper())
        println(result)
    }

    @Test
    fun test()
    {
        val dataSources = ComboPooledDataSource();
        dataSources.driverClass = "com.mysql.jdbc.Driver"
        dataSources.jdbcUrl = "jdbc:mysql://localhost:3306/test"
        dataSources.user = "root"
        dataSources.password = "gg123456"
    }

    @Test
    fun findUserById()
    {
        //从配置文件读取流
        val input = Resources.getResourceAsStream("config/mybatis/configuration.xml")

        //创建会话工厂
        val sqlSessionFactory = SqlSessionFactoryBuilder().build(input)

        //创建会话
        sqlSessionFactory.openSession().use {
            val userMapper = it.getMapper(UserMapper::class.java)
            println(userMapper.findUserById(1))
        }

        //操作数据库
        //statement为映射文件中指定的id，parameter为参数，<>中为返回值类型
//        val user = sqlSession.selectOne<User>("test.findUserById", 1)
//
//        println("\n$user")
//
//        //释放资源
//        sqlSession.close()


    }

    @Test
    fun findUserByName()
    {
        //从配置文件读取流
        val input = Resources.getResourceAsStream("config/mybatis/configuration.xml")
        //创建会话工厂
        val sqlSessionFactory = SqlSessionFactoryBuilder().build(input)

        sqlSessionFactory.openSession().use {
            val list = it.selectList<List<User>>("test.findUserByName", "小")
            println(list)
        }

    }

    @Test
    fun insertUser()
    {
        var sqlSession:SqlSession? =  null
        //从配置文件读取流
        try
        {
            val input = Resources.getResourceAsStream("config/mybatis/configuration.xml")
            //创建会话工厂
            val sqlSessionFactory = SqlSessionFactoryBuilder().build(input)
            //创建会话
            sqlSession = sqlSessionFactory.openSession()

            val user = User("tom", 54)
            val result = sqlSession.insert("test.insertUser", user)
            sqlSession.commit()
            println("\n$result")
            println("id=${user.id}")
        }
        catch (e: Exception)
        {
            println(e)
        }
        finally
        {
            //释放资源
            sqlSession!!.close()
        }
    }
}

class MyRowMapper: RowMapper<User>
{
    override fun mapRow(rs: ResultSet?, rowNum: Int): User
    {
        val name: String
        val age: Int
        //1. 从结果集拿到数据
        if (rs != null)
        {
            name = rs.getString("name")
            age = rs.getInt("age")
        }
        else
        {
            name = ""
            age = 0
        }
        //2. 将数据封装到对象中
        val user = User(name, age)

        return user
    }
}

