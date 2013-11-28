package com.zhuzi.adapter;

import java.util.List;


import com.zhuzi.ContentDetail;
import com.zhuzi.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnHoverListener;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class GridViewAdapter extends BaseAdapter {

	private List<String> gridTextList;
	private Context context;

	public GridViewAdapter(Context context,List<String> gridTextList){
		this.context = context;
		this.gridTextList = gridTextList;
	}
	
	@Override
	public int getCount() {
		return gridTextList.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return gridTextList.size();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		GViewHolder holder;
		if(convertView ==null){
			holder = new GViewHolder();
			convertView = LayoutInflater.from(context).inflate(R.layout.gridview_item, null, false);
			holder.tv = (TextView) convertView.findViewById(R.id.tv);
			convertView.setTag(holder);
		}else{
			holder = (GViewHolder) convertView.getTag();
		}
		
		if(gridTextList != null){
			holder.tv.setText(gridTextList.get(position));
		}
		
		holder.tv.setOnClickListener(new addIvonclickListener(holder.tv));
		
		//holder.tv.setOnHoverListener(new addIvonHoverListener());
		
		holder.tv.setOnHoverListener(new OnHoverListener() {
			@Override
			public boolean onHover(View v, MotionEvent event) {
				int what = event.getAction();  
                switch(what){  
                 case MotionEvent.ACTION_HOVER_ENTER:  //鼠标进入view  
                	 v.setBackgroundResource(R.drawable.con_btn_click_bg);
                     System.out.println("bottom ACTION_HOVER_ENTER");  
                     break;  
                 case MotionEvent.ACTION_HOVER_MOVE:  //鼠标在view上  
                	 v.setBackgroundResource(R.drawable.con_btn_click_bg);
                     System.out.println("bottom ACTION_HOVER_MOVE");  
                     break;  
                 case MotionEvent.ACTION_HOVER_EXIT:  //鼠标离开view  
                	 v.setBackgroundColor(Color.TRANSPARENT);
                     System.out.println("bottom ACTION_HOVER_EXIT");  
                     break;  
                }
                return false;  
			}
		});
		
		return convertView;
	}
		
	public static class GViewHolder{
		TextView tv;
	}
}

class addIvonclickListener implements OnClickListener{
	private TextView txtView;

	public addIvonclickListener(TextView txtView) {
		this.txtView = txtView;
	}

	public void onClick(View v) {
//		if (v.isTextAlignmentResolved()) {
//			v.setBackgroundResource(R.drawable.con_btn_click_bg);
//		} else {
//			v.setBackgroundColor(Color.TRANSPARENT);
//		}

		Intent intent = new Intent(v.getContext(), ContentDetail.class);
		intent.putExtra("name", txtView.getText().toString());
		//Toast.makeText(v.getContext(), "点我"+name, Toast.LENGTH_LONG).show();
		Activity activity = (Activity)v.getContext();
		activity.startActivity(intent); 
		//设置切换动画，从右边进入，左边退出,带动态效果
		activity.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
	}
}
