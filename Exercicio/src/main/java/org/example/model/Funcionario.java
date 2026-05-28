package org.example.model;

import java.time.LocalDate;

public class Funcionario {
    private int id;
    private String nome;
    private LocalDate data_funcionario;
    private int cod_emp;

    public Funcionario(String nome, LocalDate data, int cod_emp) {
        this.nome = nome;
        this.data_funcionario = data;
        this.cod_emp = cod_emp;
    }

    public Funcionario() {}

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

    public LocalDate getDataFuncionario() {
        return data_funcionario;
    }

    public void setDataFuncionario(LocalDate data_funcionario) {
        this.data_funcionario = data_funcionario;
    }

    public int getCod_emp() {
        return cod_emp;
    }

    public void setCod_emp(int cod_emp) {
        this.cod_emp = cod_emp;
    }
}