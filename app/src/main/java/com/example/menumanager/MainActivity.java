package com.example.menumanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener, ActionMode.Callback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tvTitle = findViewById(R.id.activity_main__tv__title);
        registerForContextMenu(tvTitle);

        final View root = findViewById(R.id.activity_main__cl__root);
        root.setOnLongClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu__main__item_copy) {
            Toast.makeText(this,"Copy",Toast.LENGTH_SHORT);
        } else if (item.getItemId() == R.id.menu__main__item__cut) {
            Toast.makeText(this,"Cut",Toast.LENGTH_SHORT);
        } else if (item.getItemId() == R.id.main__menu__item__paste) {
            Toast.makeText(this,"Paste",Toast.LENGTH_SHORT);
        } else {
            return super.onOptionsItemSelected(item);
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_contextual,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_contextual__item__add:
                Toast.makeText(this, "Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_contextual__item__like:
                Toast.makeText(this, "Like", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu__contextual__item__dislike:
                Toast.makeText(this, "Dislike", Toast.LENGTH_SHORT).show();
                break;
            default:
                return super.onContextItemSelected(item);
        }
        return true;
    }

    @Override
    public boolean onLongClick(View v) {
        if (v.getId() == R.id.activity_main__cl__root) {
            startActionMode(this);
            return true;
        } else {
        return false;
    }
}

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_contextual, menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        if (item.getItemId() == R.id.menu_contextual__item__add ||
                item.getItemId() == R.id.menu_contextual__item__like ||
                item.getItemId() == R.id.menu__contextual__item__dislike) {
            Toast.makeText(this, "Option from CAM", Toast.LENGTH_SHORT).show();
            mode.finish();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {

    }
}
