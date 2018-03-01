package com.machado.moises.app.Class;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.machado.moises.app.Activity.LoginActivity;

import java.util.HashMap;

/**
 * Created by moises on 2/26/18.
 */

public class Session {

    SharedPreferences _sharePref;
    SharedPreferences.Editor _editor;
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String ARQUIVO = "AppSessao";

    // All Shared Preferences Keys
    private static final String IS_LOGIN = "false";

    // DADOS DA SESSAO
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "login";
    public static final String KEY_WEBSERVICE = "webservice";

    // Constructor
    public Session(Context context){
        this._context = context;
        _sharePref = _context.getSharedPreferences(ARQUIVO, PRIVATE_MODE);
        _editor = _sharePref.edit();
    }

    public void createLoginSession(String id, String name, String webservice){
        // SET DADOS
        _editor.putBoolean(IS_LOGIN, true);
        _editor.putString(KEY_ID, id);
        _editor.putString(KEY_NAME, name);
        _editor.putString(KEY_WEBSERVICE, webservice);

        // SALVA
        _editor.commit();
    }

    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();

        user.put(KEY_NAME, _sharePref.getString(KEY_NAME, null));
        user.put(KEY_WEBSERVICE, _sharePref.getString(KEY_WEBSERVICE, null));

        return user;
    }

    public boolean isLoggedIn(){
        return _sharePref.getBoolean(IS_LOGIN, false);
    }

    public void checkLogin(){
        if(!this.isLoggedIn()){
            // Chama Activity de Login
            Intent i = new Intent(_context, LoginActivity.class);

            // Fecha todas as Activites abertas
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Adiciona Flag de nova Activit
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Abre Activity
            _context.startActivity(i);
        }

    }

    public void logoutUser(){
        // Clearing all data from Shared Preferences
        _editor.clear();
        _editor.commit();

        Intent i = new Intent(_context, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        _context.startActivity(i);
    }

}
