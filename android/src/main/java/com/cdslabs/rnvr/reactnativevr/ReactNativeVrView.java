package com.cdslabs.rnvr.reactnativevr;

import android.util.Log;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.google.vr.sdk.widgets.video.VrVideoEventListener;
import com.google.vr.sdk.widgets.video.VrVideoView;

public class ReactNativeVrView extends VrVideoView implements LifecycleEventListener {
    private final ReactContext context;

    public ReactNativeVrView(ReactContext context) {
        super(context.getBaseContext());

        this.context = context;
        this.context.addLifecycleEventListener(this);
    }

    @Override
    public void onHostResume() {
        this.resumeRendering();
        this.playVideo();
    }

    @Override
    public void onHostPause() {
        this.pauseRendering();
        this.pauseVideo();
    }

    @Override
    public void onHostDestroy() {
        this.pauseRendering();
        this.shutdown();
    }
}
