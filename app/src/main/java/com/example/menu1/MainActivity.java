package com.example.menu1;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textView = findViewById(R.id.textView);

        // Register context menu
        registerForContextMenu(textView);
    }

    // OPTION MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.menu_settings) {
            Toast.makeText(this, "Settings Clicked", Toast.LENGTH_SHORT).show();
            return true;

        } else if (id == R.id.menu_about) {
            Toast.makeText(this, "About Clicked", Toast.LENGTH_SHORT).show();
            return true;

        } else if (id == R.id.menu_exit) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // CONTEXT MENU
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.cut) {
            Toast.makeText(this, "Cut selected", Toast.LENGTH_SHORT).show();
            return true;

        } else if (id == R.id.copy) {
            Toast.makeText(this, "Copy selected", Toast.LENGTH_SHORT).show();
            return true;

        } else if (id == R.id.paste) {
            Toast.makeText(this, "Paste selected", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onContextItemSelected(item);
    }
}