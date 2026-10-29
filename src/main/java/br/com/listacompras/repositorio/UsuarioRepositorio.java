package br.com.listacompras.repositorio;

import br.com.listacompras.modelo.Usuario;
import java.util.Optional;

public interface UsuarioRepositorio extends Repositorio<Usuario> {
    Optional<Usuario> buscarPorEmail(String email);
}
