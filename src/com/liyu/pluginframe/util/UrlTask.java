package com.liyu.pluginframe.util;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import com.mogu3.app.wei.R;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;



public  class UrlTask {

	private Thread th;
	private UrlSync urlSync;
	
	DefaultHttpClient client;
	HttpContext httpContext;
	HttpResponse httpResponse;
	HttpGet getMet;
	HttpPost postMet;
	private Handler mMainHandler;
	private Context context;
	long[] pattern = {100, 50, 400, 30}; // OFF/ON/OFF/ON... 
	
	public UrlTask(Context con)
	{
		this.context=con;
		mMainHandler = new Handler() {

			@Override
			public void handleMessage(Message msg) {

				// // 接收子线程的消息
				IUrlSync urlSync=(UrlSync)msg.obj;
				if(msg.arg1==1){
					if(urlSync.getNotices()!=null&&urlSync.getNotices().size()>0&&urlSync.isNeedNotice()){
						for (Notice notice : urlSync.getNotices()) {
							putNotic(notice.getId(),notice.getTitle(),notice.getContent(),notice.getCode());
						}
					}
					if(urlSync.isNotice()&&urlSync.isNeedNotice()){
//						MobclickAgent.reportError(context,urlSync.getNoticeTitle()+"_title_"+urlSync.getNoticeContent()+"_content_"+urlSync.getNoticeCode()+"_code_");
						putNotic(urlSync.getNoticeTitle(),urlSync.getNoticeContent(),urlSync.getNoticeCode());
						Vibrator vibrator = (Vibrator) urlSync.getMainContext().getSystemService(Service.VIBRATOR_SERVICE); 
						vibrator.vibrate(pattern, -1);
//						ring();
					}else{
						if(urlSync.isToast()){
							if(urlSync.getToastContentSu()!=null){
								
							Toast.makeText(context, urlSync.getToastContentSu(), 4000).show();
							}
						}else{
							if(urlSync.getToastContentFa()!=null){
								
								Toast.makeText(context, urlSync.getToastContentFa(), 4000).show();
								}
						}
					}
				}else{
					Toast.makeText(context, "网络不给力。", 4000).show();
				}
				
			}

		};
		 th = new Thread()
	        {
	        	public void run()
	        	{
	        		String strResult=null;
	        		try{
	        		getMet = null;
	        		postMet = null;
	        		if (urlSync.isGet()) {
	        			getMet = new HttpGet(urlSync.getAllUri());
	        		} else {
	        			postMet = new HttpPost(urlSync.getAllUri());
	        			postMet.setEntity(new UrlEncodedFormEntity(urlSync.getPrarm(),HTTP.UTF_8));
	        		}
	        		Log.e("request", urlSync.getAllUri());
	        		client = new DefaultHttpClient();
	        		httpContext=new BasicHttpContext(); 
	        		client.getParams().setParameter(
	        				CoreConnectionPNames.CONNECTION_TIMEOUT, 30000);
	        		client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 30000);
	        		client.getParams().setParameter(CoreProtocolPNames.USE_EXPECT_CONTINUE, false);
	        		
	        			if (urlSync.isGet()) {
	        				httpResponse = client.execute(getMet,httpContext);

	        			} else {
	        				httpResponse = client.execute(postMet,httpContext);
	        			}
	        			
	        			int statusCode=httpResponse.getStatusLine().getStatusCode();

	        			if (statusCode == 200) {
	        				// 取出回应字串
	        				

	        				strResult = EntityUtils.toString(httpResponse.getEntity());
	        				urlSync.setResult(strResult);
	    					urlSync.doResult();
	        			}else{
	        				
	        			}
//	        		String httpUrl = setUrl();
//	        		String strResult = "";
//	            	//获得的数据
//	            	HttpGet httpRequest = new HttpGet(httpUrl);
//	            	try
//	            	{
//	            		//构建一个HttpClient对象
//	            		HttpClient httpclient = new DefaultHttpClient();
//	            		//请求HttpClient，取得HttpResponse
//	            		HttpResponse httpResponse = httpclient.execute(httpRequest);
//	            		//请求成功
//	            		if(httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
//	            		{
//	            			//取得返回的字符串
//	            			strResult = EntityUtils.toString(httpResponse.getEntity());
//	            		}
//	             	}
	        		}
	            	catch (Exception e) 
	    			{
	    			}
	            	
	        	}
	        };
	}
	public void  start()
	{
		th.start();
	}
	public Handler getmMainHandler() {
		return mMainHandler;
	}
	public void setmMainHandler(Handler mMainHandler) {
		this.mMainHandler = mMainHandler;
	}
	public Context getContext() {
		return context;
	}
	public void setContext(Context context) {
		this.context = context;
	}
	public UrlSync getUrlSync() {
		return urlSync;
	}
	public void setUrlSync(UrlSync urlSync) {
		this.urlSync = urlSync;
	}
	public void putNotic( int id,String title, String content, String appcode) {
		if(title==null||content==null||"".equals(title)||"".equals(content)){
			return;
		}
		// int s=new Date().getSeconds();
		NotificationManager nm = (NotificationManager) this.context.getSystemService(Service.NOTIFICATION_SERVICE);
		Notification n = new Notification(R.drawable.moguico, content,
				System.currentTimeMillis());
		AudioManager am=(AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
		if(am.shouldVibrate(AudioManager.VIBRATE_TYPE_NOTIFICATION)&&am.shouldVibrate(AudioManager.VIBRATE_TYPE_RINGER)){
			n.defaults=Notification.DEFAULT_ALL;
		}else{
			n.defaults=Notification.DEFAULT_SOUND;
		}
		
		n.flags = Notification.FLAG_AUTO_CANCEL;
		PendingIntent contentIntent = PendingIntent.getActivity(urlSync.getMainContext(),
				R.string.app_name, getI(appcode),
				PendingIntent.FLAG_UPDATE_CURRENT);

		n.setLatestEventInfo(urlSync.getMainContext(), title, content, contentIntent);

		
		nm.notify(id, n);
	}
	public void putNotic( String title, String content, String appcode) {
		putNotic((new Long(System.currentTimeMillis())).intValue(),title,content,appcode);
	}
	public Intent getI(String code) {
		return new Intent(urlSync.getPluginActionStr());
	}
}
