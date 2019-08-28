package com.sda.projects.MailService;

import javax.mail.MessagingException;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, MessagingException {
        Scanner sc=new Scanner(System.in);
        while (true) {
            System.out.println("Podaj email ..");
            String email=sc.nextLine();
            ConnectionService connection = new ConnectionService();
            MailService mail = new MailService();
            FileService file = new FileService();
            String path = "C:\\workspace\\MailService\\src\\main\\java\\com\\sda\\projects\\MailService\\newFile.jpg";
            BufferedImage img = connection.getImage();
            file.writeToFile(path, img);
            mail.sendMessage(path,email);
        }
    }
}
