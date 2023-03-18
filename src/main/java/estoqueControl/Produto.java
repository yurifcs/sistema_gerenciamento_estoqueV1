package estoqueControl;

import java.util.Objects;

public class Produto {
    private String nome;
    private String descricao;
    private int quantidade;
    private double preco;

    public Produto(String nome, String descricao, int quantidade, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    // equals e hashCode
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Produto produto = (Produto) obj;
        return  Objects.equals(nome, produto.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    // toString
    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", quantidade=" + quantidade +
                ", preco=" + preco +
                '}';
    }

    // método para verificar se um determinado produto está em estoque
    public boolean estaEmEstoque() {
        return quantidade > 0;
    }
}
