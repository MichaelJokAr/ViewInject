package org.compiler.inject;

import org.compiler.inject.provider.Provider;

/**
 * Created by JokAr on 16/8/6.
 */
public interface Inject<T> {

    void inject(T host, Object object, Provider provider);
}
