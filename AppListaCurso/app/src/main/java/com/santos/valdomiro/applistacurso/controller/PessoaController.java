package com.santos.valdomiro.applistacurso.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import com.santos.valdomiro.applistacurso.model.Pessoa;
import com.santos.valdomiro.applistacurso.view.MainActivity;

public class PessoaController {

    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public static final String NOME_PREFERENCES = "pref_listaVip";

    public PessoaController(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }

    @NonNull
    @Override
    public String toString() {

        Log.d("mostrar", "toString: Controler iniciada...");

        return super.toString();

    }

    /**
     * Salvar no SharedPreferences
     */
    public void salvar(Pessoa pessoa) {
        Log.d("mostrar", "salvar: Salvo: " + pessoa.toString());

        listaVip.putString("primeiroNome", pessoa.getPrimeiroNome());
        listaVip.putString("sobrenome", pessoa.getSobrenome());
        listaVip.putString("cursoDesejado", pessoa.getCursoDesejado());
        listaVip.putString("telefoneContato", pessoa.getTelefoneContato());
        listaVip.apply();
    }

    /**
     * Buscar no SharedPreferences
     */
    public void buscar(Pessoa pessoa) {
        pessoa.setPrimeiroNome(preferences.getString("primeiroNome", "vazio"));
        pessoa.setSobrenome(preferences.getString("sobrenome", "vazio"));
        pessoa.setCursoDesejado(preferences.getString("cursoDesejado", "vazio"));
        pessoa.setTelefoneContato(preferences.getString("telefoneContato", "vazio"));
    }

    /**
     * Apagar os dados do SharedPreferences
     */
    public void limpar() {
            listaVip.clear();
            listaVip.apply();
    }

}
