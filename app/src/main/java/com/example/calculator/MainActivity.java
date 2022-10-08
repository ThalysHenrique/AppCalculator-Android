package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Atributos
    private Button numeroZero, numeroUm, numeroDois, numeroTres, numeroQuatro, numeroCinco, numeroSeis, numeroSete, numeroOito, numeroNove,
    ponto, soma, subtracao, multiplicacao, divisao, igual, limpar;

    private TextView txtExpressao, txtResultado;

    private ImageView backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Chamando método
        iniciarComponentes();
        getSupportActionBar().hide();

        // Setar botão que foi clicado
        numeroZero.setOnClickListener(this);
        numeroUm.setOnClickListener(this);
        numeroDois.setOnClickListener(this);
        numeroTres.setOnClickListener(this);
        numeroQuatro.setOnClickListener(this);
        numeroCinco.setOnClickListener(this);
        numeroSeis.setOnClickListener(this);
        numeroSete.setOnClickListener(this);
        numeroOito.setOnClickListener(this);
        numeroNove.setOnClickListener(this);
        ponto.setOnClickListener(this);
        soma.setOnClickListener(this);
        subtracao.setOnClickListener(this);
        multiplicacao.setOnClickListener(this);
        divisao.setOnClickListener(this);

        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                txtExpressao.setText(" ");
                txtResultado.setText(" ");
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView expressao = findViewById(R.id.text_expressao);
                String string = expressao.getText().toString();

                if(!string.isEmpty()){

                    byte var0 = 0;
                    int var1 = string.length()-1;
                    String txtExpressao = string.substring(var0, var1);
                    expressao.setText(txtExpressao);
                }
                txtResultado.setText(" ");
            }
        });

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            try {

                Expression expressao = new ExpressionBuilder(txtExpressao.getText().toString()).build();
                double resultado = expressao.evaluate();
                long longResult = (long) resultado;

                if (resultado == (double) longResult) {
                    txtResultado.setText((CharSequence) String.valueOf(longResult));
                } else {
                    txtResultado.setText((CharSequence) String.valueOf(resultado));
                }

            } catch (Exception e){
                System.out.println("Error");
            }

            }
        });
    }

    // Método para as funções da calculadora
    private void iniciarComponentes(){
        numeroZero = findViewById(R.id.bt_zero);
        numeroUm = findViewById(R.id.bt_um);
        numeroDois = findViewById(R.id.bt_dois);
        numeroTres = findViewById(R.id.bt_tres);
        numeroQuatro = findViewById(R.id.bt_quatro);
        numeroCinco = findViewById(R.id.bt_cinco);
        numeroSeis = findViewById(R.id.bt_seis);
        numeroSete = findViewById(R.id.bt_sete);
        numeroOito = findViewById(R.id.bt_oito);
        numeroNove = findViewById(R.id.bt_nove);
        ponto = findViewById(R.id.bt_ponto);
        soma = findViewById(R.id.bt_soma);
        subtracao= findViewById(R.id.bt_subtracao);
        multiplicacao = findViewById(R.id.bt_multiplicacao);
        divisao = findViewById(R.id.bt_divisao);
        igual = findViewById(R.id.bt_igual);
        limpar = findViewById(R.id.bt_limpar);
        txtExpressao = findViewById(R.id.text_expressao);
        txtResultado = findViewById(R.id.txt_resultado);
        backspace = findViewById(R.id.bt_backspace);
    }

    public void AcrescentarUmaExpressao(String string, boolean limpar_dados){
        if(txtResultado.getText().equals("")){
            txtExpressao.setText(" ");
        }

        if (limpar_dados){
            txtResultado.setText(" ");
            txtExpressao.append(string);
        } else {
            txtExpressao.append(txtResultado.getText());
            txtExpressao.append(string);
            txtResultado.setText(" ");
        }
    }

    @Override // Captura botão clicado
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_zero:
                AcrescentarUmaExpressao("0", true);
                break;

            case R.id.bt_um:
                AcrescentarUmaExpressao("1", true);
                break;

            case R.id.bt_dois:
                AcrescentarUmaExpressao("2", true);
                break;

            case R.id.bt_tres:
                AcrescentarUmaExpressao("3", true);
                break;

            case R.id.bt_quatro:
                AcrescentarUmaExpressao("4", true);
                break;

            case R.id.bt_cinco:
                AcrescentarUmaExpressao("5", true);
                break;

            case R.id.bt_seis:
                AcrescentarUmaExpressao("6", true);
                break;

            case R.id.bt_sete:
                AcrescentarUmaExpressao("7", true);
                break;

            case R.id.bt_oito:
                AcrescentarUmaExpressao("8", true);
                break;

            case R.id.bt_nove:
                AcrescentarUmaExpressao("9", true);
                break;

            case R.id.bt_ponto:
                AcrescentarUmaExpressao(".", true);
                break;

            case R.id.bt_soma:
                AcrescentarUmaExpressao("+", true);
                break;

            case R.id.bt_subtracao:
                AcrescentarUmaExpressao("-", true);
                break;

            case R.id.bt_multiplicacao:
                AcrescentarUmaExpressao("*", true);
                break;

            case R.id.bt_divisao:
                AcrescentarUmaExpressao("/", true);
                break;
        }
    }
}