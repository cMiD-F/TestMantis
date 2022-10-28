package com.javaseleniumtemplate.flow;

import com.javaseleniumtemplate.pages.LoginPage;

public class LoginFlows {
    //Objects and constructor
    LoginPage loginPage;

    public LoginFlows(){
        //Page and Steps Objects
        loginPage = new LoginPage();
    }

    //Flows
    public void login(String username, String password){
        loginPage.fillUserName(username);
        loginPage.clickEnterUsername();
        loginPage.fillPassword(password);
        loginPage.clickEnterPassword();
    }
}
