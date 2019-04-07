package com.huaji.sleepykiller;

import android.app.*;
import android.os.*;
import java.util.*;
import android.widget.*;
import android.view.View.*;
import android.view.*;
import android.content.*;
import java.util.concurrent.*;
/*
public class MainActivity extends Activity 
{
	private Calendar calendar;
	private TextView Text;
	
	
	@Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		calendar = Calendar.getInstance();
		Text = (TextView)this.findViewById(R.id.Text);
		

		
    }
	public void settime(View v) {
		// TODO Auto-generated method stub
		calendar.setTimeInMillis(System.currentTimeMillis());
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
				@Override
				public void onTimeSet(TimePicker view, int hour, int minute) {
					calendar.setTimeInMillis(System.currentTimeMillis());
					//set(f, value) changes field f to value.
					calendar.set(Calendar.HOUR, hour);
					calendar.set(Calendar.MINUTE, minute);
					calendar.set(Calendar.SECOND, 0);
					calendar.set(Calendar.MILLISECOND, 0);
					Intent intent = new Intent(MainActivity.this, bark.class);
					intent.putExtra("music", true);
					PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, intent, 0);
					AlarmManager am;
					//获取系统进程
					am = (AlarmManager)getSystemService(ALARM_SERVICE);
					am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
					//设置周期！！
					am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+(10*1000), (24*60*60*1000), pendingIntent);
					String tmps = "设置闹钟时间为："+format(hour)+":"+format(minute);
					Text.setText(tmps);
				}
			},hour,minute,true).show();
	}
	
	
	public void Canceltime(View v)
	{
		Intent intent = new Intent(MainActivity.this, bark.class);
        intent.putExtra("music", true);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, intent, 0);
        AlarmManager am;
        //获取系统进程
        am = (AlarmManager)getSystemService(ALARM_SERVICE);
        //cancel
        am.cancel(pendingIntent);
        Text.setText("不搞了吗");
	}
	
	private String format(int x) {
		String s = ""+x;
		if(s.length() == 1)
			s = "0"+s;
		return s;
	}
}*/
public class MainActivity extends Activity {
	
	private Calendar calendar;
	private TextView Text;
    private List<Something> mData = null;
    private Context mContext;
    private SomethingAdapter mAdapter = null;
    private ListView list;
	private String time = "\r\n设置时间\r\n";
	private String music = "\r\n选择叫醒你的音乐\r\n";
	private String way = "\r\n选择...我也不知道，你来编\r\n";
	private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        intent = new Intent(MainActivity.this, Bark.class);
		mContext = MainActivity.this;
        list = (ListView) findViewById(R.id.LV);
        final LayoutInflater inflater = LayoutInflater.from(this);
		final View headView = inflater.inflate(R.layout.view_header, null, false);
		mData = new LinkedList<Something>();
        mData.add(new Something(time));
        mData.add(new Something("\r\n老子不搞了\r\n"));
        mData.add(new Something(music));
        mData.add(new Something(way));
        mData.add(new Something("nothing"));
        mAdapter = new SomethingAdapter((LinkedList<Something>) mData, mContext);
        list.addHeaderView(headView);
		list.setAdapter(mAdapter);
		list.setOnItemClickListener(new AdapterView.OnItemClickListener()
			{
				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id)
				{
					if(position==1)
					{
						
						calendar = Calendar.getInstance();
						calendar.setTimeInMillis(System.currentTimeMillis());
						int hour = calendar.get(Calendar.HOUR_OF_DAY);
						int minute = calendar.get(Calendar.MINUTE);
						new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener()
						{
								@Override
								public void onTimeSet(TimePicker view, int hourOfDay, int minute)
								{
									calendar.setTimeInMillis(System.currentTimeMillis());
									//set(f, value) changes field f to value.
									calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
									calendar.set(Calendar.MINUTE, minute);
									calendar.set(Calendar.SECOND, 0);
									calendar.set(Calendar.MILLISECOND, 0);
									
									intent.putExtra("music", true);
									PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, intent, 0);
									AlarmManager am;
									//获取系统进程
									am = (AlarmManager)getSystemService(ALARM_SERVICE);
									am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
									//设置周期！！
									am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+(10*1000), (24*60*60*1000), pendingIntent);
									String tmps = format(hourOfDay)+":"+format(minute);
									Toast.makeText(MainActivity.this,tmps,2000).show();
									tmps = "你设置的时间是\r\n" + tmps;
									Text = (TextView) headView.findViewById(R.id.settime);
									Text.setText(tmps);
									
								}
						},hour,minute,true).show();
					}
					if(position == 2)
					{
						Intent intent = new Intent(MainActivity.this, Bark.class);
        				intent.putExtra("music", true);
        				PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, intent, 0);
        				AlarmManager am;
        				//获取系统进程
        				am = (AlarmManager)getSystemService(ALARM_SERVICE);
        				//cancel
        				am.cancel(pendingIntent);
       					Toast.makeText(mContext,"给你取消了",2000).show();
						Text = (TextView) headView.findViewById(R.id.settime);
						Text.setText("不搞了吗");
					
					}
					if(position == 3||position==4||position==5)
					{
						Toast.makeText(mContext,"老子没想好",2000).show();
					}
					
						
				}
			}
		);
    }
	private String format(int x)
	{
		String s = ""+x;
		if(s.length() == 1)
		s = "0"+s;
		return s;
	}

}

