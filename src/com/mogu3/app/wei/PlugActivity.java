package com.mogu3.app.wei;




import com.mogu3.mainapp.db.DBhelper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.SQLException;
import android.net.Uri;
import android.os.Bundle;

/**
 * 
 * 插件所提供的功能，必须是Activity的子类
 *
 * @author hangxin1940@gmail.com
 *
 */
public class PlugActivity extends Activity {
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    /**
     * 每一个插件方法有且只有一个Context参数传入
     * @param context
     */
    public void callPhone(Context context){
//    	Uri uri = Uri.parse("tel:10086");
//    	Intent it = new Intent(Intent.ACTION_DIAL, uri);  
//    	context.startActivity(it);
    	try {
			DBhelper.getDBHelper(context.createPackageContext("com.mogu3.app.wei", Context.CONTEXT_IGNORE_SECURITY)).getWritableDatabase().execSQL("select * from  userinfo ;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    /**
     * 每一个插件方法有且只有一个Context参数传入
     * @param context
     */
    public void callWeb(Context context){
//    	Uri uri = Uri.parse("http://hangxin1940.cnblogs.com");
//    	Intent it  = new Intent(Intent.ACTION_VIEW,uri);
//    	context.startActivity(it);
    	try {
			DBhelper.getDBHelper(context.createPackageContext("com.mogu3.app.wei", Context.CONTEXT_IGNORE_SECURITY)).getWritableDatabase().execSQL("insert into userinfo (username) values ('wei2');");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}