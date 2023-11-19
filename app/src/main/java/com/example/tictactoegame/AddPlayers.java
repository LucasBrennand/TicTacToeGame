package com.example.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPlayers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);

        final EditText player1 = findViewById(R.id.player1Name);
        final EditText player2 = findViewById(R.id.player2Name);
        final Button playButton = findViewById(R.id.playBtn);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String getPlayer1name = player1.getText().toString();
                final String getPlayer2name = player2.getText().toString();

                if(getPlayer1name.isEmpty() || getPlayer2name.isEmpty()){
                    Toast.makeText(AddPlayers.this, "Enter player names", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(AddPlayers.this, MainActivity.class);
                    intent.putExtra("player1",getPlayer1name);
                    intent.putExtra("player2",getPlayer2name);
                    startActivity(intent);

                }
            }
        });

    }
}