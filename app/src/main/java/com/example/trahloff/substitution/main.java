package com.example.trahloff.substitution;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class main extends Activity {
    private Switch swch_mode;

    @Override
    protected void onCreate(Bundle sis) {
        super.onCreate(sis);
        setContentView(R.layout.main);
        swch_mode = findViewById(R.id.swch_mode);
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
        EditText txt_input = findViewById(R.id.txt_text);
        EditText txt_key = findViewById(R.id.txt_key);
        TextView alert = findViewById(R.id.alert);

        String input = txt_input.getText().toString().toUpperCase();
        String key = txt_key.getText().toString().toUpperCase();

        if (input.length() != 0 &&
            key.length() == 26 &&
            key.matches("[A-Z]*") && // is english
            key.matches("((.)(?!.*?\\2))*")) { // only unique chars
                txt_input.setText(cipher(input, key, swch_mode.isChecked()));
                alert.setText("done\nlast input: \n" + input);
        } else {
                alert.setText("invalid key\nexactly 26 characters\nonly a-z");
        }
    }

    public void changeMode(View v) {
        swch_mode.setText("Mode: " + (swch_mode.isChecked() ? "Encryption" : "Decryption"));
    }
}
