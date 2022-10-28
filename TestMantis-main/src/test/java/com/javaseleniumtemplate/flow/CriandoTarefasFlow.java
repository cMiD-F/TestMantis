package com.javaseleniumtemplate.flow;

import com.javaseleniumtemplate.pages.CriandoTarefaPage;
import com.javaseleniumtemplate.pages.HomePage;

public class CriandoTarefasFlow {
    //Objects and constructor
    HomePage homePage;
    CriandoTarefaPage criandoTarefaPage;
    public CriandoTarefasFlow(){
        //Page and Steps Objects
        homePage = new HomePage();
        criandoTarefaPage= new CriandoTarefaPage();
    }

    //Flows
    public void criandoTarefa(String frequency, String gravity, String priority, String username,
    String resume, String description){
        criandoTarefaPage.selectFrequencyOption(frequency);
        criandoTarefaPage.selectGravityOption(gravity);
        criandoTarefaPage.selectPriorityOption(priority);
        criandoTarefaPage.selectAtributeOption(username);
        criandoTarefaPage.fillResumeTextField(resume);
        criandoTarefaPage.fillDescriptionTextField(description);
        criandoTarefaPage.clickCreateTaskButton();
    }
}
