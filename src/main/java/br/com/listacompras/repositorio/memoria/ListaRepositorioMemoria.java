package br.com.listacompras.repositorio.memoria;

import br.com.listacompras.modelo.Lista;
import br.com.listacompras.repositorio.ListaRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListaRepositorioMemoria implements ListaRepositorio {
    private final List<Lista> dados = new ArrayList<>();
    @Override public void salvar(Lista lista) {
        if (buscarPorId(lista.getId()).isPresent()) throw new IllegalArgumentException("Já existe lista com esse ID.");
        dados.add(lista);
    }
    @Override public List<Lista> listar() { return List.copyOf(dados); }
    @Override public Optional<Lista> buscarPorId(int id) {
        return dados.stream().filter(l -> l.getId() == id).findFirst();
    }
}
