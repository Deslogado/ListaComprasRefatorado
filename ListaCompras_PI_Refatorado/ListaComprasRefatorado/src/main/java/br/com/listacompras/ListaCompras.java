package br.com.listacompras;

import br.com.listacompras.modelo.Item;
import br.com.listacompras.modelo.Lista;
import br.com.listacompras.modelo.Usuario;
import br.com.listacompras.repositorio.memoria.ItemRepositorioMemoria;
import br.com.listacompras.repositorio.memoria.ListaRepositorioMemoria;
import br.com.listacompras.repositorio.memoria.UsuarioRepositorioMemoria;
import br.com.listacompras.servico.ItemService;
import br.com.listacompras.servico.ListaService;
import br.com.listacompras.servico.UsuarioService;

/**
 * Executa verificações simples de funcionamento, conforme solicitado na atividade.
 * Não substitui uma suíte automatizada de testes unitários.
 */
public class ListaCompras {
    public static void main(String[] args) {
        UsuarioRepositorioMemoria usuarios = new UsuarioRepositorioMemoria();
        ListaRepositorioMemoria listas = new ListaRepositorioMemoria();
        ItemRepositorioMemoria itens = new ItemRepositorioMemoria();

        UsuarioService usuarioService = new UsuarioService(usuarios);
        ListaService listaService = new ListaService(listas);
        ItemService itemService = new ItemService(itens);

        Usuario usuario = usuarioService.cadastrar(1, "Ana Silva", "ana@email.com", "senha123");
        assert usuario.getNome().equals("Ana Silva");
        assert usuarios.buscarPorEmail("ANA@email.com").isPresent();

        Lista lista = listaService.criar(1, "Compras da semana");
        Item item = itemService.cadastrar(1, "Arroz", 2, "Marca A");
        itemService.adicionarNaLista(lista, item);
        assert lista.getItens().size() == 1;
        assert lista.getItens().get(0).getQuantidade() == 2;

        itemService.marcarComoComprado(item);
        assert item.isComprado();

        boolean rejeitouEmailDuplicado = false;
        try {
            usuarioService.cadastrar(2, "Outra Pessoa", "ana@email.com", "outra");
        } catch (IllegalArgumentException e) {
            rejeitouEmailDuplicado = true;
        }
        assert rejeitouEmailDuplicado : "O sistema deveria rejeitar e-mail duplicado.";

        boolean rejeitouQuantidadeInvalida = false;
        try {
            itemService.cadastrar(2, "Feijão", 0, "Marca B");
        } catch (IllegalArgumentException e) {
            rejeitouQuantidadeInvalida = true;
        }
        assert rejeitouQuantidadeInvalida : "O sistema deveria rejeitar quantidade zero.";

        System.out.println("Teste 1: cadastro e consulta de usuário - OK");
        System.out.println("Teste 2: criação de lista e cadastro de item - OK");
        System.out.println("Teste 3: marcação de item como comprado - OK");
        System.out.println("Teste 4: bloqueio de e-mail duplicado - OK");
        System.out.println("Teste 5: bloqueio de quantidade inválida - OK");
        System.out.println("TODOS OS TESTES PASSARAM");
    }
}
