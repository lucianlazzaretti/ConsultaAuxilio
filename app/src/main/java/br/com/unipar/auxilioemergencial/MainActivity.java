package br.com.unipar.auxilioemergencial;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class MainActivity extends AppCompatActivity {

    private EditText edCpf,edDataNascimento;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edCpf = findViewById(R.id.edCpf);
        edDataNascimento = findViewById(R.id.edDataNascimento);


        //criar mascara para os campos
        edCpf.addTextChangedListener(new MaskTextWatcher(edCpf, new SimpleMaskFormatter("NNN.NNN.NNN-NN")));
        edDataNascimento.addTextChangedListener(new MaskTextWatcher(edDataNascimento, new SimpleMaskFormatter("NN/NN/NNNN")));

    }

    public void calcularAuxilio(View view) {

        validar(view);
        //dataPagamento();



    }

    /*public int calcularIdade(String dataNascimento){

        Calendar dataUsuario = new GregorianCalendar();
        dataUsuario.setTime(dataNascimento);

        Calendar today = Calendar.getInstance();

        int idade = today.get(Calendar.YEAR) - dataUsuario.get(Calendar.YEAR);
        dataUsuario.add(Calendar.YEAR, idade);

        return idade;
    }*/



    public void validar(View view) {


        //String cpf = String.valueOf(edCpf.getText().toString());
        //Double rendaMensal = Double.parseDouble(edRendaMensal.toString());

        //converter de DATE para String
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strDataNascimento = dateFormat.format(date);


        /*DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date dataInformada = null;
        Date dataAtual = new Date();

        try {
            dataInformada = format.parse(String.valueOf(dataNascimento));
        } catch (ParseException e) {
            e.printStackTrace();
        }*/

        if (edCpf.getText().toString().equals("")) {
            alerta("Campo Cpf está vazio!");
        }

        else if (strDataNascimento.equals("")) {
            alerta("Campo Data de Nascimento está vazio");
        }

        /*else if (calcularIdade(strDataNascimento) < 18 ) {
            alerta("Menores de 18 anos não tem \\n direito ao benefício.");

        }*/
        else{
                segundaTela(view);
            }


    }


    /*public Date dataPagamento() {


        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date dataPagamento = null;
        try {
            dataPagamento = format.parse(String.valueOf(dataNascimento));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dataPagamento;*/


        /*Date date = new Date(); //the date instance
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.get(Calendar.YEAR);
        calendar.get(Calendar.MONTH);
        calendar.get(Calendar.DAY_OF_MONTH);
    }*/



        /*DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);

        Calendar gc = Calendar.getInstance();

        System.out.println(df.format(gc.getTime())); // 14/03/2016

        // Adiciona 10 dias:
        gc.add((GregorianCalendar.DAY_OF_MONTH), 20);*/



        /*opção1
        Calendar c = Calendar.getInstance();
        Calendar.SUNDAY == c.getFirstDayOfWeek());
        c.add(Calendar.DAY_OF_WEEK_IN_MONTH = 20)
        Date date2 = c.getTime();*/

        /*opção2
        String s = "26/03/2019";
        DateTimeFormatter parser = DateTimeFormat.forPattern("dd/MM/yyyy");
        LocalDate date = parser.parseLocalDate(s);
        date = date.plusDays(1);*/

       /*opção3
        String dt = "2008-01-01";  // A sua data
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(dt));
        c.add(Calendar.DATE, 1);  // número de dias a adicionar
        dt = sdf.format(c.getTime());  // dt é a sua nova data com mais um dia*/



         /*String s = "26/03/2019";
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/AAAA", Locale.ENGLISH);
        LocalDate dataNascimento = LocalDate.parse(s, parser);
        LocalDate dataPagamento = dataNascimento.plusDays(20);*/




    public void segundaTela (View view){
        Intent intent = new Intent(this, ResultadoActivity.class);
        Bundle b = new Bundle();
        //b.putString("dataPagamento", dataPagamento().toString());


        intent.putExtras(b);
        startActivity(intent);
        finish();
    }

    //exibir alertas de erros
    public void alerta( String msg ){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

}
