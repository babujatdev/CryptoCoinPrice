package crypto.coin.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


import java.awt.*;

public class Prices extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        String[] message = e.getMessage().getContentRaw().split(" ");
        if (message[0].equalsIgnoreCase("$pin")) {
            EmbedBuilder eb = new EmbedBuilder()
                    .setColor(Color.CYAN)
                    .setTitle("Title");
            e.getChannel().sendMessage(eb.build()).queue();
        }
    }
}