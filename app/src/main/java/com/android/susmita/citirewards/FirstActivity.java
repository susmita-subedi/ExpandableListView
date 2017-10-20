package com.android.susmita.citirewards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity {

    Button goToMainBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        goToMainBtn = (Button)findViewById(R.id.goToMain);
        goToMainBtn.setOnClickListener(view -> {
            startNewIntent();
        });
    }

    private void startNewIntent() {
        Intent intent = new Intent(FirstActivity.this,MainActivity.class);
        startActivity(intent);
    }
}
