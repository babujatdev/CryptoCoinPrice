package crypto.coin.commands;

import crypto.coin.Main;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class Ping implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        if(event.getMessageContent().equalsIgnoreCase(Main.prefix+"Ping")){
            event.getChannel().sendMessage("pong");
        }
    }
}
