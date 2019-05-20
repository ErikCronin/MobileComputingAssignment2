package com.derk.mobilecomputingassignment2;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Random rand = new Random();

        AssetManager manager = getAssets();
        try{
            String[] number = manager.list("cards");
            System.out.println(Arrays.toString(number));

            ImageView imageview = findViewById(R.id.imageView);
            assert number != null;
            InputStream stream = manager.open("cards/" + number[rand.nextInt(10+2)]);
            Bitmap bitmap = BitmapFactory.decodeStream(stream);
            imageview.setImageBitmap(bitmap);

            ImageView imageview2 = findViewById(R.id.imageView2);
            InputStream stream2 = manager.open("cards/" + number[rand.nextInt(10+2)]);
            Bitmap bitmap2 = BitmapFactory.decodeStream(stream2);
            imageview2.setImageBitmap(bitmap2);

            ImageView imageview3 = findViewById(R.id.imageView3);
            InputStream stream3 = manager.open("cards/" + number[rand.nextInt(10+2)]);
            Bitmap bitmap3 = BitmapFactory.decodeStream(stream3);
            imageview3.setImageBitmap(bitmap3);

            ImageView imageview4 = findViewById(R.id.imageView4);
            InputStream stream4 = manager.open("cards/" + number[rand.nextInt(10+2)]);
            Bitmap bitmap4 = BitmapFactory.decodeStream(stream4);
            imageview4.setImageBitmap(bitmap4);

            ImageView imageview5 = findViewById(R.id.imageView5);
            InputStream stream5 = manager.open("cards/" + number[rand.nextInt(10+2)]);
            Bitmap bitmap5 = BitmapFactory.decodeStream(stream5);
            imageview5.setImageBitmap(bitmap5);

            ImageView imageview6 = findViewById(R.id.imageView6);
            InputStream stream6 = manager.open("cards/" + number[rand.nextInt(10+2)]);
            Bitmap bitmap6 = BitmapFactory.decodeStream(stream6);
            imageview6.setImageBitmap(bitmap6);

            ImageView imageview7 = findViewById(R.id.imageView7);
            InputStream stream7 = manager.open("cards/" + number[rand.nextInt(10+2)]);
            Bitmap bitmap7 = BitmapFactory.decodeStream(stream7);
            imageview7.setImageBitmap(bitmap7);

            ImageView imageview8 = findViewById(R.id.imageView8);
            InputStream stream8 = manager.open("cards/" + number[rand.nextInt(10+2)]);
            Bitmap bitmap8 = BitmapFactory.decodeStream(stream8);
            imageview8.setImageBitmap(bitmap8);

            ImageView imageview9 = findViewById(R.id.imageView9);
            InputStream stream9 = manager.open("cards/" + number[rand.nextInt(10+2)]);
            Bitmap bitmap9 = BitmapFactory.decodeStream(stream9);
            imageview9.setImageBitmap(bitmap9);

            ImageView imageview10 = findViewById(R.id.imageView10);
            InputStream stream10 = manager.open("cards/" + number[rand.nextInt(10+2)]);
            Bitmap bitmap10 = BitmapFactory.decodeStream(stream10);
            imageview10.setImageBitmap(bitmap10);

            ImageView imageview11 = findViewById(R.id.imageView11);
            InputStream stream11 = manager.open("cards/" + number[rand.nextInt(10+2)]);
            Bitmap bitmap11 = BitmapFactory.decodeStream(stream11);
            imageview11.setImageBitmap(bitmap11);

            ImageView imageview12 = findViewById(R.id.imageView12);
            InputStream stream12 = manager.open("cards/" + number[rand.nextInt(10+2)]);
            Bitmap bitmap12 = BitmapFactory.decodeStream(stream12);
            imageview12.setImageBitmap(bitmap12);
        } catch (IOException e) {
            System.out.println("failed to get names");
        }
    }

    public void buttonClicked_settings(View view){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}
