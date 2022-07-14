package com.example.livro.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.livro.DAO.LivroDAO;
import com.example.livro.LivroAdapter;
import com.example.livro.Model.Livro;


public class ListCar extends AppCompatActivity implements interfacelivro {
    private final LivroDAO dao = new LivroDAO();
    static private EditText id;
    private RecyclerView recyclerView;
    private LivroAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_car);
        adapter = new LivroAdapter(this, dao.list(),.this);
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
        adapter = new LivroAdapter(ListCar.this, dao.list(),this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ListCar.this,RecyclerView.VERTICAL,false);
        adapter.notifyDataSetChanged();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
    private void abrirFormularioCar() {
        Intent intent = new Intent(ListCar.this, form_livro.class);
        startActivity(intent);
    }

    @Override
    public void apClick(Livro livro) {

    }

    @Override
    public void LgClick(Livro livro) {
        dao.remover(livro);
        adapter.notifyDataSetChanged();
        Toast.makeText(lista_livros.this,"Você apagou: " + livro.getModelo(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void btnEdit(int i, Livro livro) {
        Intent intent = new Intent(ListCar.this, EdtCar.class);
        intent.putExtra("id",i);
        intent.putExtra("car",livro);
        startActivity(intent);
    }
}
