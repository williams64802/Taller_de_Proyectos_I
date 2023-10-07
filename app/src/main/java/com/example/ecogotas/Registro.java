package com.example.ecogotas;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ecogotas.db.DbCont;
import com.example.ecogotas.db.DbEco;


public class Registro extends AppCompatActivity {
    private EditText nomb,apell,ema,etedad,cont;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nomb = (EditText) findViewById(R.id.edtNomUs);
        apell=  (EditText) findViewById(R.id.edtApellus);
        ema=(EditText) findViewById(R.id.edtEmaUs);
        etedad=(EditText) findViewById(R.id.edtEdadUs);
        cont=(EditText) findViewById(R.id.edtContUs);

    }

    public void UsRegi(View view){
        DbCont dbCont = new DbCont(Registro.this);
        long id = dbCont.inserteUsuario(nomb.getText().toString(),apell.getText().toString(),ema.getText().toString(),Integer.parseInt(etedad.getText().toString()),cont.getText().toString());

        if(id>0){
            Toast.makeText(this,"USUARIO REGISTRADO",Toast.LENGTH_SHORT).show();
            Intent i = new Intent(Registro.this,Datos.class);
            limpiar();
            startActivity(i);
        }else {
            Toast.makeText(this,"USUARIO NO REGISTRADO",Toast.LENGTH_SHORT).show();
        }

    }
    public void limpiar(){
        nomb.setText("");
        apell.setText("");
        ema.setText("");
        etedad.setText("");
        cont.setText("");
    }

    public void Cancelar(View view){
        Intent i = new Intent(Registro.this,Login.class);
        startActivity(i);
    }

}