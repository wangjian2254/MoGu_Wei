package com.mogu3.mainapp.db;

import android.content.Context;

public class DBhelper {
	
	private static ActiveUserHelper activeUserHelper=null;
	
	private DBhelper( Context context){
		
	}
	
	public static ActiveUserHelper getDBHelper(Context context){
		if(activeUserHelper==null){
			synchronized (DBhelper.class) {
				if(activeUserHelper==null){
					activeUserHelper=new ActiveUserHelper(context);
				}
			
			}
		}
		return activeUserHelper;
	}

}
