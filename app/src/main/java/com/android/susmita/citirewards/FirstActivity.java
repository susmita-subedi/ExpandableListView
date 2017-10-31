package com.android.susmita.citirewards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import static android.support.v7.appcompat.R.styleable.View;

public class FirstActivity extends AppCompatActivity {

    Button goToMainBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("firstA", "create");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        goToMainBtn = (Button)findViewById(R.id.goToMain);
        goToMainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startNewIntent();
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("firstA", "start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("firstA", "stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("firstA", "destroy");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("firstA", "resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("firstA", "pause");
    }

    private void startNewIntent() {
        Intent intent = new Intent(FirstActivity.this,MainActivity.class);
        startActivity(intent);
    }
}
