package co.jp.cloudbyte.StudentManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import co.jp.cloudbyte.StudentManagement.form.UserRegisterForm;
import co.jp.cloudbyte.StudentManagement.service.UserRegisterService;


@Controller
public class UserRegisterController {
	// 调用用户注册service
	@Autowired
	UserRegisterService userRegisterService;
	
	@RequestMapping("userRegister")
	public String userRegister(UserRegisterForm userRegisterForm) {
		// 当拦截成功用户注册页面的时候 调用这个方法
		// 调用这个方法之后再调用UserRegisterService里面的方法得到一个数字 有值就代表注册成功 没有值就代表注册没有成功
		int userInput = userRegisterService.inputUser(userRegisterForm);
		// 注册成功跳转用户注册成功页面
		if(userInput == 1) {
			return "userRegisterSuccess";
		}else {
			return "userRegisterFail";
		}
		
	}
}
