package io.githube.attonic.clash_royale_whatsapp_bot.exception;

public class BotClashException extends RuntimeException{

    public BotClashException(String menssagem){
        super(menssagem);
    }

    public BotClashException(String menssagem, Throwable causa){
        super(menssagem, causa);
    }
}
