package clzloader;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;

public class CustomClassLoader extends ClassLoader {

    public static void main(String[] args) {
        try {
            Class<?> clz = new CustomClassLoader().findClass("Hello");
            Method hello = clz.getMethod("hello");
            hello.invoke(clz.newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) {
        File file = new File(this.getClass().getResource("Hello.xlass").getPath());
        int length = (int) file.length();
        byte[] data = new byte[length];

        try {
            new FileInputStream(file).read(data);
            for (int i = 0; i < data.length; i++) {
                data[i] = (byte) (255 - data[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defineClass(name, data,0, data.length);
    }
}
