package io.githube.attonic.clash_royale_whatsapp_bot.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Noticia {

    private String titulo;
    private String link;

    public Noticia(String titulo, String link){
        this.titulo = titulo;
        this.link = link;
    }

}
