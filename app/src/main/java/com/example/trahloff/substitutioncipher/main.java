package com.example.trahloff.substitutioncipher;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class main extends Activity {

    @Override
    protected void onCreate(Bundle SIS) {
        super.onCreate(SIS);
        setContentView(R.layout.main);
        Switch switch_mode = findViewById(R.id.switch_mode);
        switch_mode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String mode = isChecked ? "Encryption" : "Decryption";
                buttonView.setText(String.valueOf("Mode: " + mode));
            }
        });
    }

    public void cipher(View v) {
        EditText input = findViewById(R.id.txt_text);
        EditText key = findViewById(R.id.txt_key);
        TextView alert = findViewById(R.id.alert);
        Switch switch_mode = findViewById(R.id.switch_mode);

        String TXT = input.getText().toString().toUpperCase();
        String KEY = key.getText().toString().toUpperCase();

        if (TXT.length() != 0 && parserUtil.isKeyValid(KEY)) {
            String output = cryptoUtil.cipher(TXT, KEY, switch_mode.isChecked());
            input.setText(output);
            alert.setText("done");
        } else {
            alert.setText("invalid key\nexactly 26 characters\nonly a-z");
        }
    }

}
