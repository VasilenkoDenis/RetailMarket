package ua.com.ics_market.easyscale;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.wifi.WifiManager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


/**
 * Created by vasilenkoden on 14.02.2017.
 */


class ScaleClass {

    private Context context;
    private String url;
    private String result;

public ScaleClass (Context context){

  this.context = context;

}

// Constructor
public int getAccessPointInfo (){

    WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
    DhcpInfo dhcpInfo = wifiManager.getDhcpInfo();
    //WifiInfo  wifiInfo = wifiManager.getConnectionInfo();

    return dhcpInfo.gateway;
}

//Setter
public void setURL(String url){

    this.url = url;
}

public void sendReuest (final VolleyCallback callback) {

    RequestQueue queue = Volley.newRequestQueue(context);


    // Request a string response from the provided URL.
    StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

        @Override

        public void onResponse(String response) {
            result = response;
            callback.onSuccess(result);

        }
    }, new Response.ErrorListener() {

        @Override
        public void onErrorResponse(VolleyError error) {
            result = error.getMessage();
            callback.onError(result);
        }
});

    queue.add(stringRequest);
}

    public interface VolleyCallback{
        void onSuccess(String result);
        void onError(String error);
    }
}

