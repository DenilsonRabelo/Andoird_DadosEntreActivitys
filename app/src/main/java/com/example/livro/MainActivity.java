package com.example.livro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.livro.Model.Livro;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    LivroAdpter adpter;
    Lista lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.texto_livros);

        Button btn_cadastrar = findViewById(R.id.btn_cadastro1);
        Button btn_editar = findViewById(R.id.btn_editar1);


        lista = ((MyApplication) this.getApplication()).getLista();
        adpter = new LivroAdpter(MainActivity.this, lista);
        lv.setAdapter(adpter);

        Intent intent = getIntent();
        String nome = intent.getStringExtra("nome1");
        String valor =  intent.getStringExtra("valor1");
        String id = intent.getStringExtra("id1");

        Livro livro = new Livro(nome, valor, id);
        lista.getListalivros().add(livro);
        adpter.notifyDataSetChanged();





        btn_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText id = findViewById(R.id.id1_active);
                if (id.getText().toString().equals("")){

                }else {
                    Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                    intent.putExtra("id", id.getText().toString());
                    startActivity(intent);
                }

            }
        });







    }
}