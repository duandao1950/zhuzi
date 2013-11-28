package com.zhuzi.fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.actionbarsherlock.app.SherlockFragment;
import com.zhuzi.R;
import com.zhuzi.adapter.ListViewAdapter;

public class ZhuziFragmentRenWu extends SherlockFragment {
	private ListView mListView;
	private static List<String> titleList = new ArrayList<String>();
	private static Map<String,List<String>> titleContentMap = new HashMap<String,List<String>>();

	static{
		initTextData();
	}
	
	public static ZhuziFragmentRenWu newInstance() {
		ZhuziFragmentRenWu fragment = new ZhuziFragmentRenWu();
		return fragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.activity_horizontalscrollview, null);
		mListView = (ListView) v.findViewById(R.id.scroll_listview);
		ListViewAdapter adapter = new ListViewAdapter(container.getContext(),titleList,titleContentMap);
		mListView.setAdapter(adapter);
		return v;
	}
	
	public static void initTextData(){
		Random random = new Random();
		String[] titlestrings = {"ͷ��","����","����","�ƾ�","�Ƽ�","����","����","С˵","����","�ֻ�"};
		String[] contentstrings = {"����","��ʫʫ","ղķ˹","����","С��","����","��־ӱ","������","�����","��Ԯ"};
		
		for(int i = 0;i<titlestrings.length;i++){
			String[] contentstrings0 = new String[contentstrings.length];
			for(int j=0;j<titlestrings.length;j++){
				contentstrings0[j] = contentstrings[random.nextInt(contentstrings.length)];
			}
			titleList.add(titlestrings[i]);
			titleContentMap.put(titlestrings[i], Arrays.asList(contentstrings0));
		}
	}
}
