package com.javaseleniumtemplate.flow;

import com.javaseleniumtemplate.pages.HomePage;
import com.javaseleniumtemplate.pages.TarefaPage;
import com.javaseleniumtemplate.pages.TarefasPage;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;

public class StatusTarefaUpdate {
    //Objects and constructor
    HomePage homePage;
    TarefasPage tarefasPage;
    TarefaPage tarefaPage;

    public StatusTarefaUpdate(){
        //Page and Steps Objects
        homePage = new HomePage();
        tarefasPage = new TarefasPage();
        tarefaPage = new TarefaPage();
    }

    //Flows
    public void updateTaskState(String updateTask){
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

        if(actualState.equals("resolvido")){
            tarefaPage.updateState("retorno");
        } else {
            tarefaPage.updateState("resolvido");
        }

        tarefaPage.clickOnSaveButton();
    }
}
