package estoqueControl;
import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private static Estoque instance = null;
    private List<Produto> produtos = new ArrayList<>();
    private List<EntradaEstoque> historicoEntradas = new ArrayList<>();
    private List<SaidaEstoque> historicoSaidas = new ArrayList<>();
    public List<SaidaEstoque> getHistoricoSaidas() {
        return historicoSaidas;
    }

    public List<EntradaEstoque> getHistoricoEntradas() {
        return historicoEntradas;
    }
    private Estoque() {}

    public static Estoque getInstance() {
        if (instance == null) {
            instance = new Estoque();
        }
        return instance;
    }

    public void registrarEntrada(EntradaEstoque entrada) {
        historicoEntradas.add(entrada);
        Produto produto = entrada.getProduto();
        produto.setQuantidade(produto.getQuantidade() + entrada.getQuantidade());
    }

    public void registrarSaida(SaidaEstoque saida) {
        historicoSaidas.add(saida);
        Produto produto = saida.getProduto();
        produto.setQuantidade(produto.getQuantidade() - saida.getQuantidade());
    }


//    private static Estoque instance = null;


//    public static Estoque getInstance() {
//        if (instance == null) {
//            instance = new Estoque();
//        }
//        return instance;
//    }


    private int quantidadeTotal;

//    public Estoque() {
//        produtos = new ArrayList<>();
//        quantidadeTotal = 0;
//    }

    // Getters e Setters
    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public int getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(int quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }

    // Método para adicionar um novo produto ao estoque
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        quantidadeTotal += produto.getQuantidade();
    }

    // Método para remover um produto do estoque
    public void removerProduto(Produto produto) {
        produtos.remove(produto);
        quantidadeTotal -= produto.getQuantidade();
    }

    // Método para verificar se um determinado produto está em estoque
    public boolean verificarProdutoEmEstoque(Produto produto) {
        return produtos.contains(produto);
    }

    // Método para obter uma lista de todos os produtos em estoque
    public List<Produto> listarProdutosEmEstoque() {
        return new ArrayList<>(produtos);
    }

    // Método para atualizar a quantidade de um produto em estoque após uma entrada ou saída
    public void atualizarQuantidadeProduto(Produto produto, int quantidade) {
        if (produtos.contains(produto)) {
            int index = produtos.indexOf(produto);
            Produto produtoAtualizado = produtos.get(index);
            produtoAtualizado.setQuantidade(quantidade);
            quantidadeTotal -= produto.getQuantidade();
            quantidadeTotal += quantidade;
        }
    }
}
