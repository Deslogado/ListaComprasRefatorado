package br.com.listacompras.servico;

import br.com.listacompras.modelo.Lista;
import br.com.listacompras.repositorio.ListaRepositorio;

public class ListaService {
    private final ListaRepositorio repositorio;
    public ListaService(ListaRepositorio repositorio) {
        if (repositorio == null) throw new IllegalArgumentException("O repositório é obrigatório.");
        this.repositorio = repositorio;
    }

    public Lista criar(int id, String nome) {
        Lista lista = new Lista(id, nome);
        repositorio.salvar(lista);
        return lista;
    }
}
