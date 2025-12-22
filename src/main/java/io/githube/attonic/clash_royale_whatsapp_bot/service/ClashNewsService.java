package io.githube.attonic.clash_royale_whatsapp_bot.service;

import io.githube.attonic.clash_royale_whatsapp_bot.exception.BotClashException;
import io.githube.attonic.clash_royale_whatsapp_bot.model.Noticia;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class ClashNewsService {

    private final static String URL_SITE = "https://www.clashroyaledicas.com/noticias";

    public Noticia buscarUltimaManchete(){

        try{
            log.info("Conectando ao site: " + URL_SITE);

            Document document = Jsoup.connect(URL_SITE)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64) AppleWebKit/537.36 (KHTML, like Gecko Chrome/120.0.0.0 Safari/537.36")
                    .timeout(5000)
                    .get();

            log.info("Site carregado, Titulo da pagina: " + document.title());

            Element element = document.select("h2-post-title a").first();

            if (element == null){
                log.warn("Seletor 1 falhou tentando alternativo...");
                element = document.select(".entry-title a").first();
            }

            if (element != null){
                String titulo = element.text();
                String link = element.attr("href");
                log.info("Manchete encontrada: " + titulo);
                return new Noticia(titulo, link);
            }else {
                log.error("Nenhum elemento dos seletores encotrado.");
            }

        } catch (IOException e){
            throw new BotClashException("O Site caiu ou bloqueou o acesso.", e);
        }catch (Exception e){
            throw new BotClashException("Erro desconhecido na leitura da noticia", e);
        }
        throw new BotClashException("Noticia não encontrada");

    }

}
