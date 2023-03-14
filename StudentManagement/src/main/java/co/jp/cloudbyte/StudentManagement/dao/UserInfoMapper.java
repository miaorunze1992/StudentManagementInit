package co.jp.cloudbyte.StudentManagement.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import co.jp.cloudbyte.StudentManagement.entity.UserInfo;

@Mapper
public interface UserInfoMapper {
	
	UserInfo selectUserInfo(@Param("username") String username);

}
