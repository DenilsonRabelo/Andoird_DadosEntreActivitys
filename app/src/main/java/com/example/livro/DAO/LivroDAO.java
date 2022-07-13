package com.example.livro.DAO;
import androidx.annotation.NonNull;

import com.example.livro.Model.Livro;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class LivroDAO {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private final static List<Livro> livros = new ArrayList<>();

    public void salva(Livro livro) {
        db.collection("carros")
                .add(livro)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        livro.setId(documentReference.getId());
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
        livros.add(livro);
    }
    public void remover(Livro livro) {
        db.collection("livros").document(livro.getId()).delete();
    }

    public void edit(Livro livro){
        db.collection("livros").document(livro.getId()).set(livro);
    }

    public List<Livro> list() {
        db.collection("livros")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            livros.clear();
                            for (QueryDocumentSnapshot doc : task.getResult()) {
                                String id = (String) doc.getId();
                                String nome = (String) doc.getData().get("nome");
                                String valor = (String) doc.getData().get("valor");
                                livros.add(new Livro(id,nome, valor));
                            }
                        } else {

                        }
                    }
                });
        return livros;
    }
}
