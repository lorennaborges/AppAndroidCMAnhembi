package com.dlp.scarysounds2.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dlp.scarysounds2.R;
import com.dlp.scarysounds2.dao.UsuarioDAO;
import com.dlp.scarysounds2.service.UsuarioService;

public class UsuarioActivity extends Activity {

    EditText nome;
    EditText ra;
    Button alterar;
    Button deletar;
    Cursor cursor;
    UsuarioService crud;
    String codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        codigo = this.getIntent().getStringExtra("codigo");
        crud = new UsuarioService(getBaseContext());
        nome = (EditText) findViewById(R.id.editText5);
        ra = (EditText) findViewById(R.id.editText6);
        alterar = (Button) findViewById(R.id.button2);
        cursor = crud.carregaDadoById(Integer.parseInt(codigo));
        nome.setText(cursor.getString(cursor.getColumnIndexOrThrow(UsuarioDAO.NOME)));
        ra.setText(cursor.getString(cursor.getColumnIndexOrThrow(UsuarioDAO.RA)));

        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.alteraRegistro(Integer.parseInt(codigo), nome.getText().toString(), ra.getText().toString());
                Intent intent = new Intent(UsuarioActivity.this, SobreActivity.class);
                startActivity(intent);
                finish();
            }
        });

        deletar = (Button) findViewById(R.id.button3);
        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.deletaRegistro(Integer.parseInt(codigo));
                Intent intent = new Intent(UsuarioActivity.this, SobreActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

}
