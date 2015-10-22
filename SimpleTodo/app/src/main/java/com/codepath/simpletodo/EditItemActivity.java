package com.codepath.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {
    EditText itemEdit;
    String item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        itemEdit = (EditText) findViewById(R.id.itemEdit);
        item = getIntent().getExtras().getString("item");
        itemEdit.setText(item);
    }

    public void onSubmit(View v) {
        Intent editedItem = new Intent();
        editedItem.putExtra("item", itemEdit.getText().toString());
        editedItem.putExtra("position", getIntent().getExtras().getInt("position"));
        setResult(RESULT_OK, editedItem);
        this.finish();
    }
}
