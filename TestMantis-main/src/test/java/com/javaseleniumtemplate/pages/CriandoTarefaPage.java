package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class CriandoTarefaPage extends PageBase {

    //Mapping
    By dropDownFrequency = By.id("reproducibility");

    By dropDownGravity = By.id("severity");

    By dropDownPriority = By.id("priority");

    By dropDownAtribute = By.xpath("//*[@id=\"handler_id\"]");

    By resumeTextField = By.id("summary");

    By descriptionTextField = By.id("description");

    By createTaskButton = By.xpath("//*[@id=\"report_bug_form\"]/div/div[2]/div[2]/input");

    //Actions
    public void selectFrequencyOption(String text){
    comboBoxSelectByVisibleText(dropDownFrequency, text);
    }

    public void selectGravityOption(String text){
        comboBoxSelectByVisibleText(dropDownGravity, text);
    }

    public void selectPriorityOption(String text){
        comboBoxSelectByVisibleText(dropDownPriority, text);
    }

    public void selectAtributeOption(String text){
        comboBoxSelectByVisibleText(dropDownAtribute, text);
    }

    public void fillResumeTextField(String text){
        sendKeys(resumeTextField, text);
    }

    public void fillDescriptionTextField(String text){
        sendKeys(descriptionTextField, text);
    }

    public void clickCreateTaskButton(){
        click(createTaskButton);
    }

    public String getVisibility() {
        return driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[2]/td[4]")).getText();
    }

    public String getAtribute() {
        return driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[5]/td[2]/a")).getText();
    }

    public String getPriority() {
        return driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[6]/td[1]")).getText();
    }

    public String getGravity() {
        return driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[6]/td[2]")).getText();
    }

    public String getFrequency() {
        return driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[6]/td[3]")).getText();
    }

    public String getResume() {
        return driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[10]/td")).getText();
    }

    public String getNum() {
        return driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[2]/td[1]")).getText();
    }

    public String getDescription() {
        return driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[11]/td")).getText();
    }
}
