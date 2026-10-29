package br.com.listacompras.repositorio.memoria;

import br.com.listacompras.modelo.Usuario;
import br.com.listacompras.repositorio.UsuarioRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioRepositorioMemoria implements UsuarioRepositorio {
    private final List<Usuario> dados = new ArrayList<>();

    @Override public void salvar(Usuario usuario) {
        if (buscarPorId(usuario.getId()).isPresent()) throw new IllegalArgumentException("Já existe usuário com esse ID.");
        if (buscarPorEmail(usuario.getEmail()).isPresent()) throw new IllegalArgumentException("E-mail já cadastrado.");
        dados.add(usuario);
    }
    @Override public List<Usuario> listar() { return List.copyOf(dados); }
    @Override public Optional<Usuario> buscarPorId(int id) {
        return dados.stream().filter(u -> u.getId() == id).findFirst();
    }
    @Override public Optional<Usuario> buscarPorEmail(String email) {
        if (email == null) return Optional.empty();
        return dados.stream().filter(u -> u.getEmail().equalsIgnoreCase(email.trim())).findFirst();
    }
}
