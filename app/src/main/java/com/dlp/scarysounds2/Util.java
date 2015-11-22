package com.dlp.scarysounds2;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class Util {
	static public DisplayMetrics getDisplayMetrics(Context context) {
	    DisplayMetrics metrics = new DisplayMetrics();
	    WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
	    wm.getDefaultDisplay().getMetrics(metrics);

	    return metrics;
	  }
}
