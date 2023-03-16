package co.jp.cloudbyte.StudentManagement.service;

import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

import co.jp.cloudbyte.StudentManagement.dao.UserInfoMapper;
import co.jp.cloudbyte.StudentManagement.entity.UserInfo;
import co.jp.cloudbyte.StudentManagement.form.LoginForm;

@SpringBootTest(classes = LoginServiceImpl.class)
@ExtendWith(SpringExtension.class)
public class LoginServiceTest {
	
    @MockBean
    private UserInfoMapper userInfoMapper;
    
	@Autowired
	private LoginService loginService;
	
    @BeforeAll
    static void initAll(){
        System.out.println("==========LoginController Test Start==========");
    }
    
    @BeforeEach
    void setUp() {
        System.out.println("==========Junit Case Start==========");
    }
    
    
    @Test
    public void testCheckUser_正常系_查不到(){
    	
    	// 使用mock制造了假变量
    	Model mockModel = Mockito.mock(Model.class);
    	LoginForm loginForm = Mockito.mock(LoginForm.class);
    	
    	// 打好提前量，当userInfoMapper的selectUserInfo方法被调用时返回null
    	Mockito.when(userInfoMapper.selectUserInfo(any())).thenReturn(null);
    	
    	String testResult = loginService.checkUser(mockModel, loginForm);
    	// 断言  预期值与实际值进行对比
    	Assertions.assertEquals("index",testResult);
    }
    
    
    @Test
    public void testCheckUser_正常系_查到了但是密码正确(){
    	
    	// 使用mock制造了假变量
    	Model mockModel = Mockito.mock(Model.class);
   
    	LoginForm loginForm = new LoginForm();
     	loginForm.setPassword("888");
    	
    	UserInfo userInfo = new UserInfo();
    	userInfo.setPassword("888");
    	// 打好提前量，当userInfoMapper的selectUserInfo方法被调用时返回null
    	Mockito.when(userInfoMapper.selectUserInfo(any())).thenReturn(userInfo);
    	
    	String testResult = loginService.checkUser(mockModel, loginForm);
    	// 断言  预期值与实际值进行对比
    	Assertions.assertEquals("userSearch",testResult);
    }
    
    
    @Test
    public void testCheckUser_正常系_查到了但是密码不正确(){
    	
    	// 使用mock制造了假变量
    	Model mockModel = Mockito.mock(Model.class);
   
    	LoginForm loginForm = new LoginForm();
     	loginForm.setPassword("777");
    	
    	UserInfo userInfo = new UserInfo();
    	userInfo.setPassword("888");
    	// 打好提前量，当userInfoMapper的selectUserInfo方法被调用时返回null
    	Mockito.when(userInfoMapper.selectUserInfo(any())).thenReturn(userInfo);
    	
    	String testResult = loginService.checkUser(mockModel, loginForm);
    	// 断言  预期值与实际值进行对比
    	Assertions.assertEquals("index",testResult);
    }
    
//    // カバレージ　测试代码覆盖率
//    @Test
//    public void testUserLogin_正常系() {
//    	LoginForm loginForm = new LoginForm();
//
//    	// 提前设定好，loginService的checkUser方法的返回值为index
//    	Mockito.when(loginService.checkUser(null,loginForm)).thenReturn("index");
//    	String testResult = loginController.userLogin(null, loginForm);
//    	// 断言  预期值与实际值进行对比
//    	Assertions.assertEquals("index",testResult);
//    }
//    
//    
//    // カバレージ　测试代码覆盖率
//    @Test
//    public void testUserLogin_異常系() {
//    	LoginForm loginForm = new LoginForm();
//    	String testResult = loginController.userLogin(null, loginForm);
//    	// 断言  预期值与实际值进行对比
//    	Assertions.assertEquals(null,testResult);
//    }
    

    
    @AfterEach
    void tearDown()
    {
        System.out.println("==========Junit Case End==========");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("==========LoginController Test End==========");
    }
    
    

}
