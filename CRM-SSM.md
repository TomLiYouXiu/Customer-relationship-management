# CRM-SSM

## 一.开发流程

### 1. crm的技术架构：

*   视图层(view)：展示数据，跟用户交互。
    *    html,css,js,jquery,bootstrap(ext|easyUI),jsp

*    控制层(Controller)：控制业务处理流程(接收请求,接收参数,封装参数;根据不同的请求调用业务层处理业务;根据处理结果，返回响应信息)

    *   (servlet,)springMVC(,webwork,struts1,struts2)

*   业务层(Service)：处理业务逻辑(处理业务的步骤以及操作的原子性)

    ​		 JAVASE(工作流:activiti|JBPM)
    ​        	添加学生
    ​		 2,记录操作日志

*   持久层(Dao/Mapper)：操作数据库.

    *   (jdbc,)mybatis(,hibernate,ibatis)

    *   (hibernate 淘汰原因 :不灵活,sql语句会自动生成,但是不能控制 sql 了,可能生成的不是最优的,优化不了,而且效率低,占内存,服务器压力大)
        		tbl_table----------pojo

*   整合层：维护类资源,维护数据库资源
             spring(IOC,AOP)(,ejb,corba)

### 2. 软件开发的生命周期：

+   1)招标：
        投标:----------标书
    	甲方：
    	乙方：

*   2可行性分析:---------可行性分析报告
        技术,经济

*   3) 需求分析:-----------需求文档
        产品经理,需求调研
        项目原型:容易确定需求,开发项目时作为jsp网页.

*   4)分析与设计：

    *   架构设计：----------架构文档
        物理架构设计：

        *   应用服务器:tomcat(apache),weblogic(bea-->oracle),websphere(ibm),jboss(redhat),resin(MS)
            		            web  javaee:13种协议
            			                servlet,jsp,xml,jdbc
            					mq ....

        *   数据库服务器：mysql,oracle,DB2,sqlserver,达梦

        *   逻辑架构设计：代码分层.

            ​	视图层-->控制层-->业务层-->持久层-->数据库

        *   技术选型：java,.net

    *   项目设计：---------项目设计文档

        *   物理模型设计：哪些表，哪些字段，字段的类型和长度，以及表和表之间的关系。
            	                   powerdesigner-----xxxx.pdm
        *   逻辑模型设计：哪些类，哪些属性和方法，方法的参数和返回值，以及类和类之间关系。
            	                   rational rose-----.pdl
        *   界面设计：企业级应用 朴素 -----项目原型
            	               互联网应用 炫酷
        *   算法设计：------算法设计文档

*   5)搭建开发环境：-----------技术架构文档
        创建项目,添加jar包,添加配置文件,添加静态页面,添加公共类以及其它资源;能够正常启动运行。

*   6)编码实现：-------注释

*   7)测试：-----------测试用例

*   8)试运行：---------使用手册

*   9)上线：-----------实施文档

*   10)运维：----------运维手册

*   11)文档编纂：

### 3. CRM项目的核心业务：

*   CRM项目的简介：Customer Relationship Management 客户关系管理系统
        企业级应用,传统应用;给销售或者贸易型公司使用,在市场,销售,服务等各个环节中维护客户关系，
        CRM项目的宗旨：增加新客户,留住老客户，把已有客户转化为忠诚客户。

*   CRM是一类项目,我们的CRM是给一个大型的进出口贸易公司来使用的，做大宗商品的进出口贸易;商品是受管家管制的。

*   CRM项目的核心业务：

    *   系统管理功能：不是直接处理业务数据，为了保证业务管理的功能正常安全运行而设计的功能。
        		给超级管理员，开发和运维人员使用。

        *   用户登录
        *   安全退出
        *   登录验证等

    *   业务管理功能：处理业务数据
               市场活动：市场部，设计市场活动营销活动

        *   线索：销售部(初级销售),增加线索

        *   客户和联系人：销售部(高级销售),有效地区分和跟踪客户和联系人.

            ​    交易：销售部(高级销售),更好地区分和统计交易的各个阶段。

        *   售后回访：客服部,妥善安排售后回访。主动提醒。
                统计图表：管理层,统计交易表中各个阶段数据量。

### 4. crm的表结构

  tbl_user   用户表

  tbl_dic_type   数据字典类型表==存下拉列表的类型
  tbl_dic_value  数据字典值==存下拉列表中的数据

  tbl_activity   市场活动表
  tbl_activity_remark  市场活动备注表

  tbl_clue       线索表
  tbl_clue_remark   线索备注表

  tbl_clue_activity_relation  线索和市场活动的关联关系表

  tbl_customer   客户表
  tbl_customer_remark  客户备注表

  tbl_contacts   联系人表
  tbl_contacts_remark 联系人备注表

  tbl_contacts_activity_relation 联系人和市场活动的关联关系表

  tbl_tran       交易表
  tbl_tran_remark  交易备注表
  tbl_tran_history  交易历史表

  tbl_task   任务表

#### 表分析-主键字段

*   主键字段：在数据库表中，如果有一组字段能够唯一确定一条记录，则可以把它们设计成表的主键字段。
    推荐使用一个字段做主键，而且推荐使用没有业务含义(业务含义的数据是会变化的)的字段做主键,比如：id等。

​		主键字段的类型和长度由主键值的生成方式来决定：
​		

*   主键值的生成方式：

    *   自增：借助数据库自身主键生成机制
        	数值型 长度由数据量来决定
        	运行效率低
        	开发效率高

    *   assighed：程序员手动生成主键值,唯一非空,算法.

        ​	hi/low：数值型 长度由数据量决定
        ​	UUID：字符串 长度是32位	(用的比较多,效率高)

    *   共享主键：由另一张表的类型和长度决定	(不推荐使用,耦合度太高)

        ​	身份证,驾照的数据记录,可以都引用身份证主键值

        ​	tbl_person		tbl_card

        ​	id     name			id     name

        -------------------------------------------------

        ​	1001   zs          1001    card1
        ​	1002   ls

    *   联合主键：由多个字段的类型和长度决定(不推荐,不好操作)

#### 表分析-外键字段

外键字段：用来确定表和表之间的关系。
##### 1. 一对多：

​	一张表(A)中的一条记录可以对应另一张表(B)中的多条记录;
​	另一张表(B)中的一条记录只能对应一张表(A)中的一条记录。
​	

		A(1)---------B(n)
		父表         					子表
		tbl_class						tbl_student                    
		id     name					id      name class_id        
		-----------------------------------------------------------
		111    class1				1001    zs    111            
		222    class2				1002    ls    111            
									1003    ww    222
									1004    zl    


​		
​		
​		查询所有姓张的学生的id,name和所在班级name
​			select s.id,s.name,c.name as className
​			from tbl_student s
​			join tbl_class c on s.class_id=c.id//假如外键不可以为空
​			where s.name like 'z%'


*   添加数据时,先添加父表记录，再添加子表记录;
*   删除数据时,先删除子表记录，再删除父表记录;
*   查询数据时,可能会进行关联查询： 

*   内连接：查询所有符合条件的数据，并且要求结果在两张表中都有相对应的记录
*   左外连接：查询左侧表中所有符合条件的数据，即使在右侧表中没有相对应的记录
*   怎么选择内连接和外连接
    *   如果外键不能为空，优先使用内连接；
    *   如果外键可以为空，
            假如只需要查询那些在另一张表中有相对应的记录，使用内连接
        	假如需要查询左侧表中所有符合条件的记录，使用左外连接.

##### 2. 一对一：

一张表(A)中的一条记录只能对应另一张表(B)中的一条记录;
另一张表(B)中的一条记录也只能对应一张表(A)中的一条记录。


		tbl_person         tbl_card
		----------------------------
		id     name        id     	name
		1001   zs          1001		card1
	1. 共享主键：(不推荐)
		添加数据：先添加先产生的表，再后产生的表记录
		删除数据：先删除后产生的表记录，再删除先产生的表记录
		查询数据：无需进行连接查询
		   //查询zhangsan的驾照信息  1001
		select *
		from tbl_card
		where id='1001'
		
	2. 唯一外键：
		tbl_person             tbl_card
		id     name            id     name     person_id(唯一性约束)
		-----------------------------------------------------
		1001   zs              111    card1    1001
		1002   ls              222    card2    1002
		1003   ww              333    card3    1003
		
		*一对一就是一种特殊的一对多。
		*操作跟一对多完全一样。

##### 3. 多对多：

一张表(A)中的一条记录可以对应另一张表(B)中的多条记录;
另一张表(B)中的一条记录也可以对应一张表(A)中的多条记录。

		tbl_student                    tbl_course
		id     name                    id     name   
		---------------------------------------------
		1001   zs                      111    java   
		1002   ls                      222    mysql  
		
			tbl_student_course_relation
				student_id     course_id
		      ----------------------------              
				1001            111
				1001            222
				1002            111
				1002            222
	
	添加数据时，先添加父表记录(tbl_student,tbl_course),再添加子表(tbl_student_course_relation)记录;
	删除数据时，先删除子表记录(tbl_student_course_relation),再删除父表记录(tbl_student,tbl_course)
	查询数据时，可能会进行关联查询：
			
		查询所有姓张的学生的id,name,和所选课程的name
		select s.id,s.name,c.name as courseName
		from tbl_student s
			  join tbl_student_course_relation scr on s.id=scr.student_id
			  join tbl_course c on scr.course_id=c.id
		where s.name like 'z%'

#### 给关于日期和时间的字段：

​	都按照字符串处理：
​		char(10)   yyyy-MM-dd	(date)
​		char(19)   yyyy-MM-dd HH:mm:ss (datetime)

​	java 中 Date转成 MySQL 中的 date / datetime

#### 创建crm的数据库实例：

​	  把sql脚本导入数据库实例：



## 二. 搭建开发环境

### 1 .创建项目：crm-project

设置JDK.
创建工程：crm
补全目录结构：
设置编码格式：UTF-8
		settings-->editor-->file encodings
			右侧设置 

			1. Global encoding --> utf-8
			2. project encoding --> utf-8
			3. project files(*.properties)
	  		default encoding for properties files --> utf-8 
	  		transparent native-to-ascii conversion(选中)



![image-20220611155057857](E:\学习资料\笔记\md笔记\image-20220611155057857.png)

### 2. 添加jar包：添加依赖---参考课件.

### 3. 添加配置文件：参考课件.

配置数据库的时候,url 的位置记得配置 utf-8 保证字符编码一致

```xml
<property name="url" value="jdbc:mysql://192.168.223.133:3306/crm_db?useSSL=false&amp;useUnicode=true&amp;characterEncoding=UTF-8"/>
```

当前项目老师的配置文件加载调用流程

1. 先加载 web.xml
2. web.xml-dispatcherservlet 加载了 applicationContext-mvc.xml springmvc 的配置文件
5. web.xml-监听器 加载 spring 的配置文件 applicationContext.xml
4. applicationContext.xml 配置文件中,导入了 applicationContext-dataSource.xml 配置文件
5. applicationContext-dataSource.xml 配置文件中,导入了 mybais-config.xml 配置文件

### 4. 添加静态页面资源：

