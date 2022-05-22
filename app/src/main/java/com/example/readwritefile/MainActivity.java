package com.example.readwritefile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private TextView tvreadFile;
    private EditText etwritedFile;
    private Button btnSave;
    private  Button btnReadFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvreadFile = findViewById(R.id.tv_readFile);
        etwritedFile = findViewById(R.id.et_writed);
        btnSave=findViewById(R.id.btn_guardar);
        btnReadFile=findViewById(R.id.btn_leer);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    OutputStreamWriter createFileOrwritedOver = new OutputStreamWriter(
                            openFileOutput("archivo_creado.txt", Context.MODE_PRIVATE));

                    createFileOrwritedOver.write(etwritedFile.getText().toString());
                    createFileOrwritedOver.close();

                }catch (Exception error){
                    Log.e("Archivos","Error al escribir archivo en memoria");
                }

            }
        });


        btnReadFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    BufferedReader read = new BufferedReader( new InputStreamReader(openFileInput("archivo_creado.txt")));

                    String text = read.readLine();
                    tvreadFile.setText(text);
                }catch (Exception error){
                    Log.e("Archivos","Error al leer archivo en memoria");

                }
            }
        });


    }



}