package com.zhuzi;

import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

public class ContentDetail extends Activity {
	private String name = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// ��������
		setContentView(R.layout.content_detail);
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		//getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN ,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		name = getIntent().getStringExtra("name");
		//Toast.makeText(this,"�����ˣ�"+name, Toast.LENGTH_LONG).show();
		
		TextView textView = (TextView)findViewById(R.id.tv_shakeweiboitem_screenname);
		textView.setText("hello "+name);
		
		TextView time = (TextView)findViewById(R.id.tv_shakeweiboitem_time);
		time.setText(new Date().toLocaleString());
		
		TextView content = (TextView)findViewById(R.id.tv_shakeweiboitem_content);
		content.setText("The waterfall sing, 'I find my song, when I find my freedom.'");
		
		
		WebView webView = (WebView) findViewById(R.id.wv);
		webView.setWebViewClient(new WebViewClient() {
			@Override
			public void onReceivedError(WebView view, int errorCode,
					String description, String failingUrl) {
				// ��д onReceivedError���� ����Toast����ʾ
//				Toast.makeText(convertView., "Sorry!" + description,
//						Toast.LENGTH_LONG).show();
			}
		});
		
		// ��õ�ַ���������ַ
		//http://www.baidu.com/baidu?wd=%E7%8E%8B%E7%A3%8A
		String url = "http://www.baidu.com/baidu?wd="+name;
		// �ж��Ƿ�����ַ
		if (URLUtil.isNetworkUrl(url)) {
			webView.loadUrl(url);
		} else {
			Toast.makeText(this, "�Բ��� ���������ַ�д���",
					Toast.LENGTH_LONG).show();
			// �������ƶ���EditText
			webView.requestFocus();
		}
	}
	
	/**
	 * ���淵��
	 * 
	 * @param v
	 *            the v
	 */
	public void btn_back(View v) {
		finish();
		Activity activity = (Activity)v.getContext();
		activity.overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
	}
}
