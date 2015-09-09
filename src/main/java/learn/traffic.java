package learn;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.TrafficStats;
import android.net.wifi.WifiManager;
import android.os.IBinder;
import android.text.format.Formatter;
import android.util.Log;

public class traffic extends Service {

	private TrafficReceiver tReceiver;
	private WifiManager wifiManager;
	private ConnectivityManager cManager;

	public IBinder onBind(Intent intent) {

		return null;
	}

	public void onCreate() {

		// WifiManager,ConnectivityManager
		wifiManager = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);
		cManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
		// 注册TrafficReceiver
		tReceiver = new TrafficReceiver();
		IntentFilter filter = new IntentFilter();
		filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
		filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
		registerReceiver(tReceiver, filter);
		super.onCreate();
	}

	public int onStartCommand(Intent intent, int flags, int startId) {

		return super.onStartCommand(intent, flags, startId);
	}

	private class TrafficReceiver extends BroadcastReceiver {

		private String action = "";
		private static final String TAG = "TrafficReceiver";
		long mobileRx;
		long mobileTx;

		public void onReceive(Context context, Intent intent) {

			action = intent.getAction();
			if (action.equals(WifiManager.WIFI_STATE_CHANGED_ACTION)) {
				if (wifiManager.getWifiState() == WifiManager.WIFI_STATE_DISABLING) {
					Log.i(TAG, "WIFI_STATE_DISABLING");
					long wifiDown = TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes();
					long wifiUp = TrafficStats.getTotalTxBytes() - TrafficStats.getMobileTxBytes();
					Log.i(TAG, "wifi下载流量" + Formatter.formatFileSize(context, wifiDown));
					Log.i(TAG, "wifi上传流量" + Formatter.formatFileSize(context, wifiUp));
				}
			} else if (action.equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
				Log.i(TAG, "CONNECTIVITY_ACTION");
				NetworkInfo networkInfo = cManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
				State state = networkInfo.getState();
				if (state == State.CONNECTED) {
					Log.i(TAG, "State.CONNECTED");
					// 开始不断获取最近的流量信息，值为0时，跳过
					new Thread() {

						public void run() {

							long mobileRxType = TrafficStats.getMobileRxBytes();
							long mobileTxType = TrafficStats.getMobileTxBytes();
							if (mobileRxType + mobileTxType != 0) {
								try {
									mobileRx = mobileRxType;
									mobileTx = mobileTxType;
									Log.i(TAG, "mobileRx：" + mobileRx);
									Log.i(TAG, "mobileTx：" + mobileTx);
									Thread.sleep(1000);
									run();
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						};
					}.start();
				}
			}
		}
	}

	public void onDestroy() {

		unregisterReceiver(tReceiver);
		super.onDestroy();
	}

	public static void main(String[] arg) {

		traffic tf = new traffic();
		tf.onDestroy();
	}
}
