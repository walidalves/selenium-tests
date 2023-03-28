package automatizado.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.builder.ProdutoBuilder;
import automatizado.page.ControleDeProdutoPO;
import automatizado.page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControleDeProdutoTest extends BaseTest{
    
    private static LoginPO loginPage;
    private static ControleDeProdutoPO controlleProdutoPage;
    
    @BeforeClass
    public static void prepararTestes(){
        loginPage = new LoginPO(driver);
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");
        
        controlleProdutoPage = new ControleDeProdutoPO(driver);
        assertEquals(controlleProdutoPage.obterTituloPagina(), "Controle de Produtos");
    }

    @Test
    public void TC001_deveAbrirModalParaCadastroAoClicarEmCriar(){
        controlleProdutoPage.btnAdicionar.click();
        //TODO: Remover esse clique, aassim que o sistema for corrigido
        controlleProdutoPage.btnAdicionar.click();
        
        String titulo = controlleProdutoPage.tituloModal.getText();

        assertEquals("Produto", titulo);

        controlleProdutoPage.btnSair.click();
        controlleProdutoPage.btnSair.click();
    }

    // @Test
    // public void TC002_naoDeveSerPossivelCadaastrarProdutoCampoVazio(){
    //     controlleProdutoPage.btnAdicionar.click();
    //     controlleProdutoPage.cadastrarProduto("0000010", "Martelo", 5, 56.9, "");
        
    //     String mensagem = controlleProdutoPage.spanMensagem.getText();

    //     assertEquals("Todos os campos são obrigatórios para o cadastro!", mensagem);
    // }


    @Test
    public void TC003_naoDeveSerPossivelCadaastrarProdutoCampoVazio(){
        
        String mensagem = "Todos os campos são obrigatórios para o cadastro!";
        controlleProdutoPage.btnAdicionar.click();
        
        //Criação do objeto para adicionar na tela
        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controlleProdutoPage);
        
        //Teste se o produto é adicionadao sem código
        produtoBuilder
        .adicionarCodigo("")
        .builder();

        assertEquals(mensagem, controlleProdutoPage.spanMensagem.getText());
        
        //Teste se o produto é adicionadao sem quantidade
        produtoBuilder.
        adicionarCodigo("00006")
        .adicionarNome("Martelo")
        .adicionarQuantidade(null)
        .builder();
        
        assertEquals(mensagem, controlleProdutoPage.spanMensagem.getText());

        //Teste se o produto é adicionado sem nome
        produtoBuilder
        .adicionarNome("")
        .adicionarQuantidade(8)
        .builder();
        
        assertEquals(mensagem, controlleProdutoPage.spanMensagem.getText());

        //Teste se o produto é adicionadao sem valor
        produtoBuilder
        .adicionarNome("Porta")
        .adicionarValor(null)
        .builder();
                       
        assertEquals(mensagem, controlleProdutoPage.spanMensagem.getText());


        //Teste se o produto é adicionado sem data
        produtoBuilder
        .adicionarValor(85.89)
        .adicionarData("")
        .builder();

        assertEquals(mensagem, controlleProdutoPage.spanMensagem.getText());   

        controlleProdutoPage.btnSair.click();
    }


}
