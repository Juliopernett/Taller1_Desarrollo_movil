package com.example.taller1_desarrollo_movil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import static com.example.taller1_desarrollo_movil.R.mipmap.ic_launcher;
import static com.example.taller1_desarrollo_movil.R.mipmap.ic_launcher_round;

public class MainActivity extends AppCompatActivity {

    static double pre_dolar=3200;

    String cmb1[], cmb2[], cmb3[], cmb4[];
    Spinner cmbMat1,cmbDij2, cmbPre3, cmbMod4;
    EditText txtCant;
    TextView resultado;
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
        resultado = findViewById(R.id.txtResultado);

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

    /*public  void validacion*/

    public  void comprar(View v){

        double total = 0;
        double valunitario = 0;
        /*Grupo 1*/
        if((cmbMat1.getSelectedItemPosition() == 1)
                && (cmbDij2.getSelectedItemPosition() == 1)
                &&  (cmbPre3.getSelectedItemPosition() == 1)){
            valunitario = 100;
        }else
            if ((cmbMat1.getSelectedItemPosition()==1)
                && (cmbDij2.getSelectedItemPosition()==1)
                &&  (cmbPre3.getSelectedItemPosition()==2)) {
                valunitario =80;
        }else
            if ((cmbMat1.getSelectedItemPosition() == 1)
                && (cmbDij2.getSelectedItemPosition() == 1)
                &&  (cmbPre3.getSelectedItemPosition() == 3)) {
                valunitario = 70;
        }
        else /*Grupo 2*/
        if ((cmbMat1.getSelectedItemPosition() == 1)
                && (cmbDij2.getSelectedItemPosition() == 2)
                &&  (cmbPre3.getSelectedItemPosition() == 1)) {
                valunitario = 120;
        }else
        if ((cmbMat1.getSelectedItemPosition() == 1)
                && (cmbDij2.getSelectedItemPosition() == 2)
                &&  (cmbPre3.getSelectedItemPosition() == 2)) {
                valunitario = 100;
        }else
        if ((cmbMat1.getSelectedItemPosition() == 1)
                && (cmbDij2.getSelectedItemPosition() == 2)
                &&  (cmbPre3.getSelectedItemPosition() == 3)) {
                valunitario = 90;
        }
        else /*Grupo 3*/
        if ((cmbMat1.getSelectedItemPosition() == 2)
                && (cmbDij2.getSelectedItemPosition() == 1)
                &&  (cmbPre3.getSelectedItemPosition() == 1)) {
                valunitario = 90;
        }else
        if ((cmbMat1.getSelectedItemPosition() == 2)
                && (cmbDij2.getSelectedItemPosition() == 1)
                &&  (cmbPre3.getSelectedItemPosition() == 2)) {
                valunitario = 70;
        }else
        if ((cmbMat1.getSelectedItemPosition() == 2)
                && (cmbDij2.getSelectedItemPosition() == 1)
                &&  (cmbPre3.getSelectedItemPosition() == 3)) {
                valunitario = 50;
        }
        else /*Grupo 4*/
        if ((cmbMat1.getSelectedItemPosition() == 2)
                && (cmbDij2.getSelectedItemPosition() == 2)
                &&  (cmbPre3.getSelectedItemPosition() == 1)) {
            valunitario = 110;
        }else
        if ((cmbMat1.getSelectedItemPosition() == 2)
                && (cmbDij2.getSelectedItemPosition() == 2)
                &&  (cmbPre3.getSelectedItemPosition() == 2)) {
            valunitario = 90;
        }else
        if ((cmbMat1.getSelectedItemPosition() == 2)
                && (cmbDij2.getSelectedItemPosition() == 2)
                &&  (cmbPre3.getSelectedItemPosition() == 3)) {
            valunitario = 80;
        }

        cant = Integer.parseInt(txtCant.getText().toString());
        switch (cmbMod4.getSelectedItemPosition()){
            case 1:
                total = (pre_dolar * valunitario) * cant;
                resultado.setText(getResources().getString(R.string.msj1)+ " " + cant + " "
                        + getResources().getString(R.string.msj2) + " "  + total + " " + getResources().getString(R.string.cop));
                break;
            case 2:
                total = valunitario * cant;
                resultado.setText(getResources().getString(R.string.msj1)+ " " + cant + " "
                        + getResources().getString(R.string.msj2) + " "  + total + " " + getResources().getString(R.string.usd));
                break;
        }



    }

    public void limpiar(View v) {
        txtCant.setText("");
        cmbMat1.setSelection(0);
        cmbDij2.setSelection(0);
        cmbPre3.setSelection(0);
        cmbMod4.setSelection(0);
        resultado.setText("");
        cmbMat1.requestFocus();
    }


}
