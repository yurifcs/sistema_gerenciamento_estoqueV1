package estoqueControl;

import static org.junit.Assert.assertEquals;
        import static org.mockito.Mockito.mock;
        import static org.mockito.Mockito.verify;

        import java.time.LocalDate;
        import java.util.ArrayList;
        import java.util.List;

        import org.junit.Before;
        import org.junit.Test;
        import org.mockito.ArgumentCaptor;
class EstoqueTest {


    private Estoque estoqueMock;
    private EntradaEstoque entradaEstoque;

    @Before
    public void setUp() {
        estoqueMock = mock(Estoque.class);
        entradaEstoque = new EntradaEstoque();
    }

    @Test
    public void testRegistrarEntrada() {
        entradaEstoque.registrarEntrada();
        ArgumentCaptor<EntradaEstoque> argument = ArgumentCaptor.forClass(EntradaEstoque.class);
        verify(estoqueMock).registrarEntrada(argument.capture());
        assertEquals(argument.getValue(), entradaEstoque);
    }

    @Test
    public void testListarEntradasEstoque() {
        List<EntradaEstoque> entradasEstoque = new ArrayList<>();
        entradaEstoque.setProduto(new Produto("Produto 1", 10, 1.0));
        entradaEstoque.setQuantidade(5);
        entradaEstoque.setData(LocalDate.now());
        entradasEstoque.add(entradaEstoque);
        estoqueMock.setHistoricoEntradas(entradasEstoque);
        List<EntradaEstoque> resultado = entradaEstoque.listarEntradasEstoque();
        assertEquals(resultado, entradasEstoque);
    }

    @Test
    public void testObterQuantidadeTotalProdutoPeriodo() {
        Produto produto = new Produto("Produto 1", 10, 1.0);
        LocalDate dataInicio = LocalDate.of(2022, 1, 1);
        LocalDate dataFim = LocalDate.of(2022, 12, 31);
        int quantidadeEsperada = 5;
        List<EntradaEstoque> entradasEstoque = new ArrayList<>();
        entradaEstoque.setProduto(produto);
        entradaEstoque.setQuantidade(quantidadeEsperada);
        entradaEstoque.setData(LocalDate.of(2022, 3, 1));
        entradasEstoque.add(entradaEstoque);
        estoqueMock.setHistoricoEntradas(entradasEstoque);
        int quantidadeReal = entradaEstoque.obterQuantidadeTotalProdutoPeriodo(produto, dataInicio, dataFim);
        assertEquals(quantidadeEsperada, quantidadeReal);
    }
}

