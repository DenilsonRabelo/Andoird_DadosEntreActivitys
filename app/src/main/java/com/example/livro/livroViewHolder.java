package com.example.livro;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class livroViewHolder  extends RecyclerView.ViewHolder{
    TextView nome,valor;
    Button editar;
    Button deletar;
    public livroViewHolder(@NonNull View itemView) {
        super(itemView);
        nome = itemView.findViewById(R.id.nome);
        valor = itemView.findViewById(R.id.valor);
        editar = itemView.findViewById(R.id.btn_edit);
        deletar = itemView.findViewById(R.id.btn_apagar);
    }
}
