package br.com.selenium.pages;

import br.com.selenium.core.BasePage;

public class MenuPage extends BasePage {

    public void acessarTelaInserirConta(){
        clicarLink("Contas");
        clicarLink("Adicionar");
    }

    public void acessarTelaListarConta(){
        clicarLink("Contas");
        clicarLink("Listar");
    }

    public void acessarTelaInserirMovimentacao(){
        clicarLink("Criar Movimentação");
    }

    public void acessarTelaResumo(){
        clicarLink("Resumo Mensal");
    }

}
