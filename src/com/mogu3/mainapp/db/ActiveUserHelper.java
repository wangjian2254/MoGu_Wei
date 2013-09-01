package com.mogu3.mainapp.db;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ActiveUserHelper extends SQLiteOpenHelper {
	private static final String DB_NAME="weiDB";
	public static final String username="username";
	public static final String password="password";
	public static final String key="id";
	public ActiveUserHelper(Context context) {
		super(context, DB_NAME, null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO 创建必要表
		
		try{
			db.execSQL("CREATE TABLE userinfo (id INTEGER PRIMARY KEY AUTOINCREMENT,username TEXT,password TEXT,writepwd TEXT,isactive TEXT,updateTime TEXT,lastUpdate TEXT);");
		}catch(Exception e){
			e.getMessage();
		}
		
	}
//	private void onUpdate(SQLiteDatabase db){
//		db.execSQL("CREATE TABLE photoLib (id INTEGER PRIMARY KEY AUTOINCREMENT,code TEXT,lib TEXT,groupid TEXT,type TEXT,username TEXT,isDown INTEGER,appid TEXT,var Integer);");
//		db.execSQL("CREATE TABLE photoGroup (id INTEGER PRIMARY KEY AUTOINCREMENT,groupid Text ,name TEXT,username TEXT);");
//		db.execSQL("CREATE TABLE content (id INTEGER PRIMARY KEY AUTOINCREMENT,code TEXT,maincode TEXT,username TEXT,content TEXT,title TEXT,updateSpanTime TEXT,status TEXT,level TEXT,father TEXT,replyType TEXT,type TEXT,lastUpdateTime TEXT,readstatus TEXT);");
//		db.execSQL("CREATE TABLE contentread (id INTEGER PRIMARY KEY AUTOINCREMENT,code TEXT,username TEXT,contentid INTEGER);");
//		db.execSQL("create table app (id INTEGER PRIMARY KEY AUTOINCREMENT,username TEXT,code TEXT,appid TEXT,url TEXT);");
//		db.execSQL("create table userapp (id INTEGER PRIMARY KEY AUTOINCREMENT,username TEXT,code TEXT,appparm TEXT,infoallUpdateTime TEXT,infoallTimeNum INTEGER,infoupdateUpdateTime TEXT,infoupdateTimeNum INTEGER );");
//		db.execSQL("CREATE TABLE photo (id INTEGER PRIMARY KEY AUTOINCREMENT,code TEXT,lib TEXT,type TEXT,username TEXT,isDown INTEGER,appid TEXT,contentcode TEXT,status TEXT);");
//		db.execSQL("CREATE TABLE appverson (id INTEGER PRIMARY KEY AUTOINCREMENT,verson TEXT,newverson TEXT,uri TEXT);");
//		db.execSQL("insert into appverson (id,verson,newverson) values (1,'"+Convert.APP_VERSON+"','"+Convert.APP_VERSON+"');");
//	}
	

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}

}
