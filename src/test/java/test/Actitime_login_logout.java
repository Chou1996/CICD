package test;

import java.io.IOException;

import org.testng.annotations.Test;

import generics.BaseTest;
import pom.HomePage;
import pom.LoginPage;

public class Actitime_login_logout extends BaseTest{


	@Test(description = "Login and Logout from Application" ,groups = "abc")
	public void login_logout() throws IOException, InterruptedException {

		LoginPage login=new LoginPage(driver);
		HomePage Home=login.loginMethod();
		Home.logoutMethod();

	}
	/*
	 * @Test public void test() { System.out.println("testing"); }
	 */
}
