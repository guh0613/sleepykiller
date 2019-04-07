package com.huaji.sleepykiller;
import android.content.*;
import android.os.*;
import java.util.*;
import android.widget.*;

public class Bark extends BroadcastReceiver
{
	public Vibrator vibrator;
	Context context;
	@Override
	public void onReceive(Context context, Intent intent)
	{
		vibrator=(Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
		Toast.makeText(context,"ok",2000).show();
		vibrator.vibrate(new long[]{1,3000,1,3000},0);
		
	}
	
	
}

