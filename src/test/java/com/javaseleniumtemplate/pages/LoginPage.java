package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class LoginPage extends PageBase {
    //Mapping
    By usernameField = By.id("username");
    By enterUsername = By.xpath("//*[@id=\"login-form\"]/fieldset/input[2]");

    By passwordField = By.id("password");

    By enterPassword = By.xpath("//*[@id=\"login-form\"]/fieldset/input[3]");

    //Actions
    public void fillUserName(String username){
        sendKeys(usernameField, username);
    }
    public void fillPassword(String password){
        sendKeys(passwordField, password);
    }
    public void clickEnterUsername() {
        click(enterUsername);
    }

    public void clickEnterPassword(){
        click(enterPassword);
    }
}
