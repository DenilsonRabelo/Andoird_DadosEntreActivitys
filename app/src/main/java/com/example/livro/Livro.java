package com.example.livro;


public class Livro{

    String nome;
    String valor;
    String id;

    public Livro(String nome, String valor, String id){
        this.nome = nome;
        this.valor = valor;
        this.id = id;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + nome + '\'' +
                ", valor=" + valor +
                ", id=" + id +
                '}';
    }
}
