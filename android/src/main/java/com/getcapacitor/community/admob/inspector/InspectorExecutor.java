package com.getcapacitor.community.admob.consent;

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
    public void showInspector(final PluginCall call, ) {
        try {
            MobileAds.openAdInspector(
            getContext(),
            new OnAdInspectorClosedListener() {
                public void onAdInspectorClosed(AdInspectorError error) {
                    // Error will be non-null if ad inspector closed due to an error.
                }
            });

        call.resolve();

        } catch (Exception ex) {
            call.reject(ex.getLocalizedMessage(), ex);
        }
    }
}