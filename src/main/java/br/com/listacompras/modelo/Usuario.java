package br.com.listacompras.modelo;

public class Usuario {
    private final int id;
    private final String nome;
    private final String email;
    private final String senha;

    public Usuario(int id, String nome, String email, String senha) {
        if (id <= 0) throw new IllegalArgumentException("O ID do usuário deve ser positivo.");
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("O nome é obrigatório.");
        if (email == null || !email.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$"))
            throw new IllegalArgumentException("Informe um e-mail válido.");
        if (senha == null || senha.isBlank()) throw new IllegalArgumentException("A senha é obrigatória.");
        this.id = id;
        this.nome = nome.trim();
        this.email = email.trim().toLowerCase();
        this.senha = senha;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getSenha() { return senha; }
}
