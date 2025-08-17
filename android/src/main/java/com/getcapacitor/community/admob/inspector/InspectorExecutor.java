package com.getcapacitor.community.admob.inspector;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import androidx.core.util.Supplier;
import com.getcapacitor.JSArray;
import com.getcapacitor.JSObject;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.community.admob.models.Executor;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.ump.ConsentDebugSettings;
import com.google.android.ump.ConsentForm;
import com.google.android.ump.ConsentInformation;
import com.google.android.ump.ConsentRequestParameters;
import com.google.android.ump.FormError;
import com.google.android.ump.UserMessagingPlatform;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdInspectorError;
import com.google.android.gms.ads.OnAdInspectorClosedListener;

public class InspectorExecutor extends Executor {

    

    public InspectorExecutor(
        Supplier<Context> contextSupplier,
        Supplier<Activity> activitySupplier,
        BiConsumer<String, JSObject> notifyListenersFunction,
        String pluginLogTag
    ) {
        super(contextSupplier, activitySupplier, notifyListenersFunction, pluginLogTag, "InspectorExecutor");
    }

    @PluginMethod
    public void showInspector(final PluginCall call) {
        try {

            activitySupplier.get().runOnUiThread(
                    new Runnable() {
                        @Override
                        public void run() {
                            MobileAds.openAdInspector(
                                    contextSupplier.get(),
                                    new OnAdInspectorClosedListener() {
                                        public void onAdInspectorClosed(AdInspectorError error) {
                                            // Error will be non-null if ad inspector closed due to an error.
                                        }
                                    });

                            call.resolve();
                        }
                    }
            );


        } catch (Exception ex) {
            call.reject(ex.getLocalizedMessage(), ex);
        }
    }
}