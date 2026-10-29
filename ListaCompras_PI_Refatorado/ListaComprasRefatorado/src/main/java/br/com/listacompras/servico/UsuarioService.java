package br.com.listacompras.servico;

import br.com.listacompras.modelo.Usuario;
import br.com.listacompras.repositorio.UsuarioRepositorio;

public class UsuarioService {
    private final UsuarioRepositorio repositorio;
    public UsuarioService(UsuarioRepositorio repositorio) {
        if (repositorio == null) throw new IllegalArgumentException("O repositório é obrigatório.");
        this.repositorio = repositorio;
    }

    public Usuario cadastrar(int id, String nome, String email, String senha) {
        Usuario usuario = new Usuario(id, nome, email, senha);
        if (repositorio.buscarPorEmail(usuario.getEmail()).isPresent())
            throw new IllegalArgumentException("E-mail já cadastrado.");
        repositorio.salvar(usuario);
        return usuario;
    }
}
