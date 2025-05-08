package co.jp.cloudbyte.StudentManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.jp.cloudbyte.StudentManagement.dao.UserRegisterInfoMapper;
import co.jp.cloudbyte.StudentManagement.entity.UserInfo;
import co.jp.cloudbyte.StudentManagement.entity.UserRegisterInfo;
import co.jp.cloudbyte.StudentManagement.form.UserRegisterForm;


@Service
public class UserRegisterServiceImpl implements UserRegisterService{
	
	
	@Autowired
	UserRegisterInfoMapper userRegisterInfoMapper;
	
	@Override
	public int inputUser(UserRegisterForm userRegisterForm) {
		
		// 拿到userRegisterForm的信息然后通过下面这段代码插入数据库
		Boolean result = userRegisterInfoMapper.insertUserInfo(userRegisterForm.getUsername(), userRegisterForm.getPassword());
		
		// 当成功插入数据的时候，返回1 失败的时候返回 0
		if(result) {
			return 1;
		}else {
			return 0;
		}
	}

}
