package automatizado.builder;

import org.openqa.selenium.WebDriver;

import automatizado.page.ControleDeProdutoPO;
/**
 * Classe que sabe construir ou adicionar um produto na tela.
 */
public class ProdutoBuilder {

    private String codigo = "00001";
    private String nome = "Produto Padrão";
    private Integer quantidade = 1;
    private Double valor = 1.0;
    private String data = "28/03/2023";

    private ControleDeProdutoPO ControleDeProdutoPO;
    
    //** Construtor do ProdutoBuilder, que recebe a página de controle de produtos. */
    public ProdutoBuilder(ControleDeProdutoPO ControleDeProdutoPO){
        this.ControleDeProdutoPO = ControleDeProdutoPO;
    }

    /**
     * Metodo que sabe adicionar um código ao builder.
     * @param codigo Código que será adicionado.
     * @return Retorna a própria classe ProdutoBuilder.
     */
    public ProdutoBuilder adicionarCodigo(String codigo){
        this.codigo = codigo;
        return this;
    }

    /**
     * Metodo que sabe adicionar um nome ao builder.
     * @param nome Nome que será adicionado.
     * @return Retorna a própria classe ProdutoBuilder.
     */
    public ProdutoBuilder adicionarNome(String nome){
        this.nome = nome;
        return this;
    }

    /**
     * Metodo que sabe adicionar uma qantidade ao builder.
     * @param quantidade Quantidade que será adicionado.
     * @return Retorna a própria classe ProdutoBuilder.
     */
    public ProdutoBuilder adicionarQuantidade(Integer quantidade){
        this.quantidade = quantidade;
        return this;
    }

    /**
     * Metodo que sabe adicionar um valor ao builder.
     * @param valor Valor que será adicionado.
     * @return Retorna a própria classe ProdutoBuilder.
     */
    public ProdutoBuilder adicionarValor(Double valor){
        this.valor = valor;
        return this;
    }

    /**
     * Metodo que sabe adicionar uma data ao builder.
     * @param data Data que será adicionado.
     * @return Retorna a própria classe ProdutoBuilder.
     */
    public ProdutoBuilder adicionarData(String data){
        this.data = data;
        return this;
    }

    /**
     * Metodo que constrói o produto, ou seja, adiciona o produto pela tela de caadastro de produto.
     */
    public void builder(){

        ControleDeProdutoPO.escrever(ControleDeProdutoPO.inputCodigo, codigo);
        ControleDeProdutoPO.escrever(ControleDeProdutoPO.inputNome, nome);
        ControleDeProdutoPO.escrever(ControleDeProdutoPO.inputQuantidade, (quantidade != null ) ? quantidade.toString() : "");
        ControleDeProdutoPO.escrever(ControleDeProdutoPO.inputValor, (valor != null) ? valor.toString() : "" );
        ControleDeProdutoPO.escrever(ControleDeProdutoPO.inputData, data);
    
        ControleDeProdutoPO.btnSalvar.click();
    }
}
