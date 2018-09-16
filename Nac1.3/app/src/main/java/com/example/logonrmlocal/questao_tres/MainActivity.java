package com.example.logonrmlocal.questao_tres;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private EditText edtTitulo;
    private EditText edtConteudo;
    private final String dic = "Anotações";
    private final String error404 = " Anotação não encontrada ";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doLimpar (View view)
    {
        edtTitulo = (EditText) findViewById(R.id.edtTitulo);
        edtConteudo = (EditText) findViewById(R.id.edtConteudo);
        edtTitulo.setText("");
        edtConteudo.setText("");
    }

    public void doBuscarNota(View view)
    {
        edtTitulo = (EditText) findViewById(R.id.edtTitulo);
        edtConteudo = (EditText) findViewById(R.id.edtConteudo);
        String titulo = edtTitulo.getText().toString();
        SharedPreferences sh = getSharedPreferences(dic, Context.MODE_PRIVATE);
        String conteudo = sh.getString(titulo, error404);
        if(conteudo == error404) Toast.makeText(this, "Não foi encontrado " + titulo, Toast.LENGTH_LONG).show();
        else edtConteudo.setText(conteudo);
    }

    public void doAddNota(View view)
    {
        edtTitulo = (EditText) findViewById(R.id.edtTitulo);
        edtConteudo = (EditText) findViewById(R.id.edtConteudo);
        String titulo = edtTitulo.getText().toString();
        String conteudo = edtConteudo.getText().toString();
        SharedPreferences sh = getSharedPreferences(dic, Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sh.edit();
        ed.putString(titulo, conteudo);
        ed.apply();
        edtTitulo.setText("");
        edtConteudo.setText("");
        Toast.makeText(this, "A anotação (" + titulo + ") foi add", Toast.LENGTH_LONG).show();
    }
}