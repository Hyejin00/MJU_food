package com.project.hyejin.mju_food;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button korea, japan, mi, game;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.mju);

        class Click implements View.OnClickListener {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btn_korea:
                        startActivity(new Intent(MainActivity.this, Korea.class));
                        break;
                    case R.id.btn_japan:
                        startActivity(new Intent(MainActivity.this, Japan.class));
                        break;
                    case R.id.btn_mi:
                        startActivity(new Intent(MainActivity.this, Western.class));
                        break;
                    case R.id.btn_game:
                        startActivity(new Intent(MainActivity.this, Game.class));
                        break;
                }
            }
        }

        korea = findViewById(R.id.btn_korea);
        korea.setOnClickListener(new Click());
        japan = findViewById(R.id.btn_japan);
        japan.setOnClickListener(new Click());
        mi = findViewById(R.id.btn_mi);
        mi.setOnClickListener(new Click());
        game = findViewById(R.id.btn_game);
        game.setOnClickListener(new Click());
    }
}
