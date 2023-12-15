package com.santos.valdomiro.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.santos.valdomiro.applistacurso.R;
import com.santos.valdomiro.applistacurso.controller.PessoaController;
import com.santos.valdomiro.applistacurso.model.Pessoa;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    AppCompatTextView txt_titulo;
    AppCompatEditText editPrimeiroNome;
    AppCompatEditText editSobrenome;
    AppCompatEditText editCursoDesejado;
    AppCompatEditText editTelefoneContato;
    AppCompatButton btnLimpar;
    AppCompatButton btnSalvar;
    AppCompatButton btnFinalizar;

    Pessoa pessoa;
    PessoaController controller;

    SharedPreferences preferences;

    public static final String NOME_PREFERENCES = "pref_listaVip";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarComponentes();

        preferences = getSharedPreferences(NOME_PREFERENCES, 0);
        @SuppressLint("CommitPrefEdits")
        SharedPreferences.Editor listaVip = preferences.edit();

//        pessoa = new Pessoa();
        controller = new PessoaController();
//
//        pessoa.setPrimeiroNome("Valdomiro");
//        pessoa.setSobrenome("Santos");
//        pessoa.setCursoDesejado("Desenvolvimento Android");
//        pessoa.setTelefoneContato("18-239282395");

//        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
//        editSobrenome.setText(pessoa.getSobrenome());
//        editCursoDesejado.setText(pessoa.getCursoDesejado());
//        editTelefoneContato.setText(pessoa.getTelefoneContato());

        // Recuperando dados do sharedPreferences
        // Recupera os dados e seta no objeto pessoa
        pessoa = new Pessoa();
        pessoa.setPrimeiroNome(preferences.getString("primeiroNome", "vazio"));
        pessoa.setSobrenome(preferences.getString("sobrenome", "vazio"));
        pessoa.setCursoDesejado(preferences.getString("cursoDesejado", "vazio"));
        pessoa.setTelefoneContato(preferences.getString("telefoneContato", "vazio"));

        // Após recuperar os dados, e setar no objeto pessoa
        // Setar os valores nos editText. A partir do objeto pessoa
        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobrenome.setText(pessoa.getSobrenome());
        editCursoDesejado.setText(pessoa.getCursoDesejado());
        editTelefoneContato.setText(pessoa.getTelefoneContato());

        btnLimpar.setOnClickListener(v -> {
            editPrimeiroNome.setText("");
            editSobrenome.setText("");
            editCursoDesejado.setText("");
            editTelefoneContato.setText("");

            Toast.makeText(getApplicationContext(), "Campos foram limpos",
                    Toast.LENGTH_SHORT).show();
        });

        btnFinalizar.setOnClickListener(v -> {
            finish();

            Toast.makeText(getApplicationContext(), "Aplicação finalizada",
                    Toast.LENGTH_SHORT).show();
        });

        btnSalvar.setOnClickListener(v -> {
            pessoa.setPrimeiroNome(Objects.requireNonNull(editPrimeiroNome.getText()).toString());
            pessoa.setSobrenome(Objects.requireNonNull(editSobrenome.getText()).toString());
            pessoa.setCursoDesejado(Objects.requireNonNull(editCursoDesejado.getText()).toString());
            pessoa.setTelefoneContato(Objects.requireNonNull(editTelefoneContato.getText()).toString());

            Log.d("mostrar", "Nome: " + pessoa.getPrimeiroNome());
            Log.d("mostrar", "Sobrenome: " + pessoa.getSobrenome());
            Log.d("mostrar", "Nome: " + pessoa.getCursoDesejado());
            Log.d("mostrar", "Nome: " + pessoa.getTelefoneContato());

            // Salvar no SharedPreferences
            listaVip.putString("primeiroNome", pessoa.getPrimeiroNome());
            listaVip.putString("sobrenome", pessoa.getSobrenome());
            listaVip.putString("cursoDesejado", pessoa.getCursoDesejado());
            listaVip.putString("telefoneContato", pessoa.getTelefoneContato());
            listaVip.apply();

            controller.salvar(pessoa);
        });
    }

    private void iniciarComponentes() {
        txt_titulo = findViewById(R.id.txt_titulo);

        editPrimeiroNome = findViewById(R.id.edit_primeiro_nome);
        editSobrenome = findViewById(R.id.edit_sobrenome);
        editCursoDesejado = findViewById(R.id.edit_curso_desejado);
        editTelefoneContato = findViewById(R.id.edit_telefone_contato);

        btnFinalizar = findViewById(R.id.btn_finalizar);
        btnLimpar = findViewById(R.id.btn_limpar);
        btnSalvar = findViewById(R.id.btn_salvar);
    }
}