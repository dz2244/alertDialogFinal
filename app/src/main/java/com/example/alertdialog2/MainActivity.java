package com.example.alertdialog2;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    AlertDialog.Builder adb;
    Button btnT, btnTI, btnTI1, btnTI2 ;
    LinearLayout screen;
    Random random = new Random();
    int[] colors = {Color.RED, Color.GREEN, Color.BLUE};
    int color1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnT = findViewById(R.id.btnT);
        btnTI = findViewById(R.id.btnTI);
        btnTI1 = findViewById(R.id.btnTI1);
        btnTI2 = findViewById(R.id.btnTI2);
        screen = findViewById(R.id.screen);
    }

    public void clickedBtnColors(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("text.");
        adb.setMessage("This is text");
        adb.setPositiveButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        adb.setNegativeButton("switchColor", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (screen != null) {
                    color1 = colors[random.nextInt(3)];
                    screen.setBackgroundColor(color1);
                }
            }
        });
        AlertDialog ad = adb.create();
        ad.show();
    }


    public void clickedBtnColorsChoice(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("text.1");
        adb.setMessage("This is text1");
        adb.setCancelable(false);

        int[] color = new int[] {0, 0, 0};

        final String[] colors = {"Red", "Green", "Blue"};

        adb.setTitle("Change multiple colors");
        adb.setMultiChoiceItems(colors, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked) {
                    color[which] = 255;
                } else {
                    color[which] = 0;
                }
            }
        });

        adb.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.cancel();
            }
        });

        adb.setNeutralButton("chose" , new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                screen.setBackgroundColor(Color.rgb(color[0], color[1], color[2]));
            }
        });

            AlertDialog ad = adb.create();
            ad.show();
    }


    public void clickedBtnReset(View view) {
        screen.setBackgroundColor(Color.WHITE);
    }

    public void clickedBtnToast(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("text.3");
        final EditText eTad = new EditText(this);
        eTad.setHint("Enter text");
        adb.setView(eTad);

        adb.setPositiveButton ("Copy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = eTad.getText().toString();
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();

                adb.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.cancel();
                    }
                });

                AlertDialog ad = adb.create();
                ad.show();
            }
        });
    };
}
