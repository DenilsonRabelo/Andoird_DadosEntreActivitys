package com.example.livro.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.livro.DAO.LivroDAO;
import com.example.livro.LivroAdpter;
import com.example.livro.Model.Livro;
import com.example.livro.R;

public class editar_livro extends AppCompatActivity {
    private EditText nome, valor;
    private Button btnAt, btnCacelar;
    private LivroDAO dao = new LivroDAO();
    private LivroAdpter adapter = new LivroAdpter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editar_livro);
        nome = findViewById(R.id.nome);
        valor = findViewById(R.id.valor);
        int posicao = getIntent().getIntExtra("id", 0);
        Livro livro = (Livro) getIntent().getSerializableExtra("livro");
        String livro_nome = livro.getNome();
        String valor1 = livro.getValor();
        nome.setText(livro_nome);
        valor.setText(valor1);


        configurandoBtnAtl(posicao, livro, livro_nome, valor1);

        btnCacelar = findViewById(R.id.cancelar);
        btnCacelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(.this, list.class);
                startActivity(intent);
            }
        });

    }

    private void configurandoBtnAtl(int posicao, Livro livro, String livro_nome, String valor1) {
        btnAt = findViewById(R.id.atualizar);
        btnAt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(.this, list.class);
                startActivity(intent);
            }
        });
    }
}

