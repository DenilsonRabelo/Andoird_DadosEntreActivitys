package com.example.livro.ui;

import static android.os.Build.VERSION_CODES.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.livro.DAO.LivroDAO;
import com.example.livro.LivroAdapter;
import com.example.livro.Model.Livro;


public class form_livro extends AppCompatActivity {
    private EditText nome,valor;
    private final LivroDAO dao = new LivroDAO();
    private LivroAdapter adapter = new LivroAdapter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario_livro);

        iniciandoComponentes();
        configuraBotaoSalvar();
        configuraBtnCacelar();
    }

    private void iniciandoComponentes() {
        nome = findViewById(R.id.ack_nome);
        valor = findViewById(R.id.ack_valor);
    }
    private void configuraBtnCacelar(){
        Button btnCacelar = findViewById(R.id.act2Cancelar);
        btnCacelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(form_livro.this,list.class);
                startActivity(intent);
            }
        });
    }
    private void configuraBotaoSalvar() {
        Button botaoSalvar = findViewById(R.id.act2Salvar);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String modelo1 = nome.getText().toString();
                String cor1 = valor.getText().toString();

                ValidandoCampos(modelo1,cor1);


            }
            private void ValidandoCampos(String modelo1, String cor1){
                    Livro livro = criaCarro();
                    salva(livro);
            }
        });
    }
    private void salva(Livro livro) {
        dao.salva(livro);
        adapter.notifyDataSetChanged();
        Intent intent = new Intent(form_livro.this, list.class);
        startActivity(intent);
    }
    private Livro criaCarro() {
        String id ="";
        String modeloCar = nome.getText().toString();
        String corCar = valor.getText().toString();
        return new Livro(id,modeloCar,corCar);

    }
}
