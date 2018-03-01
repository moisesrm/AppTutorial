package com.machado.moises.app.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by moises on 2/22/18.
 */

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "App.db";
    public static final String TABLE_USUARIO = "usuario";
    public static final String COL_ID = "ID";
    public static final String COL_LOGIN = "LOGIN";
    public static final String COL_SENHA = "SENHA";
    public static final String COL_WEBSERVICE = "WEBSERVICE";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_USUARIO +" ("+COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                                                     +COL_LOGIN+" TEXT,"
                                                     +COL_SENHA+" TEXT,"
                                                     +COL_WEBSERVICE+" TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_USUARIO);
        onCreate(db);
    }

    public boolean insertUsuario(String login,String senha,String webservice) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_LOGIN,login);
        contentValues.put(COL_SENHA,senha);
        contentValues.put(COL_WEBSERVICE,webservice);
        long result = db.insert(TABLE_USUARIO,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean updateUsuario(String id,String login,String senha,String webservice) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_ID,id);
        contentValues.put(COL_LOGIN,login);
        contentValues.put(COL_SENHA,senha);
        contentValues.put(COL_WEBSERVICE,webservice);
        db.update(TABLE_USUARIO, contentValues, "ID = ?",new String[] { id });
        return true;
    }

    public Cursor getAllUsuario(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_USUARIO,null);
        return res;
    }

    public Cursor getUsuario(String login,String senha) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor retorno = db.rawQuery("SELECT * FROM "+TABLE_USUARIO+" WHERE "+COL_LOGIN+" = '"+login+
                                      "' AND "+COL_SENHA+" = '"+senha+"'",null);
        return retorno;
    }




}
