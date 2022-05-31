package com.example.livro;

import android.app.Application;

public class MyApplication extends Application {
    private Lista lista = new Lista();

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }
}
