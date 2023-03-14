package co.jp.cloudbyte.StudentManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import co.jp.cloudbyte.StudentManagement.dao.UserInfoMapper;
import co.jp.cloudbyte.StudentManagement.entity.UserInfo;
import co.jp.cloudbyte.StudentManagement.form.LoginForm;


@Service
public class LoginServiceImpl implements LoginService{
	
	
	@Autowired
    UserInfoMapper userInfoMapper;
	
	@Override
	public String checkUser(Model model,LoginForm loginForm) {
		
		// 从数据库取值，通过DAO层
		UserInfo userInfo = userInfoMapper.selectUserInfo(loginForm.getUsername());
		
		// 业务处理 在Service层给我们做业务
		
		// 如果userInfo为null，则数据库没有该用户
		if(userInfo == null) {
			// 1.查询有没有该用户，如果没有该用户原地跳转，并且报出错误信息(该用户不存在)
			model.addAttribute("errorMsg", "该用户不存在");
			return "index";
		}else {
			// 2.在1（有该用户）的基础上，检查一下密码，并且报出错误信息（用户名存在，但是密码错误）
			String passwordDB = userInfo.getPassword();
			if(!passwordDB.equals(loginForm.getPassword())) {
				model.addAttribute("errorMsg", "用户名存在，但是密码错误");
				return "index";
			}
		}
		// 3. 1和2都正确的基础上，直接完成页面跳转，跳转到用户一览页面(页面需要新规TODO)
		System.out.println("登录成功");
		return "userSearch";
		
	}

}
