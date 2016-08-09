package org.compiler.inject.provider;

import android.content.Context;
import android.view.View;

/**
 * Created by JokAr on 16/8/6.
 */
public class ViewProvider implements Provider {
    @Override
    public Context getContext(Object object) {
        return ((View) object).getContext();
    }

    @Override
    public View findView(Object object, int id) {
        return ((View) object).findViewById(id);
    }
}
