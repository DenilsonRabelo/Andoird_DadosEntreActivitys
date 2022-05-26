package com.example.livro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView texto = findViewById(R.id.texto_livros);


        Button btn_cadastrar = findViewById(R.id.btn_cadastro1);
        Button btn_editar = findViewById(R.id.btn_editar1);





        Intent intent = getIntent();
        String tt = intent.getStringExtra("texto");
        String nome = intent.getStringExtra("nome");
        Integer valor = intent.getIntExtra("valor", 0);
        Integer id = intent.getIntExtra("id", 0);
        if (tt == null) {
            texto.setText(" ");
        }else {
            texto.setText(tt + "\nNome: " + nome + "Valor: " + valor + " id: " + id);

        }



        btn_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , MainActivity2.class);
                intent.putExtra("texto", texto.getText().toString());
                startActivity(intent);
            }
        });

        btn_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}