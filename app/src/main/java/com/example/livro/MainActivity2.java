package com.example.livro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button btn_cadastrar = findViewById(R.id.btn_cadastro_ack2);
        Button btn_voltar = findViewById(R.id.btn_voltar);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");


        EditText id_2 = findViewById(R.id.id_ack2);
        id_2.setText(id);

        btn_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView nome = findViewById(R.id.nome_ack);
                TextView valor = findViewById(R.id.valor_ack2);
                TextView id = findViewById(R.id.id_ack2);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("nome1",nome.getText().toString());
                intent.putExtra("valor1", valor.getText().toString());
                intent.putExtra("id1", id.getText().toString());
                startActivity(intent);
            }
        });

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
}