package com.rzaninelli.chamadaactivity02;

import static com.rzaninelli.chamadaactivity02.MostrarDadosActivity.*;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNome;
    private CheckBox checkBoxPossuiCarro;
    private RadioGroup radioGroupTipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNome = findViewById(R.id.editTextTextNome);
        checkBoxPossuiCarro = findViewById(R.id.checkBoxPossuiCarro);
        radioGroupTipo = findViewById(R.id.radioGroupTipo);
    }

    public void enviar(View view) {
        Intent intent = new Intent(this, MostrarDadosActivity.class);

        String nome = editTextNome.getText().toString();
        if (nome.isEmpty()) {
            intent.putExtra(NOME, nome);
        }

        intent.putExtra(POSSUI_CARRO, checkBoxPossuiCarro.isChecked());

        int id = radioGroupTipo.getCheckedRadioButtonId();
        if (id != -1) {
            intent.putExtra(TIPO, id);
        }

        startActivity(intent);

    }
}