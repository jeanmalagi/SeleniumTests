package br.com.selenium.tests;

import br.com.selenium.core.BaseTest;
import br.com.selenium.pages.ContaPage;
import br.com.selenium.pages.MenuPage;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContaTest extends BaseTest {
    MenuPage menuPage = new MenuPage();
    ContaPage contaPage = new ContaPage();
    @Test
    public void test1InclusaoConta() {

        menuPage.acessarTelaInserirConta();

        contaPage.setNome("Conta 1");
        contaPage.salvar();

        Assert.assertEquals("Conta adicionada com sucesso!", contaPage.obterMensagemSucesso());

    }

    @Test
    public void test2AlterarConta(){

        menuPage.acessarTelaListarConta();

        contaPage.clicarAlterarConta("Conta 1");

        contaPage.setNome("Conta 1 alterada");
        contaPage.salvar();

        Assert.assertEquals("Conta alterada com sucesso!", contaPage.obterMensagemSucesso());
    }

    @Test
    public void test3InserirContaMesmoNome(){
        menuPage.acessarTelaInserirConta();

        contaPage.setNome("Conta 1 alterada");
        contaPage.salvar();

        Assert.assertEquals("Já existe uma conta com esse nome!", contaPage.obterMensagemErro());
    }

}