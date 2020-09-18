package com.seanyj.myadrlib.utiltest;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.seanyj.myadrlib.R;
import com.seanyj.utillib.util.RichTextUtil;

public class RichTextTestActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rich_text_test);
        mResultTextView = findViewById(R.id.resultTextView);

        findViewById(R.id.spanTest).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.spanTest:
                testSpan();
                break;
        }
    }

    private void testSpan() {
        String h = "hello";
        String w = "world";
        CharSequence text = RichTextUtil.bold(RichTextUtil.italic(h), RichTextUtil.color(Color.RED, w));
        mResultTextView.setText(text);
    }
}
