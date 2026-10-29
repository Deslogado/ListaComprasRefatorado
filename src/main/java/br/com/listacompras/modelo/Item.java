package br.com.listacompras.modelo;

public class Item {
    private final int id;
    private final String nome;
    private final String marcaFornecedor;
    private int quantidade;
    private boolean comprado;

    public Item(int id, String nome, int quantidade, String marcaFornecedor) {
        if (id <= 0) throw new IllegalArgumentException("O ID do item deve ser positivo.");
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("O nome do item é obrigatório.");
        if (quantidade <= 0) throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        this.id = id;
        this.nome = nome.trim();
        this.quantidade = quantidade;
        this.marcaFornecedor = marcaFornecedor == null ? "" : marcaFornecedor.trim();
        this.comprado = false;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public int getQuantidade() { return quantidade; }
    public String getMarcaFornecedor() { return marcaFornecedor; }
    public boolean isComprado() { return comprado; }
    public void marcarComoComprado() { comprado = true; }
    public void marcarComoPendente() { comprado = false; }

    public void alterarQuantidade(int quantidade) {
        if (quantidade <= 0) throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        this.quantidade = quantidade;
    }
}
