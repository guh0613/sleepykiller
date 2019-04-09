package com.huaji.sleepykiller;
import android.widget.*;
import java.util.*;
import android.content.*;
import android.view.*;

public class SomethingAdapter extends BaseAdapter {

    private LinkedList<Something> mData;
    private Context mContext;

    public SomethingAdapter(LinkedList<Something> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(mContext).inflate(R.layout.itemforsomething,parent,false);
        TextView txt_aName = (TextView) convertView.findViewById(R.id.item);
        txt_aName.setText(mData.get(position).getaName());
        return convertView;
    }
}
