package com.example.alertdialog2;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    AlertDialog.Builder adb;
    Button btnT, btnTI, btnTI1, btnTI2, btnNext;
    LinearLayout screen;
    Random random = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnT = findViewById(R.id.btnT);
        btnTI = findViewById(R.id.btnTI);
        btnTI1 = findViewById(R.id.btnTI1);
        btnTI2 = findViewById(R.id.btnTI2);
        btnNext = findViewById(R.id.btnNext);
        screen = findViewById(R.id.screen);
    }

    public void clickedBtnT(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("text.");
        adb.setMessage("This is text");
        adb.show();
    }


    public void clickedBtnTI(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("text.1");
        adb.setMessage("This is text1");
        adb.setIcon(R.drawable.flag1);
        AlertDialog ad = adb.create();
        ad.show();
    }


    public void clickedBtnTI1(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("text.2");
        adb.setMessage("This is text2");
        adb.setIcon(R.drawable.flag1);

        adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog ad = adb.create();
        ad.show();
    }

    public void clickedBtnTI2(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("text.3");
        adb.setMessage("This is text3");
        adb.setIcon(R.drawable.flag1);

        adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        adb.setNegativeButton("editColor", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (screen != null) {
                    changeBackgroundColor();
                }
            }
        });

        AlertDialog ad = adb.create();
        ad.show();
    }


    public void clickedBtnTI3(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("text.3");
        adb.setMessage("This is text3");
        adb.setIcon(R.drawable.flag1);

        adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        adb.setNeutralButton("edit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (screen != null) {
                    changeBackgroundColor();
                }
            }
        });

        adb.setNegativeButton("reset", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                resetBackgroundColor();
            }
        });

        AlertDialog ad = adb.create();
        ad.show();
    }


    public void changeBackgroundColor() {
        int color1 = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        int color2 = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        int color3 = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        int color4 = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        int color5 = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        int color6 = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));

        if (screen != null) {
            screen.setBackgroundColor(color1);
        }

        btnT.setBackgroundColor(color2);
        btnTI.setBackgroundColor(color3);
        btnTI1.setBackgroundColor(color4);
        btnTI2.setBackgroundColor(color5);
        btnNext.setBackgroundColor(color6);
    }


    public void resetBackgroundColor() {
        int color = Color.rgb(255, 255, 255);
        if (screen != null) {
            screen.setBackgroundColor(color);
        }

        int color1 = Color.rgb(200, 200, 200);
        btnT.setBackgroundColor(color1);
        btnTI.setBackgroundColor(color1);
        btnTI1.setBackgroundColor(color1);
        btnTI2.setBackgroundColor(color1);
        btnNext.setBackgroundColor(color1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@Nullable MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.mCredits) {
            Intent si = new Intent(this, activityCredits.class);
            startActivity(si);
        }

        return true;
    }
}
