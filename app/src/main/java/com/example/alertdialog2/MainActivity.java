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
        adb.setTitle("random message");
        adb.setMessage("hello");

        final String[] colors = {"Red", "Green", "Blue"};

        int[] color = new int[]{0, 0, 0};

        adb = new AlertDialog.Builder(/* context: */ this);

        adb.setTitle("List of colors - one choice");
        adb.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                color[which] = 255;
                screen.setBackgroundColor(Color.rgb(color[0], color[1], color[2]));
            }
        });
        adb.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        adb.setCancelable(false);
        AlertDialog ad = adb.create();
        ad.show();
    }


    public void clickedBtnColorsChoice(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("text.");
        adb.setMessage("This is text");
        final String[] colors = {"Red", "Green", "Blue"};
        int[] color = new int[]{0, 0, 0};
        adb = new AlertDialog.Builder(this);
        adb.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        adb.setMultiChoiceItems(colors,null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked) color[which] = 255;
                else if (color[which] == 255) color[which] = 0;
            }
        });
        adb.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        adb.setNegativeButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                screen.setBackgroundColor(Color.rgb(color[0], color[1], color[2]));
            }
        });
        adb.setCancelable(false);
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
        adb.setMessage("This is text1");
        eTad.setHint("Enter text");
        adb.setView(eTad);

        adb.setPositiveButton("enter", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = eTad.getText().toString();
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        });

        adb.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog ad = adb.create();
        ad.show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@Nullable MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.credits) {
            Intent si = new Intent(this, activityCredits.class);
            startActivity(si);
        }

        return true;
    }
}
