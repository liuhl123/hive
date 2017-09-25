package com.vnb.spring.jdbc;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class JdbcTemplateTest {

    private static JdbcTemplate jdbcTemplate;
    private static String URL = "jdbc:mysql://localhost:3306/test?useEncoding=tree & character=UTF-8";
    private static String USERNAME = "root";
    private static String PASSWD = "root";
    private static String DRIVER_NAME = "com.mysql.jdbc.Driver";


    @BeforeClass
    public static void setUpClass () {


        DriverManagerDataSource dbds = new DriverManagerDataSource(URL,USERNAME,PASSWD);
        dbds.setDriverClassName(DRIVER_NAME);
        jdbcTemplate = new JdbcTemplate(dbds);

    }

//    @Before
//    public void createTable () {
//        String  createSQL ="create table testJDBC "+ "(id int primary key ,name varchar(20))";
//        jdbcTemplate.update(createSQL);
//    }
//
//    @After
//    public void dropTable () {
//        String  dropSQL = "drop table test.testJDBC";
//        jdbcTemplate.execute(dropSQL);
//    }


    @Test
    public void insert() throws Exception {
        int count = 0;
        try {
           for (int i= 2;i < 10;i++){
               jdbcTemplate.update("insert into testJDBC (id,name) values ("+i+",'abc"+i+"')");
               count++;
           }
           if (count == 9) {
               System.out.println("插入成功");

           }
        } catch (Exception e) {
            System.out.println("插入失败");
            throw e;

        }
    }
    @Test
    public void select () {
        jdbcTemplate.query("select * from test.testJDBC", new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
               int size =  resultSet.getFetchSize();
               System.out.println(size);
                for (int i = 0;i < size;i++) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        System.out.println("id:"+id+",name:"+name);


                }
            }
        });
    }

//    @Test
//    public void test () {
//        String sql ="select * from test.role";
//        jdbcTemplate.query(sql, new RowCallbackHandler() {
//            @Override
//            public void processRow(ResultSet resultSet) throws SQLException {
//                String value= resultSet.getString("name");
//                System.out.println("得到姓名"+value);
//            }
//        });
//    }


}