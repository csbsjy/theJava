package com.jy.inflearn.thejava.mydifw;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ContainerService<T> {


    // 요청하는 타입의 인스턴스를 반환해준다.
    public static <T> T getObject(Class<T> classType) {
        Object instance = (Object) createInstance(classType);
        Arrays.stream(classType.getDeclaredFields())
                .filter(field -> field.getAnnotation(Inject.class) != null)
                .forEach(field -> {
                    field.setAccessible(true);
                    Object fieldInstance = createInstance(field.getType());
                    try {
                        field.set(instance, fieldInstance);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });

        return (T) instance;
    }

    private static Object createInstance(Class<?> classType) {
        Object object = null;
        try {
            Constructor constructor = classType.getConstructor(null);
            constructor.setAccessible(true);
            object = constructor.newInstance();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return object;
    }

}
