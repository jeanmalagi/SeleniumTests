package br.com.selenium.tests;

import br.com.selenium.core.BaseTest;
import br.com.selenium.pages.MenuPage;
import br.com.selenium.pages.ResumoPage;
import org.junit.Assert;
import org.junit.Test;

public class ResumoTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private ResumoPage resumoPage = new ResumoPage();

    @Test
    public void testExcluirMovimentacao(){

        menuPage.acessarTelaResumo();

        resumoPage.excluirMovimentacao();

        Assert.assertEquals("Movimentação removida com sucesso!",
                resumoPage.obterMensagemSucesso());
    }

}
