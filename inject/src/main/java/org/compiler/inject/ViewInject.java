package org.compiler.inject;

import android.app.Activity;
import android.support.v4.util.ArrayMap;
import android.view.View;

import org.compiler.inject.provider.ActivityProvider;
import org.compiler.inject.provider.Provider;
import org.compiler.inject.provider.ViewProvider;

/**
 * Created by JokAr on 16/8/6.
 */
public class ViewInject {
    private static final ActivityProvider activityProvider = new ActivityProvider();

    private static final ViewProvider viewProvider = new ViewProvider();
    private static final ArrayMap<String, Inject> injectMap = new ArrayMap<>();

    public static void inject(Activity activity) {
        inject(activity, activity, activityProvider);
    }

    public static void inject(View view) {
        inject(view, view);
    }

    private static void inject(Object host, View view) {
        inject(host, view, viewProvider);
    }

    private static void inject(Object host, Object object, Provider provider) {
        String className = host.getClass().getName();
        try {
            Inject inject = injectMap.get(className);

            if (inject == null) {
                Class<?> aClass = Class.forName(className + "$$ViewInject");
                inject = (Inject) aClass.newInstance();
                injectMap.put(className, inject);
            }
            inject.inject(host, object, provider);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
