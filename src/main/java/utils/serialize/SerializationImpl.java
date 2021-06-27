package utils.serialize;

import java.io.*;

public class SerializationImpl {

    public static void saveObject(Object o, String filename) {
        try(FileOutputStream fileOutputStream = new FileOutputStream(filename);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
            objectOutputStream.writeObject(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static Object loadObject(String filename) throws IOException {
        Object o = null;
        try(FileInputStream inputStream = new FileInputStream(filename);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)){
            o = objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return o;
    }
}
