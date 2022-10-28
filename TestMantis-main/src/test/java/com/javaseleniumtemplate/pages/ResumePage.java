package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ResumePage extends PageBase {

    //Mapping
    By devStatsRows = By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[12]/table/tbody/tr");

    //Actions
    public List<WebElement> getDevStatsRows(){ return driver.findElements(devStatsRows); }

    public String getUsername(String row){
        return driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[12]/table/tbody/tr[" + row + "]/td[1]/a")).getText();
    }

    public String getFinishedQt(String row){
        return driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[12]/table/tbody/tr[" + row + "]/td[3]")).getText();
    }

    public String getTotalTasks(String row){
        return driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[12]/table/tbody/tr[" + row + "]/td[5]")).getText();
    }

    public String getTotalProportion(String row){
        return driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[12]/table/tbody/tr[" + row + "]/td[7]")).getText();
    }

    public String getResolvedProportion(String row){
        return driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[12]/table/tbody/tr[" + row + "]/td[6]")).getText();
    }
}
