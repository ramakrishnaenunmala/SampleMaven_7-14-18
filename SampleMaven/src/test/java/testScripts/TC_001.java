package testScripts;

import org.testng.annotations.Test;

import com.develop_maven.SampleMaven.VerifyLoginCredentiols;

public class TC_001 {

	//public static void main(String[] args) {
		
		VerifyLoginCredentiols obj=new VerifyLoginCredentiols();
		
		@Test
		public void mm(){
		obj.setUP("chrome");
		obj.loginToApp();
		obj.tearDown();
}
	}
//}
