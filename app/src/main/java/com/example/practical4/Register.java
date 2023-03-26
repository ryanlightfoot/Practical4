package com.example.practical4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button btnB = (Button) findViewById(R.id.btnBackReg);
        Button btnReg = (Button) findViewById(R.id.btnReg1);

        String strMod1 = getString(R.string.mod1);
        String strMod2 = getString(R.string.mod2);
        String strMod3 = getString(R.string.mod3);
        String strMod4 = getString(R.string.mod4);
        String strMod5 = getString(R.string.mod5);

        CheckBox rbnM1 = (CheckBox) findViewById(R.id.rbnMod1);
        CheckBox rbnM2 = (CheckBox) findViewById(R.id.rbnMod2);
        CheckBox rbnM3 = (CheckBox) findViewById(R.id.rbnMod3);
        CheckBox rbnM4 = (CheckBox) findViewById(R.id.rbnMod4);
        CheckBox rbnM5 = (CheckBox) findViewById(R.id.rbnMod5);





        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strModules = "You are registered for:";
                if(rbnM1.isChecked()){
                    strModules += " IMOB301";
                }
                if(rbnM2.isChecked()){
                    strModules += " IENT301";
                }
                if(rbnM3.isChecked()){
                    strModules += " IRUD301";
                }
                if(rbnM4.isChecked()){
                    strModules += " IAPP301";
                }
                if(rbnM5.isChecked()){
                    strModules += " IMPS301";
                }

                Toast tModules = Toast.makeText(getApplicationContext(),strModules, Toast.LENGTH_SHORT);
                tModules.show();
            }
        });

        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Register.this, MainActivity.class));
            }
        });
    }
}