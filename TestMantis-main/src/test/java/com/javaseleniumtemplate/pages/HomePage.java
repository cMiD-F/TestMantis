package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class HomePage extends PageBase {

    //Mapping
    By createTaskButton = By.xpath("//*[@id=\"navbar-container\"]/div[2]/ul/li[1]/div/a");

    By viewTasksButton = By.xpath("//*[@id=\"sidebar\"]/ul/li[2]/a");

    By viewResumeButton = By.xpath("//*[@id=\"sidebar\"]/ul/li[6]/a");

    //Actions
    public void clickCreateTask() {
        click(createTaskButton);
    }

    public void clickViewTasks() { click(viewTasksButton); }

    public void clickViewResume() { click(viewResumeButton); }
}
