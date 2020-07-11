package com.seanyj.utillib.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

public class ScreenUtil {
    public static int[] getScreenSize(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(dm);
        return new int[]{dm.widthPixels, dm.heightPixels};
    }

    public static int getScreenWidth(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    public static int[] getScreenSizeWithNavBar(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display defaultDisplay = windowManager.getDefaultDisplay();
        Point outPoint = new Point();
        defaultDisplay.getRealSize(outPoint);
        return new int[]{outPoint.x, outPoint.y};
    }

    public static int getStatusBarHeight(Activity activity) {
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect.top;
    }

    public int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    /**
     * 注意：这个方法的值必须等到页面创建完成后才能获取到。推荐写在onWindowFocusChanged（）方法中
     *
     * @param activity
     * @return
     */
    public static int getTitleBarHeight(Activity activity) {
        int contentTop = activity.getWindow().findViewById(Window.ID_ANDROID_CONTENT).getTop();
        int statusBarHeight = getStatusBarHeight(activity);
        return contentTop - statusBarHeight;
    }


    public static int getNavigationBarHeight(Context context) {
        int navigationBarHeight = -1;
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0) {
            navigationBarHeight = resources.getDimensionPixelSize(resourceId);
        }
        return navigationBarHeight;
    }

    /**
     * 注意：这个方法的值必须等到页面创建完成后才能获取到。推荐写在onWindowFocusChanged（）方法中
     *
     * @param activity
     * @return
     */
    public static int getContentViewHeight(Activity activity) {
        Rect rectangle = new Rect();
        activity.getWindow().findViewById(Window.ID_ANDROID_CONTENT).getDrawingRect(rectangle);
        return rectangle.height();
    }

    /**
     * 可以利用getScreenHeight() 与 getScreenHeight3() 返回值的差异来判断是否存在虚拟导航栏
     *
     * @param context
     * @return
     */
    public static boolean hasNavigationBar(Context context) {
        return getScreenSize(context)[1] != getScreenSizeWithNavBar(context)[1];
    }

}
