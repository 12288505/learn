package learn;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.TrafficStats;
import android.util.Log;

public class getBytes extends Activity {

	public static void main(String[] arg) {

		// getBytes get = new getBytes();
		// get.getByte();
		System.out.println(TrafficStats.getTotalRxBytes() == TrafficStats.UNSUPPORTED ? 0
				: (TrafficStats.getTotalRxBytes() / 1024));
	}

	public void getByte() {

		Map<Integer, String> users = new TreeMap<Integer, String>();
		PackageManager packageManager = this.getPackageManager();

		// PackageManager packageManager = getPackageManager();
		for (ApplicationInfo info : packageManager.getInstalledApplications(0)) {
			int uid = info.uid;
			if (!users.containsKey(uid))
				users.put(uid, packageManager.getApplicationLabel(info).toString());
			// users.put(uid,
			// packageManager.getNameForUid(uid).split(":")[0]);
		}

		long totalRx = 0;
		long totalTx = 0;
		int i = 1;
		for (Entry<Integer, String> entry : users.entrySet()) {

			int uid = entry.getKey();
			String uidName = entry.getValue();

			System.out.println("[" + i + "]" + "uid----->" + uid + "uidName------>" + uidName + "\n");
			i++;
			long recv = TrafficStats.getUidRxBytes(uid);
			long sent = TrafficStats.getUidTxBytes(uid);
			System.out.println(recv);
			if (sent > 0) {
				// Log.v("tmp", "uid=" + uidName + " tx=" + sent);
				System.out.println("uid=" + uidName + " tx=" + sent);
				totalTx += sent;
			} else {
				System.out.println("暂时还未产生发送流量！");
			}
			if (recv > 0) {
				// Log.d("tmp", "uid=" + uidName + " rx=" + recv);
				System.out.println("uid=" + uidName + " rx=" + recv);
				totalRx += recv;
			} else {
				System.out.println("暂时还未产生接收流量！");
			}
		}
		Log.i("tmp", "totalRx sum=" + totalRx + " api=" + TrafficStats.getMobileRxBytes());
		Log.i("tmp", "totalTx sum=" + totalTx + " api=" + TrafficStats.getMobileTxBytes());
	}

}
