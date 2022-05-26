package com.example.livro;


import android.os.Parcel;
import android.os.Parcelable;

public class Livro implements Parcelable {

    String nome;
    int valor;
    int id;

    public Livro (String nome, int valor , int id){
        this.nome = nome;
        this.valor = valor;
        this.id = id;
    }

    protected Livro(Parcel in) {
        nome = in.readString();
        valor = in.readInt();
        id = in.readInt();
    }

    public static final Creator<Livro> CREATOR = new Creator<Livro>() {
        @Override
        public Livro createFromParcel(Parcel in) {
            return new Livro(in);
        }

        @Override
        public Livro[] newArray(int size) {
            return new Livro[size];
        }
    };




    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeInt(valor);
        dest.writeInt(id);
    }
}
