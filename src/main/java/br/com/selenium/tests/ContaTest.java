package br.com.selenium.tests;

import br.com.selenium.core.BaseTest;
import br.com.selenium.pages.ContaPage;
import br.com.selenium.pages.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class ContaTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    ContaPage contaPage = new ContaPage();
    @Test
    public void test(){

        menuPage.acessarTelaInserirConta();

        contaPage.setNome("Conta 1");
        contaPage.salvar();

        Assert.assertEquals("Conta adicionada com sucesso!", contaPage.obterMensagemSucesso());
    }
}