## 用户登录

用户在登录页面,输入用户名和密码,点击"登录"按钮或者回车,完成用户登录的功能.

​	*用户名和密码不能为空

​	*用户名或者密码错误,用户已过期,用户状态被锁定,ip受限 都不能登录成功

​	*登录成功之后,所有业务页面显示当前用户的名称

​	*实现10天记住密码

​	*登录成功之后,跳转到业务主页面

​	*登录失败,页面不跳转,提示信息

![](https://pic1.imgdb.cn/item/634a731616f2c2beb13e24e4.jpg)



# 刷新

全局刷新同步

局部刷新异步

可能全局可能局部用异步刷新

# 搭建mybatis逆向工程

根据表生成mapper层的三部分代码：实体类，mapper接口，映射文件

## 使用mybatis逆向工程

* 创建工程：crm-mybatis-generator
* 添加插件

~~~xml
<!--myBatis逆向工程插件-->
    <plugin>
	<groupId>org.mybatis.generator</groupId>
	<artifactId>mybatis-generator-maven-plugin</artifactId>
	<version>1.3.2</version>
	<configuration>
	    <verbose>true</verbose>
	    <overwrite>true</overwrite>
	</configuration>
    </plugin>
~~~

* 信息

  * 数据库连接信息
  * 代码保存目录
  * 表的信息

* 提供mybatis逆向工程配置文件

  * 在项目目录中

* 运行逆向工程，根据指定的表生成java代码，保存到指定的目录中

  

  

  

  

  



