package com.mycompany.tamikowilliamsgreeter;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Miko on 2/27/2016.
 */
public class MainActivityTests extends
        ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTests() {
        super(MainActivity.class);
    }

    public void testActivityExists() {
        MainActivity activity = getActivity();
        assertNotNull(activity);
    }
    public void testGreet() {
        MainActivity activity = getActivity();

        this.runHelper();

        // Tap "Greet" button
        // ----------------------

        Button greetButton =
                (Button) activity.findViewById(R.id.greet_button);

        TouchUtils.clickView(this, greetButton);

        // Verify greet message
        // ----------------------

        TextView greetMessage = (TextView) activity.findViewById(R.id.message_text_view);
        String actualText = greetMessage.getText().toString();
        assertEquals("Hello, Jake!", actualText);

    }
    public void testReverseDisabled(){
        MainActivity activity = getActivity();

        Button reverseButton =
                (Button) activity.findViewById(R.id.reverse_button);
        assertFalse(reverseButton.isEnabled());

    }
    public void testReverseEnabled(){
        MainActivity activity = getActivity();
        Button reverseButton =
                (Button) activity.findViewById(R.id.reverse_button);
        Button greetButton =
                (Button) activity.findViewById(R.id.greet_button);

        TouchUtils.clickView(this, greetButton);
        assertTrue(reverseButton.isEnabled());

    }
    public void testTextIsReversed() {
        MainActivity activity = getActivity();
        Button greetButton =
               (Button) activity.findViewById(R.id.greet_button);
        Button reverseButton =
                (Button) activity.findViewById(R.id.reverse_button);

        this.runHelper();
        TouchUtils.clickView(this, greetButton);

        TextView greetMessage = (TextView) activity.findViewById(R.id.message_text_view);
        String actualText = greetMessage.getText().toString();
        assertEquals("Hello, Jake!", actualText);

        TouchUtils.clickView(this, reverseButton);

        // Verify greet message
        // ----------------------
        String reverseText = greetMessage.getText().toString();
        assertEquals("!ekaJ ,olleH", reverseText);

    }
    //*****************Helper Method ****************

    private void runHelper() {
        MainActivity activity = getActivity();
        final EditText nameEditText =
                (EditText) activity.findViewById(R.id.greet_edit_text);
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                nameEditText.requestFocus();
            }
        });

        getInstrumentation().waitForIdleSync();
        getInstrumentation().sendStringSync("Jake");
        getInstrumentation().waitForIdleSync();
    }

}

