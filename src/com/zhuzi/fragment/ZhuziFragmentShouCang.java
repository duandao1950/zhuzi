package com.zhuzi.fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockFragment;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshHorizontalScrollView;
import com.zhuzi.R;
import com.zhuzi.adapter.ListViewAdapter;
import com.zhuzi.utils.Helper;

public class ZhuziFragmentShouCang extends SherlockFragment {
	private static final int[] STRINGS_WANGCHAO = { 1, 2, 3, 4,5,6,7,8,9,0};
	
	private static final String[] STRINGS_RENWU = { "Abbaye de Belloc", "Abbaye du Mont des Cats", "Abertam", "Abondance",
		"Ackawi", "Acorn", "Adelost", "Affidelice au Chablis", "Afuega'l Pitu", "Airag", "Airedale", "Aisy Cendre",
		"Allgauer Emmentaler", "Abbaye de Belloc", "Abbaye du Mont des Cats", "Abertam", "Abondance", "Ackawi",
		"Acorn", "Adelost", "Affidelice au Chablis", "Afuega'l Pitu", "Airag", "Airedale", "Aisy Cendre",
		"Allgauer Emmentaler" };
	
	ListView listView;
	
	PullToRefreshHorizontalScrollView mPullRefreshScrollView;
	HorizontalScrollView mScrollView;
	//private ViewPager mViewPager;
	
	private ListView mListView;
	private ArrayList<HashMap<String,Integer>> mList = new ArrayList<HashMap<String,Integer>>();
	private ArrayList<HashMap<String,Integer>> mGist = new ArrayList<HashMap<String,Integer>>();
	
	public static ZhuziFragmentShouCang newInstance() {
		ZhuziFragmentShouCang fragment = new ZhuziFragmentShouCang();
		return fragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//View v = inflater.inflate(R.layout.fragment4, null);
		
		View v = inflater.inflate(R.layout.activity_horizontalscrollview, null);
		
//		mPullRefreshScrollView = (PullToRefreshHorizontalScrollView) v.findViewById(R.id.pull_refresh_horizontalscrollview);
//		
//		mPullRefreshScrollView.setOnRefreshListener(new OnRefreshListener<HorizontalScrollView>() {
//
//			@Override
//			public void onRefresh(PullToRefreshBase<HorizontalScrollView> refreshView) {
//				new GetDataTask().execute();
//			}
//		});
//
//		mScrollView = mPullRefreshScrollView.getRefreshableView();
		
//		listView = (ListView) v.findViewById(R.id.listview);
//		setListViewHeightBasedOnChildren(listView);
		
//		mViewPager = (ViewPager) v.findViewById(R.id.vp_list);
//		mViewPager.setAdapter(new ListViewPagerAdapter());

//		listView = (ListView) v.findViewById(R.id.listview);
//		Context context = container.getContext();
//		listView.setAdapter(new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1, STRINGS));
//        Helper.getListViewSize(listView);
		
		mListView = (ListView) v.findViewById(R.id.scroll_listview);
		initData();
		Context context = container.getContext();
		//ListViewAdapter adapter = new ListViewAdapter(context, mList,mGist);
		//mListView.setAdapter(adapter);
		
		return v;
	}
	
	public void initData(){
		for(int i = 0;i<5;i++){
			HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
			hashmap.put("titlePicList", R.drawable.test);
			for(int j = 0;j<15;j++){
				HashMap<String, Integer> map = new HashMap<String, Integer>();
				map.put("gridPicList", R.drawable.ic_launcher);
				mGist.add(map);
			}
			mList.add(hashmap);
		}
	}
	
	private class GetDataTask extends AsyncTask<Void, Void, String[]> {

		@Override
		protected String[] doInBackground(Void... params) {
			// Simulates a background job.
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
			}
			return null;
		}

		@Override
		protected void onPostExecute(String[] result) {
			// Do some stuff here

			// Call onRefreshComplete when the list has been refreshed.
			mPullRefreshScrollView.onRefreshComplete();

			super.onPostExecute(result);
		}
	}
	
	/**
	 * 动态设置listView的高度
	 * 
	 * @param listView
	 */
	public static void setListViewHeightBasedOnChildren(ListView listView) {
		ListAdapter listAdapter = listView.getAdapter();
		if (listAdapter == null) {
			return;
		}

		int totalHeight = 50;
		for (int i = 0; i < listAdapter.getCount(); i++) {
			View listItem = listAdapter.getView(i, null, listView);
			listItem.measure(0, 0);
			totalHeight += listItem.getMeasuredHeight();
		}
		ViewGroup.LayoutParams params = listView.getLayoutParams();
		params.height = totalHeight
				+ (listView.getDividerHeight() * (listAdapter.getCount() - 1));
		// ((MarginLayoutParams) params).setMargins(10, 10, 10, 10);
		listView.setLayoutParams(params);
	}
}
