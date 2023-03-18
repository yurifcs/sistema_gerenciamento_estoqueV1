package estoqueControl;

import java.time.LocalDate;
import java.util.List;


public class EntradaEstoque {

    private Produto produto;
    private int quantidade;
    private LocalDate data;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }


    public void registrarEntrada() {
        Estoque estoque = Estoque.getInstance(); // obtém a instância do estoque
        estoque.registrarEntrada(this); // registra a entrada no estoque
    }

    public List<EntradaEstoque> listarEntradasEstoque() {
        // Retorna uma lista com todas as entradas de estoque registradas
        return null;
    }

    public int obterQuantidadeTotalProdutoPeriodo(Produto produto, LocalDate dataInicio, LocalDate dataFim) {
        // Retorna a quantidade total do produto que entrou no estoque em um determinado período de tempo
        return 0;
    }
}
