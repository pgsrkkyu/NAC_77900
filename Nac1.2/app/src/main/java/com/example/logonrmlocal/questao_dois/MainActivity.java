package com.example.logonrmlocal.questao_dois;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doEnviar(View view)
    {
        TextView edtId = findViewById(R.id.edtId);
        TextView edtTitulo = findViewById(R.id.edtTitulo);
        TextView edtContex = findViewById(R.id.edtContex);
        TextView txtResp = findViewById(R.id.txtResp);

        String url = "https://jsonplaceholder.typicode.com/posts";

        String parameter =
                "{\n  "                                       +
                        "   \"userId\":   ValorId,\n  " +
                        "   \"title\" : \"ValorTitulo\"\n  " +
                        "   \"body\"  : \"ValorContex\"\n   " +
                        "}                                     ";

        parameter.replace( "ValorId" , edtId.getText().toString() );
        parameter.replace( "ValorTitulo" , edtTitulo.getText().toString() );
        parameter.replace( "ValorContex" , edtContex.getText().toString() );

        new DataGetterPost(txtResp).execute(url,parameter);
    }

    public void doLimpar(View view)
    {
        TextView edtId = findViewById(R.id.edtId);
        TextView edtTitulo = findViewById(R.id.edtTitulo);
        TextView edtContex = findViewById(R.id.edtContex);
        TextView txtResp = findViewById(R.id.txtResp);

        edtId.setText("");
        edtTitulo.setText("");
        edtContex.setText("");
        txtResp.setText("Resposta");
    }
}