```
tomcat 配置项目的目录结构
    webapps
       |->stumgr
       |->crm
            |->.html,.css,.js,.img   test.jsp
            |->WEB-INF
                    |->web.xml
                    |->classes
                    |->lib

*web应用根目录下的内容都是不安全的，外界可以通过url直接访问;
 所以，一般为了数据的安全，都会把页面放到WEB-INF下,因为WEB-INF目录下的资源是受保护的，外界不能直接访问。

以上的方式http://127.0.0.1:8080/crm/test.jsp是可以直接访问的,不安全,应该放到 WEB-INF 下

webapps
    |->stumgr
    |->crm
         |->.css,.js,.img   
         |->WEB-INF
                |->web.xml
                |->classes
                |->lib
                |->pages  test.jsp
```

​			

### 5. 把crm项目部署到tomcat上：

​    http://127.0.0.1:8080/crm



# 业务功能逻辑

### 1. 记住密码

访问：login.jsp---->后台：.html：如果上次记住密码，自动填上账号和密码;否则，不填。
		如何判断上次是否记住密码？`
	上次登录成功，判断是否需要记住密码：如果需要记住密码，则往浏览器写cookie；否则，删除cookie。
		而且cookie的值必须是该用户的loginAct和loginPwd
	下次登录时，判断该用户有没有cookie：如果有，则自动填写账号和密码；否则，不写。
		而且填写的是cookie的值.
	----->浏览器显示

### 2. 登录验证

确保用户访问所有的业务页面时都是登录状态,登录状态可以通过session获取

**分析** : 实现方式采用过滤器还是拦截器呢

过滤器 : 实现  Filter 接口,重写 dofilter 方法,
配置过滤器 : web.xml

拦截器 : 实现拦截器 HandlerInterceptor接口,重写方法,在 prehanlder中编写拦截业务
配置拦截器 : 在 springmvc 配置文件中声明拦截器

过滤器通常用来处理一些简单的,拦截器更强大一点,提供了三个时机(执行请求之前,执行请求之后,响应返回后)的方法,现在的框架都提供了拦截器.
实际开发中中,业务复杂的通常都用拦截器来实现

这里采用拦截器的方式
在拦截器的 preHandler 中拦截请求----验证是否为登录状态

```java
if(登录验证不通过){
	重定向 login
	不可以放行 false	
}else{ 
	return true
}
```

在配置文件中配置需要拦截和不需要拦截的路径

写的 拦截器 应该写在那么目录下?

```java
package com.xxx.crm.settings.web.interceptor; // 写在 settings 下
@Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o) throws Exception {
    HttpSession session = request.getSession();
    User user = (User) session.getAttribute(Constants.SESSION_USER);
    if (user==null){
        httpServletResponse.sendRedirect(request.getContextPath()); // 这里直接项目的根路径就可以
        return false;
    }
    return true;
}
```

### 3. 保存活动功能

1. 先使用 mybatis逆向工程
      tbl_activity
    id UUID(写一个工具类)
    owner : 所有者用户的 id
    create_by : 当前登录的用户id

2. 写mapper接口给添加保存方法,xml 自己创建的是不是已经有了,改名拿来用
    新建市场活动的时候,修改时间和修改人肯定是空的,所以通常直接把这两个字段去掉
   (id, 

3. 写 service,记得扫描包(写数据需要考虑 service 有没有报异常!! try..catch,报异常,捕获),-->controller

4.   controller  新建还是用已有的,已有的,因为资源返回的还是 index 页面

     *   用对象接收参数
     *   传过来的参数不够	
     *   二次封装参数
     *   调用 service
     *   根据 service 的返回结果返回响应信息

     *   返回什么
         *   首先请求,页面没有完全刷新----异步请求
             返回一个 returnObj

5.   jsp 页面

     1.   用户点击创建弹出模态窗口,这里改成 js 代码弹出,这样可以在弹出前做初始化操作(清除表单)

          去掉超链接原有的  taggole target 属性,写上 id ,增加单击事件

     2.   将保存按钮的关闭窗口关掉(data-dismiss="modal"),写上 id ,增加单击事件

          ```jsp
          <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
          <button type="button" class="btn btn-primary" id="saveActivityBtn" >保存</button>
          ```

     3.   在保存按钮绑定的函数中

          1.   收集表单数据

          2.   验证数据

          3.   提交请求

               *   这里是异步请求

          4.   处理响应结果

               *   返回的是个 json 对象,当执行成功就关闭模态窗口,执行失败弹窗提示不关闭窗口

                   ```jsp
                    $("#createActivityModal").modal("hide"); // 当保存成功,再关闭窗口
                   ```

### 4. 保存活动功能中使日历的方式

找别人写好的插件   
一类问题：

   1. 实现起来比较复杂。难度高
   2. 跟业务无关。耦合度低,复用性高

   日历插件：bootstrap-datetimepicker
前端插件使用步骤：

1.   引入开发包：.js,.css
     	下载开发包，拷贝到项目webapp目录下
     	把开发包引入到jsp文件中：`<link><script>`

     ```jsp
     <link href="jquery/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
     <link href="jquery/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css" type="text/css" rel="stylesheet" />
     
     <script type="text/javascript" src="jquery/jquery-1.11.1-min.js"></script>
     <script type="text/javascript" src="jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>
     <script type="text/javascript" src="jquery/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.js"></script>
     <script type="text/javascript" src="jquery/bootstrap-datetimepicker-master/locale/bootstrap-datetimepicker.zh-CN.js"></script>
     
     ```
     
     
     
2. 创建容器：`<input type="text"><div>`	把运行结果放到容器标签中,放到 text 文本框或div

3. 当容器加载完成之后，对容器调用工具函数.
    需要确保容器加载完成之后,所以把容器写在前面

依赖了 bootstrap 框架实现的日历,所以 bootstrap 框架也需要引入
datetimepickertest.jsp
还需要引入 jQuery 
jQuery -->  bootstrap ---> 日历

函数需要在容器加载完才能调用
所以要在 入口函数中调用
入口函数 : 是整个页面加载完成才执行
通过传参控制日历显示效果

让用户自己选,不要给写的权限

```jsp
$(function(){
	$("#create-startDate").datetimepicker({ // 这里的函数需要在入口函数中
		language:'zh-CN',
		format:'yyyy-mm-dd',
		minView:'month',
		initialDate:new Date(),
		autoclose:true,
		todayBtn:true,
		clearBtn:true
	})
});
<input type="text" class="form-control" id="create-startDate" readonly >
```



### 5. 分页查询市场活动

所有的分页查询都分为三个部分

*   第一部分 : 当主页面打开的时候显示所有数据的第一页
*   第二部分 : 当用户填写查询条件之后,查询出符合条件的第一页
*   第三部分 : 分页,用户切换页号的时候,或切换每页显示条数(默认每页显示条数,被改变的时候) 翻页需求

在当前项目中

1. 第一次点入市场活动的时候,显示无条件的查询数据,页码1,记录条数10
2. 用户输入查询条件后点击查询按钮,查询出符合条件的数据,页码1,记录条数
3. 翻页功能的时候,用户点击翻页,查询指定页码的指定数据

客户端

把查询条件放到 map 当中,jsp 的查询日期加插件
而且需要控制结束日期不能比开始日期早
单独写一个分页查询的函数,在两个位置调用分页的函数

发送的请求是 异步 的请求,携带用户查询条件以及页码

controller 接收参数的分析

​	controller 接收请求处理参数后封装成一个 map 去调用 service mapper,接收到 service 的数据后封装响应给客户端.这里需要封装的参数应该是什么 ? 首先查询出来的分页数据,然后还有总记录条数,可以用一个 map 将数据放进去.

mapper 中查询条件可能没有,使用 where 嵌套 if 标签进行自动判断拼接



翻页功能

使用 bootstrap 的 bs_pagination分页插件,在页面中展示翻页的按钮以及翻页后的函数调用

在查询分页的异步请求成功后的 success 函数后,加上bs_pagination 的$("#demo_pag1").bs_pagination 函数

当接收到分页数据,以及总记录条数,就可以对 $("#demo_pag1").bs_pagination 函数进行调用

只需要通过获取到的总记录条数和每页条数,就可以计算出总页数

对bs_pagination中的属性进行赋值,来完成翻页 div 的加载的工作

在 bs_pagination 中绑定了翻页事件的函数 : onChangePage ,但发生翻页,调用分页查询函数,传入分页条件查询



注意  : 为什么翻页放在了查询函数执行成功的时候
	首先我们分析一下什么时候需要加载分页 div 以及加载翻页需要的参数
翻页我们需要看到一共有多少页,一页有多少条,以及当前页码

总条数是在执行完分页查询后才能得到的,所以在这里将翻页放到了分页的方法中,这样可以直接获取到总条数
而总条数来算出总页数,需要pageSize,pageSize可以通过参数获取(分页查询是需要pageSize,pageNo)
因此totalRows和pageSize都有了

js 是弱类型语言,变量是没有类型的,因此获取totalPages,需要通过 parseInt 获取整数部分

```js
//计算总页数
var totalPages=1;
if(data.totalRows%pageSize==0){
    totalPages=data.totalRows/pageSize;
}else{
    totalPages=parseInt(data.totalRows/pageSize)+1;
}
```

分页逻辑

```
  1,queryActivityByConditionForPage(1,10)
       |->把pageNo,pageSize和查询条件一起发送到后台，查询数据
       |->data
            |->activityList：遍历list，显示列表
	    |->totalRows:调用工具函数，显示翻页信息
  2,当用户切换页号或者每页显示条数时：pageNo,pageSize
       |->翻页信息会自动变化
       |->手动刷新列表：
              |->把pageNo,pageSize和查询条件一起发送到后台，查询数据
	      |->data
	           |->activityList：遍历list，显示列表
	           |->totalRows:调用工具函数，显示翻页信息
```



```js
success:function (data){
    $("#activityList").html("");
    $.each(data.activities,function (index,element){
        $("#activityList").append('追加列表的代码')
    })

    var totalPages = 1;
    if (data.totalRows%pageSize==0){
        totalPages =data.totalRows/pageSize ;
    }else{
        totalPages =parseInt(data.totalRows/pageSize) +1;
    }
    $("#selectPageNo").bs_pagination({
        currentPage:pageNo, // 默认第一页  pageNo
        rowsPerPage:pageSize, // 默认一页十条  pageSize
        totalPages:totalPages, // 算出来   总页数 : 总条数/pageSize
        totalRows:data.totalRows, // 从哪来 总条数

        visiblePageLinks:5,
        showRowsPerPage:true,
        showGoToPage:false,
        showRowsInfo:false,

        onChangePage:function (event,pageObj){
            alert(totalPages+"-------------2"); // NAN
            queryActivityByConditionForPage(pageObj.currentPage,pageObj.rowsPerPage);
        }

    })
}
```

注意此时翻页也有了,但是用户当改变每页记录条数之后,当用户输入了查询条件进行分页查询,返回的页面中 pageSize 是不应该改变的,用户之前 pageSize = 2 ,查询后回到了默认的  pageSize = 10 这样不友好

因此当用户点击查询的时候,查询的参数不再是原来的(pageNo = 1,pageSize =10),应当动态获取上一次翻页加载的 pageSize ,这就需要使用bs_pagination 的函数来获取 

```js
 $("#demo_pag1").bs_pagination('getOption', 'rowsPerPage')
