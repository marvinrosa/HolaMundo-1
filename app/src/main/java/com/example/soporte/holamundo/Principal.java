package com.example.soporte.holamundo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class Principal extends AppCompatActivity {

    private EditText cajaNombre;
    private TextView cajaApellido;
    private Intent i;
    private Bundle b;
    private Spinner comboGenero;
    private RadioButton r1,r2,r3;
    private String genero, estado_civil="";

    // Mostrar la info en el combo
   // private ArrayAdapter<Sring> adapter;

    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //Capturamos las cajas
        cajaNombre = (EditText)findViewById(R.id.txtNombre);
        cajaApellido = (EditText)findViewById(R.id.txtApellido);


        //Captuarar compbos
        comboGenero =  (Spinner)findViewById(R.id.cmbGenero);

        // Captura los radio
        r1 = (RadioButton)findViewById(R.id.r1);
        r2 = (RadioButton)findViewById(R.id.radioButton2);
        r3 = (RadioButton)findViewById(R.id.radioButton3);

        i =  new Intent(this,Saludo.class);
        b = new Bundle();

        //Array Adapter
        String[] opc = this.getResources().getStringArray(R.array.generos);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, opc);

        comboGenero.setAdapter(adapter);
    }


    public void Saludar(View v){
       String nomb, apell;

        // Se toma el valor de la persona q ingreso los datos
        nomb= cajaNombre.getText().toString();
        apell= cajaApellido.getText().toString();

        b.putString("Nombre",nomb);
        b.putString("Apellido",apell);


        if(validar())
        {
            //Tomo el valor que la persona ingresó tanto en nombre como en apellido
            nomb = cajaNombre.getText().toString();
            apell = cajaApellido.getText().toString();

            // captura genero

            genero = comboGenero.getSelectedItem().toString();


            // captura estado civil

            if(r1.isChecked()){
                estado_civil = getResources().getString(R.string.soltero);
            }
            if(r2.isChecked()){
                estado_civil = getResources().getString(R.string.casado);
            }
            if(r3.isChecked()){
                estado_civil = getResources().getString(R.string.divorciado);
            }


            //Encapsulo los valores previamente tomados
            b.putString("Nombre", nomb);
            b.putString("Apellido", apell);
            b.putString("Genero", genero);
            b.putString("Estado_civil", estado_civil);

            //Le paso al intent todos los datos en forma encapsulada con el bundle
            i.putExtras(b);
            //Arranco la actividad que le intent me diga
            startActivity(i);

        }

    }

    public boolean validar(){
        if(cajaNombre.getText().toString().isEmpty())
        {
            cajaNombre.setError(getResources().getString(R.string.error_1));
             // Toast.makeText(this,"Digite por favor el nombre",Toast.LENGTH_SHORT).show();
                return false;
        }
         if (cajaApellido.getText().toString().isEmpty())
         {
            cajaApellido.setError(getResources().getString(R.string.error_2));
             //Toast.makeText(this,"Digite por favor el Apellido",Toast.LENGTH_SHORT).show();
                return false;
         }
          return true;

    }

    public void Borrar(View v)
    {
        cajaNombre.setText("");
        cajaNombre.requestFocus();
        cajaApellido.setText("");
        comboGenero.setSelection(0);
        r1.setChecked(true);
    }
}















