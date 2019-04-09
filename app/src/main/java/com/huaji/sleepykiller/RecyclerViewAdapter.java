package com.huaji.sleepykiller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import android.content.*;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<AlarmTime> mList;

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView titleTextView;
        LinearLayout linearLayout;

        public ViewHolder(View view){
            super(view);
            titleTextView=(TextView)view.findViewById(R.id.time);
			
            linearLayout=(LinearLayout)view.findViewById(R.id.layout);

        }
    }

    //传入展示数据,并且赋值给全局变量
    public RecyclerViewAdapter(List<AlarmTime> List){
        mList=List;
    }

    //创建ViewHolder实例,将item布局加载出来
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    //对RecyclerView的子项数据进行赋值
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        AlarmTime AlarmTime = mList.get(position);
        holder.titleTextView.setText(AlarmTime.getTime());
		
        //点击事件
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					int position=holder.getAdapterPosition();
					AlarmTime AlarmTime=mList.get(position);
					//Toast.makeText(v.getContext(),AlarmTime.getTime() + "当前位置" + position,Toast.LENGTH_SHORT).show();
					Intent intent = new Intent(v.getContext(),AlarmOption.class);
					v.getContext().startActivity(intent);

				}
			});
    }
    //获取RecyclerView有多少子项
    @Override
    public int getItemCount() {
        return mList.size();
    }
}