package io.githube.attonic.clash_royale_whatsapp_bot.task;

import io.githube.attonic.clash_royale_whatsapp_bot.exception.BotClashException;
import io.githube.attonic.clash_royale_whatsapp_bot.model.Noticia;
import io.githube.attonic.clash_royale_whatsapp_bot.model.NoticiaHistorico;
import io.githube.attonic.clash_royale_whatsapp_bot.repository.NoticiaRepository;
import io.githube.attonic.clash_royale_whatsapp_bot.service.ClashNewsService;
import io.githube.attonic.clash_royale_whatsapp_bot.service.WhatsappService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RotinaDiaria {

    @Autowired
    private ClashNewsService clashNewsService;
    @Autowired
    private WhatsappService whatsappService;
    @Autowired
    private NoticiaRepository noticiaRepository;

    @Scheduled(cron = "0 35 20 * * *", zone = "America/Sao_Paulo")
    public void verificarEnvio(){
        log.info("Iniciando verificação de noticias...");
        try {
            Noticia noticia = clashNewsService.buscarUltimaManchete();

            if (noticia != null){
                boolean jaFoiEnviada = noticiaRepository.existsByTitulo(noticia.getTitulo());
                if (!jaFoiEnviada){
                    log.info("Nova noticia encontrada." + noticia);
                    whatsappService.enviarNoticia(noticia);
                    noticiaRepository.save(new NoticiaHistorico(noticia.getTitulo()));
                }else {
                    log.info("Noticia repetida. Já enviada." + noticia.getTitulo());
                }
            }
        }catch (BotClashException e){
            log.error("Alerta: " + e.getMessage());
        } catch (Exception e){
            log.error("Erro genérico no sistema! " + e.getMessage());
        }
    }

}
