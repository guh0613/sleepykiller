package com.huaji.sleepykiller;
import android.content.*;
import android.os.*;

public class Bark extends BroadcastReceiver
{
	public Vibrator vibrator;
	Context context;
	@Override
	public void onReceive(Context context, Intent intent)
	{
		vibrator=(Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
		vibrator.vibrate(new long[]{1000,3000,1000,3000},0);
	}
	
}
