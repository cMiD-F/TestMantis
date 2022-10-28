package com.javaseleniumtemplate.tests;

import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.flow.LoginFlows;
import com.javaseleniumtemplate.pages.HomePage;
import com.javaseleniumtemplate.pages.TarefaPage;
import com.javaseleniumtemplate.pages.TarefasPage;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateTarefaStatusTest extends TestBase {
    //Objects
    LoginFlows loginFlow;
    HomePage homePage;
    TarefasPage tarefasPage;
    TarefaPage tarefaPage;

    //Tests
    @Test
    @DisplayName("Test for updating the taskState")
    public void updateTaskState() {

        //Objects instances
        loginFlow = new LoginFlows();
        homePage = new HomePage();
        tarefasPage = new TarefasPage();
        tarefaPage = new TarefaPage();

        //Parameters
        String username = "cauetdamasceno";
        String password = "cauetdamasceno";
        String updateTask = "0000050";

        //Test
        loginFlow.login(username, password);
        homePage.clickViewTasks();

        List<WebElement> rows = tarefasPage.getTasksRows();
        for(int i = 1; i <= rows.size(); i++){
            String task = tarefasPage.getTaskNum(String.valueOf(i));
            if(Objects.equals(updateTask, task)){
                tarefasPage.openTaskToBeUpdated(String.valueOf(i));
                break;
            }
        }

        String actualState = tarefaPage.getActualState();
        tarefaPage.clickOnUpdateButton();
        String state = "";
        if(actualState.equals("resolvido")){
            tarefaPage.updateState("retorno");
            state = "retorno";
        } else {
            tarefaPage.updateState("resolvido");
            state = "resolvido";
        }

        tarefaPage.clickOnSaveButton();
        homePage.clickViewTasks();
        rows = tarefasPage.getTasksRows();
        String updatedState = "";

        for(int i = 1; i <= rows.size(); i++){
            String task = tarefasPage.getTaskNum(String.valueOf(i));
            if(Objects.equals(updateTask, task)){
                updatedState = tarefasPage.getTaskState(String.valueOf(i));
                break;
            }
        }

        Assertions.assertEquals(state, updatedState);
    }
}
