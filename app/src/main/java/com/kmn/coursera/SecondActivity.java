package com.kmn.coursera;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.net.URLEncoder;

public class SecondActivity extends AppCompatActivity {

    public static String DATA_TEXT = "DATA_TEXT";

    private TextView mOutputText;
    private Button mBtn;

   private String urlString = "http://google.com/search?q=";
    private String urlInputText;

    private View.OnClickListener mOnButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlString + urlInputText ));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setPackage("com.android.chrome");
            try
            {
                startActivity(intent);
            }
            catch (ActivityNotFoundException ex)
            {
                //if Chrome browser not installed
                intent.setPackage(null);
                startActivity(intent);
            }
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
        urlInputText = URLEncoder.encode(dataText.getmText());
        mOutputText.setText(dataText.getmText());

        mBtn.setOnClickListener(mOnButtonClickListener);
    }
}

