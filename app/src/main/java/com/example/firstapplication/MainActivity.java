package com.example.firstapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    private EditText editText;
    private EditText sizeText;
    private Button edit_button;
    private Button color_button;
    private Button size_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_button = findViewById(R.id.edit_button);
        color_button = findViewById(R.id.color_button);
        size_button = findViewById(R.id.size_button);
        text = findViewById(R.id.text);
        editText = findViewById(R.id.edit_text);
        sizeText = findViewById(R.id.new_size);
        edit_button.setOnClickListener(new MainActivity.EditTextListener(text,editText));
        color_button.setOnClickListener(new MainActivity.EditColorListener(text));
        size_button.setOnClickListener(new MainActivity.EditSizeListener(text, sizeText));
    }

    static class EditTextListener implements View.OnClickListener {

        private final TextView newText;
        private final EditText edit_Text;

        public EditTextListener(TextView text, EditText editText) {
            newText = text;
            edit_Text = editText;
        }

        @Override
        public void onClick(View view) {

            newText.setText(edit_Text.getText().toString());
            edit_Text.setText("");
        }
    }

    static class EditColorListener implements View.OnClickListener {

        private final TextView newText;

        public EditColorListener(TextView text){
            newText = text;
        }

        @Override
        public void onClick(View view) {

            Random random = new Random();

            int randomColor = Color.rgb(
                    random.nextInt(256), // Red component
                    random.nextInt(256), // Green component
                    random.nextInt(256)  // Blue component
            );

            newText.setTextColor(randomColor);
        }
    }

    static class EditSizeListener implements View.OnClickListener {

        private final TextView newText;
        private final EditText newSize;

        public EditSizeListener(TextView text, EditText size){
            newText = text;
            newSize = size;
        }

        @Override
        public void onClick(View view) {

            float size = Float.parseFloat(newSize.getText().toString());
            newText.setTextSize(size);
            newSize.setText("");
        }
    }
}