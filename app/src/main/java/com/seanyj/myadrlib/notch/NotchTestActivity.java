package com.seanyj.myadrlib.notch;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import com.seanyj.myadrlib.R;
import com.seanyj.utillib.notch.INotchScreen;
import com.seanyj.utillib.notch.NotchScreenManager;

public class NotchTestActivity extends AppCompatActivity {
    private NotchScreenManager notchScreenManager = NotchScreenManager.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 设置Activity全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_notch_test);

        // 支持显示到刘海区域
        notchScreenManager.setDisplayInNotch(this);
        // 获取刘海屏信息
        notchScreenManager.getNotchInfo(this, new INotchScreen.NotchScreenCallback() {
            @Override
            public void onResult(INotchScreen.NotchScreenInfo notchScreenInfo) {
                Log.i("hello", "Is this screen notch? " + notchScreenInfo.hasNotch);
                if (notchScreenInfo.hasNotch) {
                    for (Rect rect : notchScreenInfo.notchRects) {
                        Log.i("hello", "notch screen Rect =  " + rect.toShortString());
                        // 将被遮挡的TextView下移
//                        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) textView.getLayoutParams();
//                        layoutParams.topMargin = rect.bottom;
//                        textView.setLayoutParams(layoutParams);
                    }
                }
            }
        });
    }
}
