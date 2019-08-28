package com.sda.projects.MailService;

import lombok.NoArgsConstructor;
import org.springframework.web.client.RestTemplate;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

@NoArgsConstructor
public class ConnectionService {


    public String connect() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://aws.random.cat/meow", String.class);
    }

    public BufferedImage getImage() throws IOException {
        final String link= connect();
       String cutLink=link.substring(9,link.length()-2).replace("\\","");
       BufferedImage image=ImageIO.read(new URL(cutLink));
       return  image;
    }
}
