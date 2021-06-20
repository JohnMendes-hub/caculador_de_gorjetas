package com.example.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editValor;
    private TextView textPorcentagem;
    private SeekBar seekBarProcentagem;
    private TextView textGorjeta;
    private TextView textTotal;

    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor = findViewById(R.id.editValor);
        textPorcentagem = findViewById(R.id.textPorcentagem);
        seekBarProcentagem = findViewById(R.id.seekBarPorcentagem);
        textGorjeta = findViewById(R.id.textGorjeta);
        textTotal = findViewById(R.id.textTotal);


        seekBarProcentagem.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                porcentagem = progress;
                textPorcentagem.setText( Math.round( porcentagem ) + "%" );
                calcular();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });

    }

    public void calcular(){

        String valorRecuperado = editValor.getText().toString();
        if( valorRecuperado == null || valorRecuperado.equals("") ){

            Toast.makeText(
                    getApplicationContext(),
            "Digite um valor primeiro!",
                    Toast.LENGTH_LONG
        ).show();

        }else {

            //Converter string para double
            double valorDigitado = Double.parseDouble( valorRecuperado );

            //calcular gorjeta total
            double gorjeta = valorDigitado * (porcentagem/100);
            double total = gorjeta + valorDigitado;

            //exibir gorjeta e total
            textGorjeta.setText("R$" + gorjeta );
            textTotal.setText("R$" + total);


        }


    }



}