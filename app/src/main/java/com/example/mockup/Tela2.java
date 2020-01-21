package com.example.mockup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Tela2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);


    }

    public void login(View view) {
        EditText Email = findViewById(R.id.Email);
        EditText Senha = findViewById(R.id.Senha);
        String strEmail = Email.getText().toString();
        String strSenha = Senha.getText().toString();
        boolean erro = false;

        if (strEmail.length() > 0 && strSenha.length() > 0) {
            BancoController crud = new BancoController(getBaseContext());
            Cursor cursor = crud.fazerLogin(strEmail, strSenha);
            if (cursor == null || cursor.getCount() == 0) {
                erro = true;

            } else {
                String resEmail = cursor.getString(cursor.getColumnIndex("Email"));
                String resSenha = cursor.getString(cursor.getColumnIndex("Senha"));

                if (strEmail.equals(resEmail) && strSenha.equals(resSenha)) {
                    Toast.makeText(getApplicationContext(), "Seja bem-vindo", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(this, home.class);
                    startActivity(intent);


                } else {
                    erro = true;

                }
            }
        }else{
            erro = true;
        }
        if (erro)
            Toast.makeText(getApplicationContext(), "Credenciais incorretas.", Toast.LENGTH_LONG).show();


    }





    public void proximaTela(View view){

        Intent intent = new Intent(this,home.class);
        startActivity(intent);
    }

    public void Tela2(View view) {

        Intent intent = new Intent(this, Cadastro.class);
        startActivity(intent);
    }


}
