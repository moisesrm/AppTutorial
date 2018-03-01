package com.machado.moises.app.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.machado.moises.app.DB.DBHelper;
import com.machado.moises.app.R;

public class CadastroActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Button cadastroBtn = (Button) findViewById(R.id.btn_cadastro);
        cadastroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Cadastrar(); }
        });
    }

    public void Cadastrar() {
        EditText txtLogin = (EditText) findViewById(R.id.login);
        EditText txtSenha = (EditText) findViewById(R.id.senha);
        EditText txtWebservice = (EditText) findViewById(R.id.webservice);

        DBHelper db = new DBHelper(this);
        db.insertUsuario(txtLogin.getText().toString(), txtSenha.getText().toString(), txtWebservice.getText().toString());
        Intent login = new Intent(CadastroActivity.this, LoginActivity.class);
        startActivity(login);
    }
}