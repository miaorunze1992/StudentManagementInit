package co.jp.cloudbyte.StudentManagement.entity;

import lombok.Data;

@Data
public class UserInfo {
	
	private String username;
	private String password;
	private Integer gender;
	private String address;
	private Integer country;
	private String comment;

}