```



### 6. 活动的全选和取消全选

全选 checkbox : 通过 id 获取

所有 checkbox : 通过选择器来获取



全选 : 所有 checkbox 的值等于全选 checkbox 

反向全选,选中所有的 checkbox 后全选 checkbox 也应该显示被选中,如果有一个没有选中,全选 checkbox 也不会被选中  : 全选 checkbox = (所有 checkbox.size==所有 checkbox被选中.size)

### 7. 删除活动信息

首先删除活动的需求

​	用户选中(一个或多个)活动的 checkbox 后点击删除按钮, confirm 确认是否删除

客户端 : 需要获取到被选中的需要删除的活动的 id 

首先选择器和过滤器获取到所有选中的checkbox 对象的 jQuery 数组

遍历数组,将其 id 拼接成一个数组字符串

发起异步请求删除数据,删除成功更新页面,失败弹窗不更新

问题 :

*   前端怎么把数组发过去

    *   一开始用一个数组 var idArr = new Array(); idArr.put(id) 的方式

        但是,后台接收不到,查看 request.getParameterNames() 看到 name = idArr[]
        而且根据查到的资料,需要用 request.getParameter 的方式取,再用 JSONStr 的一个方式转 list 再转数组但是还是不行, mapper 的位置报错 说 where 中找不到 idArr 字段,但它就不该找这个

    *   所以后来看老师的方式 : 前台不穿数组类型,传的是个字符串 

        ```js
        var ids = "";
        checks.each(function (index,ele){
            ids += "id="+ele.value+"&"
        })
        ids=ids.substr(0,ids.length-1);
        ```

    *   ajax 中传参数

        *   data :{id :ids} 错误,后台收数据用的是自动注入,后台收的是 id=111&id=222&id=333
            *   controller 中的 String[] id 自动注入是从参数中注入的,不是 data 中的变量名
        *   data:ids  直接这样传,相当于把 data:  id=111&id=222&id=333 

*   后端怎么接收

    *   controller 直接用自动注入接收 String[] id 的方式就可以了

### 8. 修改活动表

	1. 点击修改按钮,判断选中的 checkbox 的数量
		> 1 提示
		< 1 提示
		= 1 发起异步请求,跳转到 修改页面
	1. 修改页面接收请求中携带的活动 id
	调用 service,mapper 查出指定 id 的Activity 并返回
	将 activity 返回给 index ,jsp 打开模态窗口,显示 activity的数据  !! 
	查询页面的所有者下拉框是怎么赋值的?用 value ,之前的下拉列表的 value 就是 owner的id ,所以查owner 查id就可以
		连接数据库不用查出 owner 的名字,直接查 id ,然后赋值value id 框架会自动将其 id 对应的name 选中点击更新和点击保存的操作是一样的,但是传递的参数中包含 id

### 9. 导出全部市场活动

1. 给"批量导出"按钮添加单击事件，发送导出请求

    ​	注意,所有文件下载的请求都是同步的请求

2. 查询所有的市场活动  conttoller 中需要查询出所有市场活动

    1. 判断list是不是为空,为空则不生成

3. 创建一个excel文件，并且把市场活动写到excel文件中

4. 把生成的excel文件输出到浏览器(文件下载)

### 10. 导入市场活动

1.   前台点击导入按钮,验证文件的合法性

     1.   判断文件是否为 xls 格式的

          *   通过获取文件名,截串获取后缀

          *   文件名的获取 : 注意直接通过jQuery获取对象 val 只能获取到文件名,不能获取到文件的本身

          *   截串获取后缀,截串从最后一个 . 的下一位开始到文件的结尾

          *   文件格式是不区分大小写的,excel文件的后缀 .xml .XML 都是可以的,所以转为小写再比较

              ```js
              var filename = $("#activityFile").val(); // 获取文件名
              if (filename.substr(filename.lastIndexOf(".")+1).toLowerCase()!="xls"){
                  alert("上传文件需要是 xls 格式的文件")
                  return;
              };
              <input type="file" id="activityFile">    
              ```

     2.   判断文件的大小不超过5M

          *   获取文件本身,需要通过 jQuery 转为 dom 对象 ($("#activityFile")[0]) 的files 方法会获取到文件的数组,再通过 [0] 获取到第一个文件对象

          *   文件大小通过 size 的属性来获取,这里如果使用的是 size() 是获取不到的

              ```js
              var activitiyFile = $("#activityFile")[0].files[0]; // 获取到文件的 dom 对象
              if(activitiyFile.size>5*1024*1024){
                  alert("上传的文件不能超过 5M");
                  return;
              }
              ```

2.   合法发送异步请求,发送数据,是上传的文件

     *   上传的文件是二进制的, ajax 的 data 是无法直接发送文件的,需要借助 FormData

     *   向 FormData 对象中放入文件,用 append 的方法参数为 (文件名,文件) 这里的文件名和后台接收是一致的

     *   ajax 中 data 为 formdata 对象

     *   需要设置 contnetType: false 设置 Ajax 向后台提交参数之前不要把参数统一转换成字符串

     *   设置 processData:false 设置 Ajax 向后台提交参数之前不要把参数统一an找 urlencoding 编码

         ```js
         var formdata = new FormData();
         formdata.append("activitiyFile",activitiyFile);
         //    到这文件大小和格式是合法的,发起ajax请求,异步
         $.ajax({
             url:"workbench/activity/importActivities.do",
             type:"post",
             data:formdata,
             dataType:"json",
             processData:false,
             contentType:false,
             success:function(res){
                 if (res.code==1){
                     alert(res.msg);
                     queryActivityByConditionForPage(1,$("#selectPageNo").bs_pagination('getOption','rowsPerPage'));
                     $("#importActivityModal").modal("hide"); // 关窗口 !! 刷一下列表
                 }else{
                     alert(res.msg);
                     $("#importActivityModal").modal("show"); //窗口不关
                     return;
                 }
             }
         })
         ```

         

3.   controller接收文件,解析文件,封装成 list 调用service

4.   service 调用 mapper 执行批量添加语句,统计总成功条数返回 controller

5.   controller 返回响应

疑问 : 

1.   用户上传的表中的所有者是姓名啊
     1.   给用户一个附录,id和姓名对应让用户自己输id
     2.   用户提供姓名,每次去数据库查,但是这种可能同名用户对应两个 id
     3.   去掉所有者字段,单独准备一个公共账号,所有上传来的数据都将所有者分配到这个公共账号
          领导再次分配
     4.   去掉所有者字段,所有上传来的数据所有者都设置成上传者
     
2.   多个市场活动插入,放list,遍历执行insert吗

     ​	不用,select 调用mapper 传参list 
     ​	mapper 在sql中拼接sql,foreach传入list
     ​	注意 resultType 

3.   创建时间是给它重新生成

4.   id UUID 生成

### 11. 查看市场活动详情

前端携带 id 发送请求,同步请求,打开了detail.jsp
前台 : 查看详情的操作的时候,怎么把 id 传过去的 ?,url 中拼接 id
controller : 
      调用 activityService 查询市场活动的全部信息,需要连接表查出创建人和修改人,得到一个 activity
      调用 activityRemarkService 查询市场活动对应的全部备注信息,得到一个 List`<ActivityRemark>`
	  将查出的数据放到 request 中,返回String,跳转到 detail.jsp

activityService : 调用 mapper 查出来,需要表连接,其中 editBy 可能是没有的,所以用外连接
activityRemarkService : 调用mapper 查出activityId 对应的所有的备注
activityMapper : 
      根据 id 查询活动信息的 sql 已经有了,是在修改市场活动信息的时候有的,但是当时的字段只有一部分
      重新写一个 sql
activityRemarkMapper : 逆向工程,写通过id查询 remark 的sql    

### 12. 增加市场活动备注

在市场活动详情页面,用户输入备注,点击保存,发起异步请求,添加备注

*   前台用户点击保存需要向后台传递的数据有哪些 ? 

    *   当前市场活动的 id ,备注的内容,当前市场活动的 id ,可以直接用 el 取,详情页面打开的时候 request 中有

*   controller 接收到请求后,调用 service,mapper 添加数据,封装参数

    *   根据字段,封装活动备注的 ID -- UUID 生成创建人,创建时间, editFlag
    *   ediflag : 是指当前记录是否被修改过,如果未被修改 为 0 , 已被修改则为 1 ,此处创建,设为 0

*   controller 接收返回的影响记录条数,根据结果返回一个 returnObject

*   前台接收到结果,要将当前页面刷新,但是再次连接数据库效率太低,因此通过追加一条记录 div 的方式

    *   追加需要的数据当中创建人需要的是姓名,可以通过在controller 返回的 returnObject 当中放入备注对象,创建人放入id(从 session 当中拿)

    *   怎么追加,页面中的状态如下,显然是没有办法通过 append 追加的,append 在某个父元素中追加,但是需要追加的内容在两个同级的 div 之间,所以采用 after 的方式

        ```js
        <div id='a'>
            <div id= 'b'> // 这是其他的div
            </div>
            <c:foreach>
                <div>
                    这里的内容是遍历的每一条备注
                </div>
            </c:foreach>
        	<div> // 这是其他的 div
        	</div>
        </div>
            
        ```

        

    *   after 实现在 id 为 b 的 div 之外的后面追加

        ```
        $("#b").after(追加div)
        ```

### 13. 修改删除市场活动备注

*   前台 : 用户点击修改,弹出模态窗口,填写修改后的备注点击更新发送请求

    *   修改在备注当中,是跟随用户查询出数据回来之后动态增加的,不是页面固有元素,因此要动态绑定单击事件,打开模态窗口函数

    *   模态窗口对应的备注对象,要获取对应备注的 id ,修改是给超链接,通过在修改中添加自定义属性,存入对应的 id,在代开模态窗口的函数中获取到属性的 id ,并将其放到一个 hidden 的text 标签中,获取当前单击事件对象的自定义属性值

    *   用户点击更新按钮,需要传递当前备注的id,备注是动态生成的,通过模态窗口中隐藏域获取 id 值

        ```js
        $("#remarkListSuperDiv").on("click",".editRemark",function (){
            var id = $(this).attr("remarkIdVal");  // 获取当前单击对象的自定义属性的属性值
            $("#remarkId").val(id); // 将数据放到隐藏域中
            $("#editRemarkModal").modal("show");
        })
        
        $("#updateRemarkBtn").click(function (){
            var remarkId =$("#remarkId").val(); // 通过隐藏域获取 id 的值
            var noteContent = $.trim($("#noteContent").val());
            if(noteContent==""){
                alert("备注内容不能为空");
                return;
            }
            $.ajax({
                url:"workbench/activity/updateActivityRemark.do",
                data:{
                    id:remarkId,
                    noteContent:noteContent
                },
                dataType: "json",
                type:"post",
                success:function (res){
                    if (res.code=='1'){
                        //  这里页面怎么替换掉 div???
                        $("#editRemarkModal").modal("hide");
                    }else{
                        alert(res.msg)
                        $("#editRemarkModal").modal("show");
                    }
                }
            })
        
        })
        ```

        

*   controller 接收请求,二次封装参数,返回一个 json : returnObject

*   前台页面接收响应的 json 对象

    *   成功,更新页面,关闭模态窗口

        *   更新连接数据库效率太低,在 controller 返回的对象中封装一个修改后的备注对象

        *   前台更新/删除这个备注的对象

        *   怎么更新

        *   获取到显示了备注信息的 div 元素,怎么获取,给 div 增加 id ,id 赋值为 remark.id

        *   通过有变量的 id ,获取备注id 对应的 div ,替换或移除

            ```js
            var idstr="#"+res.returnData.id; // 通过动态的 id 获取到div 对象,替换当中的内容
            $(idstr).html( // 这里是替换的 div 的内容
            '<img title="'+res.returnData.createBy+'" src="image/user-thumbnail.png" style="width: 30px; height:30px;">' +
            '<div style="position: relative; top: -40px; left: 40px;" >' +
            '<h5>'+res.returnData.noteContent+'</h5>'+
            '<font color="gray">市场活动</font> <font color="gray">-</font> <b>${activity.name}</b> <small style="color: gray;">'+res.returnData.editTime+'  由'+res.returnData.editBy+' 修改</small>'+
            '<div style="position: relative; left: 500px; top: -30px; height: 30px; width: 100px; display: none;">'+
            '<a class="myHref editRemark" remarkIdVal= "'+res.returnData.id+'"><span class="glyphicon glyphicon-edit" style="font-size: 20px; color: #E6E6E6;"></span></a>&nbsp;&nbsp;&nbsp;&nbsp;'+
            '<a class="myHref delRemark" remarkIdVal= "'+res.returnData.id+'" ><span class="glyphicon glyphicon-remove" style="font-size: 20px; color: #E6E6E6;"></span></a>')
            $("#editRemarkModal").modal("hide"); // 关闭模态窗口
            $("#noteContent").val(""); // 清空编辑框
            ```

            

    *   失败,弹窗,不关闭模态窗口

### 14. 线索功能的增删改查

1. 线索：初级销售 

		数据量最大，每一条数据最详细：tbl_clue
	
	有购买意向的线索，转换到高级销售阶段;
	没有购买意向的线索，删除掉.
	
	创建线索，查看线索明细，线索关联市场活动，解除线索和市场活动的关联关系,线索转换

2. 创建线索：


		tbl_dic_type  存储下拉列表的类型的，每一个下拉列表在tbl_dic_type对应一条记录,
		   主键值都是各自的编码,有含义的字段做主键，在程序如果需要用到这些主键值，可以直接使用。(可以直接写死)
			code	主键
			name
			description
			
		tbl_dic_value    : 存储每一个下拉列表中的选项值，通过type_code区分选项值属于哪一个下拉列表
			id
			value
			text
			order_no	展示下拉列表中的顺序
			type_code	外键

​	主键必须唯一非空因此业务做主键,数据字典用户添加数据的时候验证了不能重复的功能
​	当重复记录高的时候,表比较多的时候,主键不要是有业务含义的

### 15. 线索页面关联线索

### 

### 16. 线索转换

   线索是给初级销售人员使用；如果线索没有购买意向，则删除线索
   如果线索有购买意向，则把该线索信息转换到客户和联系人表中，把该线索删除。

   数据转换：
       把该线索中有关公司的信息转换到客户表中
       把该线索中有关个人的信息转换到联系人表中
       把该线索下所有备注信息转换到客户备注表中一份
       把该线索下所有备注信息转换到联系人备注表中一份
       把该线索和市场活动的关联关系转换联系人和市场活动的关联关系表中
       如果需要创建交易，则往交易表中添加一条记录
       如果需要创建交易，则还需要把该线索下所有备注转换到交易备注表中一份
       删除该线索下所有的备注
       删除该线索和市场活动的关联关系
       删除该线索

   以上所有操作必须在同一个事务中完成,在同一个service方法中完成。

### 17. 客户页面和联系人页面

1. 客户页面的交易和联系人根据 customerID 去查询
2. 客户页面的编辑和删除的功能已经被去掉了,删除需要删除所有相关的表格中的数据
3. 联系人同客户页面

### 18. 创建交易

用户点击交易菜单,进入交易主页面,分页+条件查询
用户在交易主页面，点击”创建”按钮，跳转到创建交易的页面；
用户在创建交易的页面填写表单，点击”保存”按钮，完成创建交易的功能。
1. 所有者、阶段、类型、来源 都是动态的
2. 市场活动源是可搜索的,不需要过滤关联过的市场,直接按照输入的名称模糊查询
3. 联系人也是可搜索的
4. 可能性是可配置的,是根据阶段从配置文件中读出来的
5. 客户名称支持自动补全===是要求全称
6. 表单验证
7. 保存成功之后，跳转到交易主页面,并在页面中显示刚才创建的交易
8. 保存失败，提示信息，页面不跳转

### 19. 交易创建中的客户名称自动补全

1.   给输入框添加键盘弹起事件
2.   后台接收到请求，根据名称模糊查询，返回到客户端
3.   把查询到的数据显示在输入框下边
          用户选择一个客户，实现自动补全















# 开发报错记录

### 1. Mybatis Could not find SQL statement to include with refid ‘xxx‘的问题

```xml
引用sql片段
	正确 :  <include refid="BaseResultMap" />
	错误 : <include refid="BaseResultMap" /></include>
