package com.example.trahloff.substitution;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class main2 extends Activity {
    EditText input;
    EditText key;
    TextView alert;
    Switch switch_mode;

    @Override
    protected void onCreate(Bundle sis) {
        super.onCreate(sis);
        setContentView(R.layout.main);

        input = findViewById(R.id.txt_text);
        key = findViewById(R.id.txt_key);
        alert = findViewById(R.id.alert);
        switch_mode = findViewById(R.id.swch_mode);
    }

    private static String cipher(String input, String key, Boolean encrypt) {
        String output = "";
        for (char c : input.toCharArray()) {
            if ((c < 'A') || (c > 'Z')) continue;
            output += (encrypt ? key.charAt(((int) c) - 65) : (char) (key.indexOf(c) + 65));
        }
        return output;
    }

    public void runCipher(View v) {
        String TXT = input.getText().toString().toUpperCase();
        String KEY = key.getText().toString().toUpperCase();

        if (TXT.length() != 0 &&
            KEY.length() == 26 &&
            KEY.matches("((.)(?!.*?\\2))*") && // only unique chars
            KEY.matches("[A-Z]*")) { // is english
                input.setText(cipher(TXT, KEY, switch_mode.isChecked()));
                alert.setText("done");
        } else {
                alert.setText("invalid key\nexactly 26 characters\nonly a-z");
        }
    }

    public void changeMode(View v) {
        switch_mode.setText("Mode: " + (switch_mode.isChecked() ? "Encryption" : "Decryption"));
    }
}
