package com.example.mockup;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import static android.icu.text.MessagePattern.ArgType.SELECT;
import static com.example.mockup.CriaBanco2.EMAIL;
import static com.example.mockup.CriaBanco2.SENHA;
import static com.example.mockup.CriaBanco2.TABELA;

public class BancoController {
    private SQLiteDatabase db;
    private CriaBanco2 banco;

    public BancoController(Context context) {
        banco = new CriaBanco2(context);
    }


    public String insereDado(String nome, String email, String senha) {
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();

        valores.put(CriaBanco2.NOME, nome);
        valores.put(CriaBanco2.EMAIL, email);
        valores.put(CriaBanco2.SENHA, senha);


        resultado = db.insert(TABELA, null, valores);
        db.close();

        if (resultado == -1) {
            return "Erro ao inserir registro";
        } else {
            return "Sucesso";

        }


    }

    public Cursor fazerLogin(String email, String senha){

        db = banco.getWritableDatabase();
        String sql =  "SELECT * FROM  "+TABELA+" WHERE "+EMAIL+" = ? AND "+SENHA+" = ?";
        String[] selectionArgs = new String[] {email, senha};
        Cursor cursor = db.rawQuery(sql,selectionArgs);
        if (cursor != null)  {
            cursor.moveToFirst();
            return cursor;
        }else{
            return null;
        }
    }



}





