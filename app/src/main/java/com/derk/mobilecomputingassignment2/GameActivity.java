package com.derk.mobilecomputingassignment2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    Random rand = new Random();
    int cardOne = rand.nextInt(9+1);
    int cardTwo = rand.nextInt(9+1);
    int cardThree = rand.nextInt(9+1);
    int cardFour = rand.nextInt(9+1);
    int cardFive = rand.nextInt(9+1);
    int cardSix = rand.nextInt(9+1);
    int cardSeven = rand.nextInt(9+1);
    int cardEight = rand.nextInt(9+1);
    int cardNine = rand.nextInt(9+1);
    int cardTen = rand.nextInt(9+1);
    int cardEleven = rand.nextInt(9+1);
    int cardTwelve = rand.nextInt(9+1);

    public static int timeCounter = 0;
    private boolean running = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        if(savedInstanceState != null){
            timeCounter = savedInstanceState.getInt("timeCounter");
            running = savedInstanceState.getBoolean("running");
        }
        runTimer();

        AssetManager manager = getAssets();
        String[] number = new String[0];
        try {
            number = manager.list("cards");
        } catch (IOException e) {
            e.printStackTrace();
        }


        try{
            ImageView imageview = findViewById(R.id.imageButton);
            assert number != null;
            InputStream stream = manager.open("cards/" + number[cardOne]);
            Bitmap bitmap = BitmapFactory.decodeStream(stream);
            imageview.setImageBitmap(bitmap);

            ImageView imageview2 = findViewById(R.id.imageButton2);
            InputStream stream2 = manager.open("cards/" + number[cardTwo]);
            Bitmap bitmap2 = BitmapFactory.decodeStream(stream2);
            imageview2.setImageBitmap(bitmap2);

            ImageView imageview3 = findViewById(R.id.imageButton3);
            InputStream stream3 = manager.open("cards/" + number[cardThree]);
            Bitmap bitmap3 = BitmapFactory.decodeStream(stream3);
            imageview3.setImageBitmap(bitmap3);

            ImageView imageview4 = findViewById(R.id.imageButton4);
            InputStream stream4 = manager.open("cards/" + number[cardFour]);
            Bitmap bitmap4 = BitmapFactory.decodeStream(stream4);
            imageview4.setImageBitmap(bitmap4);

            ImageView imageview5 = findViewById(R.id.imageButton5);
            InputStream stream5 = manager.open("cards/" + number[cardFive]);
            Bitmap bitmap5 = BitmapFactory.decodeStream(stream5);
            imageview5.setImageBitmap(bitmap5);

            ImageView imageview6 = findViewById(R.id.imageButton6);
            InputStream stream6 = manager.open("cards/" + number[cardSix]);
            Bitmap bitmap6 = BitmapFactory.decodeStream(stream6);
            imageview6.setImageBitmap(bitmap6);

            ImageView imageview7 = findViewById(R.id.imageButton7);
            InputStream stream7 = manager.open("cards/" + number[cardSeven]);
            Bitmap bitmap7 = BitmapFactory.decodeStream(stream7);
            imageview7.setImageBitmap(bitmap7);

            ImageView imageview8 = findViewById(R.id.imageButton8);
            InputStream stream8 = manager.open("cards/" + number[cardEight]);
            Bitmap bitmap8 = BitmapFactory.decodeStream(stream8);
            imageview8.setImageBitmap(bitmap8);

            ImageView imageview9 = findViewById(R.id.imageButton9);
            InputStream stream9 = manager.open("cards/" + number[cardNine]);
            Bitmap bitmap9 = BitmapFactory.decodeStream(stream9);
            imageview9.setImageBitmap(bitmap9);

            ImageView imageview10 = findViewById(R.id.imageButton10);
            InputStream stream10 = manager.open("cards/" + number[cardTen]);
            Bitmap bitmap10 = BitmapFactory.decodeStream(stream10);
            imageview10.setImageBitmap(bitmap10);

            ImageView imageview11 = findViewById(R.id.imageButton11);
            InputStream stream11 = manager.open("cards/" + number[cardEleven]);
            Bitmap bitmap11 = BitmapFactory.decodeStream(stream11);
            imageview11.setImageBitmap(bitmap11);

            ImageView imageview12 = findViewById(R.id.imageButton12);
            InputStream stream12 = manager.open("cards/" + number[cardTwelve]);
            Bitmap bitmap12 = BitmapFactory.decodeStream(stream12);
            imageview12.setImageBitmap(bitmap12);
        } catch (IOException e) {
            System.out.println("failed to get cards");
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("timeCounter", timeCounter);
        savedInstanceState.putBoolean("running", running);
    }

    private void runTimer(){
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                final TextView timeView = findViewById(R.id.time_view);
                int hours = timeCounter /3600;
                int minutes = (timeCounter %3600)/60;
                int secs = timeCounter %60;

                if(running){
                    timeCounter++;
                }
                String time = String.format(Locale.getDefault(),"%d:%02d:%02d", hours, minutes, secs);
                timeView.setText(time);
                handler.postDelayed(this, 1000);
            }
        });
    }

    public void buttonClicked_settings(View view){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    @SuppressLint("SetTextI18n")
    public void buttonClicked_numberChecker(View view){
        TextView textView = findViewById(R.id.first_number_id);
        String first_number = textView.getText().toString();

        TextView textView2 = findViewById(R.id.second_number_id);
        String second_number = textView2.getText().toString();

        if(first_number.equals("")){
            textView.setText(Integer.toString(cardOne + 1));
        } else if(second_number.equals("")){
            textView2.setText(Integer.toString(cardOne + 1));
        } else {System.out.println("Finish the sum first");}
    }

    @SuppressLint("SetTextI18n")
    public void buttonClicked_numberChecker2(View view){
        TextView textView = findViewById(R.id.first_number_id);
        String first_number = textView.getText().toString();

        TextView textView2 = findViewById(R.id.second_number_id);
        String second_number = textView2.getText().toString();

        if(first_number.equals("")){
            textView.setText(Integer.toString(cardTwo + 1));
        } else if(second_number.equals("")){
            textView2.setText(Integer.toString(cardTwo + 1));
        } else {System.out.println("Finish the sum first");}
    }

    @SuppressLint("SetTextI18n")
    public void buttonClicked_numberChecker3(View view){
        TextView textView = findViewById(R.id.first_number_id);
        String first_number = textView.getText().toString();

        TextView textView2 = findViewById(R.id.second_number_id);
        String second_number = textView2.getText().toString();

        if(first_number.equals("")){
            textView.setText(Integer.toString(cardThree + 1));
        } else if(second_number.equals("")){
            textView2.setText(Integer.toString(cardThree + 1));
        } else {System.out.println("Finish the sum first");}
    }

    @SuppressLint("SetTextI18n")
    public void buttonClicked_numberChecker4(View view){
        TextView textView = findViewById(R.id.first_number_id);
        String first_number = textView.getText().toString();

        TextView textView2 = findViewById(R.id.second_number_id);
        String second_number = textView2.getText().toString();

        if(first_number.equals("")){
            textView.setText(Integer.toString(cardFour + 1));
        } else if(second_number.equals("")){
            textView2.setText(Integer.toString(cardFour + 1));
        } else {System.out.println("Finish the sum first");}
    }

    @SuppressLint("SetTextI18n")
    public void buttonClicked_numberChecker5(View view){
        TextView textView = findViewById(R.id.first_number_id);
        String first_number = textView.getText().toString();

        TextView textView2 = findViewById(R.id.second_number_id);
        String second_number = textView2.getText().toString();

        if(first_number.equals("")){
            textView.setText(Integer.toString(cardFive + 1));
        } else if(second_number.equals("")){
            textView2.setText(Integer.toString(cardFive + 1));
        } else {System.out.println("Finish the sum first");}
    }

    @SuppressLint("SetTextI18n")
    public void buttonClicked_numberChecker6(View view){
        TextView textView = findViewById(R.id.first_number_id);
        String first_number = textView.getText().toString();

        TextView textView2 = findViewById(R.id.second_number_id);
        String second_number = textView2.getText().toString();

        if(first_number.equals("")){
            textView.setText(Integer.toString(cardSix + 1));
        } else if(second_number.equals("")){
            textView2.setText(Integer.toString(cardSix + 1));
        } else {System.out.println("Finish the sum first");}
    }

    @SuppressLint("SetTextI18n")
    public void buttonClicked_numberChecker7(View view){
        TextView textView = findViewById(R.id.first_number_id);
        String first_number = textView.getText().toString();

        TextView textView2 = findViewById(R.id.second_number_id);
        String second_number = textView2.getText().toString();

        if(first_number.equals("")){
            textView.setText(Integer.toString(cardSeven + 1));
        } else if(second_number.equals("")){
            textView2.setText(Integer.toString(cardSeven + 1));
        } else {System.out.println("Finish the sum first");}
    }

    @SuppressLint("SetTextI18n")
    public void buttonClicked_numberChecker8(View view){
        TextView textView = findViewById(R.id.first_number_id);
        String first_number = textView.getText().toString();

        TextView textView2 = findViewById(R.id.second_number_id);
        String second_number = textView2.getText().toString();

        if(first_number.equals("")){
            textView.setText(Integer.toString(cardEight + 1));
        } else if(second_number.equals("")){
            textView2.setText(Integer.toString(cardEight + 1));
        } else {System.out.println("Finish the sum first");}
    }

    @SuppressLint("SetTextI18n")
    public void buttonClicked_numberChecker9(View view){
        TextView textView = findViewById(R.id.first_number_id);
        String first_number = textView.getText().toString();

        TextView textView2 = findViewById(R.id.second_number_id);
        String second_number = textView2.getText().toString();

        if(first_number.equals("")){
            textView.setText(Integer.toString(cardNine + 1));
        } else if(second_number.equals("")){
            textView2.setText(Integer.toString(cardNine + 1));
        } else {System.out.println("Finish the sum first");}
    }

    @SuppressLint("SetTextI18n")
    public void buttonClicked_numberChecker10(View view){
        ImageView imageview = findViewById(R.id.imageButton10);
        TextView textView = findViewById(R.id.first_number_id);

        String first_number = textView.getText().toString();
        TextView textView2 = findViewById(R.id.second_number_id);

        String second_number = textView2.getText().toString();
        if(first_number.equals("")){
            textView.setText(Integer.toString(cardTen + 1));
        } else if(second_number.equals("")){
            textView2.setText(Integer.toString(cardTen + 1));
        } else {System.out.println("Finish the sum first");}
    }

    @SuppressLint("SetTextI18n")
    public void buttonClicked_numberChecker11(View view){
        TextView textView = findViewById(R.id.first_number_id);
        String first_number = textView.getText().toString();

        TextView textView2 = findViewById(R.id.second_number_id);
        String second_number = textView2.getText().toString();

        if(first_number.equals("")){
            textView.setText(Integer.toString(cardEleven + 1));
        } else if(second_number.equals("")){
            textView2.setText(Integer.toString(cardEleven + 1));
        } else {System.out.println("Finish the sum first");}
    }

    @SuppressLint("SetTextI18n")
    public void buttonClicked_numberChecker12(View view){
        TextView textView = findViewById(R.id.first_number_id);
        String first_number = textView.getText().toString();

        TextView textView2 = findViewById(R.id.second_number_id);
        String second_number = textView2.getText().toString();

        if(first_number.equals("")){
            textView.setText(Integer.toString(cardTwelve + 1));
        } else if(second_number.equals("")){
            textView2.setText(Integer.toString(cardTwelve + 1));
        } else {System.out.println("Finish the sum first");}
    }

    public void buttonClicked_guessCheck(View view){
        TextView textView = findViewById(R.id.first_number_id);
        String first_number = textView.getText().toString();
        int numero_uno = Integer.parseInt(first_number);

        TextView textView2 = findViewById(R.id.second_number_id);
        String second_number = textView2.getText().toString();
        int numero_duo = Integer.parseInt(second_number);

        EditText editText = findViewById(R.id.editText);
        String userGuess = editText.getText().toString();
        int usero_guessero = Integer.parseInt(userGuess);

        if((numero_uno + numero_duo) == usero_guessero){
            System.out.println("Correct");
            textView.setText("");
            textView2.setText("");
        } else {
            System.out.println("Not correct!");
        }
    }
}
