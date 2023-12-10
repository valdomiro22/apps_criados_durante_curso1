package com.santos.valdomiro.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.santos.valdomiro.applistacurso.R;
import com.santos.valdomiro.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa();

    }
}