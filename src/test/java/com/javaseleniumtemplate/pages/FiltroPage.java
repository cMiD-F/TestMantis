package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FiltroPage extends PageBase {

    //Mapping
    By nameTextField = By.name("query_name");

    By allProjectsCheckBox = By.xpath("//*[@id=\"save-filter\"]/div[2]/div/form[1]/div[4]/label/span");

    By saveFilterButton = By.xpath("//*[@id=\"save-filter\"]/div[2]/div/form[1]/input[3]");

    By deleteFilterButton = By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[2]/form/input[4]");

    By filterTableRows = By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[2]/div[2]/div/table/tbody/tr/td[1]");

    By attributeTo = By.id("handler_id_filter_target");

    By gravity = By.id("show_severity_filter_target");

    By showValue = By.id("per_page_filter_target");

    //Actions

    public void fillFilterName(String name){
        sendKeys(nameTextField, name);
    }

    public void checkAllProjects(){ click(allProjectsCheckBox); }

    public void clickOnSaveFilter(){ click(saveFilterButton); }

    public List<WebElement> findTableRows(){
        return driver.findElements(filterTableRows);
    }

    public String getFilterName(String row){
        return driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[2]/div[2]/div/table/tbody/tr[" + row + "]/td[1]")).getText();
    }

    public void deleteRepeatedFilter(String row){
        click(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[2]/div[2]/div/table/tbody/tr[" + row + "]/td[6]/div[3]/form/fieldset/button"));
    }

    public void clickOnDeleteButton(){ click(deleteFilterButton); }

    public void clickOnNewFilter(String row) { click(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[2]/div[2]/div/table/tbody/tr[" + row + "]/td[1]/a")); }

    public String getAttributeToValue() {
        return driver.findElement(attributeTo).getText();
    }

    public String getGravity(){
        return driver.findElement(gravity).getText();
    }

    public String getShowValue() {
        return driver.findElement(showValue).getText();
    }

}
