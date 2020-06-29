package br.com.unipar.auxilioemergencial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class ResultadoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        segundaAtividade();
    }

    public void segundaAtividade(){

        Bundle b = getIntent().getExtras();
       // String dataPagamento = b.getString("dataPagamento");


        TextView textElementprimeiraParcela = (TextView) findViewById(R.id.primeiraParcela);
        textElementprimeiraParcela.setText("Primeira Parcela  : \n"+"R$:"+ saldoReceber.toString());

        TextView textElementsegundaParcela = (TextView) findViewById(R.id.segundaParcela);
        textElementsegundaParcela.setText("Segunda Parcela  : \n"+"R$:"+ saldoReceber.toString());

        TextView textElementterceiraParcela = (TextView) findViewById(R.id.terceiraParcela);
        textElementterceiraParcela.setText("Terceira Parcela  : \n"+"R$:"+ saldoReceber.toString());

    }
    public void voltar(View view){
        Intent intent = new Intent(this, MainActivity.class);
        Bundle b = new Bundle();
        intent.putExtras(b);
        startActivity(intent);
        finish();
    }

}
