package com.javaseleniumtemplate.tests;

import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.flow.CriandoTarefasFlow;
import com.javaseleniumtemplate.flow.LoginFlows;
import com.javaseleniumtemplate.pages.HomePage;
import com.javaseleniumtemplate.pages.TarefaPage;
import com.javaseleniumtemplate.pages.TarefasPage;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebElement;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertAll;

public class UpdateTarefaValoresTest extends TestBase {

    //Objects
    LoginFlows loginFlow;
    HomePage homePage;
    CriandoTarefasFlow createTaskFlows;
    TarefasPage tarefasPage;
    TarefaPage tarefaPage;

    //Tests
    @Test
    @DisplayName("Test for updating a task and checking if the values are correctly saved")
    public void updateTaskValuesTest() {

        //Objects instances
        loginFlow = new LoginFlows();
        homePage = new HomePage();
        tarefasPage = new TarefasPage();
        tarefaPage = new TarefaPage();
        createTaskFlows = new CriandoTarefasFlow();

        //Parameters
        String username = "lucaslourenco";
        String password = "Lucas123";
        String updateTask = "0000100";

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

        String initialResume = tarefaPage.getResumeText();
        String initialDescription = tarefaPage.getDescriptionText();
        tarefaPage.clickOnUpdateButton();
        String updatedResume;

        if(initialResume.equals(updateTask + ": Teste automatizado.")){
            updatedResume = "teste";
        } else {
            updatedResume = "Teste automatizado";
        }

        String updatedDescription;

        if(initialDescription.equals("Validando testes automatizados curso B2.")){
            updatedDescription = "Update!!";
        } else {
            updatedDescription = "teste";
        }

        tarefaPage.fillResumeTextField(updatedResume);
        tarefaPage.fillDescriptionTextField(updatedDescription);
        tarefaPage.clickOnSaveButton();
        homePage.clickViewTasks();
        rows = tarefasPage.getTasksRows();

        for(int i = 1; i <= rows.size(); i++){
            String task = tarefasPage.getTaskNum(String.valueOf(i));
            if(Objects.equals(updateTask, task)){
                tarefasPage.openTaskToBeUpdated(String.valueOf(i));
                break;
            }
        }

        assertAll(
                () -> Assertions.assertEquals(updateTask + ": " + updatedResume, tarefaPage.getResumeText()),
                () -> Assertions.assertEquals(updatedDescription, tarefaPage.getDescriptionText())
        );
    }
}
