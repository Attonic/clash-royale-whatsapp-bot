package io.githube.attonic.clash_royale_whatsapp_bot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class NoticiaHistorico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private LocalDateTime dataEnvio;

    public NoticiaHistorico() {}

    public NoticiaHistorico(String titulo){
        this.titulo = titulo;
        this.dataEnvio = LocalDateTime.now();
    }


}
