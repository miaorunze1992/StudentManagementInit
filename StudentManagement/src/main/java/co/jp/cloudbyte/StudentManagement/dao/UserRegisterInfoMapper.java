package co.jp.cloudbyte.StudentManagement.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import co.jp.cloudbyte.StudentManagement.entity.UserInfo;
import co.jp.cloudbyte.StudentManagement.entity.UserRegisterInfo;

@Mapper
public interface UserRegisterInfoMapper {
	
	Boolean insertUserInfo(@Param("username") String username,@Param("userpassword") String userpassword);

}
