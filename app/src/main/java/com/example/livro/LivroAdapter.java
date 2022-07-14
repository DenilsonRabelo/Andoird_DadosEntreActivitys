package com.example.livro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.livro.Model.Livro;

import java.util.List;



public class LivroAdapter extends RecyclerView.Adapter<com.example.livro.livroViewHolder> {
    private Context context;
    private List<Livro> livros;
    private interfaceLivro interfacelicro;
    private livroViewHolder livroViewHolder;

    public LivroAdapter(Context context, List<Livro> livros, interfaceLivro livro) {
        this.context = context;
        this.livros = livros;
        this.interfacelicro = livro;
    }

    public LivroAdapter() {

    }


    @NonNull
    @Override
    public livroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.livro, parent, false);
        livroViewHolder livroViewHolder = new livroViewHolder(view);
        return livroViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull livroViewHolder holder, int position) {
        Livro livro = livros.get(position);
        int posicao = position;
        holder.nome.setText(livro.getNome());
        holder.valor.setText(livro.getValor());

        holder.editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                interfacelicro.btnEdit(posicao, livro);
            }
        });

        holder.deletar.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                interfacelicro.LgClick(livro);
                return false;
            }
        });


    }

    @Override
    public int getItemCount() {
        return livros.size();
    }
}
