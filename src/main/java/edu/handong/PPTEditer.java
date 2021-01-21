package edu.handong;

import java.io.*;

public class PPTEditer {
    public String function(String str) {
        return str;
    }

    public void saveAs(String filePath,String content) throws FileNotFoundException {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
