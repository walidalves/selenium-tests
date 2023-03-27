package automatizado.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

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

    @Test
    public void TC002_naoDeveSerPossivelCadaastrarProdutoCampoVazio(){
        controlleProdutoPage.btnAdicionar.click();
        //TODO: Remover esse clique, aassim que o sistema for corrigido
        controlleProdutoPage.btnAdicionar.click();
        
        String titulo = controlleProdutoPage.tituloModal.getText();

        assertEquals("Produto", titulo);
    }

}
