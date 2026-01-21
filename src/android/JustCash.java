package org.libsea.justcash;
 
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JustCash extends CordovaPlugin {
     public JustCash() {
     }

     public void initialize(CordovaInterface cordova, CordovaWebView webView) {
             super.initialize(cordova, webView);
     }

     public boolean execute(String action, JSONArray args,
                     CallbackContext callbackContext) throws JSONException {
             callbackContext.success(justcashlib.init());
             return true;
     }
}
