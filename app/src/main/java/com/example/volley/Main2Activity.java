package com.example.volley;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
public class Main2Activity extends AppCompatActivity {
    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main2 );
        imageView = findViewById( R.id.image_view );
        textView = findViewById( R.id.text_view );
        Intent intent = getIntent();
        String  image_url = intent.getStringExtra( "s2" );
        String text_url = intent.getStringExtra( "s1" );
        
        textView.setText( text_url );
        Glide.with( this ).load( image_url ).fitCenter().into( imageView );
    }
}
