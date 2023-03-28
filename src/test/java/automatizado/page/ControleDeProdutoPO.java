package automatizado.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import automatizado.builder.ProdutoBuilder;

public class ControleDeProdutoPO extends BasePO {

    //#region WebElements
    @FindBy(id = "btn-adicionar")
    public WebElement btnAdicionar;

    @FindBy(css = "ul>li>a.nav-link")
    public WebElement linkVoltar;

    @FindBy(css = "div.modal-header>h4")
    public WebElement tituloModal;

    @FindBy(id = "codigo")
    public WebElement inputCodigo;

    @FindBy(id = "nome")
    public WebElement inputNome;

    @FindBy(id = "quantidade")
    public WebElement inputQuantidade;

    @FindBy(id = "valor")
    public WebElement inputValor;

    @FindBy(id = "data")
    public WebElement inputData;

    @FindBy(id = "btn-salvar")
    public WebElement btnSalvar;

    @FindBy(id = "btn-sair")
    public WebElement btnSair;
    
    @FindBy(id = "mensagem")
    public WebElement spanMensagem;

    //#endregion WeblElements

    //#region Construtor

    public ControleDeProdutoPO(WebDriver driver) {
        super(driver);
    }
    
    //#endregion Construtor

    //#region Métodos
    
    public void cadastrarProduto(ProdutoBuilder produtoBuilder){
        produtoBuilder.builder();    
    }
   
    //#endregion Métodos

}
