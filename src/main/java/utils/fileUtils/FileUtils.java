package utils.fileUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class FileUtils {

    public static String readFile(String path,Charset charset) {
        String s = "";
        try (FileInputStream fis = new FileInputStream(path)) {
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            s = new String(bytes,charset);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return s;
    }

    public static String readFile(String path) {
        return readFile(path,Charset.defaultCharset());
    }

    public static String readFile(File file,Charset charset) {
        return readFile(file.getAbsolutePath(),charset);
    }

    public static String readFile(File file) {
        return readFile(file.getAbsolutePath(),Charset.defaultCharset());
    }

    public static synchronized void writeFile(String text, String path, boolean b) {
        //System.out.println(text);
        try (FileOutputStream writer = new FileOutputStream(path,b)) {
            //writer.write(text);
            writer.write(text.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void writeFile(List<String> texts, String path) {
        try {
            Files.deleteIfExists(Paths.get(path));
            for (String s : texts) {
                writeFile(s + "\n", path, true);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized <T> void writeFile(Map<String, T> texts, String path) {
        try {
            Files.deleteIfExists(Paths.get(path));
            for(Map.Entry<String,T> entry : texts.entrySet()) {
                String output = entry.getKey() + "~" + entry.getValue() + "\n";
                writeFile(output, path, true);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void writeFile(InputStream in, String path) throws IOException {
        int ch;
        try (FileOutputStream fos = new FileOutputStream(path, false)) {
            while ((ch = in.read()) != -1) {
                fos.write(ch);
            }
            in.close();
        }
    }

    public static synchronized void writeFile(byte[] bytes, String path) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(path, false)) {
            for (int i = 0; i < bytes.length; i++) {
                fos.write(bytes[i]);
            }
        }
    }

    public static synchronized void writeFile(String text, String path, boolean b, Charset charset) {
        //System.out.println(text);
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(path,b),charset)) {
            //writer.write(text);
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void removeFile(String fileName){
        if (fileExists(fileName)) {
            //System.out.println("deleting " + fileName);
            new File(fileName).delete();
        }
    }

    public static synchronized void renameFile(String oldFilename, String newFilename){
        if (fileExists(oldFilename)){
            removeFile(newFilename);
            new File(oldFilename).renameTo(new File(newFilename));
        }
    }

    public static boolean fileExists(String path) {
        File file = new File(path);
        if (file.exists()) {
            return true;
        }
        return false;
    }
}
