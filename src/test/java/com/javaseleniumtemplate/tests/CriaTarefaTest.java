package com.javaseleniumtemplate.tests;

import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.flow.LoginFlows;
import com.javaseleniumtemplate.pages.CriandoTarefaPage;
import com.javaseleniumtemplate.pages.HomePage;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CriaTarefaTest extends TestBase {
    //Objects
    LoginFlows loginFlow;

    HomePage homePage;

    CriandoTarefaPage criandoTarefaPage;

    //Tests
    @Test
    @DisplayName("Teste para criar uma nova tarefa e verifique se os valores estão corretos quando ela é criada.")
    public void createNewTask() throws InterruptedException {

        //Objects instances
        loginFlow = new LoginFlows();
        homePage = new HomePage();
        criandoTarefaPage = new CriandoTarefaPage();

        //Parameters
        String username = "cauetdamasceno";
        String password = "cauetdamasceno";
        String optionFrequency = "sempre";
        String optionGravity = "pequeno";
        String optionPriority = "nenhuma";
        String resume = "Apenas um teste";
        String description = "Este teste está sendo com base no que foi ensinado nas aulas.";

        //Test
        loginFlow.login(username, password);
        homePage.clickCreateTask();

        criandoTarefaPage.selectFrequencyOption(optionFrequency);
        criandoTarefaPage.selectGravityOption(optionGravity);
        criandoTarefaPage.selectPriorityOption(optionPriority);
        criandoTarefaPage.selectAtributeOption(username);
        criandoTarefaPage.fillResumeTextField(resume);
        criandoTarefaPage.fillDescriptionTextField(description);
        criandoTarefaPage.clickCreateTaskButton();

        Thread.sleep(1000);

        assertAll(
                () -> assertEquals("público", criandoTarefaPage.getVisibility()),
                () -> assertEquals(username, criandoTarefaPage.getAtribute()),
                () -> assertEquals(optionPriority, criandoTarefaPage.getPriority()),
                () -> assertEquals(optionGravity, criandoTarefaPage.getGravity()),
                () -> assertEquals(optionFrequency, criandoTarefaPage.getFrequency()),
                () -> assertEquals(criandoTarefaPage.getNum() + ": " + resume, criandoTarefaPage.getResume()),
                () -> assertEquals(description, criandoTarefaPage.getDescription())
        );
    }
}
