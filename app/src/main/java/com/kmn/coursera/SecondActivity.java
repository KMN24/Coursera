package com.kmn.coursera;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    public static String DATA_TEXT = "DATA_TEXT";

    private TextView mOutputText;
    private Button mBtn;

    private View.OnClickListener mOnButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        mOutputText = findViewById(R.id.tvOutputText);
        mBtn = findViewById(R.id.btn_click2);

        Bundle bundle = getIntent().getExtras();
        Data dataText = (Data) bundle.get(DATA_TEXT);
        mOutputText.setText(dataText.getmText());

        mBtn.setOnClickListener(mOnButtonClickListener);
    }
}
