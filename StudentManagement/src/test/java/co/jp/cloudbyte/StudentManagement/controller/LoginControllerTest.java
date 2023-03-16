package co.jp.cloudbyte.StudentManagement.controller;

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
import org.springframework.ui.Model;

import co.jp.cloudbyte.StudentManagement.form.LoginForm;
import co.jp.cloudbyte.StudentManagement.service.LoginService;

@SpringBootTest(classes = LoginController.class)
@ExtendWith(SpringExtension.class)
public class LoginControllerTest {
	
    @MockBean
    private LoginService loginService;
    
    @Autowired
    private LoginController loginController;
    
    @BeforeAll
    static void initAll(){
        System.out.println("==========LoginController Test Start==========");
    }
    
    @BeforeEach
    void setUp() {
        System.out.println("==========Junit Case Start==========");
    }
    
    
    @Test
    public void testUserRegister_正常系(){
    	String testResult = loginController.userRegister();
    	// 断言  预期值与实际值进行对比
    	Assertions.assertEquals("userRegister",testResult);
    }
    
    // カバレージ　测试代码覆盖率
    @Test
    public void testUserLogin_正常系() {
    	LoginForm loginForm = new LoginForm();

    	// 提前设定好，loginService的checkUser方法的返回值为index
    	Mockito.when(loginService.checkUser(null,loginForm)).thenReturn("index");
    	String testResult = loginController.userLogin(null, loginForm);
    	// 断言  预期值与实际值进行对比
    	Assertions.assertEquals("index",testResult);
    }
    
    
    // カバレージ　测试代码覆盖率
    @Test
    public void testUserLogin_異常系() {
    	LoginForm loginForm = new LoginForm();
    	String testResult = loginController.userLogin(null, loginForm);
    	// 断言  预期值与实际值进行对比
    	Assertions.assertEquals(null,testResult);
    }
    

    
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
