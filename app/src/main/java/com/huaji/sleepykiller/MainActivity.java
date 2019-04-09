package com.huaji.sleepykiller;

import android.app.*;
import android.os.*;
import android.support.v7.widget.*;
import java.util.ArrayList;
import java.util.List;
import com.huaji.sleepykiller.*;

public class MainActivity extends Activity 
{
    private RecyclerView recyclerView;
	private RecyclerViewAdapter adapter;
	private List<AlarmTime> mList=new ArrayList<>();
	@Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		Something();
		recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new RecyclerViewAdapter(mList);
        recyclerView.setAdapter(adapter);
    }
	private void Something()
	{
        
            AlarmTime one= new AlarmTime( "13:00");
            mList.add(one);
        

	}
}
