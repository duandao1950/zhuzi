package com.zhuzi.adapter;

import com.zhuzi.fragment.ZhuziFragmentWoMen;
import com.zhuzi.fragment.ZhuziFragmentShouCang;
import com.zhuzi.fragment.ZhuziFragmentRenWu;
import com.zhuzi.fragment.ZhuziFragmentWangChao;
import com.zhuzi.fragment.ZhuziFragmentZuoPin;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MainFragmentAdapter extends FragmentPagerAdapter {
	private String[] titleStr = {"�½��ʼ�","ȫ���ʼ�","�ʼǱ�","��Ƭ��תվ","����"};
	//private String[] titleStr = {"����","����","�ղ�","����","����"};
	public MainFragmentAdapter(FragmentManager fm) {
		super(fm);
	}
	
	public MainFragmentAdapter(FragmentManager fm,Context context) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		switch (position) {
		case 0:
			return ZhuziFragmentRenWu.newInstance();
		case 1:
			return ZhuziFragmentZuoPin.newInstance();
		case 2:
			return ZhuziFragmentWangChao.newInstance();
		case 3:
			return ZhuziFragmentShouCang.newInstance();
		case 4:
			return ZhuziFragmentWoMen.newInstance();
		}
		return null;
	}
	
	@Override
	public CharSequence getPageTitle(int position) {
		return titleStr[position];
	}
	
	@Override
	public int getItemPosition(Object object) {
		return POSITION_NONE;
	}
	
	@Override
	public int getCount() {
		return titleStr.length;
	}

}
