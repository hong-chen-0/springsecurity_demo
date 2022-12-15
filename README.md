# springsecurity_demo
SpringSecurity模板、涉及登录、角色权限验证，注册需要自己开发

参考教程

https://blog.csdn.net/weixin_42375707/article/details/110678638

简单理解: 自定义配置登录成功、登陆失败、注销成功目标结果类，并将其注入到springsecurity的配置文件中。如何认证、授权交给AuthenticationManager去作

复杂理解: 

(1)用户发起表单登录请求后，首先进入 UsernamePasswordAuthenticationFilter， 在 UsernamePasswordAuthenticationFilter 中根据用户输入的用户名、密码构建了 UsernamePasswordAuthenticationToken，并将其交给 AuthenticationManager 来进行认证处理。

AuthenticationManager 本身不包含认证逻辑，其核心是用来管理所有的 AuthenticationProvider，通过交由合适的 AuthenticationProvider 来实现认证。

(2)下面跳转到了 SelfAuthenticationProvider，该类是 AuthenticationProvider 的实现类：你可以在该类的 Authentication authenticate(Authentication authentication) 自定义认证逻辑, 然后在该类中通过调用UserDetails loadUserByUsername(account) 去获取数据库用户信息并验证，然后创建 UsernamePasswordAuthenticationToken 并将权限、用户个人信息注入到其中 ，并通过setAuthenticated(true) 设置为需要验证。

(3) 至此认证信息就被传递回 UsernamePasswordAuthenticationFilter 中，在 UsernamePasswordAuthenticationFilter 的父类 AbstractAuthenticationProcessingFilter 的 doFilter() 中，会根据认证的成功或者失败调用相应的 handler： 所谓的handler就是我们注入到springsecurity配置文件的handler。

访问/login时必须要用post方法！, 访问的参数名必须为username和password   

访问/logout时即可用post也可用get方法！

//springsecurity配置文件中的hasRole("")不能以ROLE开头，比如ROLE_USER就是错的，springsecurity会默认帮我们加上，但数据库的权限字段必须是ROLE_开头，否则读取不到

.antMatchers("/index").hasRole("USER")

 .antMatchers("/hello").hasRole("ADMIN")
 
 修改been、mysql、端口、redis部分即可自己使用
