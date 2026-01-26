package com.loop46.justcash;

import org.apache.commons.codec.binary.Base64;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

import java.util.List;

public class JustCash extends CordovaPlugin {
     public JustCash() {
     }

     public void pluginInitialize() {
             super.pluginInitialize();
             JustcashKt.init();
     }

     public boolean execute(String action, JSONArray args,
                     CallbackContext callbackContext) throws JSONException {
         if ("prove".equals(action)) {
             JSONObject input = args.getJSONObject(0);
             JSONArray hashes = input.getJSONArray("hashes");
             List<byte[]> hashes2 = new ArrayList<byte[]>();

             for (int i = 0; i < hashes.length(); i++) {
                 hashes2.add(Base64.decodeBase64(hashes.getString(i)));
             }

             byte[] directions = Base64.decodeBase64(input.getString("directions"));
             byte[] sk = Base64.decodeBase64(input.getString("sk"));
             byte[] nk = Base64.decodeBase64(input.getString("nk"));

             Input input2 = new Input(
                     hashes2,
                     directions,
                     sk,
                     nk
             );
             try {
                 JustcashKt.prove(input2);
             } catch (ProveException e) {
                 callbackContext.error(e.getMessage());
                 return false;
             }
             callbackContext.success();
             return true;
         }
         return false;
     }
}

