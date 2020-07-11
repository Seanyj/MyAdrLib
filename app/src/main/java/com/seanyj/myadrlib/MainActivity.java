package com.seanyj.myadrlib;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.seanyj.utillib.util.ScreenUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = findViewById(R.id.textView);

        int[] ret = ScreenUtil.getScreenSizeWithNavBar(this);
        tv.setText("widht: " + ret[0] + "  height: " + ret[1]);
    }
}
