# 项目地址

https://github.com/TomLiYouXiu/Customer-relationship-management.git

# 功能设计

1.分析需求

2.分析与设计

3.编码与实现

4.测试

## 首页

用户访问项目首页，首先进入登录页面。

具体流程查看首页流程图

![](https://pic1.imgdb.cn/item/63492c9716f2c2beb1e84227.jpg)

## 用户登录

用户在登录页面,输入用户名和密码,点击"登录"按钮或者回车,完成用户登录的功能.

​	*用户名和密码不能为空

​	*用户名或者密码错误,用户已过期,用户状态被锁定,ip受限 都不能登录成功

​	*登录成功之后,所有业务页面显示当前用户的名称

​	*实现10天记住密码

​	*登录成功之后,跳转到业务主页面

​	*登录失败,页面不跳转,提示信息



## 一个资源目录对应一个Controller

# 问题遗留

不能通过base动态的获取图片，只能通过相对路径实现，灵活性较差！！！！！

请求 URL: http://localhost:8080/crm/settings/qx/user/jquery/bootstrap_3.3.0/css/bootstrap.min.css

![](https://pic1.imgdb.cn/item/63492b9a16f2c2beb1e6de1a.jpg)