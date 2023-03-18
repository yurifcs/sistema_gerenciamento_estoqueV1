package estoqueControl;

import java.time.LocalDate;
import java.util.List;

public class Relatório {

    public void gerarRelatórioEstoqueAtualizado() {
        Estoque estoque = Estoque.getInstance(); // Obtém a instância do estoque
        List<Produto> produtos = estoque.getProdutos(); // Obtém a lista de produtos do estoque

        System.out.println("Relatório de Estoque Atualizado:");
        for (Produto produto : produtos) {
            System.out.println("Produto: " + produto.getNome());
            System.out.println("Quantidade: " + produto.getQuantidade());
            System.out.println("Preço: " + produto.getPreco());
            System.out.println("--------------------------------");
        }
    }

    public void gerarRelatórioEntradas(LocalDate dataInicial, LocalDate dataFinal) {
        Estoque estoque = Estoque.getInstance(); // Obtém a instância do estoque
        List<EntradaEstoque> entradas = estoque.getHistoricoEntradas(); // Obtém o histórico de entradas do estoque

        System.out.println("Relatório de Entradas de Estoque:");
        for (EntradaEstoque entrada : entradas) {
            if (entrada.getData().isAfter(dataInicial) && entrada.getData().isBefore(dataFinal)) {
                System.out.println("Produto: " + entrada.getProduto().getNome());
                System.out.println("Quantidade: " + entrada.getQuantidade());
                System.out.println("Data: " + entrada.getData());
                System.out.println("--------------------------------");
            }
        }
    }

    public void gerarRelatórioSaidas(LocalDate dataInicial, LocalDate dataFinal) {
        Estoque estoque = Estoque.getInstance(); // Obtém a instância do estoque
        List<SaidaEstoque> saidas = estoque.getHistoricoSaidas(); // Obtém o histórico de saídas do estoque

        System.out.println("Relatório de Saídas de Estoque:");
        for (SaidaEstoque saida : saidas) {
            if (saida.getData().isAfter(dataInicial) && saida.getData().isBefore(dataFinal)) {
                System.out.println("Produto: " + saida.getProduto().getNome());
                System.out.println("Quantidade: " + saida.getQuantidade());
                System.out.println("Data: " + saida.getData());
                System.out.println("--------------------------------");
            }
        }
    }
}
