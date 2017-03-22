package com.example.soporte.holamundo;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Saludo extends AppCompatActivity {

    private TextView saludo;
    private Bundle b;
    private String aux, nomb, apell;
    private Resources res;
    private String genero, estado_civil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludo);

        saludo = (TextView)findViewById(R.id.txtSaludo);

        b = getIntent().getExtras();
        nomb = b.getString("Nombre");
        apell = b.getString("Apellido");

        genero = b.getString("Genero");
        estado_civil = b.getString("Estado_civil");
        res = this.getResources();

        aux = res.getString(R.string.parte_saludo)+ " "+ nomb + " " + apell + " " + res.getString(R.string.parte_saludo2)+ "\n";
        aux = aux + "\n\n" + getResources().getString(R.string.datos);
        aux = aux + "\n\n"+ getResources().getString(R.string.nombre) + ":" + nomb;
        aux = aux + "\n\n"+ getResources().getString(R.string.apellido) + ":" + apell;
        aux = aux + "\n\n"+ getResources().getString(R.string.genero) + ":" + genero;
        aux = aux + "\n\n"+ getResources().getString(R.string.estadoCivil) + ":" + estado_civil;


        saludo.setText(aux);

    }
}
