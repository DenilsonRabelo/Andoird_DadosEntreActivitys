package com.example.livro;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lista {
    List<Livro> listalivros;

    public Lista(List<Livro> listalivros) {
        this.listalivros = listalivros;
    }

    public Lista(){
        this.listalivros = new ArrayList<>();

    }

    public List<Livro> getListalivros() {
        return listalivros;
    }

    public void setListalivros(List<Livro> listalivros) {
        this.listalivros = listalivros;
    }
}
