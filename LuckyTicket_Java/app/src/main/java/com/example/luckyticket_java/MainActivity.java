package com.example.luckyticket_java;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final int MAX_NUMBER_OF_DIGITS = 6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.btnCheckNumber);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        EditText editText = findViewById(R.id.etTicketNumber);
        ImageView bulb = findViewById(R.id.lightbulb);
        Drawable green_bulb = getDrawable(getResources().getIdentifier("@drawable/ic_green_bulb",null,getPackageName()));
        Drawable red_bulb = getDrawable(getResources().getIdentifier("@drawable/ic_red_bulb",null,getPackageName()));
        String number = editText.getText().toString();

        if (number.length() == MAX_NUMBER_OF_DIGITS){
            if(number.charAt(0) + number.charAt(1) + number.charAt(2)
                    == number.charAt(3) + number.charAt(4) + number.charAt(5)){
                bulb.setImageDrawable(green_bulb);
                Toast.makeText(getApplicationContext(), R.string.lucky_ticket, Toast.LENGTH_SHORT).show();
            } else{
              bulb.setImageDrawable(red_bulb);
              Toast.makeText(getApplicationContext(), R.string.unlucky_ticket, Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(getApplicationContext(), R.string.incorrect_input, Toast.LENGTH_SHORT).show();
        }
    }
}