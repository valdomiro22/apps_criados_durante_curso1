package com.santos.valdomiro.applistacurso.controller;

import android.util.Log;

import androidx.annotation.NonNull;

import com.santos.valdomiro.applistacurso.model.Pessoa;

public class PessoaController {

    @NonNull
    @Override
    public String toString() {

        Log.d("mostrar", "toString: Controler iniciada...");

        return super.toString();

    }

    public void salvar(Pessoa pessoa) {
        Log.d("mostrar", "salvar: Salvo: " + pessoa.toString());
    }
}
