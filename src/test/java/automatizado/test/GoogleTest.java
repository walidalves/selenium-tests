package automatizado.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import automatizado.page.GooglePO;

public class GoogleTest extends BaseTeste {

    private static GooglePO googlePage;

    @BeforeClass
    public static void prepararTestes(){
        googlePage = new GooglePO(driver);
    }
    
    @Test
    public void TC001_devePesquisarOTextoBatataFrita(){

        googlePage.pesquisar("Batata frita");

        String resultado = googlePage.obterResultadoDaPesquisa();

        assertTrue(resultado, resultado.contains("Aproximadamente"));
    }


    @Test
    public void TC002_devePesquisarOTextoComBacon(){

        googlePage.pesquisar(" Com Bacon");

        String resultado = googlePage.obterResultadoDaPesquisa();
        
        assertTrue(resultado, resultado.contains("resultados"));
    }
}
