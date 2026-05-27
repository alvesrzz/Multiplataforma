package org.example.model;

public class Empresa {
    private int id;
    private String nome;
    private int qtd_func;
    private String endereco;

    public Empresa(String nome, int qtd_func, String endereco) {
        this.nome = nome;
        this.qtd_func = qtd_func;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtd_func() {
        return qtd_func;
    }

    public void setQtd_func(int qtd_func) {
        this.qtd_func = qtd_func;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
