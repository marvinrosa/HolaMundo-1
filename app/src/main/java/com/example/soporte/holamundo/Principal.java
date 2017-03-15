package com.example.soporte.holamundo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Principal extends AppCompatActivity {

    private EditText cajaNombre;
    private TextView cajaApellido;
    private Intent i;
    private Bundle b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //Capturamos las cajas
        cajaNombre = (EditText)findViewById(R.id.txtNombre);
        cajaApellido = (EditText)findViewById(R.id.txtApellido);
        i =  new Intent(this,Saludo.class);
        b = new Bundle();

    }


    public void Saludar(View v){
       String nomb, apell;

        // Se toma el valor de la persona q ingreso los datos
        nomb= cajaNombre.getText().toString();
        apell= cajaApellido.getText().toString();

        b.putString("Nombre",nomb);
        b.putString("Apellido",apell);


        i.putExtras(b);

        startActivity(i);

    }

    public boolean validar(){
        return  true;
    }
}















