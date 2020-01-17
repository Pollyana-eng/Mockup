package com.example.mockup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Cadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        Button botao = (Button) findViewById(R.id.angry_btn);

        botao.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                EditText Nome = (EditText)findViewById(R.id.Nome);
                EditText Email = (EditText)findViewById(R.id.Email);
                EditText Senha = (EditText)findViewById(R.id.Senha);
                EditText RepitaSenha = (EditText)findViewById(R.id.RepitaSenha);

                String NomeString = Nome.getText().toString();
                String EmailString = Email.getText().toString();
                String SenhaString = Senha.getText().toString();
                String RepitaSenhaString = RepitaSenha.getText().toString();

                if(NomeString.isEmpty() || EmailString.isEmpty() || SenhaString.isEmpty() || RepitaSenhaString.isEmpty()) {


                    String resultado = "preencha todos os campos";

                    Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();

                }else{
                    if (SenhaString.equals(RepitaSenhaString)) {
                        String resultado = "cadastrou";


                        Toast toast = Toast.makeText(getApplicationContext(),
                        resultado, Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                        toast.show();

                    }else{
                        String resultado = "as senhas não conferem";

                        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
                    }

                }

            }
        });
    }

}


