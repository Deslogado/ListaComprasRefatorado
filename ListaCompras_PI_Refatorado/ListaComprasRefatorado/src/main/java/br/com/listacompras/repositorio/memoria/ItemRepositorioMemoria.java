package br.com.listacompras.repositorio.memoria;

import br.com.listacompras.modelo.Item;
import br.com.listacompras.repositorio.ItemRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemRepositorioMemoria implements ItemRepositorio {
    private final List<Item> dados = new ArrayList<>();
    @Override public void salvar(Item item) {
        if (buscarPorId(item.getId()).isPresent()) throw new IllegalArgumentException("Já existe item com esse ID.");
        dados.add(item);
    }
    @Override public List<Item> listar() { return List.copyOf(dados); }
    @Override public Optional<Item> buscarPorId(int id) {
        return dados.stream().filter(i -> i.getId() == id).findFirst();
    }
}
