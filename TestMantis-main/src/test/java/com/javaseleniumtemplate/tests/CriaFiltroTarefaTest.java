package com.javaseleniumtemplate.tests;

import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.flow.LoginFlows;
import com.javaseleniumtemplate.pages.FiltroPage;
import com.javaseleniumtemplate.pages.HomePage;
import com.javaseleniumtemplate.pages.TarefasPage;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CriaFiltroTarefaTest extends TestBase {
    //Objects
    LoginFlows loginFlow;
    HomePage homePage;
    TarefasPage tarefasPage;
    FiltroPage filtroPage;

    //Tests
    @Test
    @DisplayName("Teste para criar um novo filtro, verificando se foi salvo corretamente")
    public void createNewFilter() throws InterruptedException {

        //Objects instances
        loginFlow = new LoginFlows();
        homePage = new HomePage();
        tarefasPage = new TarefasPage();
        filtroPage = new FiltroPage();

        //Parameters
        String username = "lucaslourenco";
        String password = "Lucas123";
        String gravity = "travamento";
        String quantity = "10";
        String name = "PrimeiroTeste";

        //Testes
        loginFlow.login(username, password);
        homePage.clickViewTasks();

        tarefasPage.clickOnOptionsDropDown();
        tarefasPage.clickOnManageOption();

        List<WebElement> filterTableRows = filtroPage.findTableRows();
        for(int i = 1; i <= filterTableRows.size(); i++){
            String filter = filtroPage.getFilterName(String.valueOf(i));
            if(Objects.equals(filter, name)){
                filtroPage.deleteRepeatedFilter(String.valueOf(i));
                filtroPage.clickOnDeleteButton();
                break;
            }
        }

        homePage.clickViewTasks();
        tarefasPage.clickOnAttribute();
        tarefasPage.selectAttributeTo(username);
        tarefasPage.clickOnGravity();
        tarefasPage.selectGravity(gravity);
        tarefasPage.clickOnQuantity();
        tarefasPage.fillShowQuantity(quantity);
        tarefasPage.clickOnSaveFilter();
        filtroPage.fillFilterName(name);
        filtroPage.checkAllProjects();
        filtroPage.clickOnSaveFilter();
        tarefasPage.clickOnOptionsDropDown();
        tarefasPage.clickOnManageOption();
        filterTableRows = filtroPage.findTableRows();

        for(int i = 1; i < filterTableRows.size(); i++){
            String filter = filtroPage.getFilterName(String.valueOf(i));
            if(Objects.equals(filter, name)){
                filtroPage.clickOnNewFilter(String.valueOf(i));
                break;
            }
        }

        String filterAttributedTo = filtroPage.getAttributeToValue();
        String filterGravity = filtroPage.getGravity();
        String filterShowValue = filtroPage.getShowValue();
        //O filtro não está sendo salvo corretamente, então o teste está falhando - Bug Report :O
        assertAll(
                () -> Assertions.assertEquals(username, filterAttributedTo),
                () -> Assertions.assertEquals(gravity, filterGravity),
                () -> Assertions.assertEquals(quantity, filterShowValue)
        );
    }
}
