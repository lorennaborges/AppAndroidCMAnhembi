package com.dlp.scarysounds2.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dlp.scarysounds2.R;
import com.dlp.scarysounds2.service.UsuarioService;

public class InsereActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insere);

        Button botao = (Button) findViewById(R.id.button);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UsuarioService crud = new UsuarioService(getBaseContext());
                EditText nome = (EditText) findViewById((R.id.editText2));
                EditText ra = (EditText) findViewById(R.id.editText3);
                String nomeString = nome.getText().toString();
                String raString = ra.getText().toString();
                String resultado;
                resultado = crud.insereDado(nomeString, raString);
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });

    }

}
