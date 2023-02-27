package com.rzaninelli.chamadaactivity02;

import static com.rzaninelli.chamadaactivity02.MostrarDadosActivity.*;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNome;
    private CheckBox checkBoxPossuiCarro;
    private RadioGroup radioGroupTipo;

    public static final int PEDIR_NOTA = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNome = findViewById(R.id.editTextTextNome);
        checkBoxPossuiCarro = findViewById(R.id.checkBoxPossuiCarro);
        radioGroupTipo = findViewById(R.id.radioGroupTipo);
    }

    public void enviarPedindoNota(View view) {
        chamaTelaDois(true);
    }

    public void enviarSemPedirNota(View view) {
        chamaTelaDois(false);
    }

    public void chamaTelaDois(boolean pedirNota) {
        Intent intent = new Intent(this, MostrarDadosActivity.class);

        String nome = editTextNome.getText().toString();
        if (!nome.isEmpty()) {
            intent.putExtra(NOME, nome);
        }

        intent.putExtra(POSSUI_CARRO, checkBoxPossuiCarro.isChecked());

        int id = radioGroupTipo.getCheckedRadioButtonId();
        if (id != -1) {
            intent.putExtra(TIPO, id);
        }

        if (pedirNota) {
            intent.putExtra(MODO, PEDIR_NOTA);
            startActivityForResult(intent, PEDIR_NOTA);

        } else {
            startActivity(intent);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == PEDIR_NOTA && resultCode == Activity.RESULT_OK) {
            Bundle bundle = data.getExtras();

            if (bundle != null) {
                int nota = bundle.getInt(NOTA);
                Toast.makeText(this, getString(R.string.nota) + nota, Toast.LENGTH_LONG).show();
            }
        }
    }

}