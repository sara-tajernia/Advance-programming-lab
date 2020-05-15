//package ceit.aut.ac.ir.utils;

import javax.tools.JavaFileManager;
import java.io.*;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileUtils {

    private static final String NOTES_PATH = "./notes/";

    //It's a static initializer. It's executed when the class is loaded.
    //It's similar to constructor
    static {
        boolean isSuccessful = new File(NOTES_PATH).mkdirs();
        System.out.println("Creating " + NOTES_PATH + " directory is successful: " + isSuccessful);
    }

    public static File[] getFilesInDirectory() {
        return new File(NOTES_PATH).listFiles();
    }


//    public static String fileReader(File file){
//        System.out.println("file reader");
//        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
//            String line = bufferedReader.readLine();
//            while(line != null) {
//                System.out.println(line);
//                line = bufferedReader.readLine();
//            }
//        } catch (FileNotFoundException e) {
//            // Exception handling
//        } catch (IOException e) {
//            // Exception handling
//        }
//        return "";
//
//        //TODO: Phase1: read content from file
//    }

    public static void fileWriter(String content) {
        System.out.println("file writer");

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Note note = new Note("title", content, formatter.format(date));

        String fileName = getProperFileName(content);
        try(FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            String fileContent = note.toString();
            fileOutputStream.write(fileContent.getBytes());
        } catch (FileNotFoundException e) {
            // exception handling
        } catch (IOException e) {
            // exception handling
        }
        //TODO: write content on file
    }
    public static String fileReader(File file){
        System.out.println("file reader");
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line = bufferedReader.readLine();
            while(line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            // Exception handling
        } catch (IOException e) {
            // Exception handling
        }
        return "";
        //TODO: Phase1: read content from file
    }

    public static void writeOutputStream(String text){
        try(FileOutputStream fileOutputStream = new FileOutputStream(text)) {
            String fileContent = "This is a sample text.";
            fileOutputStream.write(fileContent.getBytes());
        } catch (FileNotFoundException e) {
            // exception handling
        } catch (IOException e) {
            // exception handling
        }
//    TODO: Phase1: define method here for reading file with InputStream
    }

    public static String  readInputStream(File file){
        try(FileInputStream fileInputStream = new FileInputStream(file)) {
            int ch = fileInputStream.read();
            while(ch != -1) {
                System.out.print((char)ch);
                ch = fileInputStream.read();
            }
        } catch (FileNotFoundException e) {
            // exception handling
        } catch (IOException e) {
            // exception handling
        }
        return "";
//    TODO: Phase1: define method here for writing file with OutputStream
    }



    //TODO: Phase2: proper methods for handling serialization

    private static String getProperFileName(String content) {
        int loc = content.indexOf("\n");
        if (loc != -1) {
            return content.substring(0, loc);
        }
        if (!content.isEmpty()) {
            return content;
        }
        return System.currentTimeMillis() + "_new file.txt";
    }
}
