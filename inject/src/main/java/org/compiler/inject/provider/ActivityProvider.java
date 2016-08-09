package org.compiler.inject.provider;

import android.app.Activity;
import android.content.Context;
import android.view.View;

/**
 * Created by JokAr on 16/8/6.
 */
public class ActivityProvider implements Provider {

    @Override
    public Context getContext(Object object) {
        return (Activity) object;
    }

    @Override
    public View findView(Object object, int id) {
        return ((Activity) object).findViewById(id);
    }
}
