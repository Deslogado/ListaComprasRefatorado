package br.com.listacompras.servico;

import br.com.listacompras.modelo.Item;
import br.com.listacompras.modelo.Lista;
import br.com.listacompras.repositorio.ItemRepositorio;

public class ItemService {
    private final ItemRepositorio repositorio;
    public ItemService(ItemRepositorio repositorio) {
        if (repositorio == null) throw new IllegalArgumentException("O repositório é obrigatório.");
        this.repositorio = repositorio;
    }

    public Item cadastrar(int id, String nome, int quantidade, String marcaFornecedor) {
        Item item = new Item(id, nome, quantidade, marcaFornecedor);
        repositorio.salvar(item);
        return item;
    }

    public void adicionarNaLista(Lista lista, Item item) {
        if (lista == null || item == null) throw new IllegalArgumentException("Lista e item são obrigatórios.");
        lista.adicionarItem(item);
    }

    public void marcarComoComprado(Item item) {
        if (item == null) throw new IllegalArgumentException("O item é obrigatório.");
        item.marcarComoComprado();
    }
}
