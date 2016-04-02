package networks;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class WifiConnection {
    private static Context context;

    public WifiConnection(Context context) {
        this.context = context;
    }

    public static boolean isWiFiConnected(Context context)
    {
        ConnectivityManager connectivityManager =
                (ConnectivityManager)context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null)
        {
            NetworkInfo[] arrayOfNetworkInfo = connectivityManager.getAllNetworkInfo();
            if (arrayOfNetworkInfo != null) {
                for (int i = 0; i < arrayOfNetworkInfo.length; i++) {
                    if ((arrayOfNetworkInfo[i].getTypeName().equals("WIFI")) && (arrayOfNetworkInfo[i].isConnected())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}