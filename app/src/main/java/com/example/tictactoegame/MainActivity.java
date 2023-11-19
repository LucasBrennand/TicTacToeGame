package com.example.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final List<int[]> combinationsList = new ArrayList<>();
    private int[] boxPositions = {0,0,0,0,0,0,0,0,0};
    private int playerTurn = 1;
    private int selectedBoxes = 1;
    private LinearLayout player1Layout, player2Layout;
    private TextView player1Name, player2Name;
    private ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player1Name = findViewById(R.id.player1Name);
        player2Name = findViewById(R.id.player2Name);

        player1Layout = findViewById(R.id.player1Layout);
        player2Layout = findViewById(R.id.player2Layout);

        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        img5 = findViewById(R.id.img5);
        img6 = findViewById(R.id.img6);
        img7 = findViewById(R.id.img7);
        img8 = findViewById(R.id.img8);
        img9 = findViewById(R.id.img9);

        combinationsList.add(new int[]{0, 1, 2});
        combinationsList.add(new int[]{3, 4, 5});
        combinationsList.add(new int[]{6, 7, 8});
        combinationsList.add(new int[]{0, 3, 6});
        combinationsList.add(new int[]{1, 4, 7});
        combinationsList.add(new int[]{2, 5, 8});
        combinationsList.add(new int[]{2, 4, 6});
        combinationsList.add(new int[]{0, 4, 8});

        final String getPlayer1Name = getIntent().getStringExtra("player1");
        final String getPlayer2Name = getIntent().getStringExtra("player2");
        player1Name.setText(getPlayer1Name);
        player2Name.setText(getPlayer2Name);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((isBoxClickable(0))) {
                    peformClick((ImageView)view,0);
                }
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((isBoxClickable(1))) {
                    peformClick((ImageView)view,1);
                }
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((isBoxClickable(2))) {
                    peformClick((ImageView)view,2);
                }
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((isBoxClickable(3))) {
                    peformClick((ImageView)view,3);
                }
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((isBoxClickable(4))) {
                    peformClick((ImageView)view,4);
                }
            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((isBoxClickable(5))) {
                    peformClick((ImageView)view,5);
                }
            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((isBoxClickable(6))) {
                    peformClick((ImageView)view,6);
                }
            }
        });
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((isBoxClickable(7))) {
                    peformClick((ImageView)view,7);
                }
            }
        });
        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((isBoxClickable(8))) {
                    peformClick((ImageView)view,8);
                }
            }
        });

    }
    private void peformClick(ImageView imageView, int selectedBoxPosition){
        boxPositions[selectedBoxPosition] = playerTurn;
        if (playerTurn == 1){
            imageView.setImageResource(R.drawable.cross);
            if (checkPlayerWin()){
                Message message = new Message(MainActivity.this, player1Name.getText().toString() + " wins!", MainActivity.this);
                message.setCancelable(false);
                message.show();
            }
            else if (selectedBoxes == 9){
                Message message = new Message(MainActivity.this, "Tie Game!", MainActivity.this);
                message.setCancelable(false);
                message.show();
            }
            else {
                changePlayerTurn(2);
                selectedBoxes++;
            }
        }
        else {
            imageView.setImageResource(R.drawable.zero);
            if (checkPlayerWin()){
                Message message = new Message(MainActivity.this, player2Name.getText().toString() + " wins!", MainActivity.this);
                message.setCancelable(false);
                message.show();
            }
            else if (selectedBoxes == 9){
                Message message = new Message(MainActivity.this, "Tie Game!", MainActivity.this);
                message.setCancelable(false);
                message.show();
            }
            else {
                changePlayerTurn(1);
                selectedBoxes++;
            }
        }
    }
    private void changePlayerTurn(int currentPlayerTurn){
        playerTurn = currentPlayerTurn;
        if (playerTurn == 1){
            player1Layout.setBackgroundResource(R.drawable.round_back_blue_border);
            player2Layout.setBackgroundResource(R.drawable.round_back_dark_blue);
        }
        else {
            player2Layout.setBackgroundResource(R.drawable.round_back_blue_border);
            player1Layout.setBackgroundResource(R.drawable.round_back_dark_blue);
        }
    }
    private boolean checkPlayerWin(){
        boolean response = false;
        for (int i = 0; i < combinationsList.size(); i++){
            final int [] combinations = combinationsList.get(i);
            if (boxPositions[combinations[0]] == playerTurn && boxPositions[combinations[1]] == playerTurn && boxPositions[combinations[2]] == playerTurn){
                response = true;
            }
        }
        return response;
    }
    private boolean isBoxClickable(int boxPosition){
        boolean response = false;
        if(boxPositions[boxPosition] == 0){
            response = true;
        }
        return response;
    }
    public void restartMatch(){
        boxPositions = new int[]{0,0,0,0,0,0,0,0,0};
        playerTurn = 1;
        selectedBoxes = 1;
        img1.setImageResource(R.drawable.transp);
        img2.setImageResource(R.drawable.transp);
        img3.setImageResource(R.drawable.transp);
        img4.setImageResource(R.drawable.transp);
        img5.setImageResource(R.drawable.transp);
        img6.setImageResource(R.drawable.transp);
        img7.setImageResource(R.drawable.transp);
        img8.setImageResource(R.drawable.transp);
        img9.setImageResource(R.drawable.transp);
    }
}