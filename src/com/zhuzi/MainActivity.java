package com.zhuzi;

import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.viewpagerindicator.TabPageIndicator;
import com.zhuzi.adapter.MainFragmentAdapter;

public class MainActivity extends SherlockFragmentActivity {
	private View mainActionBarView;
	private FragmentPagerAdapter adapter;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initActionBar();
		initViews();
	}

	private void initViews() {
		adapter = new MainFragmentAdapter(getSupportFragmentManager(),this);
		ViewPager pager = (ViewPager)findViewById(R.id.pager);
		pager.setAdapter(adapter);
		
		TabPageIndicator indicator = (TabPageIndicator) findViewById(R.id.indicator);
		indicator.setViewPager(pager);
	}

	/**
	 * 
	 */
	private void initActionBar() {
		//可以自定义actionbar
		getSupportActionBar().setDisplayShowCustomEnabled(true);
		getSupportActionBar().setDisplayShowTitleEnabled(false);
		//不在actionbar显示logo
		getSupportActionBar().setDisplayShowHomeEnabled(false);
		
		getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_tab_bg));
		mainActionBarView = LayoutInflater.from(this).inflate(R.layout.main_action_bar, null);
		getSupportActionBar().setCustomView(mainActionBarView);
	}
}