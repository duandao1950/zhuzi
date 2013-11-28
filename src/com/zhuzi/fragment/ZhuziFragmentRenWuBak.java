package com.zhuzi.fragment;

import java.util.Arrays;
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
import android.widget.ListAdapter;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockFragment;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.zhuzi.R;

public class ZhuziFragmentRenWuBak extends SherlockFragment {
	private static final String[] STRINGS = { "Abbaye de Belloc", "Abbaye du Mont des Cats", "Abertam", "Abondance",
		"Ackawi", "Acorn", "Adelost", "Affidelice au Chablis", "Afuega'l Pitu", "Airag", "Airedale", "Aisy Cendre",
		"Allgauer Emmentaler", "Abbaye de Belloc", "Abbaye du Mont des Cats", "Abertam", "Abondance", "Ackawi",
		"Acorn", "Adelost", "Affidelice au Chablis", "Afuega'l Pitu", "Airag", "Airedale", "Aisy Cendre",
		"Allgauer Emmentaler" };

	private ViewPager mViewPager;

	public static ZhuziFragmentRenWu newInstance() {
		ZhuziFragmentRenWu fragment = new ZhuziFragmentRenWu();
		return fragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.activity_ptr_list_in_vp, null);
		
		mViewPager = (ViewPager) v.findViewById(R.id.vp_list);
		mViewPager.setAdapter(new ListViewPagerAdapter());
		return v;
	}
	
	private class ListViewPagerAdapter extends PagerAdapter {

		@Override
		public View instantiateItem(ViewGroup container, int position) {
			Context context = container.getContext();

			PullToRefreshListView plv = (PullToRefreshListView) LayoutInflater.from(context).inflate(
					R.layout.layout_listview_in_viewpager, container, false);

			ListAdapter adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1,
					Arrays.asList(STRINGS));
			plv.setAdapter(adapter);

			//plv.setOnRefreshListener(PullToRefreshListInViewPagerActivity.this);

			ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);  
			
	        List<RunningTaskInfo> runningTasks = am.getRunningTasks(1);  
	  
	        RunningTaskInfo rti = runningTasks.get(0);  
	        ComponentName component = rti.topActivity;  
	  
	        Log.i("tracy", component.getClassName());  
			// Now just add ListView to ViewPager and return it
			container.addView(plv, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

			return plv;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == object;
		}

		@Override
		public int getCount() {
			return 3;
		}

	}

	public void onRefresh(PullToRefreshBase<ListView> refreshView) {
		new GetDataTask(refreshView).execute();
	}

	private static class GetDataTask extends AsyncTask<Void, Void, Void> {

		PullToRefreshBase<?> mRefreshedView;

		public GetDataTask(PullToRefreshBase<?> refreshedView) {
			mRefreshedView = refreshedView;
		}

		@Override
		protected Void doInBackground(Void... params) {
			// Simulates a background job.
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			mRefreshedView.onRefreshComplete();
			super.onPostExecute(result);
		}
	}
}
