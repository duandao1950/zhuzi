package com.zhuzi.adapter;

import java.util.List;
import java.util.Map;

import com.zhuzi.R;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter {

	//列宽
	private int cWidth = 50;
	//水平间距
	private int hSpacing = 3;
	private Context context;
	private List<String> titleList;
	private Map<String,List<String>> titleContentMap;
	private GridViewAdapter adapter;

	public ListViewAdapter(Context context,List<String> titleList,Map<String,List<String>> titleContentMap) {
		this.context = context;
		this.titleList = titleList;
		this.titleContentMap = titleContentMap;
	}
	
	@Override
	public int getCount() {
		return titleList.size();
	}

	@Override
	public Object getItem(int position) {
		return titleList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return titleList.size();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup viewGroup) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = LayoutInflater.from(context).inflate(
					R.layout.list_item, viewGroup, false);
			holder.tv = (TextView) convertView.findViewById(R.id.tv);
			holder.gv = (GridView) convertView.findViewById(R.id.gridview);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		if(titleList != null){
			holder.tv.setText(titleList.get(position));
		}
		
		adapter = new GridViewAdapter(context,titleContentMap.get(titleList.get(position)));
		int count = adapter.getCount();
		
		//android.widget.RelativeLayout.LayoutParams params = new android.widget.RelativeLayout.LayoutParams(count * (48 + 10),30);
		LayoutParams params = new LayoutParams(count * (48 + 10),30);
		params.gravity = Gravity.CENTER_VERTICAL;  
		holder.gv.setLayoutParams(params);
		holder.gv.setGravity(Gravity.CENTER_VERTICAL);
		holder.gv.setColumnWidth(cWidth);
		//holder.gv.setHorizontalSpacing(hSpacing);
		//holder.gv.setStretchMode(GridView.NO_STRETCH);
		holder.gv.setStretchMode(3);
		holder.gv.setHorizontalSpacing(14);
		holder.gv.setVerticalSpacing(7);
		holder.gv.setNumColumns(count);
		holder.gv.setSelection(position);
		holder.gv.setAdapter(adapter);
		
		return convertView;
	}

	public static class ViewHolder {
		TextView tv;
		GridView gv;
	}
}
