package com.bawei.zhangyiman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private FlowLayout flowLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flowLayout = findViewById(R.id.fl);

        flowLayout.addTag("111111");
        flowLayout.addTag("222");
        flowLayout.addTag("11565111");
        flowLayout.addTag("2235");
        flowLayout.addTag("1111");
        flowLayout.addTag("22355");
        flowLayout.addTag("11111");
        flowLayout.addTag("22");

    }
}
