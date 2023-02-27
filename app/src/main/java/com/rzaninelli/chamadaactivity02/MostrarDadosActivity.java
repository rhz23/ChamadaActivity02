package com.rzaninelli.chamadaactivity02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MostrarDadosActivity extends AppCompatActivity {

    public static final String NOME = "NOME";
    public static final String POSSUI_CARRO = "POSSUI_CARRO";
    public static final String TIPO = "TIPO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_dados);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            String nome = bundle.getString(NOME, getString(R.string.nao_cadastrado));
            boolean possuiCarro = bundle.getBoolean(POSSUI_CARRO);
            int id = bundle.getInt(TIPO, -1);

            String saida = getString(R.string.nome) + ": " + nome + "\n";
            saida += getString(R.string.possui_carro) + "? ";
            saida += (possuiCarro ? getString(R.string.sim) : getString(R.string.nao)) + "\n";

            switch (id) {
                case R.id.radioButtonAluno:
                    saida += getString(R.string.aluno);
                    break;

                case R.id.radioButtonProfessor:
                    saida += getString(R.string.professor);
                    break;

                default:
                    saida += getString(R.string.nenhum_tipo_escolhido);
            }

            TextView textViewDados = findViewById(R.id.textViewDados);

            textViewDados.setText(saida);
        }

        setTitle(getString(R.string.dados_cadastrados));
    }
}