package br.com.listacompras.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lista {
    private final int id;
    private final String nome;
    private final List<Item> itens = new ArrayList<>();

    public Lista(int id, String nome) {
        if (id <= 0) throw new IllegalArgumentException("O ID da lista deve ser positivo.");
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("O nome da lista é obrigatório.");
        this.id = id;
        this.nome = nome.trim();
    }

    public int getId() { return id; }
    public String getNome() { return nome; }

    public void adicionarItem(Item item) {
        if (item == null) throw new IllegalArgumentException("O item não pode ser nulo.");
        itens.add(item);
    }

    public List<Item> getItens() {
        return Collections.unmodifiableList(itens);
    }
}
