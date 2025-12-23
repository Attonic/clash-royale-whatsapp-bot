package io.githube.attonic.clash_royale_whatsapp_bot.service;

import io.githube.attonic.clash_royale_whatsapp_bot.exception.BotClashException;
import io.githube.attonic.clash_royale_whatsapp_bot.model.Noticia;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class WhatsappService {

    @Value("${greenapi.instance}")
    private String instaceId;

    @Value("${greenapi.token}")
    private String apiToken;

    @Value("${greenapi.group}")
    private String chatId;

    public void enviarNoticia(Noticia noticia){

        String url = "https://api.green-api.com/waInstance" + this.instaceId + "/sendMessage/" + this.apiToken;

        if (this.chatId == null || this.chatId.equals("PENDENTE")){
            log.error("Erro: O id do grupo não foi configurado corretamente");
        }

        String messagemFormatada = "\uD83D\uDC51 *NOVIDADE CLASH ROYALE* \uD83D\uDC51\n\n"
                + noticia.getTitulo() + "\n"
                + "\"\uD83D\uDC49Leia aqui: " + noticia.getLink();

        Map<String, String> payload = new HashMap<>();
        payload.put("chatId", chatId);
        payload.put("message", messagemFormatada);

        RestTemplate restTemplate = new RestTemplate();

        try{
            var resposta = restTemplate.postForEntity(url, payload, String.class);
            log.info("Status da resposta: {}",  resposta.getHeaders());
            log.info("Mensagem enviada com sucesso!");
        }catch (Exception e){
            throw new BotClashException("Erro ao mandar mensagem: ", e);
        }
    }

}
