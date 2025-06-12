package br.com.biblioteca;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LivroServiceTest {

    @Test
    public void testAdicionarLivroComDadosValidos() {
        LivroService service = new LivroService();
        Livro livro = new Livro("Clean Code", "Robert Martin", "1234567890", "Prentice Hall", 2008, 3);

        boolean resultado = service.adicionarLivro(livro);

        assertTrue(resultado, "O livro deveria ser adicionado com sucesso");
    }

    @Test
    public void testAdicionarLivroComCampoObrigatorioVazio() {
    LivroService service = new LivroService();
    // Título está vazio
    Livro livro = new Livro("", "Autor Exemplo", "9876543210", "Editora Exemplo", 2024, 5);

    boolean resultado = service.adicionarLivro(livro);

    assertFalse(resultado);
}
    @Test
public void testAdicionarLivroComISBNDuplicado() {
    LivroService service = new LivroService();

    
    Livro livro1 = new Livro("Livro 1", "Autor 1", "1111111111", "Editora X", 2022, 2);
    boolean resultado1 = service.adicionarLivro(livro1);


    Livro livro2 = new Livro("Livro 2", "Autor 2", "1111111111", "Editora Y", 2023, 1);
    boolean resultado2 = service.adicionarLivro(livro2);

    assertTrue(resultado1, "O primeiro livro deve ser cadastrado com sucesso");
    assertFalse(resultado2, "O sistema deve impedir o cadastro de ISBN duplicado");
}

@Test
public void testVisualizarLivroExistente() {
    LivroService service = new LivroService();
    Livro livro = new Livro("Clean Architecture", "Robert Martin", "9999999999", "Pearson", 2019, 2);

    // Simula que o livro foi adicionado (mesmo que não salve de verdade)
    service.adicionarLivro(livro);

    Livro resultado = service.buscarLivroPorISBN("9999999999");

    assertNotNull(resultado, "O sistema deve retornar o livro existente");
}

@Test
public void testVisualizarLivroInexistente() {
    LivroService service = new LivroService();

    Livro resultado = service.buscarLivroPorISBN("0000000000");

    assertNull(resultado);
}


@Test
public void testAtualizarLivroComDadosValidos() {
    LivroService service = new LivroService();

    Livro livroOriginal = new Livro("Livro Antigo", "Autor A", "2222222222", "Editora A", 2010, 1);
    service.adicionarLivro(livroOriginal); // simula o cadastro

    Livro livroAtualizado = new Livro("Livro Atualizado", "Autor A", "2222222222", "Editora Nova", 2024, 2);
    boolean resultado = service.atualizarLivro(livroAtualizado);

    assertTrue(resultado);
}

@Test
public void testAtualizarLivroInexistente() {
    LivroService service = new LivroService();

    Livro livroInexistente = new Livro("Livro Fantasma", "Autor X", "3333333333", "Editora X", 2005, 1);

    boolean resultado = service.atualizarLivro(livroInexistente);

    assertFalse(resultado);
}
@Test
public void testRemoverLivro_Valido() {
    LivroService service = new LivroService();
    boolean resultado = service.removerLivro("1234567890");
    assertFalse(resultado); 
}
@Test
public void testRemoverLivro_NaoEncontrado() {
    LivroService service = new LivroService();
    boolean resultado = service.removerLivro("isbn-inexistente");
    assertFalse(resultado);
}
@Test
public void testAlterarStatus_DisponivelParaIndisponivel() {
    LivroService service = new LivroService();
    boolean resultado = service.alterarStatusDisponibilidade("1234567890", false);
    assertFalse(resultado); 
}

@Test
public void testAlterarStatus_LivroInexistente() {
    LivroService service = new LivroService();
    boolean resultado = service.alterarStatusDisponibilidade("isbn-invalido", true);
    assertFalse(resultado); 
}


}
