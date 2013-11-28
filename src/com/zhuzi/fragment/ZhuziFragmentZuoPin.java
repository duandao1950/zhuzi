package com.zhuzi.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.MenuItem.OnMenuItemClickListener;
import com.zhuzi.R;

public class ZhuziFragmentZuoPin extends SherlockFragment {
	
	public static ZhuziFragmentZuoPin newInstance() {
		ZhuziFragmentZuoPin fragment = new ZhuziFragmentZuoPin();
		return fragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment2, null);
		this.setHasOptionsMenu(true);
		return v;
	}
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		MenuItem add = menu.add("add");
		add.setIcon(R.drawable.menu_add_note);
		add.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		add.setOnMenuItemClickListener(new OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(getActivity(), "新建", Toast.LENGTH_LONG).show();
                return true;
            }
        });
        MenuItem search = menu.add("search");
        search.setIcon(R.drawable.menu_search);
        search.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        search.setOnMenuItemClickListener(new OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(getActivity(), "查找", Toast.LENGTH_LONG).show();
                return true;
            }
        });
        MenuItem sync = menu.add("sync");
        sync.setIcon(R.drawable.menu_sync);
        sync.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        sync.setOnMenuItemClickListener(new OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(getActivity(), "同步", Toast.LENGTH_LONG).show();
                return true;
            }
        });
		super.onCreateOptionsMenu(menu, inflater);
	}
}
