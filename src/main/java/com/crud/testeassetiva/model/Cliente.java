package com.crud.testeassetiva.model;

import java.util.List;
import java.util.Objects;

public class Cliente {

    private Long id;
    private String cpf;
    private String nome;
    private List<String> celulares;
    private List<String> emails;

    public Cliente() {}

    public Cliente(String cpf, String nome, List<String> celulares, List<String> emails) {
        this.cpf = cpf;
        this.nome = nome;
        this.celulares = celulares;
        this.emails = emails;
    }

    public Cliente(Long id, String cpf, String nome, List<String> celulares, List<String> emails) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.celulares = celulares;
        this.emails = emails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getCelulares() {
        return celulares;
    }

    public void setCelulares(List<String> celulares) {
        this.celulares = celulares;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id) && Objects.equals(cpf, cliente.cpf) && Objects.equals(nome, cliente.nome) && Objects.equals(celulares, cliente.celulares) && Objects.equals(emails, cliente.emails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf, nome, celulares, emails);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", celulares=" + celulares +
                ", emails=" + emails +
                '}';
    }
}

