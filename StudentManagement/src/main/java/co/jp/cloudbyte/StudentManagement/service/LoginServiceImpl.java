package co.jp.cloudbyte.StudentManagement.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import co.jp.cloudbyte.StudentManagement.form.LoginForm;


@Service
public class LoginServiceImpl implements LoginService{

	@Override
	public String checkUser(Model model,LoginForm loginForm) {
		
		// 假数据 用户名：admin/密码：admin （未来将会是DAO层给我们查询出来的）
		String usernameDB = "admin";
		String passwordDB = "admin";
		
		// 业务处理 在Service层给我们做业务
		// 1.查询有没有该用户，如果没有该用户原地跳转，并且报出错误信息(该用户不存在)
		if(!usernameDB.equals(loginForm.getUsername())) {
			model.addAttribute("errorMsg", "该用户不存在");
			return "index";
		}
		
		// 2.在1（有该用户）的基础上，检查一下密码，并且报出错误信息（用户名存在，但是密码错误）
		if(!passwordDB.equals(loginForm.getPassword())) {
			model.addAttribute("errorMsg", "用户名存在，但是密码错误");
			return "index";
		}
		
		// 3. 1和2都正确的基础上，直接完成页面跳转，跳转到用户一览页面(页面需要新规TODO)
		System.out.println("登录成功");
		return "userSearch";
		
	}

}
