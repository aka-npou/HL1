package ru.aka_npou.util;

import java.io.*;
//import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnZip {
    private final static int BUFFER_SIZE = 512;
    private final static String ZIP_ARCHIVE = new File("tmp").getAbsolutePath()+"/data/data.zip";

    public static String CurrentDir(){
        String path=System.getProperty("java.class.path");
        String FileSeparator=(String)System.getProperty("file.separator");
        return path.substring(0, path.lastIndexOf(FileSeparator)+1);
    }

    protected void unZip() {
        //byte[] buffer = new byte[BUFFER_SIZE];

        final char[] buffer = new char[8*1024];

        //ArrayList<String> files = new ArrayList<>();

        try {
            String tmp;
            int i;
            // Получаем содержимое ZIP архива
            final ZipInputStream zis = new ZipInputStream(
                    new FileInputStream(ZIP_ARCHIVE));
            ZipEntry ze = zis.getNextEntry();
            while (ze != null) {
                //System.out.println(ze.getName());
                StringBuilder s = new StringBuilder();
                InputStreamReader isr = new InputStreamReader(zis);
                while(isr.read(buffer, 0, buffer.length) != -1) {
                    tmp = new String(buffer);
                    i = tmp.indexOf("]}");
                    if (i != -1) {
                        tmp = tmp.substring(0, i+2);
                    }
                    s.append(tmp);
                }
                //files.add(s.toString());
                Data.readFile(s.toString());

                ze = zis.getNextEntry();
            }
            zis.closeEntry();
            zis.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UnZip.class.getName())
                    .log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UnZip.class.getName())
                    .log(Level.SEVERE, null, ex);
        }

        //return files;
    }

    private String destinationDirectory(final String srcZip) {
        return srcZip.substring(0, srcZip.lastIndexOf("."));
    }
}
