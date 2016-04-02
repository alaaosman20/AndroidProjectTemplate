package networks;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by admin on 4/2/2016.
 */
public class CheckingConnection {
    public static final int NOT_CONNECTED = 0;
    public static final int WIFI = 1;
    public static final int MOBILE = 2;

    public static int getConnectionStatus(Context context){
        ConnectivityManager connectivityManager =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if(networkInfo != null){
            if(networkInfo.getType() == ConnectivityManager.TYPE_WIFI){
                return WIFI;
            }
            if(networkInfo.getType() == ConnectivityManager.TYPE_MOBILE){
                return MOBILE;
            }
        }
        return NOT_CONNECTED;
    }

    public static boolean isOnline(Context context) {
        try {
            NetworkInfo localNetworkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
            if (localNetworkInfo != null) {
                boolean bool = localNetworkInfo.isConnectedOrConnecting();
                if (bool) {
                    return true;
                }
            }
        } catch (Exception ex) {}
        return false;
    }
}