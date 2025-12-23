package io.githube.attonic.clash_royale_whatsapp_bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ClashRoyaleWhatsappBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClashRoyaleWhatsappBotApplication.class, args);
	}

}
