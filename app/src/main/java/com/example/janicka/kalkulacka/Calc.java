package com.example.janicka.kalkulacka;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Calc extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        myTextView = (TextView)  findViewById(R.id.textView);
    }

    /*@Override
    protected void onPause(Bundle savedInstanceState){
       super.onPause();
    }*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calc, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public TextView myTextView;
    public float Ans = 0, x1 =0, x2=0;
    public boolean sum, sub, mul, div = false;
    public String total = "";

    public void onClick(View v) {
        Button button = (Button) v;
        String bText = (String) button.getText();
        //int value = Integer.parseInt(bText);
        total += bText;
        //if (bText == ".") total="0.";
        Ans=Float.parseFloat(total);
        myTextView.setText(total);

         }

    public void onButtonCl(View v) {
        myTextView.setText("");
        total="";
    }

    public void onButtonAns(View v) {
        myTextView.setText("");
        myTextView.setText(String.valueOf(Ans));
        total="";
    }

    public void onButtonSum(View v) {
        x1=Ans;
        Ans=0;
        sum=true;
        total="";
        myTextView.setText("+");

    }

    public void onButtonSub(View v) {
        x1=Ans;
        Ans=0;
        sub=true;
        total="";
        myTextView.setText("-");

    }

    public void onButtonMul(View v) {
        x1=Ans;
        Ans=0;
        mul=true;
        total="";
        myTextView.setText("*");

    }

    public void onButtonDiv(View v) {
        x1=Ans;
        Ans=0;
        div=true;
        total="";
        myTextView.setText("/");

    }

    public void onButtonEaq(View v) {
        if (sum){
            x2=Ans;
            Ans=x1+x2;
            sum=false;
        }else if (sub){
            x2=Ans;
            Ans=x1-x2;
            sub=false;
        }else if (mul){
            x2=Ans;
            Ans=x1*x2;
            mul=false;
        }else if (div){
            x2=Ans;
            Ans=x1/x2;
            div=false;
        }

        //myTextView.setText("");
        myTextView.setText(String.valueOf(Ans));
        x1=0; x2=0;
        total="";
    }
}
