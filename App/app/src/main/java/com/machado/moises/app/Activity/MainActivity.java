package com.machado.moises.app.Activity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.machado.moises.app.Class.Session;
import com.machado.moises.app.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Loading();
    }

    public boolean checkInternet(){
        ConnectivityManager conectivtyManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conectivtyManager.getActiveNetworkInfo() != null
                && conectivtyManager.getActiveNetworkInfo().isAvailable()
                && conectivtyManager.getActiveNetworkInfo().isConnected()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gera a tela de loading
     */
    public void Loading(){
        Thread splash = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    while (waited < 3500) {
                        sleep(100);
                        waited += 100;
                        Session session = new Session(getApplicationContext());
                        if(checkInternet()){
                            if(session.isLoggedIn()){
                                Intent menu = new Intent(MainActivity.this,MenuActivity.class);
                                startActivity(menu);
                                break;
                            }else{
                                Intent login = new Intent(MainActivity.this,LoginActivity.class);
                                startActivity(login);
                                break;
                            }
                        }else{
                            Intent cadastro = new Intent(MainActivity.this,CadastroActivity.class);
                            startActivity(cadastro);
                            break;
                        }
                    }
                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    MainActivity.this.finish();
                }

            }
        };
        splash.start();
    }
}