package com.cdslabs.rnvr.reactnativevr;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.vr.sdk.widgets.video.VrVideoView;
import com.google.vr.sdk.widgets.video.VrVideoView.Options;

public class ReactNativeVrViewManager extends SimpleViewManager<ReactNativeVrView> {

    public static final String REACT_CLASS = "RCTVrVideoView";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected ReactNativeVrView createViewInstance(ThemedReactContext reactContext) {
        return new ReactNativeVrView(reactContext);
    }

    @ReactProp(name = "src")
    public void setSrc(VrVideoView view, ReadableMap src) {
        Uri uri = Uri.parse(src.getString("uri"));
        VideoLoader loader = new VideoLoader();
        Options options = new Options();

        options.inputType = src.getInt("type");
        options.inputFormat = src.getInt("format");

        loader.setUri(uri);
        loader.setOptions(options);
        loader.setView(view);

        loader.execute();
    }

    @ReactProp(name = "displayMode")
    public void setDisplayMode(VrVideoView view, Integer mode) {
        view.setDisplayMode(mode);
    }

    @ReactProp(name = "paused")
    public void setPaused(VrVideoView view, Boolean paused) {
        if (paused == true) {
            view.pauseVideo();
        } else {
            view.playVideo();
        }
    }

    private class VideoLoader extends AsyncTask<Void, Void, Boolean> {
        private Uri uri = null;
        private VrVideoView view = null;
        private Options options = null;

        public void setUri(Uri uri) {
            this.uri = uri;
        }

        public void setView(VrVideoView view) {
            this.view = view;
        }

        public void setOptions(Options options) {
            this.options = options;
        }

        protected Boolean doInBackground(Void... _) {
            try {
                this.view.loadVideo(this.uri, this.options);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }
    }
}