```



### 2. java.lang.IllegalArgumentException: XML fragments parsed from previous mappers does not contain value for com.xxx.crm.settings.mapper.UserMapper.BaseResultMap

仔细检查mapper映射文件sql标签以及使用标签中的字段名和对应属性

```xml
<select id="selectUserByLoginActAndLoginPwd" parameterType="map" resultType="com.xxx.crm.settings.entity.User">  // 这里错误
    select <include refid="这里引用的写错了" />
    from tbl_user
    where login_act = #{loginAct} and login_pwd = #{loginPwd} // 这里是 # 不是 
</select>
```

要用一个 user 对象接收属性,属性名和列名对应的是应用自动生成的 BaseResultMap,就要写resultMap="BaseResultMap",而不是 resultType



### 3. RequestMapping 中的路径应该以斜杠开始,return 的视图逻辑名称不应该加 / 

RequestMapping 路径的前面应该是完整的 url : 协议 ip 端口号 应用名,用斜杠来代替了

```java
@RequestMapping("/workbench/main/index.do")
public String index(){
    return "workbench/main/index";
}
```



### 4. 模态窗口关闭语法

*   错误语法 : $("#createActivityModal").modal.show(); 
*   正确语法 : $("#createActivityModal").modal("show");

### 5. mapper 传参,limit 数字被拼接成了字符串

limit '1','10'

```java
    @RequestMapping("/workbench/activity/queryActivityConditionForPage.do")
    public @ResponseBody List<Activity> queryActivityConditionForPage(Integer pageNo,Integer pageSize){  // 这里传入 map 的类型需要是Integer,不能是String
        Map<String,Object> map = new HashMap<>();
        map.put("pageNo",pageNo);       // 这里应该放 startIndex么?
        map.put("pageSize",pageSize);
        List<Activity> activities = activityService.selectActivityByConditionForPage(map);
        return activities;
    }
```



### 6. 出错：java.lang.ClassNotFoundException: org.springframework.web.context.ContextLoade

### 7. 报错根据标记文件中的TLD或attribute指令,attribute[value]不接受任何表达式

foreach 标签中的 items 和 var 用反了

### 8. echarts 乱码

本地引用的echarts源文件，页面其他部分显示正常，唯独toolbox鼠标悬停在上面时提示信息显示乱码。

![image-20220630201114063](E:\学习资料\笔记\md笔记\image-20220630201114063.png)

解决办法

1.   把 echarts 文件拿出来放到桌面,笔记本打开,另存为,另存为改下编码方式 UTF-8/带有BOM 的 UTF-8

2.   引入的位置,设置 charset

     ```js
     <script src="jquery/echars/echarts.min.js" charset="UTF-8" ></script>
     ```

还是没有解决

```js
<script type="text/javascript" src="jquery/echars/echarts.min.js" charset="UTF-8" ></script>
```

最终发现在以上步骤没有清除缓存,每一个步骤清除缓存重新尝试,可以了

















# 开发技巧手记

### 1. 跨模块使用的类放在公共的包中 --> commons 

### 2. 将可以定义为常量的定义为常量,移植性高 常量：constant



















# 开发技术点补充与回顾

### 1. js 中两个数据比较都是用 == ,字符串比较都是 ==  非空是 !="";

### 2. jQuery Ajax请求中有一个参数 beforeSend

在用ajax请求时，没有返回前会出现前出现一个转动的loading小图标或者“内容加载中…”，用来告知用户正在请求数据。这个就可以用beforeSend方法来实现。和 success 是同级的

当ajax向后台发送请求之前，会自动执行本函数；
	该函数的返回值能够决定ajax是否真正向后台发送请求：
		如果该函数返回true,则ajax会真正向后台发送请求；
		否则，如果该函数返回false，则ajax放弃向后台发送请求。

```jsp
$.ajax({
    url:"settings/qx/user/login",
    type:"post",
    data:{
        "loginAct":loginAct,
        "loginPwd":loginPwd,
        "isRemPwd":isRemPwd
    },
    success:function (res){
        // alert(res.code)
        if (res.code=="0"){
            $("#msg").html(res.msg); // 失败显示信息
        }else{
            window.location.href = "workbench/index.do";
        }
    },
    beforeSend:function (){
        $("#msg").html("正在努力验证"); // 正在努力验证
    }
})
```

### 3. 回车登录功能实现

1.   绑定 keydown事件,但是给谁绑定 ?  -- window 对象

2.   注册事件的传参就是绑定的函数,函数中的参数就是 event,event 的 keycode 属性值就是检测到的键盘输入值

3.   回车 : event.keycode = 13

     ```jsp
     $(window).keydown(function (e){
         if(e.keyCode==13){
             // alert("test")
             $("#loginBut").click();
         }
     })
     ```

     

### 4. jquery事件函数的用法：

1.   选择器.click(function(){//给指定的元素添加事件
           //js代码
        });d
2.   选择器.click();//在指定的元素上模拟发生一次事件

### 5. 同步和异步请求的选择

*   同步请求：浏览器窗口发出的请求,响应信息返回到浏览器窗口,所以会进行全局刷新。
*   异步请求：ajax发出的请求,响应信息返回到ajax的回调函数,既可以进行全局刷新，也可以进行局部刷新。

总结：
	如果需要进行全局刷新，推荐使用同步请求，当然也可以使用异步请求；
	如果需要进行局部刷新，只能使用异步请求；
如果既可能进行全局刷新，也可能进行局部刷新，也是只能使用异步请求。

### 6. mybatis 逆向工程

#### 概述

由官方提供的一个工程模板，可以根据指定的数据库自动生成针对单表的所有的常规的增删改查的配置及接口。可以极大的方便设计者，不用再去创建大量的配置及书写接口，从而把精力集中到业务逻辑的实现上去，它的[源码](https://so.csdn.net/so/search?q=源码&spm=1001.2101.3001.7020)存放在github上，也提供了相关的具有逆向工程功能的Maven插件。

#### 使用步骤

1. 创建工程:crm-mybatis-generator(工程名)
    archetype 不用选模板,直接创建就可以了
    下一步如果默认该 model和其他模块有继承关系把继承去掉

2. 添加插件：
    依赖是 jar 插件是独立的程序可以独立的运行		build-->plugins-->plugin

  ```xml
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
  ```

  

3. 添加配置文件：将 generaotr.properties && generaotrConfig.xml 拷贝到 mybatis 的 src/main/resources 目录下根据自己的情况把需要该的配置信息改一下

    ```
    1. 数据库连接信息(generaotr.properties)
    	数据库的驱动位置,maven 底层仓库有
    2. 代码保存的目录 放在新建的目录下(generaotrConfig.xml )
           配置根据表生成的实体类存放的位置
                <javaModelGenerator   
           配置根据表生成的mapper存放的位置
                <sqlMapperGenerator   
            mapper接口的位置
                <javaClientGeneraotr
    3. 表的信息(generaotrConfig.xml )
    	表的信息
    		指定的表,要根据哪个表生成代码,只需要把哪一个表打开注释,不需要根据表生成的要注释掉
    ```

    

4. 运行mybatis的逆向工程，根据指定表生成java代码，保存到指定的目录中。
    点击右侧 maven--generator 的模块 plugins--> mybatis-generator--> mybatis-generator:generate

5. 在指定的包下去取结果

    *   对应于表的PO
    *   对应于PO的Mapper接口及映射文件
    *   对应于PO映射文件的可以生成执行条件的

6. 把逆向工程 生成的内容复制到需要使用的项目中

7. 使用逆向工程来实现需要的功能

### 7. 使用jquery获取指定元素的指定属性的值：

  选择器.attr("属性名");//用来获取那些值不是true/false的属性的值.
  选择器.prop("属性名");//用来获取值是true/false的属性的值.例如：checked,selected,readonly,disabled等。

获取 checkbox 的值 : 选择器.prop("checked")

### 8. el 表达式

##### 1. session 中取用户相关的数据的时候,可以直接通过变量名取

​	${loginAct} : 底层会先从 page,request,session 依次找过去,这样效率比较低
​	可以直接指定  ${sessionScope.user.name} 

##### 2. el 可以直接从 cookie 中取数据

​	${cookie.loginAct.value} 

*   注意 取出来数据需要使用value!不然取出的是 cookie 对象
*   cookie 也是一个作用域,在四大作用域之外还有其他的作用域,如 : cookie,param...
*   cookie也是内置对象, 所以可以直接拿来用

### 9. Session

​	session 可以用来保存用户当前登录的用户数据

*   处理器方法中可以直接通过注入的对象 : HttpSession 用,不用再从 request中获取

*   销毁session的语法

    ```java
    @RequestMapping("settings/qx/user/logout.do")
    public String logout(HttpSession session,HttpServletResponse response){	//直接加参数注入
        //        退出登录,
        //        销毁 cookie
        Cookie cookie1 = new Cookie("loginAct", "1");
        Cookie cookie2 = new Cookie("loginPwd", "1");
        cookie1.setMaxAge(0);
        cookie2.setMaxAge(0);
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        //        销毁session,
        session.invalidate();
        return "redirect:/";
    }
    ```

    

### 10. 发送请求的三种方式

*   地址栏 : window.loccation.href
*   超链接
*   表单

### 11. 拦截器的配置

拦截器拦截的路径和不拦截的路径
排除拦截路径的优先级比较高

```xml
<!--    声明拦截器-->
<mvc:interceptors>
    <mvc:interceptor>
        <!--            配置走拦截器的路径-->
        <mvc:mapping path="/settings/**"/>
        <mvc:mapping path="/workbench/**"/>
        <!--            配置不走拦截器的路径-->
        <mvc:exclude-mapping path="/settings/qx/user/doLogin"/>
        <mvc:exclude-mapping path="/settings/qx/user/login"/>
        <!--            拦截器的全限定类名-->
        <bean class="com.xxx.crm.settings.web.interceptor.LoginInterceptor" />
    </mvc:interceptor>
