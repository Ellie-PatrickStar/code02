package com.example.code02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static final String COUNT_VALUE = "count_value";
    private int count = 0;

    @Override
    protected void onSaveInstanceState(Bundle outState){
        outState.putInt(COUNT_VALUE,count);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnShowToast = findViewById(R.id.btnShowToast);
        btnShowToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Hello World!",
                        Toast.LENGTH_SHORT).show();
            }
        });
        final TextView tvCount = findViewById(R.id.tvCount);
        Button btnCount = findViewById(R.id.btnCount);
        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvCount.setText(Integer.toString(++count));
            }
        });
    }

    TextView tvCount;

    protected void  onRestoreInstante(Bundle saveInstanceState){
        super.onRestoreInstanceState(saveInstanceState);
        count= saveInstanceState.getInt(COUNT_VALUE);
        if (tvCount!=null){
            tvCount.setText(Integer.toString(count));
        }
    }
}