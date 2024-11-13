package org.example.test;

import groovy.transform.ASTTest;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.example.login.Login;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogTest {

    @Test
    public void loginDemoBlaze(){

        Login login = new Login();
        String tempToken = login.logIn();

        Assert.assertNotNull(tempToken, "Logowanie nie zostało wykonane poprawnie");
        System.out.println("Logowanie zakończyło się sukcesem, token: " + tempToken);
    }
}
