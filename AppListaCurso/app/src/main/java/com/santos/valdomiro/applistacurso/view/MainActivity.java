package com.santos.valdomiro.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;
import android.widget.Toast;

import com.santos.valdomiro.applistacurso.R;
import com.santos.valdomiro.applistacurso.controller.PessoaController;
import com.santos.valdomiro.applistacurso.model.Pessoa;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    AppCompatTextView txtTitulo;
    AppCompatEditText editPrimeiroNome;
    AppCompatEditText editSobrenome;
    AppCompatEditText editCursoDesejado;
    AppCompatEditText editTelefoneContato;
    AppCompatButton btnLimpar;
    AppCompatButton btnSalvar;
    AppCompatButton btnFinalizar;

    Pessoa pessoa;
    PessoaController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarComponentes();

        controller = new PessoaController(MainActivity.this);

        // Recuperando dados do sharedPreferences
        // Recupera os dados e seta no objeto pessoa
        pessoa = new Pessoa();
        controller.buscar(pessoa);

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

            // Limpar os dados do sharedPreferences
            controller.limpar();

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

            Toast.makeText(getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

            // Salvar os dados no sharedPreferences
            controller.salvar(pessoa);
        });
    }

    private void iniciarComponentes() {
        txtTitulo = findViewById(R.id.txt_titulo);

        editPrimeiroNome = findViewById(R.id.edit_primeiro_nome);
        editSobrenome = findViewById(R.id.edit_sobrenome);
        editCursoDesejado = findViewById(R.id.edit_curso_desejado);
        editTelefoneContato = findViewById(R.id.edit_telefone_contato);

        btnFinalizar = findViewById(R.id.btn_finalizar);
        btnLimpar = findViewById(R.id.btn_limpar);
        btnSalvar = findViewById(R.id.btn_salvar);
    }
}