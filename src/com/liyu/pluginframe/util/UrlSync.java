package com.liyu.pluginframe.util;

import java.util.List;

import org.apache.http.NameValuePair;


import android.content.Context;
import android.os.Handler;

public class UrlSync implements IUrlSync {
	private String uri=null;
	private Context mainContext;
	private Context pluginContext;
	private String pluginActionStr;
	private String modth=GET;
	private String urlparam="";
	private List<NameValuePair> prarm=null;
	private String resultType=null;
	private String syncType=INFOSEND;
	private String appcode="";
	private String code=null;
	private boolean isNotice=false;
	private boolean needNotice=true;//是否设定
	
	private boolean isSync=false;
	
	private String noticeTitle="";
	private String noticeContent="";
	private String noticeCode="";
	
	private String toastContentSu=null;
	private String toastContentFa=null;
	private boolean isToast=true;
	
	private String result=null;
	private String userinfoparam=null;
	
	private Handler handler=null;
	
	// 通知列表
	
	private List<Notice> noticelist;
	
	public void setSync(){
		this.isSync=true;
	}
	@Override
	public String getResult() {
		return result;
	}
	@Override
	public void setResult(String result) {
		this.result = result;
	}
	@Override
	public boolean isGet(){
		if(GET.equals(this.modth)){
			return true;
		}
		return false;
	}
	@Override
	public String getUri() {
		return uri;
	}
	@Override
	public String getAppParam(){
//		GetSyncUrl.getUserParamByCode(maincode);
		return "";
	}
	@Override
	public String getAllUri(){
//		return null;
		return uri+getUserinfoparam()+(this.isSync?"&isSync=true":"")+getAppParam()+urlparam;
	}
	@Override
	public void setUri(String uri) {
			if(uri.indexOf(HTTP)!=0){
				this.uri=HTTP+uri;
			}else{
			this.uri = uri;
			}
		
	}
	@Override
	public String getModth() {
		return modth;
	}
	@Override
	public void setModth(String modth) {
		this.modth = modth;
	}

	
	@Override
	public String getResultType() {
		return resultType;
	}
	@Override
	public void setResultType(String resultType) {
		this.resultType = resultType;
	}
	@Override
	public String getSyncType() {
		return syncType;
	}
	@Override
	public void setSyncType(String syncType) {
		this.syncType = syncType;
	}

	
	@Override
	public String getCode() {
		return code;
	}
	@Override
	public void setCode(String code) {
		this.code = code;
	}

	
	
	public UrlSync() {
	}
	@Override
	public boolean isNotice() {
		return isNotice;
	}
	@Override
	public void setNotice(boolean isNotice) {
		this.isNotice = isNotice;
	}
	
	@Override
	public String getNoticeTitle() {
		return noticeTitle;
	}
	@Override
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	@Override
	public String getNoticeContent() {
		return noticeContent;
	}
	@Override
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	@Override
	public String getUrlparam() {
		return urlparam;
	}
	@Override
	public void setUrlparam(String urlparam) {
		if(urlparam==null){
			return;
		}
		this.urlparam = urlparam;
	}
	@Override
	public String getNoticeCode() {
		return noticeCode;
	}
	@Override
	public void setNoticeCode(String noticeCode) {
		this.noticeCode = noticeCode;
	}
	@Override
	public String getToastContentSu() {
		return toastContentSu;
	}
	@Override
	public void setToastContentSu(String toastContentSu) {
		this.toastContentSu = toastContentSu;
	}
	@Override
	public String getToastContentFa() {
		return toastContentFa;
	}
	@Override
	public void setToastContentFa(String toastContentFa) {
		this.toastContentFa = toastContentFa;
	}
	
	@Override
	public boolean isToast() {
		return isToast;
	}
	@Override
	public void setToast(boolean isToast) {
		this.isToast = isToast;
	}
	@Override
	public Handler getHandler() {
		return handler;
	}
	@Override
	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	@Override
	public List<NameValuePair> getPrarm() {
		return prarm;
	}
	@Override
	public void setPrarm(List<NameValuePair> prarm) {
		this.prarm = prarm;
	}
	@Override
	public List<Notice> getNoticelist() {
		return noticelist;
	}
	@Override
	public void setNoticelist(List<Notice> noticelist) {
		this.noticelist = noticelist;
	}

	@Override
	public boolean isNeedNotice() {
		return needNotice;
	}
	@Override
	public void setNeedNotice(boolean needNotice) {
		this.needNotice = needNotice;
	}

	@Override
	public void doResult() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Notice> getNotices() {
		// TODO Auto-generated method stub
		return noticelist;
	}

	@Override
	public String getAppcode() {
		return appcode;
	}
	@Override
	public void setAppcode(String appcode) {
		this.appcode = appcode;
	}

	@Override
	public void setMainContext(Context context) {
		// TODO Auto-generated method stub
		this.mainContext=context;
	}
	@Override
	public Context getMainContext() {
		// TODO Auto-generated method stub
		return this.mainContext;
	}

	@Override
	public void setPluginContext(Context context) {
		// TODO Auto-generated method stub
		this.pluginContext=context;
	}
	@Override
	public Context getPluginContext() {
		// TODO Auto-generated method stub
		return this.pluginContext;
	}
	@Override
	public String getUserinfoparam() {
		return userinfoparam;
	}
	@Override
	public void setUserinfoparam(String userinfoparam) {
		this.userinfoparam = userinfoparam;
	}
	@Override
	public String getPluginActionStr() {
		return pluginActionStr;
	}
	@Override
	public void setPluginActionStr(String pluginActionStr) {
		this.pluginActionStr = pluginActionStr;
	}
	
}
