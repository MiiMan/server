package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class File {

    public static boolean write(String filename, String text) {
        try(FileWriter writer = new FileWriter(filename, false))
        {
            writer.write(text);
            writer.flush();
            return true;
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static String read(String filename) {
        String str = "";
        try(FileReader reader = new FileReader("notes3.txt"))
        {
            // читаем посимвольно
            int c;
            while((c=reader.read())!=-1){
                str += (char)c;
            }

            return str;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
