package estoqueControl;

import java.time.LocalDate;
import java.util.List;

public class SaidaEstoque {
    private Produto produto;
    private int quantidade;
    private LocalDate data;

    public SaidaEstoque(Produto produto, int quantidade, LocalDate data) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.data = data;
    }

    // getters e setters
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

    // método para registrar uma nova saída de estoque
    public void registrarSaidaEstoque() {
        Estoque estoque = Estoque.getInstance();
        estoque.registrarSaida(this);
    }

    // método para obter uma lista de todas as saídas de estoque registradas
    public static List<SaidaEstoque> obterTodasSaidasEstoque() {
        Estoque estoque = Estoque.getInstance(); // Obtém a instância do estoque
        return estoque.getHistoricoSaidas(); // Retorna o histórico de saídas do estoque
    }

    // método para obter a quantidade total de um determinado produto que saiu do estoque em um período de tempo
    public static int obterQuantidadeProdutoSaiuPeriodo(Produto produto, LocalDate inicio, LocalDate fim) {
        Estoque estoque = Estoque.getInstance(); // Obtém a instância do estoque
        List<SaidaEstoque> historicoSaidas = estoque.getHistoricoSaidas(); // Obtém o histórico de saídas

        int quantidadeTotal = 0;
        for (SaidaEstoque saidaEstoque : historicoSaidas) {
            if (saidaEstoque.getProduto().equals(produto) && saidaEstoque.getData().isAfter(inicio) && saidaEstoque.getData().isBefore(fim)) {
                quantidadeTotal += saidaEstoque.getQuantidade();
            }
        }

        return quantidadeTotal;
    }
}