</mvc:interceptors>
```

```xml
<!--声明拦截器： 拦截器可以有0或多个-->
<mvc:interceptors>
    <!--声明第一个拦截器-->
    <mvc:interceptor>
        <!--指定拦截的请求uri地址
                path：就是uri地址，可以使用通配符 **
                      ** ： 表示任意的字符，文件或者多级目录和目录中的文件
                http://localhost:8080/myweb/user/listUser.do
                http://localhost:8080/myweb/student/addStudent.do
            <mvc:mapping path="/user/**"/> 拦截所有 user开头的请求
            -->
        <mvc:mapping path="/**"/>
		<!--指定不被拦截的路径-->
        <mvc:exclude-mapping path="/settings/qx/user/login"/>
        <!--声明拦截器对象-->
        <bean class="com.bjpowernode.handler.MyInterceptor" />
    </mvc:interceptor>
</mvc:interceptors>
```

### 12. Cookie的路径

该路径可通过setPath("/xxx")进行设置,这个路径直接决定服务器的请求是否会从浏览器中加载某些Cookie。

首先默认情况下，如果不设置Cookie的path，默认是“/项目名/当前路径的上一层地址”，如：请求路径：/cookie/cookieDome/servlet/login，Cookie的请求路径：/cookie/cookieDome/servlet

如果我们设置path，如果当前访问的路径包含了Cookie的路径（当前访问路径在Cookie路径基础上要比Cookie的范围小）Cookie就会加载request的对象之中。

再次强调：这个路径就是请求的上一层路径，
例如在请求http://loaclhost/day01/servlet/hello时，
服务器响应了一个Cookie，那么这个Cookie的默认路径就是/day01/servlet，默认当前请求路径的上一级。

注意：在设置cookie路径时最好不要写死，可通过request.getContextpath()来获取当前项目的根目录来设置。

```java
cookie.setPath(request.getContextPath+"/")
```

### 13. 关于重定向的路径

sendRedirect("") : 此时需要加上项目名,这里浏览器发起新的请求

controller 中的处理器方法返回路径的时候 : return("redirect:xxx") 此时不加项目名
这里时借助框架来重定向,框架在底层会调用 sendRedirect("")  并帮你加上项目名

### 14. 项目的请求路径要书写规范,有规律

这样当你需要拦截请求的时候,可以很方便,总结需要拦截路径的特点就可以了

### 15. 什么时候需要创建新的 controlller

当这个方法跳转的资源占用一个独立的资源目录,就需要创建新的controller

### 16. 在指定的窗口打开网页

```jsp
window.open("workbench/main/index.do","workareaFrame");
在 workareaFrame 窗口中打开workbench/main/index.do 
下面指定了一个 div 的位置并命名为 workareaFrame
  <!-- 工作区 -->
<div id="workarea" style="position: absolute; top : 0px; left: 18%; width: 82%; height: 100%;">
    <iframe style="border-width: 0px; width: 100%; height: 100%;" name="workareaFrame">	</iframe>
</div>

```



### 17. 页面切割技术

1.   `<frameset>`和`<frame>`：效率低,这两个标签都是重量级的标签

     1.   `<frameset>`：用来切割页面.只能用来切割页面 : 行和列只能选一个,不能同时使用

          ```jsp
          <frameset cols="20%,60%,20%" > 按行切
          <frameset rows="10%,80%,10%"> 按列切	
          ```

     2.   `<frame>`：显示页面,每一个`<frame>`标签就是一个独立的浏览器窗口。
          name 作为一个标识不能重名,target指定带开的窗口位置,用 name 指定

          ```jsp
          <frame src="url">
          <frameset cols="20%,60%,20%">
              <frame src="url1" name="f1">
              <frame src="url2" name="f2">
              <frame src="url3" name="f3">
          </frameset>            
          <a href="url" target="f3">test</a>
          ```

2.   `<div>`和`<iframe>`：效率高,这两个标签都是轻量级的

     1.   `<div>`：切割页面。

          ```jsp
          <div style="height:10%;width=20%">
          ```

     2.   `<iframe>`:显示页面。

          ```jsp
          <div style="height:10%;width=20%">
          	<iframe href="url">
          </div>
          ```

### 18. 模态窗口

模态窗口：模拟的窗口,本质上是<div>，通过设置z-index大小来实现的;
	初始时，z-index初始参数是<0，所以不显示；
	需要显示时，z-index值设置成>0即可。

​	bootstrap来控制z-index的大小。

控制模态窗口的显示与隐藏：

*   方式一：通过标签的属性data-toggle="modal" data-target="模态窗口的id"(就是哪个 div 的id)
*   方式二：通过js函数控制： 
    		选择器(选中div).modal("show");//显示选中的模态窗口
    		选择器(选中div).modal("hide");//关闭选中的模态窗口

*   方式三：通过标签的属性data-dismiss=""
    		点击添加了data-dismiss=""属性的标签，自动关闭该标签所在的模态窗口。在模态窗口的div中关闭当前窗口的时候可以给按钮绑定该属性

    ```jsp
    <button type="button" class="btn btn-primary" data-dismiss="modal" id="logoutBut" >确定</button>
    ```

    

模态窗口的意义：
	window.open("url","_blank"); 这种方式打开的是两个窗口,是两个 window.document 对象

​	模态窗口本质上就是原来页面中的一个`<div>`，只有一个页面;所有的操作都是在同一个页面中完成。
​	这种方式是在一个页面中,数据传递方便

### 19. 通常id 主键使用 UUID 的方式

自增id的效率比较低,所以通常使用 UUID,封装一个工具类,用的时候直接调用就可以了

获取 UUID, toString 之后是有分隔符的,通常把分隔符去掉,就可以得到一个32为的字符串

```java
return UUID.randomUUID().toString().replace("-","");
```

### 20. service为什么注解要起名字啊

因为默认的起名规则是 : activityServiceImpl

```java
@Service("activityService")
public class ActivityServiceImpl implements ActivityService {}
```

### 21. 注入接口应该用private

```java
@Service("activityService")
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    ActivityMapper activityMapper;  // 这里应该 private

    @Override
    public int saveCreateActivity(Activity activity) {
        return activityMapper.insertActivity(activity);
    }
}
```

### 22. 表单reset是 dom 对象的方法 

jQuery 对象先 get(0) 转换成 dom 对象再调用 reset() 方法



### 23. mapper 中参数运算

用 ${} 在这里进行运算 ,#{}是无法运算的,通常 limit 的 第一个参数起始下标命名为 beginNo

```xml
<select id="selectActivityByConditionForPage"  resultMap="BaseResultMap" >
  select u.name owner,a.name,a.start_date,a.end_date
  from tbl_activity a
  join tbl_user u
  on a.owner= u.id
  limit ${pageSize*(pageNo-1)},#{pageSize}
