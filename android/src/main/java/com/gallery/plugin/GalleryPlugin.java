package com.gallery.plugin;

import android.content.Intent;

import com.getcapacitor.JSObject;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;

@NativePlugin()
public class GalleryPlugin extends Plugin {

    @PluginMethod()
    public void echo(PluginCall call) {
        Boolean isMultiple = call.getBoolean("isMultiple");
        if(isMultiple){
            Intent intent = new Intent(getContext(),GalleryMainActivity.class);
            getActivity().startActivity(intent);
        }
//        JSObject ret = new JSObject();
//        ret.put("value", value);


//        call.success(ret);
    }
}
