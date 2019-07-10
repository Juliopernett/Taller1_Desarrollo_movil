package com.example.taller1_desarrollo_movil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import static com.example.taller1_desarrollo_movil.R.mipmap.ic_launcher;
import static com.example.taller1_desarrollo_movil.R.mipmap.ic_launcher_round;

public class MainActivity extends AppCompatActivity {

    String cmb1[], cmb2[], cmb3[], cmb4[];
    Spinner cmbMat1,cmbDij2, cmbPre3, cmbMod4;
    EditText txtCant;
    int cant=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //captura de los objetos utilizados
        cmbMat1 = findViewById(R.id.cmbUno);
        cmbDij2 = findViewById(R.id.cmbDos);
        cmbPre3 = findViewById(R.id.cmbTres);
        cmbMod4 = findViewById(R.id.cmbCuatro);
        txtCant = findViewById(R.id.txtCantidad);

        //traemos las opciones del array
        cmb1 = getResources().getStringArray(R.array.StringCmbUno);
        cmb2 = getResources().getStringArray(R.array.StringCmbDos);
        cmb3 = getResources().getStringArray(R.array.StringCmbTres);
        cmb4 = getResources().getStringArray(R.array.StringCmbCuatro);

        //creamos el adapter indicando donde se va a mostrar
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cmb1);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cmb2);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cmb3);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cmb4);

        //pasamos el adapter al combo
        cmbMat1.setAdapter(adapter);
        cmbDij2.setAdapter(adapter1);
        cmbPre3.setAdapter(adapter2);
        cmbMod4.setAdapter(adapter3);
    }

    public void limpiar(View v) {
        txtCant.setText("");
    }

}
