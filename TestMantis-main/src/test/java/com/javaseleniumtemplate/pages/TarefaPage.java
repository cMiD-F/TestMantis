package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class TarefaPage extends PageBase {

    //Mapping
    By actualState = By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[7]/td[1]");
    By updateButton = By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tfoot/tr/td/div/div[1]/form/fieldset/input[3]");

    By stateDropDown = By.id("status");

    By saveUpdateButton = By.xpath("//*[@id=\"update_bug_form\"]/div/div[3]/input");

    By resumeText = By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[10]/td");

    By descriptionText = By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[11]/td");

    By resumeTextField = By.id("summary");

    By descriptionTextField = By.id("description");

    By updatedDate = By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[2]/td[6]");

    //Actions
    public void clickOnUpdateButton(){ click(updateButton); }

    public String getActualState(){
        return driver.findElement(actualState).getText();
    }

    public void updateState(String state) { comboBoxSelectByVisibleText(stateDropDown, state); }

    public void clickOnSaveButton() { click(saveUpdateButton); }

    public String getResumeText() { return driver.findElement(resumeText).getText(); }

    public String getDescriptionText() { return driver.findElement(descriptionText).getText(); }

    public void fillResumeTextField(String text) {
        driver.findElement(resumeTextField).clear();
        sendKeys(resumeTextField, text);
    }

    public void fillDescriptionTextField(String text){
        driver.findElement(descriptionTextField).clear();
        sendKeys(descriptionTextField, text);
    }

    public String getUpdatedDate() { return driver.findElement(updatedDate).getText(); }
}
