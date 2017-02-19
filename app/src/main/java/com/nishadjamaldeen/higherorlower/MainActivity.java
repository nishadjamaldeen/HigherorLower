package com.nishadjamaldeen.higherorlower;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.lang.*;

public class MainActivity extends AppCompatActivity {

    public Random rand = new Random();
    public int actualNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actualNumber = rand.nextInt(1000) + 1;
    }

    public void guess(View view){
        EditText inputText = (EditText) findViewById(R.id.editText);
        ImageView jumbo = (ImageView) findViewById(R.id.imageView2);
        TextView hintText = (TextView) findViewById(R.id.textView);
        /*String[] numberList  = new String[3];
        StringBuilder outputStringBuilder = new StringBuilder();*/


        jumbo.setImageResource(R.drawable.questions);



        int guessNum = Integer.parseInt(inputText.getText().toString());


        if(hintText.getText().toString().equals("Correct!"))
            hintText.setText("I'm thinking of a number between 1 and 1000. See if you can guess what it is!");


        if (guessNum > actualNumber) {
            hintText.setText(Integer.toString(guessNum) + " - Lower!");
            inputText.getText().clear();

        } else if ( guessNum < actualNumber){
            hintText.setText(Integer.toString(guessNum) + " - Higher!");
            inputText.getText().clear();

        } else if ( guessNum == actualNumber) {
            hintText.setText(Integer.toString(guessNum) + " - Correct!");
            jumbo.setImageResource(R.drawable.correct);
            inputText.getText().clear();
            Toast.makeText(this, "I have a new number in mind", Toast.LENGTH_LONG).show();
            actualNumber = rand.nextInt(1000) + 1;

        }/*else if(numberList.length > 0 && numberList.length <=3){
            for(int i = 0; i < numberList.length; i++){

                if (Integer.parseInt(numberList[i]) > actualNumber)
                    outputStringBuilder.append(numberList[i] + " - Lower!\n");
                else if (Integer.parseInt(numberList[i]) < actualNumber)
                    outputStringBuilder.append(numberList[i] + " - Higher!\n");
                else if (Integer.parseInt(numberList[i]) == actualNumber)
                    outputStringBuilder.append(numberList[i] + " - Correct!\n");
            }

            outputString = outputStringBuilder.toString();
            hintText.setText(outputString);

        } */
        else {
            Toast.makeText(this, "Please enter up to 3 numbers", Toast.LENGTH_SHORT).show();
        }

    }
}
