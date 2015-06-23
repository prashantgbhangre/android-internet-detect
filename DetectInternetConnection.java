package com.prashantb.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by Prashant Bhangare
 *  
 * Manifest Permission 
 * <uses-permission android:name="android.permission.INTERNET" /> 
 * <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" /> 
 * 
 * Call From Java File
 * 
 * DetectInternetConnection mDetectInternetConnection = new DetectInternetConnection(getApplicationContext());
 * mDetectInternetConnection is returns true or false
 *  
 */

public class DetectInternetConnection {

	private Context mContext;

	public DetectInternetConnection(Context c) {
		this.mContext = c;
	}

	public boolean isConnectionToInternet() {

		boolean status = false;
		ConnectivityManager connect = (ConnectivityManager) mContext
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (connect != null) {
			NetworkInfo[] info = connect.getAllNetworkInfo();
			if (info != null) {
				for (int i = 0; i < info.length; i++) {
					if (info[i].getState() == NetworkInfo.State.CONNECTED)
						status = true;
				}
			}
		}
		if (!status) {
			Toast.makeText(mContext, "Internet is not connected !!!",
					Toast.LENGTH_SHORT).show();
		}
		return status;
	}
}
