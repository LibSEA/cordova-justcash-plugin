package com.loop46.justcash;
 
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

     public void pluginInitialize() {
             super.pluginInitialize();
             com.loop46.justcash.JustcashKt.init();
     }

     public boolean execute(String action, JSONArray args,
                     CallbackContext callbackContext) throws JSONException {
             callbackContext.success();
             return true;
     }
}
