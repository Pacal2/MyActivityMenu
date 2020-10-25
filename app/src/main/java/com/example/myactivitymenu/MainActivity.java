package com.example.myactivitymenu;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.ContextMenu;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Menu appMenu = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        TextView tv = (TextView)this.findViewById(R.id.textViewId);
        tv.setText("Menu kontekstowe");
        registerForContextMenu(tv);



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        this.appMenu = menu;
        AddRegularMenuItem(menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_start) {
            return true;
        } else if (id == R.id.menu_message) {
            TextView tv = new TextView(this);
            tv.setText("Wiadomość z aplikacji");
            setContentView(tv);
        } else if (id == R.id.menu_exit) {
            finish();
        } else if (id == 100) {

            Toast.makeText(
                    MainActivity.this,
                    "Nacisnąłeś przycisk dodany programowo",
                    Toast.LENGTH_LONG
            ).show();

        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Menu kontekstowe");
        menu.add(200, 200, 200, "Element 1");
        menu.add(300, 300, 300, "Element 2");
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
            if (id == 200) {
                return true;
            } else if (id == 300) {
                return true;
            }

            return super.onContextItemSelected(item);
    }




    private void AddRegularMenuItem(Menu menu) {
        int base = Menu.FIRST;
        menu.add(base, base, base, "Pozycja dodana programowo");
        menu.add(base, 100, 100, "Pozycja dodana na koniec");
    }

}