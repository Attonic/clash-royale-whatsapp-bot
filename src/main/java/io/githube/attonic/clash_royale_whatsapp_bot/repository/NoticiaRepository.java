package io.githube.attonic.clash_royale_whatsapp_bot.repository;

import io.githube.attonic.clash_royale_whatsapp_bot.model.NoticiaHistorico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticiaRepository extends JpaRepository<NoticiaHistorico, Long> {
    boolean existsByTitulo(String titulo);
}
