package com.cdslabs.rnvr.reactnativevr;

import android.widget.Toast;

import com.facebook.react.bridge.ObjectAlreadyConsumedException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import com.google.vr.sdk.widgets.common.VrWidgetView;
import com.google.vr.sdk.widgets.video.VrVideoView;

import java.util.HashMap;
import java.util.Map;

public class ReactNativeVrModule extends ReactContextBaseJavaModule {

    private static final String DURATION_SHORT_KEY = "SHORT";
    private static final String DURATION_LONG_KEY = "LONG";
    private static final String TEST_KEY = "TEST";

    public ReactNativeVrModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "RNVrModule";
    }

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        final Map<String, Object> displayModes = new HashMap<>();
        final Map<String, Object> types = new HashMap<>();
        final Map<String, Object> formats = new HashMap<>();

        displayModes.put("EMBEDDED", VrVideoView.DisplayMode.EMBEDDED);
        displayModes.put("FULLSCREEN_MONO", VrVideoView.DisplayMode.FULLSCREEN_MONO);
        displayModes.put("FULLSCREEN_STEREO", VrVideoView.DisplayMode.FULLSCREEN_STEREO);

        types.put("MONO", VrVideoView.Options.TYPE_MONO);
        types.put("STEREO_OVER_UNDER", VrVideoView.Options.TYPE_STEREO_OVER_UNDER);

        formats.put("DEFAULT", VrVideoView.Options.FORMAT_DEFAULT);
        formats.put("HLS", VrVideoView.Options.FORMAT_HLS);

        constants.put("DISPLAY_MODE", displayModes);
        constants.put("TYPE", types);
        constants.put("FORMAT", formats);

        return constants;
    }
}