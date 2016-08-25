package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
    int life = 5;
    int Rand;
    int C1 = 1, C2 = 3, C3 = 5;
    int Strike = 0, Ball = 0, Out = 0;
    TextView TxLife, TxV1, TxV2, TxV3, TxV4, TxV5, LorW;
    Button Choose;
    Button Exit, Restart;
    EditText PS1, PS2, PS3;
    int PC1, PC2, PC3;
    LinearLayout LoseView;
    Animation Appear,disappear;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoseView = (LinearLayout)findViewById(R.id.View_Lose);
        TxLife = (TextView)findViewById(R.id.TxLife);
        Choose = (Button)findViewById(R.id.Btn_Choose);
        Exit = (Button)findViewById(R.id.Btn_Finish);
        Restart = (Button)findViewById(R.id.Btn_Restart);
        PS1 = (EditText)findViewById(R.id.PS1);
        PS2 = (EditText)findViewById(R.id.PS2);
        PS3 = (EditText)findViewById(R.id.PS3);
        TxV1 = (TextView)findViewById(R.id.TxV1);
        TxV2 = (TextView)findViewById(R.id.TxV2);
        TxV3 = (TextView)findViewById(R.id.TxV3);
        TxV4 = (TextView)findViewById(R.id.TxV4);
        TxV5 = (TextView)findViewById(R.id.TxV5);
        LorW = (TextView)findViewById(R.id.LorWText);
        Appear = AnimationUtils.loadAnimation(this, R.anim.alpha_appear);
        disappear = AnimationUtils.loadAnimation(this, R.anim.anim_disappear);
        Restart.setOnClickListener(this);
        Exit.setOnClickListener(this);
        Choose.setOnClickListener(this);

        for (int i = 0 ; i < 3; i++) {
            Rand = (int) (Math.random() * 10);
            switch (i) {
                case 0:
                    C1 = Rand;
                    break;
                case 1:
                    C2 = Rand;
                    break;
                case 2:
                    C3 = Rand;
                    break;
            }
              if (C1 == C2 || C2 == C3 || C3 == C1) {
                i--;
               }
             }
            }
    @Override
    public void onClick(View v) {

        PC1 = Integer.parseInt(PS1.getText().toString().trim());
        PC2 = Integer.parseInt(PS2.getText().toString().trim());
        PC3 = Integer.parseInt(PS3.getText().toString().trim());

        if (v == Exit) {
            LoseView.setVisibility(View.GONE);
            finish();
        }
        if (v == Restart) {
            LoseView.setVisibility(View.GONE);
            LoseView.startAnimation(disappear);

            life = 5;
            TxLife.setText("5");

            TxV1.setText(null);
            TxV2.setText(null);
            TxV3.setText(null);
            TxV4.setText(null);
            TxV5.setText(null);

            for (int i = 0 ; i < 3; i++) {

                Rand = (int) (Math.random() * 10);

                switch (i) {
                    case 0:
                        C1 = Rand;
                        break;
                    case 1:
                        C2 = Rand;
                        break;
                    case 2:
                        C3 = Rand;
                        break;
                }
                if (C1 == C2 || C2 == C3 || C3 == C1) {
                    i--;
                }
            }
            Strike = 0;
            Ball = 0;
        }

        if (v == Choose) {
            if (PS1 == null || PS2 == null || PS3 == null) {
                Toast.makeText(MainActivity.this, "값을 입력하세요", Toast.LENGTH_SHORT).show();
            }
            if (PC1 == PC2 || PC2 == PC3 || PC3 == PC1) {
                Toast.makeText(MainActivity.this, "같은숫자가 있습니다.", Toast.LENGTH_SHORT).show();
            }else {
                        if (PC1 == C1) {
                            Strike++;
                        }

                        if (PC2 == C2) {
                            Strike++;
                        }

                        if (PC3 == C3) {
                            Strike++;
                        }

                        if (PC1 == C2 || PC1 == C3) {
                            Ball++;
                        }

                        if (PC2 == C1 || PC2 == C3) {
                            Ball++;
                        }

                        if (PC3 == C2 || PC3 == C1) {
                            Ball++;
                        }
                       if (Strike <= 0 && Ball <= 0) {
                    Out = 1;
                }

            switch (life){
                case 5 :
                    TxV1.setText("입력한 값 :"+PC1+PC2+PC3+"\n"+Strike + "스트라이크, " + Ball + "볼, " + Out + "아웃.");
                    life--;
                    TxLife.setText("4");
                    break;
                case 4 :
                    TxV2.setText("입력한 값 :"+PC1+PC2+PC3+"\n"+Strike+"스트라이크, "+Ball+"볼, "+Out+"아웃.");
                    life--;
                    TxLife.setText("3");
                    break;
                case 3 :
                    TxV3.setText("입력한 값 :"+PC1+PC2+PC3+"\n"+Strike+"스트라이크, "+Ball+"볼, "+Out+"아웃.");
                    life--;
                    TxLife.setText("2");
                    break;
                case 2 :
                    TxV4.setText("입력한 값 :"+PC1+PC2+PC3+"\n"+Strike+"스트라이크, "+Ball+"볼, "+Out+"아웃.");
                    life--;
                    TxLife.setText("1");
                    break;
                case 1 :
                    TxV5.setText("입력한 값 :"+PC1+PC2+PC3+"\n"+Strike+"스트라이크, "+Ball+"볼, "+Out+"아웃.");
                    life--;
                    TxLife.setText("0");
                    break;
            }
                if (life == 0){
                LoseView.setVisibility(View.VISIBLE);
                    LorW.setText("패배");
                LoseView.startAnimation(Appear);
                }
                if (Strike == 3) {
                    LoseView.setVisibility(View.VISIBLE);
                    LoseView.startAnimation(Appear);
                    LorW.setText("승리");
                }

            }
            Strike = 0;
            Ball = 0;
            Out = 0;
        }
    }
}
