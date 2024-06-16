package br.com.selenium.tests;

import br.com.selenium.core.BaseTest;
import br.com.selenium.pages.MenuPage;
import br.com.selenium.pages.MovimentacaoPage;
import br.com.selenium.utils.DataUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static br.com.selenium.utils.DataUtils.obterDataFormatada;

public class MovimentacaoTest extends BaseTest {
    private MenuPage menuPage = new MenuPage();
    private MovimentacaoPage movPage = new MovimentacaoPage();

    @Test
    public void test1InserirMovimentacao(){
        menuPage.acessarTelaInserirMovimentacao();

        movPage.setDataMovimentacao("14/06/2024");
        movPage.setDataPagamento("14/06/2024");
        movPage.setDescricao("Movimentação de Teste");
        movPage.setInteressado("Interessado Qualquer");
        movPage.setValor("2000");
        movPage.setConta("Conta 1 alterada");
        movPage.setStatusPago();
        movPage.salvar();

        Assert.assertEquals("Movimentação adicionada com sucesso!", movPage.obterMensagemSucesso());
    }
    @Test
    public void test2CamposObrigatorios(){
        menuPage.acessarTelaInserirMovimentacao();

        movPage.salvar();
        List<String> erros = movPage.obterErros();
        Assert.assertTrue(erros.containsAll(Arrays.asList(
                "Data da Movimentação é obrigatório", "Data do pagamento é obrigatório",
                "Descrição é obrigatório", "Interessado é obrigatório",
                "Valor é obrigatório", "Valor deve ser um número")));
        Assert.assertEquals(6, erros.size());
    }

    @Test
    public void testInserirMovimentacaoFutura(){
        menuPage.acessarTelaInserirMovimentacao();

        Date dataFutura = DataUtils.obterDataComDiferencaDias(5);

        movPage.setDataMovimentacao(obterDataFormatada(dataFutura));
        movPage.setDataPagamento(obterDataFormatada(dataFutura));
        movPage.setDescricao("Movimentação do Teste");
        movPage.setInteressado("Interessado Qualquer");
        movPage.setValor("500");
        movPage.setConta("Conta do Teste alterada");
        movPage.setStatusPago();
        movPage.salvar();

        List<String> erros = movPage.obterErros();
        Assert.assertTrue(
                erros.contains("Data da Movimentação deve ser menor ou igual à data atual"));
        Assert.assertEquals(1, erros.size());
    }
}

