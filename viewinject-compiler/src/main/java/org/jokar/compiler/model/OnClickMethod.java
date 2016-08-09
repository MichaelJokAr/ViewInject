package org.jokar.compiler.model;


import com.annotation.OnClick;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Name;
import javax.lang.model.element.VariableElement;

/**
 * Created by JokAr on 16/8/8.
 */
public class OnClickMethod {
    private ExecutableElement mExecutableElement;
    private int[] resIds;
    private Name mMethodName;

    public OnClickMethod(Element element) throws IllegalArgumentException {
        if (element.getKind() != ElementKind.METHOD) {
            throw new IllegalArgumentException(
                    String.format("Only methods can be annotated with @%s",
                            OnClick.class.getSimpleName()));
        }

        mExecutableElement = (ExecutableElement) element;

        resIds = mExecutableElement.getAnnotation(OnClick.class).value();

        if (resIds == null) {
            throw new IllegalArgumentException(String.format("Must set valid ids for @%s",
                    OnClick.class.getSimpleName()));
        } else {
            for (int id : resIds) {
                if (id < 0) {
                    throw new IllegalArgumentException(String.format("Must set valid id for @%s",
                            OnClick.class.getSimpleName()));
                }
            }
        }
        mMethodName = mExecutableElement.getSimpleName();
        List<? extends VariableElement> parameters = mExecutableElement.getParameters();

        if (parameters.size() > 0) {
            throw new IllegalArgumentException(
                    String.format("The method annotated with @%s must have no parameters",
                            OnClick.class.getSimpleName()));
        }
    }

    /**
     * 获取方法名称
     * @return
     */
    public Name getMethodName() {
        return mMethodName;
    }

    /**
     * 获取id数组
     * @return
     */
    public int[] getResIds() {
        return resIds;
    }
}
