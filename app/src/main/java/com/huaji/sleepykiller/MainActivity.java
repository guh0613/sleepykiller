package com.huaji.sleepykiller;

import android.app.*;
import android.os.*;
import android.support.v7.widget.*;
import java.util.ArrayList;
import java.util.List;
import com.huaji.sleepykiller.*;
import android.support.design.widget.*;
import android.view.*;
import android.content.*;

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
		
		
	
		/*
		FloatingActionButton fab= ((FloatingActionButton) findViewById(R.id.contact_fab));
        fab.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					Intent intent = new Intent(MainActivity.this,AlarmOption.class);
					startActivity(intent);

				}
			});
		*/
    }
	private void Something()
	{
        
            AlarmTime one= new AlarmTime( "13:00");
			AlarmTime two= new AlarmTime("12:31");
            mList.add(one);
			mList.add(two);
        

	}
}
