SSM:  Spring   SpringMVC   Mybatis

-------------------------------------------------------------------------
demo1
框架分类：
SSH
struts2 爆出漏洞 不用了
Spring 精华 精华 精华
hibernate

SpringMVC 包含在Spring 用来接受用户请求的MVC框架  Spring的一部分
Spring 经典 核心
Mybatis 轻量级 直接操作sql 灵活
hibernate  HQL语言，屏蔽sql，优化麻烦 ，太笨重，学习成本增加 //数据库是基础设施 不能动

Spring解决耦合方法：
1、依赖注入（DI）

2、切面编程（AOP）//面试必问

准备工作：
配置文件：解决配置问题,一般在resources文件夹里
1、priperties key,value 文本文件

2、xml 读写：理解spring工作
     (1)dom解析
    （2）sax解析
    （3）dom4j//常用 第三方包，综合两种特点
    //x path 路径表示符

3、反射、注解
反射：class加载反向生成java对象，获取方法，反着来的


框架：
	1.spring 核心：依赖注入（）  切面编程（AOP）//面试必问
    （1）DI 对象耦合，编码效率，通过框架编程，只用写业务逻辑，耦合性基本解决
		
	（2）注解方式注入 ：@Service 业务层，业务逻辑
						@Component 公共组件
						@Controller 控制业务请求 用于MVC
						@Autowired 使用时注入
	（3）切面编程（AOP）防止操作数据库重复代码，打开数据库操作自动操作，封装起来，只用写业务逻辑
						统一组织代码，拦截某些方法执行前后 做一些操作
						两种配置方法 一种基于注解  一种基于xML配置
		    原理：（面试必问）  （1）（默认）JDK（Proxy代理类）和 InvocationHandler（调用处理）
									要求：必须实现接口
									优点：创建效率高
								（2）chlib  使用asm，字节码 基于子类，继承，类没有接口时可用
									优势 执行效率高
	2.SpringMVC 	处理前端请求的MVC框架，操作前端请求，基于servlet
					工作流程：	1.项目启动后HandlerMapping先扫描Controller注解 说明是MVC处理请求的文件，标注出来
								2.请求发来后通过DispatcherServlet寻找处理器HendlerMpping，找到ResquestMapping的类，拿到路径
								3.将请求转发到方法里处理，根据ViewReslover配置找到文件
					请求转发 和 重定向  forward把一个请求装发到页面  
										redirect 重定向 返回的页面重新定向到另一个页面
							  
					get获取数据 post提交数据的
					
					springMVC处理json 接受和返回 josn可以和很多东西交换数据 用jackson或 fast josn（alibab）
					
					springMVC请求拦截器 servlet过滤器 区别
						拦截器基于反射不是servlet，可以拿到ioc容器（bean），和spring结合紧密，只拦截MVC请求
						过滤器依赖servlet，基于函数回调，基本拦截所有请求，不能处理bean
	
	
	3.Mybatis:	半自动 相对hibernate（有一个hql 屏蔽了数据库的差异 不太好优化）
				Mybatis 实现增删改查流程：配置文件和映射文件给Configuration通过SqlSessionFactory创建SqlSession
											创建Sqlssion，根据接口的增删改查找到映射文件和配置文件执行sql，出异常回滚，没有异常执行
	
				动态sql 一对一查询