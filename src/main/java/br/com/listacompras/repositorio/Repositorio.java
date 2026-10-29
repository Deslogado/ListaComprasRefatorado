package br.com.listacompras.repositorio;

import java.util.List;
import java.util.Optional;

/** Contrato simples de armazenamento, independente da tecnologia usada. */
public interface Repositorio<T> {
    void salvar(T entidade);
    List<T> listar();
    Optional<T> buscarPorId(int id);
}
