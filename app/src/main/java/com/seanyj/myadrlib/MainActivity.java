package com.seanyj.myadrlib;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.seanyj.myadrlib.notch.NotchTestActivity;
import com.seanyj.myadrlib.utiltest.RichTextTestActivity;
import com.seanyj.utillib.util.ScreenUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private  List<Map<String, Object>> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = findViewById(R.id.listView);
        initData();
        initView();
    }

    private void initView() {
        SimpleAdapter adapter = new SimpleAdapter(this, mList, android.R.layout.simple_list_item_1,
                new String[]{"title"}, new int[] {android.R.id.text1});
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Map<String, Object> item = (Map<String, Object>) mListView.getItemAtPosition(position);
                Class cl = (Class) item.get("class");
                Intent i = new Intent(MainActivity.this, cl);
                startActivity(i);
            }
        });
    }

    private void initData() {
        mList.add(createItem("Test Notch", NotchTestActivity.class));
    }

    private Map<String, Object> createItem(String title, Class cl) {
        Map<String, Object> map = new HashMap<>();
        map.put("title", title);
        map.put("class", cl);
        return map;
    }

}
