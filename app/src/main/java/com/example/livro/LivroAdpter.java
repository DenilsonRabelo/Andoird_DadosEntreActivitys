package com.example.livro;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.livro.Model.Livro;

public class LivroAdpter extends BaseAdapter {

    Activity maActivity;
    Lista lista;

    public LivroAdpter(Activity maActivity, Lista lista) {
        this.maActivity = maActivity;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.getListalivros().size();
    }

    @Override
    public Livro getItem(int i) {
        return lista.getListalivros().get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View uma_lista;
        LayoutInflater inflater = (LayoutInflater) maActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        uma_lista = inflater.inflate(R.layout., viewGroup, false);
        TextView tv_nome = uma_lista.findViewById(R.id.);
        TextView tv_valor = uma_lista.findViewById(R.id.);
        TextView tv_id  = uma_lista.findViewById(R.id.);
        Livro p = this.getItem(i);
        tv_nome.setText(p.getNome());
        tv_valor.setText(p.getValor());
        tv_id.setText(p.getId());



        return uma_lista;
    }
}
