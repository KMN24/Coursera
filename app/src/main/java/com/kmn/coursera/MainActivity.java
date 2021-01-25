package com.kmn.coursera;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText mTextInput;
    private Button mBtnClick;

    private View.OnClickListener mOnTextInputListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showMessage();
        }
    };

    private void showMessage(){
        if( mTextInput.getText().length() != 0 ){
            Toast.makeText(this, mTextInput.getText(), Toast.LENGTH_LONG).show();
            Intent startSecondIntent = new Intent(MainActivity.this, SecondActivity.class);
            startSecondIntent.putExtra(SecondActivity.DATA_TEXT, new Data(mTextInput.getText().toString()));
            startActivity(startSecondIntent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextInput = findViewById(R.id.etInput);
        mBtnClick = findViewById(R.id.btn_click);

        mBtnClick.setOnClickListener(mOnTextInputListener);
    }
}