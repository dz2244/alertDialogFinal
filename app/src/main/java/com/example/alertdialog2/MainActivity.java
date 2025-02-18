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
    AlertDialog.Builder adb ;
    Button btnT, btnTI, btnTI1, btnTI2;
    LinearLayout screen;


    /**
     * Initializes the activity, sets the layout, and links UI elements.
     *
     * @param savedInstanceState the saved instance state, if any.
     */
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

    /**
     * Displays an alert dialog with a list of colors to choose from.
     * Changes the background color of the screen based on the selected color.
     *
     * @param view the clicked button view.
     */
    public void clickedBtnColors(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("SKIBIDI");
        adb.setMessage("SIGMA");
        final String[] colors = {"Red", "Green", "Blue"};
        int[] color = new int[]{0, 0, 0};
        adb = new AlertDialog.Builder(this);
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

    /**
     * Displays a multi-choice alert dialog allowing users to select multiple colors.
     * Updates the background color based on the selected colors.
     *
     * @param view the clicked button view.
     */
    public void clickedBtnColorsChoice(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("SKIBIDI");
        adb.setMessage("SIGMA");
        final String[] colors = {"Red", "Green", "Blue"};
        int[] color = new int[]{0, 0, 0};
        adb = new AlertDialog.Builder( this);
        adb.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                screen.setBackgroundColor(Color.rgb(color[0], color[1], color[2]));
            }
        });
        adb.setMultiChoiceItems(colors, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked) color[which] = 255;
                else if (color[which] == 255) color[which] = 0;
            }
        });
        AlertDialog ad = adb.create();
        ad.setCancelable(false);
        ad.show();
    }

    /**
     * Resets the background color of the screen to white.
     *
     * @param view the clicked button view.
     */
    public void clickedBtnReset(View view) {
        screen.setBackgroundColor(Color.WHITE);
    }

    /**
     * Displays an alert dialog with an EditText input and a Toast message.
     * The user can enter text, which will be displayed in a Toast.
     *
     * @param view the clicked button view.
     */
    public void clickedBtnToast(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("SKIBIDI");
        final EditText eTad = new EditText(this);
        adb.setMessage("SIGMA");
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
        ad.setCancelable(false);
        ad.show();
    }

    /**
     * Inflates the options menu in the activity.
     *
     * @param menu the options menu.
     * @return true if the menu is successfully created.
     */

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * Handles selection of menu items.
     *
     * @param item the selected menu item.
     * @return true if the item is successfully handled.
     */
    @Override
    public boolean onOptionsItemSelected(@Nullable MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.credits) {
            Intent si = new Intent(this, activityCredits.class);
            startActivity(si);
        }

        return true;
    }

}
