package com.javaseleniumtemplate.flow;

import com.javaseleniumtemplate.pages.HomePage;
import com.javaseleniumtemplate.pages.TarefasPage;

public class FiltroTarefaFlow {
    //Objects and constructor
    HomePage homePage;
    TarefasPage tarefasPage;
    public FiltroTarefaFlow(){
        //Page and Steps Objects
        homePage = new HomePage();
        tarefasPage = new TarefasPage();
    }

    //Flows
    public void filtroTarefaFlow(String username, String gravity, String quantity) throws InterruptedException {
        homePage.clickViewTasks();

        tarefasPage.clickOnAttribute();
        tarefasPage.selectAttributeTo(username);
        tarefasPage.clickOnGravity();
        tarefasPage.selectGravity(gravity);
        tarefasPage.clickOnQuantity();
        tarefasPage.fillShowQuantity(quantity);
        tarefasPage.clickOnSaveFilter();

    }
}
