package com.nishadjamaldeen.higherorlower;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.lang.*;

public class MainActivity extends AppCompatActivity {

    public Random rand = new Random();
    public int actualNumber;
    public Queue<String> pastResults = new LinkedList<>();
    public int guesses = 0;
    public int wins = 0;

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
        TextView guess = (TextView) findViewById(R.id.guesses);
        TextView win = (TextView) findViewById(R.id.wins);
        StringBuilder outputStringBuilder = new StringBuilder();

        jumbo.setImageResource(R.drawable.questions);
        int guessNum = Integer.parseInt(inputText.getText().toString());
        guesses++;

        if(hintText.getText().toString().equals("Correct!"))
            hintText.setText("I'm thinking of a number between 1 and 1000. See if you can guess what it is!");

        if (guessNum > actualNumber) {
            
            if(pastResults.size() == 3) {
                pastResults.remove();
                pastResults.add(Integer.toString(guessNum) + " - Lower!\n");
            }else
                pastResults.add(Integer.toString(guessNum) + " - Lower!\n");
            inputText.getText().clear();

        } else if ( guessNum < actualNumber){

            if(pastResults.size() == 3){
                pastResults.remove();
                pastResults.add(Integer.toString(guessNum) + " - Higher!\n");
            }else
                pastResults.add(Integer.toString(guessNum) + " - Higher!\n");
            inputText.getText().clear();

        } else if ( guessNum == actualNumber) {
            hintText.setText(Integer.toString(guessNum) + " - Correct!");
            jumbo.setImageResource(R.drawable.correct);
            inputText.getText().clear();
            Toast.makeText(this, "I have a new number in mind", Toast.LENGTH_LONG).show();
            actualNumber = rand.nextInt(1000) + 1;
            guesses = 0;
            wins++;

        } else
            Toast.makeText(this, "Please enter up to 3 numbers", Toast.LENGTH_SHORT).show();

        Object[] pastResultsArray = pastResults.toArray();

        for (int i = 0; i < pastResults.size(); i++)
            outputStringBuilder.append(pastResultsArray[i].toString());

        String outputString = outputStringBuilder.toString();

        hintText.setText(outputString);
        hintText.setWidth(200);
        guess.setText("Guesses: " + guesses);
        win.setText("Wins: " + wins);

    }
}