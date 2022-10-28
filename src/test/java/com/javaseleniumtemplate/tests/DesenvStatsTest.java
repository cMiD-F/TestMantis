package com.javaseleniumtemplate.tests;

import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.flow.StatusDesenvFlow;
import com.javaseleniumtemplate.flow.LoginFlows;
import com.javaseleniumtemplate.flow.StatusTarefaUpdate;
import com.javaseleniumtemplate.pages.HomePage;
import com.javaseleniumtemplate.pages.ResumePage;
import com.javaseleniumtemplate.pages.TarefasPage;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebElement;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertAll;

public class DesenvStatsTest extends TestBase {

    private static final DecimalFormat df = new DecimalFormat("0.0");

    //Objects
    LoginFlows loginFlow;
    HomePage homePage;
    TarefasPage tarefasPage;
    ResumePage resumePage;
    StatusTarefaUpdate statusTarefaUpdate;
    StatusDesenvFlow statusDesenvFlow;

    //Tests
    @Test
    @DisplayName("Test for updating a task (resolved - return) and checking if the DevStatsResume fields are correct")
    public void checkDevStatsResumeFields() {

        //Objects instances
        loginFlow = new LoginFlows();
        homePage = new HomePage();
        tarefasPage = new TarefasPage();
        resumePage = new ResumePage();
        statusTarefaUpdate = new StatusTarefaUpdate();
        statusDesenvFlow = new StatusDesenvFlow();
        //Parameters
        String username = "cauetdamasceno";
        String password = "cauetdamasceno";
        String taskSelected = "0000050";
        String initialStatus = "";
        long initialFinishedTasks;
        //Test
        loginFlow.login(username, password);
        homePage.clickViewTasks();
        List<WebElement> taskRows = tarefasPage.getTasksRows();

        for(int i = 1; i <= taskRows.size(); i++){
            String task = tarefasPage.getTaskNum(String.valueOf(i));
            if(Objects.equals(taskSelected, task)){
                initialStatus = tarefasPage.getTaskState(String.valueOf(i));
                break;
            }
        }

        homePage.clickViewResume();
        List<WebElement> devStatsRows = resumePage.getDevStatsRows();
        initialFinishedTasks = statusDesenvFlow.getFinishedTasks(devStatsRows.size(), username);
        statusTarefaUpdate.updateTaskState(taskSelected);
        homePage.clickViewResume();

        //Values to assert
        long updatedFinishedTasks = initialStatus.equals("Resolvido") ?
                initialFinishedTasks - 1 :
                initialFinishedTasks + 1;
        long actualFinishedTasks = statusDesenvFlow.getFinishedTasks(devStatsRows.size(), username);
        double totalTasks = statusDesenvFlow.getTotalTasks(devStatsRows.size());
        double totalTasksByUser = statusDesenvFlow.getTotalTasksByUser(username, devStatsRows.size());
        String userProportion = df.format((totalTasksByUser / totalTasks) * 100);
        String actualUserProportion = statusDesenvFlow.getUserProportion(username, devStatsRows.size());
        String resolvedProportion = df.format((updatedFinishedTasks / totalTasksByUser) * 100);
        String actualResolvedProportion = statusDesenvFlow.getUserResolvedProportion(username, devStatsRows.size());
        assertAll(
                () -> Assertions.assertEquals(updatedFinishedTasks, actualFinishedTasks),
                () -> Assertions.assertEquals(userProportion + "%", actualUserProportion),
                () -> Assertions.assertEquals(resolvedProportion + "%", actualResolvedProportion)
        );
    }
}
