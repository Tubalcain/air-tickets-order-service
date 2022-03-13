package io.restassured.internal.classpath;


public class ClassPathResolver {

    public static boolean existInCP(String className) {
        return existsInCP(className, Thread.currentThread().getContextClassLoader());
    }

    private static boolean existsInCP(String className, ClassLoader classLoader) {
        try {
            Class.forName(className, false, classLoader);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
