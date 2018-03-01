package com.machado.moises.app.Activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.machado.moises.app.Class.Session;
import com.machado.moises.app.DB.DBHelper;
import com.machado.moises.app.R;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnLogin = (Button) findViewById(R.id.btn_login);
        Button btnCadastro = (Button) findViewById(R.id.btn_cadastro);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Login(); }
        });

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Cadastrar(); }
        });
    }

    public void Cadastrar(){
        Intent cadastro = new Intent(LoginActivity.this, CadastroActivity.class);
        startActivity(cadastro);
    }

    public void Login(){
        EditText txtLogin = (EditText) findViewById(R.id.login);
        EditText txtSenha = (EditText) findViewById(R.id.senha);
        DBHelper db = new DBHelper(this);
        Cursor usuario = db.getUsuario(txtLogin.getText().toString(), txtSenha.getText().toString());
        if(usuario.moveToFirst()){
            Session session = new Session(getApplicationContext());
            String id = usuario.getString(0);
            String login = usuario.getString(1);
            String webservice = usuario.getString(3);
            session.createLoginSession(id,login,webservice);
            Intent menu = new Intent(LoginActivity.this, MenuActivity.class);
            startActivity(menu);
        }else{
            Toast.makeText(getApplicationContext(), "Login ou Senha Incorretos!", Toast.LENGTH_LONG).show();
        }

    }

}