</select>
```

### 24. js 中函数应该声明在哪

封装函数要在 入口函数之外,script 标签之内封装,不要在入口函数中封装

```jsp
$(function(){})里面不能写函数，只能写js语法
如下：
$(function(){
   sayHello();//此时运行程序会弹出hello
});
function sayHello()
{
  alert("hello");
}
```

### 25. js 中一个标可以有多个class

```jsp
<input type="text" class="form-control showCalender" id="create-startDate" readonly >
```

class 之间用空格隔开,这样可以对自己想要选取的一类声明同样的 class $(.calender) 这样就可以获取到了

### 26. 内连接的效率更高,以及 where 中不能有别名

不行的，where语句在select语句之前执行，那时候别名还没取上去

### 27. jsp 中命名

button xxBtn

b 标签 xxB

超链接 xxA

### 28. js变量只能用 jQuery 的 each,不能用 jstl 标签的 foreach

如 Ajax 中的函数中就不能用 jstl 因为他们只是局部变量不是作用域里的数据,所以不能用

遍历 作用域中的数据用 jstl 标签结合 el 来用



### 29. submit 回向后台发送同步请求 !!!

### 30. JS 是弱类型语言,执行 5/2 会得到 2. 5 ,当需要取整的时候 parseInt()

parseInt(2.5) = 2



### 31. bs_pagination翻页插件的使用

bs_pagination 翻页插件是bootstrap 提供的,因此当需要使用的时候需要先将 bootstrap 相关的插件引入

而 bootstrap 插件又是基于 jQuery 来实现的因此需要先将 jQuery 的插件引入

引入的顺序很重要 : 先引入被依赖的插件,因此引入顺序是 jQuery --> bootstrap -->bs_pagination

```jsp
<%--jQuery--%>
<script type="text/javascript" src="jquery/jquery-1.11.1-min.js" ></script>
<%--bootstrap--%>
<link href="jquery/bootstrap_3.3.0/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="jquery/bootstrap_3.3.0/js/bootstrap.min.js" ></script>
<%-- pagination pllugin--%>
<link rel="stylesheet" type="text/css" href="jquery/bs_pagination-master/css/jquery.bs_pagination.min.css">
<script type="text/javascript" src="jquery/bs_pagination-master/js/jquery.bs_pagination.min.js" ></script>
<script type="text/javascript" src="jquery/bs_pagination-master/localization/en.js" charset="UTF-8" ></script>

