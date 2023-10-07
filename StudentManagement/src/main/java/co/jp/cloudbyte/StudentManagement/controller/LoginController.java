package co.jp.cloudbyte.StudentManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.jp.cloudbyte.StudentManagement.form.LoginForm;
import co.jp.cloudbyte.StudentManagement.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping("userLogin")
	public String userLogin(Model model,LoginForm loginForm) {
		
//		// 创建LoginServiceImpl类的对象 loginServiceImpl
//		LoginServiceImpl loginServiceImpl = new LoginServiceImpl();
//		// 通过对象.方法调用LoginServiceImpl的checkUser()方法,result是用来接收方法的返回值
//		String result = loginServiceImpl.checkUser(model, loginForm);
//		// 方法的返回值是页面,可以直接分发
//		return result;
		
		// leader  review代码后，告诉我们要用注解的形式调用Service
		return loginService.checkUser(model, loginForm);
	
	}


	// TODO更改后的注释
  // mohan更改了代码
	@RequestMapping("register")
	public String userRegister() {
		return "userRegister";
	}
	
}
