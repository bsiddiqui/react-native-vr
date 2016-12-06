package com.cdslabs.rnvr.reactnativevr;

import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.vr.sdk.widgets.common.VrWidgetView;
import com.google.vr.sdk.widgets.video.VrVideoEventListener;
import com.google.vr.sdk.widgets.video.VrVideoView;
import com.google.vr.sdk.widgets.video.VrVideoView.Options;

import java.io.IOException;

public class ReactNativeVrViewManager extends SimpleViewManager<FrameLayout> {

    public static final String REACT_CLASS = "RCTVrVideoView";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected VrVideoView createViewInstance(ThemedReactContext reactContext) {
        VrVideoView view = new VrVideoView(reactContext.getBaseContext());
        view.setEventListener(new ActivityEventListener());

        return view;
    }

    @ReactProp(name = "src")
    public void setSource(VrVideoView view, @Nullable String src) {
        Uri uri = Uri.parse(src);
        VideoLoader loader = new VideoLoader();
        view.setDisplayMode(VrWidgetView.DisplayMode.EMBEDDED);
        loader.setUri(uri);
        loader.setView(view);
        loader.execute();
        view.setVisibility(View.VISIBLE);
        view.setActivated(true);
    }

    private class ActivityEventListener extends VrVideoEventListener {
        @Override
        public void onLoadSuccess() {
            Log.d("VIDEO", "loaded");
        }

        @Override
        public void onLoadError(String error) {
            Log.d("VIDEO",  "Load error " + error);
        }


        @Override
        public void onNewFrame() {
            Log.d("VIDEO",  "New frame");
        }
    }

    private class VideoLoader extends AsyncTask<Void, Void, Boolean> {
        private Uri uri = null;
        private VrVideoView view = null;

        public void setUri(Uri uri) {
            this.uri = uri;
        }

        public void setView(VrVideoView view) {
            this.view = view;
        }

        protected Boolean doInBackground(Void... _) {
            try {
                Log.d("VIDEO", "Loading " + this.uri);
                Options options = new Options();
                options.inputType = Options.TYPE_MONO;
                this.view.loadVideo(uri, options);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }
    }
}
