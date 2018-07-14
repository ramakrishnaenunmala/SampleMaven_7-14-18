package testScripts;



import org.testng.annotations.Test;

import com.develop_maven.SampleMaven.VerifyLoginCredentiols;

public class TC_002 {
	VerifyLoginCredentiols obj;
	@Test
	public void addEmploye() throws InterruptedException{
		
		 obj=new VerifyLoginCredentiols();
		 obj.setUP("chrome");
		 obj.loginToApp();
		 obj.addEmploye();
		 obj.tearDown();
	}
}

