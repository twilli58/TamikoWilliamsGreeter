package com.mycompany.tamikowilliamsgreeter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    }
    public void didTapGreetButton(View view) {
        Button button = (Button) findViewById(R.id.reverse_button);
        button.setEnabled(true);
        EditText greetEditText =
                (EditText) findViewById(R.id.greet_edit_text);

        String name = greetEditText.getText().toString();
        String greeting = String.format("Hello, %s!", name);

        TextView messageTextView =
                (TextView) findViewById(R.id.message_text_view);

        messageTextView.setText(greeting);
    }
    public void reverseTextButton(View view) {
        final TextView reverseTextView = (TextView)findViewById(R.id.message_text_view);
        String original = reverseTextView.getText().toString();
        StringBuilder string = new StringBuilder(original);
        String reverse = string.reverse().toString();
        reverseTextView.setText(reverse);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