```

bs_pagination 插件的使用

1.   引入jar
2.   创建容器,这里采用的是 div 的方式
3.   js 函数

函数的参数以及使用方式

官网

创建容器,给一个 div 并指定 id

```jsp
<div id="demo_pag1"></div>
```

使用 js 函数

```js
$(function() {
    $("#demo_pag1").bs_pagination({
        currentPage:1,//当前页号,相当于pageNo

        rowsPerPage:10,//每页显示条数,相当于pageSize
        totalRows:1000,//总条数
        totalPages: 100,  //总页数,必填参数. 这个是唯一必须的参数

        visiblePageLinks:5,//最多可以显示的卡片数

        showGoToPage:true,//是否显示"跳转到"部分,默认true--显示
        showRowsPerPage:true,//是否显示"每页显示条数"部分。默认true--显示
        showRowsInfo:true,//是否显示记录的信息，默认true--显示

        //用户每次切换页号，都自动触发本函数;
        //每次返回切换页号之后的pageNo和pageSize
        onChangePage: function(event,pageObj) { // returns page_num and rows_per_page after a link has clicked
            //js代码
            alert(pageObj.currentPage);
            alert(pageObj.rowsPerPage);
        }
    });
});
$("#selectPageNo").bs_pagination('getOption', 'rowsPerPage') // 获取当前的参数
```

### 32. 显示动态的jsp片段

选择器.html(jsp页面片段的字符串);//覆盖显示
选择器.append(jsp页面片段的字符串);//追加显示
选择器.after(jsp页面片段的字符串);
选择器.before(jsp页面片段的字符串);
选择器.text(jsp页面片段的字符串);

### 33. js 选择器和过滤器

*   表单选择器
    		$(":checkbox") : 选中所有的 checkbox

*   属性过滤选择器 : 过滤规则是通过元素的属性来获取相应的元素。
    	$("input[type='checkbox']") : 选取属性 type 为checkbox 的`<input>`元素
    	$("div[title=test]") : 选取属性 title 为test 的`<div>`元素

*   表单过滤器,所有被选中的 checkbox
    	$("input[type='checkbox']:checked")
    	$(":checkbox:checked")

*   层级选择器
    	祖先后代、父子选择器、相邻选择器、兄弟选择器
    *   ancestor descendant 祖先后代选择器
        	在给定的祖先元素下匹配所有的后代元素
    *   parent > child 父子选择器
        	在给定的父元素下匹配所有的子元素(这里只能直接子元素,就是只能是一级的关系)

​			只能选直接子标签 空格可以获取所有

​	$("#tBody input[type='checkbox']") ; 父子选择器,所有 tbody 中的 checkbox

​	$("#tBody input[type='checkbox']:checked") : 父子选择器过滤,所有 tbody 中被选中的 checkbox 

### 34. 在页面中给元素添加事件语法：  这三种记死了,够用的!!

动态绑定事件函数不能用 .cllick 应该用 .on(click,选择器)

```
1. 使用元素的事件属性：onxxxx="f()"   
2. 使用jquery对象：
     选择器.xxxx(function(){  
     		// onxxx属性和xxx事件函数是 一一对应的
     //js代码});
     只能给固有元素添加事件
     固有元素：当调用事件函数给元素添加事件时，如果元素已经生成，则这些元素叫做固有元素；
     动态生成的元素：当调用事件函数给元素添加事件时，如果元素还没有生成，后来生成的元素叫做动态生成的元素。
3. 使用jquery的on函数：
    父选择器.on("事件类型",子选择器,function(){
        //js代码    
    //this});
    
    父 : remarkListSuperDiv
    子 : remarkDiv
    事件 : mouseover
    注意子选择器是个字符串 !!! 
    事件也是一个字符串
    $("#remarkListSuperDiv").on("mouseover",".remarkDiv",function (){
        $(this).children("div").children("div").show();
    })

父元素:必须是固有元素,可以直接父元素,也可以是间接父元素.(一级或多级,父元素的父元素)
	原则固有父元素范围越小越好.
事件类型：跟事件属性和事件函数一一对应。
子选择器：目标元素,跟父选择器构成一个父子选择器
! !不但能给固有元素添加事件，还能够给动态生成的元素添加事件。
```

### 35. js 中截串

```js
截掉最后一位 : ids=ids.substr(0,ids.length-1);

str.substr(startIndex,length);//从下标为startIndex的字符开始截取，截取length个字符
str.substr(startIndex)//从下标为startIndex的字符开始截取，截取到字符串的最后
str.substring(startIndex,endIndex)//从下标为startIndex的字符开始截取，截取到下标是endIndex的字符
var str="beijing";
str.substr(2,3);//iji
str.substring(2,3);//ij

```



### 36. mybatis 中 insert delete update 自动返回 int - 影响记录条数,所以不用写 resultMap resultType ,写了就错了

### 37. ajax向后台发送请求时，可以通过data提交参数,data的数据格式有三种格式：

1. data:{

			k1:v1,
			k2:v2,
			....
			}
		劣势：只能向后台提交一个参数名对应一个参数值的数据，
				不能向后台提交一个参数名对应多个参数值的数据。
				k2:v2,
				k2:v3,
				后台只能收到 v3
				只能向后台提交字符串数据
		优势：操作简单

2. data:k1=v1&k2:v2&....

			优势：不但能够向后台提交一个参数名对应一个参数值的数据，
				还能向后台提交一个参数名对应多个参数值的数据。
		劣势：操作麻烦,你得拼串
				只能向后台提交字符串数据

3. data:FormData对象

		序列化表单
	​	优势：不但能提交字符串数据，还能提交二进制数据
	​	劣势：操作更复杂

### 38. 当 ajax 中 data 只传一个参数

```
// data:{id:id},
data:id,  直接这样就可以了
```

### 39. sql中传参封装参数：

1. 如果做查询条件，或者参数之间不是属于一个实体类对象，封装成map
2. 如果做写数据，并且参数本来就是属于一个实体类对象，封装成实体类对象.

		如果写的数据是属于一个实体类对象,封装成实体类对象.
		如果写的数据是属于多个实体类对象,封装成map



### 40. 数据库表中字段名多个单词之间用下划线隔开 user_name



### 41. excel,ppt,pdf 都是有有格式的文件 

音频,视频,java源代码都是没有格式的

excel,ppt,pdf 都是有有格式的文件 (颜色,字体,加粗...格式),io 是操作不了的

​     

### 42. jQuery 中的 each 函数中的变量

```js
函数中的变量可以没有
$.each(遍历的对象,function(index,ele){})
$.each(遍历的对象,function(){
	this 相当于 ele
})
```



### 43. apache poi 办公软件插件

使用java生成excel文件：iText,apache-poi

​	关于办公文档插件使用的基本思想：把办公文档的所有元素封装成普通的Java类，
​				 程序员通过操作这些类达到操作办公文档目的。
​	文件---------HSSFWorkbook
​	页-----------HSSFSheet
​	行-----------HSSFRow
​	列-----------HSSFCell
​	样式---------HSSFCellStyle

apache poi 是用Java语言编写的,免费开源的跨平台的 JavaAPI ,Apache POI提供API给Java程序对[Microsoft Office](https://baike.baidu.com/item/Microsoft Office)格式档案读和写的功能

HSSF [1] － 提供读写[Microsoft Excel](https://baike.baidu.com/item/Microsoft Excel) [XLS](https://baike.baidu.com/item/XLS)格式档案的功能。使用apache-poi生成excel文件

使用apache-poi生成excel：
1. 添加依赖：

   ```xml
   <dependency>
   	<groupId>org.apache.poi</groupId>
   	<artifactId>poi</artifactId>
   	<version>3.15</version>
   </dependency>
   ```

2. 使用封装类生成excel文件：

```java

/**
 * 使用apache-poi生成excel文件
 */
public class CreateExcelTest {
    public static void main(String[] args) throws Exception{
        //创建HSSFWorkbook对象，对应一个excel文件
        HSSFWorkbook wb=new HSSFWorkbook();
        //使用wb创建HSSFSheet对象，对应wb文件中的一页
        HSSFSheet sheet=wb.createSheet("学生列表");
        //使用sheet创建HSSFRow对象，对应sheet中的一行
        HSSFRow row=sheet.createRow(0);//行号：从0开始,依次增加
        //使用row创建HSSFCell对象，对应row中的列
        HSSFCell cell=row.createCell(0);//列的编号：从0开始，依次增加
        cell.setCellValue("学号");
        cell=row.createCell(1);
        cell.setCellValue("姓名");
        cell=row.createCell(2);
        cell.setCellValue("年龄");

        //生成HSSFCellStyle对象
        HSSFCellStyle style=wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);

        //使用sheet创建10个HSSFRow对象，对应sheet中的10行
        for(int i=1;i<=10;i++){
            row=sheet.createRow(i);

            cell=row.createCell(0);//列的编号：从0开始，依次增加
            cell.setCellValue(100+i);
            cell=row.createCell(1);
            cell.setCellValue("NAME"+i);
            cell=row.createCell(2);
            cell.setCellStyle(style);
            cell.setCellValue(20+i);
        }

        //调用工具函数生成excel文件
        OutputStream os=new FileOutputStream("D:\\course\\18-CRM\\阶段资料\\serverDir\\studentList.xls");//目录必须手动创建，文件如果不存在，poi会自动创建
        wb.write(os);

        //关闭资源
        os.close();
        wb.close();

        System.out.println("===========create ok==========");
    }
}

```

使用apache-poi解析excel：

使用 mvc框架获取到从前台上传的 xls 文件

```java
@RequestMapping("/test/fileuploadtest.do")
public @ResponseBody Object fileUploadtest(MultipartFile uploadfile) throws IOException {

    InputStream is = uploadfile.getInputStream();// 将springmvc自动装配的MultipartFile对象,转换为输入流对象
    HSSFWorkbook wb = new HSSFWorkbook(is); // 这里不是创建新的 wb 对象,通过构造传参将文件转换为wb对象

    HSSFSheet sheet = wb.getSheetAt(0);// 通过 wb 对象获取sheet对象
    int rowCount = sheet.getLastRowNum(); // 获取到总行数
    System.out.println("行数"+rowCount);
    // 将对象在循环外声明,减少对象的创建次数,提高效率
    HSSFRow row = null;
    HSSFCell cell = null;

    List<UserTest> userTestList = new ArrayList<>();
    UserTest user = null;

    for (int i = 1; i <= rowCount; i++) {
        row = sheet.getRow(i); // 拿到行 从第一行开始,略过表头
        int cellCount = row.getLastCellNum();
        System.out.println("总列数 : "+cellCount);
        cell = row.getCell(0); // 拿到第一个单元格
        String id = Integer.toString((int) cell.getNumericCellValue()); // 获取第一个单元格的值,关于获取值
        //            String a = cell.getStringCellValue();
        //            double b =cell.getNumericCellValue();
        //            boolean c =cell.getBooleanCellValue();
        //            Date d = cell.getDateCellValue();


        cell = row.getCell(1);
        String uname = cell.getStringCellValue();
        System.out.println(uname);

        cell = row.getCell(2);
        int age = (int) cell.getNumericCellValue();

        user = new UserTest(id,uname,age);
        userTestList.add(user);
    }

    System.out.println("end");


    return null;
}
```

方法详解

1.   获取总行数和总列数和的计数方式不同
     获取行数获取到的值是从0计数,如总共5行数据,获取到的最大行号=4

     ```java
     int rowCount = sheet.getLastRowNum(); // 获取到最大行数 5行返回4
     ```

     获取列数获取到的值是列的数量,如共3列数据,获取到的最大列值就是3

     ```java
     int cellCount = row.getLastCellNum(); // 获取列的数量 3 列 返回3
     ```

2.   通过 cell 获取数据根据它本身的数据类型不同方法名不同,当初传入数据的时候方法名都是cell.setCellValue(100+i);,参数重载了,但是取数据的时候,如果数据是个int,用String取,会报异常
     以及数字类型的只有double类型,自己需要转换

     ```java
     String a = cell.getStringCellValue();
     double b =cell.getNumericCellValue();
     boolean c =cell.getBooleanCellValue();
     Date d = cell.getDateCellValue();
     ```

     

### 44. controller 中调用 poi 生成 excel 直接返回给浏览器

controller 中处理器方法的分析

1.   返回值应当是什么? 返回值是让springmvc 框架帮我们将数据处理返回给浏览器,但是springmvc框架能处理的数据类型, Object,String,ModelAndView.. 帮我们将返回值改变格式等操作,但是对于文件,springmvc框架是没有办法处理的,因此用response的方式返回一个流

2.   response 返回一个文件,前台的解析,首先所有文件的下载的请求都只能发送同步请求,响应返回的是一个文件,不会显示到窗口上,会返回到下载窗口,窗口是不会覆盖的,返回文件需要设置响应类型

     ```java
     response.setContentType("application/octet-stream;charset=UTF-8");
     ```

3.   但是当response返回一个文件的时候,默认情况下，直接在显示窗口中打开响应信息；即使打不开，也会调用应用程序打开；只有实在打不开，才会激活文件下载窗口。
     但我们希望浏览器不去打开文件,直接跳转到下载窗口,可以设置响应头信息，使浏览器接收到响应信息之后，直接激活文件下载窗口，即使能打开也不打开(attachment : 附件)

     ```java
     response.addHeader("Content-Disposition","attachment;filename=mystudentList.xls");
     ```

4.    注意 : 所有文件的下载的请求都只能发送同步请求

### 45. 当需要在循环体内每次循环获取一个对对象,把创建对象拿到循环外面,效率更高 不用每次都创建对象

```java
Activity a = null;  // 
for (int i = 1; i <= activities.size(); i++) {
//   Activity a = activities.get(i-1);
	a = activities.get(i-1);
}
```

### 46. 文件上传

文件上传的表单三个条件：

    1.表单组件标签必须用：<input type="file">
      <input type="text|password|radio|checkbox|hidden|button|submit|reset|file">
                      <select>,<textarea>等
    2.请求方式只能用：post
      get：参数通过请求头提交到后台，参数放在URL后边；只能向后台提交文本数据；对参数长度有限制；数据不安全；
    	效率高
      post：参数通过请求体提交到后台；既能能提交文件数据，又能够提交二进制数据；理论上对参数长度没有限制；相对安全；效率相对较低
    3.表单的编码格式只能用：multipart/form-data : multipart 多样性的
      根据HTTP协议的规定，浏览器每次向后台提交参数，都会对参数进行统一编码；默认采用的编码格式是urlencoded，这种编码格式只能对文本数据进行编码；
      浏览器每次向后台提交参数，都会首先把所有的参数转换成字符串，然后对这些数据统一进行urlencoded编码；
      文件

springmvc 框架使用的话必须在springmvc的配置文件上传解析器,否则是不能通过框架将post中的参数自动注入到 controller 处理器方法中的参数的
在 springmvc 的配置文件中配置上传解析器 id:必须是multipartResolver,因为是springmvc的框架通过自动装配的方式,所以 id 需要符合 首字母小写,它才能找得到

```xml
<bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">       	 	
    <property name="maxUploadSize" value="#{1024*1024*5}"/>
    <property name="defaultEncoding" value="utf-8"/>
</bean> 
```

### 47. 通过 ajax 发送文件的格式

1.   首先通过 jQuery 获取到的文件对象只能获取到文件名,是不能获取到文件本身的 var file = $("#fileid").val()

2.   获取文件本身需要使用 FormData 
     FormData 是 ajax 提供的接口,可以模拟键值对向后台提交参数
     FormData 最大的又是是不但能提交文本数据,还能提交二进制数据
     当需要提交一个文件的时候,就可以使用 FormData
     当需要同时传一个普通类型,字符串也是可以的

3.    通过设置 processData:false : 设置ajax向后台提交参数之前，不要把参数统一转换成字符串：true--是,false--不是,默认是true

4.   ajax 模拟浏览器的行为发送请求对数据的编码方式默认是 urlencoding

     *   通过设置 contentType:false : 设置ajax向后台提交参数之前，不要把所有的参数统一按urlencoded编码：true--是,false--不是，默认是true

     ```js
     var activityFileName=$("#activityFile").val(); // 通过 jQuery 获取文件对象 .val只能获取文件名
     
     // 注意先通过jQuery获取id为activityFile的对象,获取到的是个jQuery对象,通过[0]转换为dom对象,再调用dom对象的files方法获取一个文件的数组,虽然浏览器只允许一次上传一个文件,但是方法的设计上是允许上传多个文件的,因此得到的又是给数组,[0]才能得到你上传的文件的对象
     var activityFile=$("#activityFile")[0].files[0]; // 通过jQuery->DOM获取文件对象的files是个数组
     var formData=new FormData();
     formData.append("activityFile",activityFile); // activityFile 参数名,参数是文件的 dom 对象
     formData.append("userName","张三"); // 同时传一个字符串参数也是可以的
     $.ajax({
         url:'workbench/activity/importActivity.do',
         data:formData,
         processData:false,//设置ajax向后台提交参数之前，是否把参数统一转换成字符串：true--是,false--不是,默认是true
         contentType:false,//设置ajax向后台提交参数之前，是否把所有的参数统一按urlencoded编码：true--是,false--不是，默认是true
         type:'post',
         dataType:'json',
         success:function (data) {
             if(data.code=="1"){
                 //提示成功导入记录条数
                 alert("成功导入"+data.retData+"条记录");
                 //关闭模态窗口
                 $("#importActivityModal").modal("hide");
                 //刷新市场活动列表,显示第一页数据,保持每页显示条数不变
                 queryActivityByConditionForPage(1,$("#demo_pag1").bs_pagination('getOption', 'rowsPerPage'));
             }else{
                 //提示信息
                 alert(data.message);
                 //模态窗口不关闭
                 $("#importActivityModal").modal("show");
             }
         }
     });
     			
     ```

     


### 48. 关于同步请求能够解析 json 吗

同步请求不能返回 json 解析不了

### 49. 给元素扩展属性

html页面是可扩展的标记语言，可以给指定的标签任意扩展属性，只要属性名符合标识符的命名规则即可。

作用

1.   在 jsp 中使用标签保存数据,以便在需要的时候获取到这些数据
     *   给标签添加属性
         *   如果是表单组件中的标签,优先使用 value ,只有 value 不方便使用的时候,再使用自定义的标签
         *   如果不是表单组件标签,不推荐使用 value,推荐使用自定义的属性
     *   获取添加的自定义属性的属性值
         *   获取表单组件标签的 value 属性,
             *   dom : dom 对象.value;
             *   jQuery : jQuery 对象.val();
         *   自定义属性
             *   对于自定义属性,不管是什么标签,只能用 jQuery 对象.attr("属性名");
2.   定位标签
     *   优先考虑 id 属性,其次考虑 name 属性,只有 id 和 name 属性都不方便使用时,使用自定义属性

​	



### 50. 把页面片段显示在动态显示在页面中

*   选择器.html(htmlStr)：覆盖显示在标签的内部

*   选择器.text(htmlStr)：覆盖显示在标签的内部

*   选择器.append(htmlStr)：追加显示在指定标签的内部的后边

    ```jsp
    <div id="myDiv">
        aaaaaaaaa
        bbbbbbbbb
    </div>
    var htmlStr="<p>ccccccccc</p>";
    $("#myDiv").append(htmlStr);
    <div id="myDiv">
        aaaaaaaaa
        bbbbbbbbb
        <p>ccccccccc</p>
    </div>
    ```

    

*   选择器.after(htmlStr)：追加显示在指定标签的外部的后边

    ```jsp
    <div id="myDiv">
        aaaaaaaaa
        bbbbbbbbb
    </div>
    var htmlStr="<p>ccccccccc</p>";
    $("#myDiv").after(htmlStr);
    <div id="myDiv">
        aaaaaaaaa
        bbbbbbbbb
    </div>
    <p>ccccccccc</p>
    ```

    

*   选择器.before(htmlStr)：追加显示在指定标签的外部的前边

    ```jsp
    <div id="myDiv">
        aaaaaaaaa
        bbbbbbbbb
    </div>
    var htmlStr="<p>ccccccccc</p>";
    $("#myDiv").before(htmlStr);
    <p>ccccccccc</p>
    <div id="myDiv">
        aaaaaaaaa
        bbbbbbbbb
    </div>
    
    ```

### 51. 单击事件中获取发生单击事件的元素的某个自定义属性的值

*   获取当前对象,用 this ,获取到的是个 dom 对象

*   获取自定义属性的值,只能通过 jQuery 对象,将 dom 对象转为 jQuery 对象,再通过 attr 获取自定义属性的值

    ```jsp
    // 获取选择器中发生单击事件的当前元素的 remarkIdVal 属性的值
    $("#remarkListSuperDiv").on("click",".editRemark",function (){
    	var id = $(this).attr("remarkIdVal");
    	$("#remarkId").val(id);
    	$("#editRemarkModal").modal("show");
    })
    ```

### 52. el 中的三目运算符

注意整体是个 el 表达式

```js
正确 : ${remark.editFlag=='1'?remark.editBy:remark.createBy}
错误 : ${remark.editFlag}=='1'?${remark.editBy}:${remark.createBy}
当需要展示的数据是字符串
正确 : ${remark.editFlag=='1'?'修改':'创建'} // 这样可以根据三目的运算结果直接输出字符串
错误 : ${remark.editFlag=='1'?修改:创建'} // 这种写法会让 el 去域中找变量名为 修改/创建 的变量
```

### 53. 在 id 中使用变量 以及  通过id 删除对应的元素 以及通过 id 替换 div 中的内容

```js
var idstr = "#"+id;  // 在外面拼好串
$(idstr).remove();
$(idstr).html("当中是需要替换的内容");

$("#d"+id).remove(); 直接在选择器中拼串是不是也可以


拼串父子选择器
$("div_"+res.returnData.id9+" h5").text(xxx)
```

### 54. EL 表达式在 js 中使用都需要放在引号中

xxxjsp的运行原理：
1. tocmat中运行：
      把xxx.jsp翻译成一个servlet,
      运行servlet,运行的结果是一个html网页
      把html网页输出到浏览器
2. html网页在浏览器上运行：
      先从上到下加载html网页到浏览器，在加载过程中，运行前端代码
      当页面都加载完成，再执行入口函数.

因此当加载 js 中的内容的时候,已经将 jsp 翻译成 html 网页了,el是从域中取数据,在加载 js 的时候,el 表达式已经变成数据了

```
request : name = zhangsan 
var a = ${name}
加载js 的时候已经变成了
var a = zhangsan
此时 zhangsan 会被当作一个变量,会去当前页面中找变量 zhangsan , 而不是将 变量 a 赋值为 zhangsan
```

### 55. 关于 service 和 mapper 中方法的命名

*   save -----> insert
*   query ----> select
*   saveEdit -----> update

### 56. 根据某个变量将将id设置为动态的

id='user.id'

当有多个组件的 id ,都需要通过某个变量来设为 id 以便定位元素

如 : div 的id 用当前某个对象的 id 作为 div 的 id ,那么通过对象的 id 可以定位到对应 div 的元素

如果此时有另一个组件,如 span 也需要用对象的 id 来表示定位dom 元素

可以通过拼接前缀的方式区分,取数据的时候拿到对象的id 再手动拼一个前缀就可以了

```
<div id='div_'+user.id >
<span id='span_'+user.id >
$("#div_"+id)
```

### 57. Mapper 中当返回一个 List`<String>` 时 : resultType= string

### 58. :: ??? service方法开头如delete save在配置文件里都默认写了，不然会只读数据库写不进去，或者把配置文件里的readOnly给位false

```
delClueActivityRelationByClueIdAndActivityId : 显示只读
deleteClueActivityRelationByClueIdAndActivityId : 
```

java.sql.SQLException: Connection is read-only. Queries leading to data modification are not allowed
; SQL []; Connection is read-only. Queries leading to data modification are not allowed; nested exception is java.sql.SQLException: Connection is read-only. Queries leading to data modification are not allowed

### 59. dml 语句放到 try...catch 当中s

### 60. ajax 提交表单序列化的同时提交其他的参数

```js
var formData = $("#select-clue-conditions-form").serialize();
$.ajax({
url:"workbench/clue/pagingQueryCluesWithConditions.do",
dataType: "json",
data:formData+"&pageNo="+pageNo+"&pageSize="+pageSize,
})
```

### 61. 主键字段当有业务含义时

主键必须唯一非空因此业务做主键,数据字典用户添加数据的时候验证了不能重复的功能
当重复记录高的时候,表比较多的时候,主键不要是有业务含义的





### 62. 访问一张表对应一个实体类,对应一个 mapper,对应一个 service 甚至对应一个controller

### 63.  mapper 中模糊查询时,可以在 mapper 中拼接字符串但是 !

```xml
<if test="name != null and name !=''">
    and c.fullname like "%" #{name} "%"   // 正确 : WHERE c.fullname like "%" ? "%" 
</if>
<if test="company != null and company !=''">
    and c.company like '%'#{company}'%'  // 错误 :  WHERE c.company like '%'?'%' 
</if>	
```



### 64. 获取下拉列表选中的选项的文本值而不是 value

获取下拉列表选中的选项的文本值而不是 value :

1.   $("#edit-appellation option:selected").text()
2.   $(this).find('option:selected').text();

获取下拉列表的value: $("#edit-appellation").val()

### 65.checkbox 赋值

checks.attr("checked",checkAll);  // 这行代码只能生效一次,第三次就无效了
checks.prop("checked",checkAll);  // 这行代码可以每次生效



### 66. parameterType 

当传参是一个 list 的时候(List`<Student>`) : parameterType  = student
当传参是一个 数组 的时候(String[]) : parameterType  = string

### 67. 配置文件

1.   xxxx.properties配置文件：
     	key1=value1
     	key2=value2
     	.....

​		适合配置简单数据(一对一)，几乎没有冗余数据，效率高
​			解析相对简单：Properties，BundleResource

2.   xxx.xml配置文件：标签语言.

     ```xml
     <studentList>
         <student email="zs@163.com">
             <id>1001</id>
             <name>zs</name>
             <age>20</age>
         </student>
         <student email="ls@163.com">
             <id>1002</id>
             <name>ls</name>
             <age>20</age>
         </student>
     </studentList>
     ```

     适合配置复杂数据，产生冗余数据，效率低
     	解析相对复杂：dom4j,jdom

### 68. 自动补全功能

自动补全插件：bs_typeahead
1. 引入开发包：.css,.js

2. 创建容器：`<div> <input type="text">`

3. 当容器加载完成之后，对容器调用工具函数：

  

```jsp
<link href="jquery/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>

<script type="text/javascript" src="jquery/jquery-1.11.1-min.js"></script>
<script type="text/javascript" src="jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>

<script type="text/javascript" src="jquery/bs_typeahead/bootstrap3-typeahead.min.js"></script>

```



```js
var accountMap={}; // 创建对象保存结果
$("#create-accountName").typeahead({
    minLength:1,
    showHintOnFocus:true,
    fitToElement:true,
    items:8,
    delay:500,
    // source: function (query,process) {//指定数据源，query代表输入框中你的输入值（即查询值）,process回调函数
    //每次键盘弹起，都自动触发本函数；我们可以向后台送请求，查询客户表中所有的名称，把客户名称以[]字符串形式返回前台，赋值给source
    //process：是个函数，能够将['xxx','xxxxx','xxxxxx',.....]字符串赋值给source，从而完成自动补全
    //query：在容器中输入的关键字
    //var customerName=$("#customerName").val();
    source: function (query,process) {//指定数据源，query代表输入框中你的输入值（即查询值）,process回调函数
        //发送请求
        $.ajax({
            url: "workbench/transaction/queryCustomerNames.do",
            type: "post",
            dataType: "json",
            data: {
                // name: $("#create-accountName").val()
                name: query // query 就相当于 $("#create-accountName").val()
            },
            success: function (data) {//data表示查询结果，自动补全的数据
                var show = [];//显示数组
                $.each(data, function (index, obj) {//遍历结果，数组中的单个对象
                    accountMap[obj.name] = obj.id;//name：id
                    show.push(obj.name);//添加到显示数组中
                });
                process(show);//显示的数据
            },
        });
    },
    afterSelect: function (item) {//选中一条数据后的回调函数，此处可以向隐藏域赋值数据id
        console.log(accountMap[item]);//取出选中项的值,打印到控制台

        $("#accountId").val(accountMap[item]);//隐藏的数据
    }
})
```

```jsp
<%--创建一个隐藏域，用来保存id--%>
<input type="hidden" id="hide"/>
<%--显示选中的值--%>
<input type="text" class="form-control" id="show"/>
```



### 69. 实体类和表的关系

java中的实体类是为了操作数据库表，
    所以,实体类要和数据库中的表相对应，实体类中的属性要和表中的字段相对应，属性的类型要和表字段的类型相对应。
java中的实体类不是只为了操作表，还有可能进行数据传输.
    所以,java中的实体类在数据库中不一定有表相对应，实体类中的属性在数据库表中也不一定有字段相对应；

但是，数据库一张表在java中一定有实体类相对应，数据库表中一个字段在实体类中一定有属性相对应。

​			java属性 ---(不一定)-----> table字段
​			java属性 <----(一定)------  table字段

### 70. 分析交易阶段的图标：

  图标的数量：跟交易总的阶段数量一致
              每一个阶段对应显示一个图标
  图标的种类：三类
  图标的颜色：绿色和黑色
  图标的顺序：跟阶段的顺序一致
  图标数量的变化：阶段的数量可能变化，图标的数量也可能变化
  图标的实现：
           `<span class="glyphicon glyphicon-ok-circle" data-content="" style="color: #90F790;">`  显示交易阶段的图标：
      按照顺序查询交易所有的阶段：stageList
      遍历stageList,显示每一个阶段对应图标，图标上显示的阶段的名称从遍历出的阶段中获取。



### 71. 统计图表

​	以更专业、更形象的形式展示系统中的数据。

销售漏斗图：展示商品销售数据、销售业绩
		展示交易表中的数据,统计交易表中各个阶段的数量

报表插件:jfreechart,iReport,锐浪,echarts

echarts的使用：

1.   引入开发包：echarts.min.js
2.   创建容器：`<div id="main" style="width: 600px;height:400px;"></div>`
3.   当容器加载完成之后，对容器调用工具函数：































# 疑问

### 1. service 扫描组件的包名应该写 service 还是 impl

impl 是可以正常运行的,但是老师演示扫描的是 service,这里是更好的编程习惯吗

```xml
<!--    扫描注解-->
<context:component-scan base-package="com.xxx.crm.settings.service.impl" />
<context:component-scan base-package="com.xxx.crm.workbench.service.impl" />

这里老师的演示是 
<context:component-scan base-package="com.xxx.crm.workbench.service" />
```

### 2. 希望在页面第一次加载后执行的函数,在异步请求后再次执行了

[(14条消息) $(function(){}页面加载后只希望执行一次的函数,在异步请求后再次执行了-编程语言-CSDN问答](https://ask.csdn.net/questions/7742196)

老师的处理方式,声明的函数中直接获取条件,两次调用的时候不需要传参数,页面加载时获取不到自动为空

原因 : button 标签 submit 属性重复提交了

```jsp
<%--<button type="submit" class="btn btn-default" id="queryActivitiesBtn">查询</button>--%>
<button type="button" class="btn btn-default" id="queryActivitiesBtn">查询</button>
```

