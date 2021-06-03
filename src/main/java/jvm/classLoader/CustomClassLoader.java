package jvm.classLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CustomClassLoader extends ClassLoader {

  /**
   * findClass方法用于根据指定类的binaryName来查找并组装成Class对象, 如果实现自定义类加载器必须覆写此方法，由loadClass方法调用
   */
  @Override
  protected Class<?> findClass (String name) throws ClassNotFoundException {
    byte[] b = loadClassData (name);
    // 根据字节码生成Class对象,native方法
    return defineClass (name, b, 0, b.length);
  }

  /**
   * 读取class文件
   */
  private byte[] loadClassData (String name) {
    try (InputStream is = new FileInputStream (new File (name + ".class"));
        ByteArrayOutputStream baos = new ByteArrayOutputStream ()) {
      int ch = 0;
      while (-1 != (ch = is.read ())) {
        baos.write (ch);
      }
      return baos.toByteArray ();
    } catch (IOException e) {
      e.printStackTrace ();
    }
    return null;
  }

  public static void main (String[] args) throws Exception {
    CustomClassLoader loader = new CustomClassLoader ();
    Class<?> clazz = loader.loadClass ("jvm.classLoader.Demo");
    Object object = clazz.newInstance ();
    // com.hicsc.classloader.Demo@5b2133b1
    System.out.println (object.toString ());
    // jdk.internal.loader.ClassLoaders$AppClassLoader@3d4eac69
    System.out.println (object.getClass ().getClassLoader ());
  }
}
