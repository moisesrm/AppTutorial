package com.machado.moises.app.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.machado.moises.app.Class.Session;
import com.machado.moises.app.R;

public class MenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btnRelatorio = (Button) findViewById(R.id.btn_logs);
        Button btnFiltros = (Button) findViewById(R.id.btn_filters);
        Button btnRede = (Button) findViewById(R.id.btn_network);
        Button btnPerfil = (Button) findViewById(R.id.btn_perfil);
        Button btnLogout = (Button) findViewById(R.id.btn_logout);

        btnFiltros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Filtros();
            }
        });

        btnRelatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Logs();
            }
        });

        btnRede.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Rede();
            }
        });

        btnPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Perfil();
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logout();
            }
        });

    }

    public void Relatorio(){
        //Intent relatorio = new Intent(MenuActivity.this, RelatorioActivity.class);
        //startActivity(relatorio);
    }

    public void Filtros(){
        //Intent relatorio = new Intent(MenuActivity.this, FiltroActivity.class);
        //startActivity(relatorio);
    }

    public void Rede(){
        //Intent relatorio = new Intent(MenuActivity.this, RedeActivity.class);
        //startActivity(relatorio);
    }

    public void Logs(){
        //Intent relatorio = new Intent(MenuActivity.this, LogsActivity.class);
        //startActivity(relatorio);
    }

    public void Perfil(){
        //Intent relatorio = new Intent(MenuActivity.this, PerfilActivity.class);
        //startActivity(relatorio);
    }

    public void Logout(){
        Session session = new Session(getApplicationContext());
        session.logoutUser();
        Intent login = new Intent(MenuActivity.this, LoginActivity.class);
        startActivity(login);
    }

}
