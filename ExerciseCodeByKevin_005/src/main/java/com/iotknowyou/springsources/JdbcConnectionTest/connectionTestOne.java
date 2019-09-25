package com.iotknowyou.springsources.JdbcConnectionTest;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class connectionTestOne {
    /*
    *   这个类，实现了通过jdbc 去操作数据库
    *       实际上有三种 Statement 对象，他们都作为在给定连接上执行SQL语句的包容器
    *       1、Statement 对象，用于执行不带参数的简单SQL语句
    *       2、PreparedStatement （从Statement中继承而来），用于执行 带或者不带 IN参数的预编译 SQL语句
    *       3、CallableStatement 对象用于执行对数据库已经存在的存储过程的调用
    *
    *
    *   我们在实际的开发中，往往会批量处理执行SQL ，Statement 和  PreparedStatement 都 支持批量执行SQL语句，
    *   但是，这些SQL语句必须是，Insert，Update，Delete 这种执行语句，这种执行后返回一个Int类型的数，表示影响的行数，
    *
    *   Statement 和  PreparedStatement
    *   都是通过addBatch()方法添加一条SQL语句，
    *   通过 executeBatch()方法批量执行SQL
    *   返回一个Int类型的数组，表示SQL的返回值
    *
    */

    // 测试 Statement
    @Test
    public void TestOne()  {
        /* 创建 JDBC 连接数据库Mysql */
        Connection connection = null;
        Statement statement   = null;
        ResultSet resultSet   = null;

        /*======以下是基本的创建步骤=====*/

        try {
            // 注册驱动
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            // 通过注册的驱动获取连接对象 Connection
            String url =
                    "jdbc:mysql://127.0.0.1:3306/" +
                    "spring_sources_projects_code_by_kevin?" +
                    "useUnicode=ture&characterEncoding=UTF-8&" +
                    "serverTimezone=UTC&useSSL=false";
            connection = DriverManager.getConnection(url,"root","liu2019");
            //通过Statement对象执行操作，返回结果 ResultSet
            statement = connection.createStatement();
            //返回结果
            resultSet = statement.executeQuery("SELECT * FROM exercise_05_tables_user");
            while (resultSet.next()){
                System.out.print("姓名："+resultSet.getString("name")+"\t");
                System.out.print("年龄："+resultSet.getString("ages")+"\t");
                System.out.print("余额："+resultSet.getString("money")+"\t");
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception ："+e.getMessage());
            e.printStackTrace();
        }finally {
                //释放 连接资源
                try {
                    if(connection != null){ connection.close();}
                    if(statement != null){ statement.close();}
                    if(resultSet != null){ resultSet.close();}

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            };
    }

    // 测试 PreparedStatement
    @Test
    public void TestTwo()  {
        /* 创建 JDBC 连接数据库Mysql */
        Connection connection = null;
        PreparedStatement preparedStatement   = null;
        ResultSet resultSet   = null;

        /*======以下是基本的创建步骤=====*/

        try {
            // 注册驱动
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            // 通过注册的驱动获取连接对象 Connection
            String url =
                    "jdbc:mysql://127.0.0.1:3306/" +
                            "spring_sources_projects_code_by_kevin?" +
                            "useUnicode=ture&characterEncoding=UTF-8&" +
                            "serverTimezone=UTC&useSSL=false";
            connection = DriverManager.getConnection(url,"root","liu2019");
            //通过PreparedStatement对象执行操作，返回结果 ResultSet
            String sql = "insert into exercise_05_tables_user (name,ages,money) values (?,?,?) ";

            preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,"Liu");
            preparedStatement.setInt(2,23);
            preparedStatement.setDouble(3,888.88);
            //返回结果
            int result = preparedStatement.executeUpdate();

            //如果执行成功，获取新增数据的 自增ID
            if(result > 0){
                System.out.println("添加数据 成功 。。。 ");
                resultSet = preparedStatement.getGeneratedKeys();
                while (resultSet.next()){
                    System.out.println("生成的主键ID为：" + resultSet.getInt(1));
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception ："+e.getMessage());
            e.printStackTrace();
        }finally {
            //释放 连接资源
            try {
                if(connection != null){ connection.close();}
                if(preparedStatement != null){ preparedStatement.close();}
                if(resultSet != null){ resultSet.close();}

            } catch (SQLException e) {
                e.printStackTrace();
            }
        };
    }

    // 测试 CallableStatement
    @Test
    public void TestThree(){
        /* 在使用 数据库的过程中，可能会调用存储过程，可以使用  CallableStatement 来调用 存储过程  */


        /* 创建 JDBC 连接数据库Mysql */
        Connection connection = null;
        CallableStatement callableStatement   = null;
        ResultSet resultSet   = null;


        try {
            // 注册驱动
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            // 通过注册的驱动获取连接对象 Connection
            String url =
                    "jdbc:mysql://127.0.0.1:3306/" +
                            "spring_sources_projects_code_by_kevin?" +
                            "useUnicode=ture&characterEncoding=UTF-8&" +
                            "serverTimezone=UTC&useSSL=false";
            connection = DriverManager.getConnection(url,"root","liu2019");

            // 获取 CallableStatement 对象
            callableStatement = connection.prepareCall("{call p_selectUserByAge(?,?)}");
            callableStatement.setInt(1,23);
            // 设置传入参数
            callableStatement.registerOutParameter(2,Types.INTEGER);
            resultSet = callableStatement.executeQuery();
            // 循环遍历
            while (resultSet.next()){
                System.out.print("姓名："+resultSet.getString("name")+"\t");
                System.out.print("年龄："+resultSet.getString("ages")+"\t");
                System.out.print("余额："+resultSet.getString("money")+"\t");
                System.out.println();
            }
            // 输出 存储过程返回的结果
            System.out.println("存储过程返回的结果:"+callableStatement.getInt(2));

        } catch (SQLException e) {
            System.out.println("SQL Exception ："+e.getMessage());
            e.printStackTrace();
        }finally {
            //释放 连接资源
            try {
                if(connection != null){ connection.close();}
                if(callableStatement != null){ callableStatement.close();}
                if(resultSet != null){ resultSet.close();}

            } catch (SQLException e) {
                e.printStackTrace();
            }
        };
    }

    /*   测试 批处理      */
    /*
    *   1、使用 Statement ， addBatch() , executeBatch 实现 对数据库的批量操作。
    *   2、使用Statement 进行批量操作的缺点是 Statement 无法传递参数，必须是完整的SQL语句
    */
    @Test
    public void TestFour(){
        /* 创建 JDBC 连接数据库Mysql */
        Connection connection = null;
        Statement statement   = null;
        ResultSet resultSet   = null;

        /*======以下是基本的创建步骤=====*/

        try {
            // 注册驱动
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            // 通过注册的驱动获取连接对象 Connection
            String url =
                    "jdbc:mysql://127.0.0.1:3306/" +
                            "spring_sources_projects_code_by_kevin?" +
                            "useUnicode=ture&characterEncoding=UTF-8&" +
                            "serverTimezone=UTC&useSSL=false";
            connection = DriverManager.getConnection(url,"root","liu2019");
            //通过Statement对象执行操作，返回结果 ResultSet
            statement = connection.createStatement();

            // 通过for循环批量添加SQL
            for (int i=0 ; i<10 ;i++){
                String sql  = "insert into exercise_05_tables_user (name,ages,money) value "
                        +"(\""
                        +"statement_"+i
                        +"\","+(30+i)
                        +","+(444.44+i)
                        +")";
                statement.addBatch(sql);
            }
            // 批处理结果
            int[] result = statement.executeBatch();
            System.out.println("影响的行数分别为：");
            for (int i : result) {
                System.out.print(i + "\t");
            }

        } catch (SQLException e) {
            System.out.println("SQL Exception ："+e.getMessage());
            e.printStackTrace();
        }finally {
            //释放 连接资源
            try {
                if(connection != null){ connection.close();}
                if(statement != null){ statement.close();}
                if(resultSet != null){ resultSet.close();}

            } catch (SQLException e) {
                e.printStackTrace();
            }
        };
    }

    /*
    *   1、使用 PreparedStatement 既可以是完整的 SQL ， 也可以是带参数的不完整的SQL
    */
    @Test
    public void TestFive(){
        /* 创建 JDBC 连接数据库Mysql */
        Connection connection = null;
        PreparedStatement preparedStatement   = null;
        ResultSet resultSet   = null;

        /*======以下是基本的创建步骤=====*/

        try {
            // 注册驱动
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            // 通过注册的驱动获取连接对象 Connection
            String url =
                    "jdbc:mysql://127.0.0.1:3306/" +
                            "spring_sources_projects_code_by_kevin?" +
                            "useUnicode=ture&characterEncoding=UTF-8&" +
                            "serverTimezone=UTC&useSSL=false";
            connection = DriverManager.getConnection(url,"root","liu2019");
            //通过PreparedStatement对象执行操作，返回结果 ResultSet
            String sql = "insert into exercise_05_tables_user (name,ages,money) values (?,?,?) ";

            preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

            /* for 循环，添加SQL语句*/
            for (int i=0;i<10;i++){
                preparedStatement.setString(1,"preparedStatement_"+i);
                preparedStatement.setInt(2,23+i);
                preparedStatement.setDouble(3,888.88+i);
                preparedStatement.addBatch();
            }

            //返回结果
            int[]  result = preparedStatement.executeBatch();

            // 批处理结果
            System.out.println("影响的行数分别为：");
            for (int i : result) {
                System.out.print(i + "\t");
            }

        } catch (SQLException e) {
            System.out.println("SQL Exception ："+e.getMessage());
            e.printStackTrace();
        }finally {
            //释放 连接资源
            try {
                if(connection != null){ connection.close();}
                if(preparedStatement != null){ preparedStatement.close();}
                if(resultSet != null){ resultSet.close();}

            } catch (SQLException e) {
                e.printStackTrace();
            }
        };
    }

    /* 数据库的 事务处理*/
    /*
    *    关系型数据库一般，都支持事务，事务具有四大特征 ---> 原子性、一致性、隔离性、持久性
    *
    *    原子性：事务包含的所有操作，要么全部成功，要么失败，回滚
    *    一致性：事务必须使数据库从一个一致性状态到另一个一致性状态。（事务执行之前和执行之后都必须处于一致性状态）
    *    隔离性：当多个用户并发访问数据库时，多个并发事务之间要 相互隔离。
    *    持久性：一个事务一旦被提交，那么对数据中的数据的改变就是永久的。
    */
    @Test
    public void TestSix(){
        /* 创建 JDBC 连接数据库Mysql */
        Connection connection = null;
        PreparedStatement preparedStatement   = null;
        ResultSet resultSet   = null;

        /*======以下是基本的创建步骤=====*/

        try {
            // 注册驱动
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            // 通过注册的驱动获取连接对象 Connection
            String url =
                    "jdbc:mysql://127.0.0.1:3306/" +
                            "spring_sources_projects_code_by_kevin?" +
                            "useUnicode=ture&characterEncoding=UTF-8&" +
                            "serverTimezone=UTC&useSSL=false";
            connection = DriverManager.getConnection(url,"root","liu2019");

            /************/
            /*手动开启事务*/
            /************/
            connection.setAutoCommit(false);

            //通过PreparedStatement对象执行操作，返回结果 ResultSet
            String sql = "update exercise_05_tables_user set money= money-? where id=? ";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setDouble(1,100);
            preparedStatement.setInt(2,2);
            preparedStatement.addBatch();

            preparedStatement.setDouble(1,200);
            preparedStatement.setInt(2,1);
            preparedStatement.addBatch();

            /*如果出现异常，则本次 操作无效，sql回滚*/
            //int i= 1/0;

            //批处理返回结果
            int[]  result = preparedStatement.executeBatch();

            // 提交事务，如果不提交事务，则执行SQL无效
            connection.commit();

        } catch (SQLException e) {

            try {
                // 如果有异常抛出，进行事务回滚
                connection.rollback();
                System.out.println("SQL Exception ："+e.getMessage());
                e.printStackTrace();

            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        }finally {
            //释放 连接资源
            try {
                if(connection != null){ connection.close();}
                if(preparedStatement != null){ preparedStatement.close();}
                if(resultSet != null){ resultSet.close();}

            } catch (SQLException e) {
                e.printStackTrace();
            }
        };
    }
}

