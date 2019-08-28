package com.sda.projects.MailService;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileService {

    public  void writeToFile(String path, BufferedImage img){
        try {
            File outputfile = new File(path);
            ImageIO.write(img, "jpg", outputfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
