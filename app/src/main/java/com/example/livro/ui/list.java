package com.example.livro.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.livro.DAO.LivroDAO;
import com.example.livro.LivroAdapter;
import com.example.livro.Model.Livro;
import com.example.livro.interfaceLivro;


public class list extends AppCompatActivity implements interfaceLivro {
    private final LivroDAO dao = new LivroDAO();
    static private EditText id;
    private RecyclerView recyclerView;
    private LivroAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_livro);
        adapter = new LivroAdapter(this, dao.list(), this);
        adapter.notifyDataSetChanged();
        configRecycler();
        ConfigurandoBtnAdd();
    }



    private void ConfigurandoBtnAdd() {
        Button btnAdd = findViewById(R.id.Adicionar);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirFormularioCar();
            }
        });
    }

    private void configRecycler() {
        recyclerView = findViewById(R.id.recycler);
        adapter = new LivroAdapter(list.this, dao.list(),this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(list.this,RecyclerView.VERTICAL,false);
        adapter.notifyDataSetChanged();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
    private void abrirFormularioCar() {
        Intent intent = new Intent(list.this, formlivro.class);
        startActivity(intent);
    }

    public void apClick(Livro livro) {

    }

    public void LgClick(Livro livro) {
        dao.remover(livro);
        adapter.notifyDataSetChanged();
        Toast.makeText(list.this,"Você apagou: " + livro.getNome(),Toast.LENGTH_SHORT).show();
    }


    public void btnEdit(int i, Livro livro) {
        Intent intent = new Intent(list.this, editar_livro.class);
        intent.putExtra("id",i);
        intent.putExtra("livro", (Parcelable) livro);
        startActivity(intent);
    }
}
