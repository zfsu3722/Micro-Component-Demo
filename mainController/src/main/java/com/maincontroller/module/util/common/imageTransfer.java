package com.maincontroller.module.util.common;
import java.io.*;
import java.util.Base64;
public class imageTransfer {
    public static byte[] fileToBytes(String filePath) {
        byte[] buffer = null;
        File file = new File(filePath);

        FileInputStream fis = null;
        ByteArrayOutputStream bos = null;

        try {
            fis = new FileInputStream(file);
            bos = new ByteArrayOutputStream();

            byte[] b = new byte[1024];

            int n;

            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }

            buffer = bos.toByteArray();
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(JmsReceiver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            //Logger.getLogger(JmsReceiver.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (null != bos) {
                    bos.close();
                }
            } catch (IOException ex) {
                //Logger.getLogger(JmsReceiver.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                try {
                    if(null!=fis){
                        fis.close();
                    }
                } catch (IOException ex) {
                    //Logger.getLogger(JmsReceiver.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return buffer;
    }
    public static String fileBase64Str(String filePath) {
        byte[] fileBytes = fileToBytes(filePath);
        String fileStr = null;
        if (fileBytes != null) {
            fileStr = Base64.getEncoder().encodeToString(fileBytes);
        }
        return fileStr;
    }


}
