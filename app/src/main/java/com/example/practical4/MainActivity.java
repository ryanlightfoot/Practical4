package com.example.practical4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnReg = (Button) findViewById(R.id.btnRegister);
        Button btnPay = (Button) findViewById(R.id.btnpay);

        RadioButton rgbY = (RadioButton) findViewById(R.id.rgpYes);
        RadioButton rgbN = (RadioButton) findViewById(R.id.rgpNo);

        TextView txvStNo = (TextView) findViewById(R.id.txbStudentNo);
        String numb = getString(R.string.num);
        final double amtOwe = 25000.00; // How much needs to be paid

        //Error messages
        Toast tReg = Toast.makeText(getApplicationContext(),"Please pay registration", Toast.LENGTH_SHORT);
        Toast tStNo = Toast.makeText(getApplicationContext(),"Please Enter Student Number", Toast.LENGTH_SHORT);
        Toast tStLied = Toast.makeText(getApplicationContext(),"You lied... Please pay.", Toast.LENGTH_SHORT);


        double amtPaid = (double) Double.parseDouble(numb); //Get the amount the student has paid



        rgbY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double regOwe = amtOwe * 0.3; // How much needs to be paid to register

                if(amtPaid<regOwe) // Check if Registration amount has been paid
                {
                    rgbN.setChecked(true);
                    tStLied.show();
                }
            }
        });

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!rgbY.isChecked()){
                    tReg.show(); //Check if paid registration
                }
                else if (txvStNo.getText().toString().equals("")) {
                    tStNo.show(); //Check if entered student number
                }
                else {
                    startActivity(new Intent(MainActivity.this, Register.class)); //Goes to new instance
                }
            }
        });

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PayScreen.class)); //Goes to new instance
            }
        });
    }
}