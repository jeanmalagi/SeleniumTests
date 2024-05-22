package br.com.selenium.tests;

import br.com.selenium.core.BaseTest;
import br.com.selenium.pages.MenuPage;
import org.junit.Test;

public class ContaTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    @Test
    public void test(){

        menuPage.acessarTelaInserirConta();

    }
}