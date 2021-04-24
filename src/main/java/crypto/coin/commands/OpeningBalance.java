package crypto.coin.commands;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import crypto.coin.Main;
import crypto.coin.beans.OpeningBalanceBean;
import crypto.coin.connectionRequests.HttpConnection;
import crypto.coin.connectionRequests.URLs;
import crypto.coin.utils.GsonService;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class OpeningBalance extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        super.onGuildMessageReceived(event);
        try {
            Message mes = event.getMessage();
            TextChannel channel = mes.getTextChannel();
            String msg = mes.getContentDisplay();

            if (msg.startsWith(Main.prefix)) {
                String[] args = msg.substring(Main.prefix.length()).split(" ");
                if (args[0].equalsIgnoreCase("openingbalance")) {
                    OpeningBalanceBean[] openingBalancesBean = GsonService.getInstance().getGsonInstance().fromJson(HttpConnection.getJsonArrayResponse("GET", URLs.openingBalance).toString(), OpeningBalanceBean[].class);
                    System.out.println("Gson  " + new Gson().toJson(HttpConnection.getJsonArrayResponse("GET", URLs.openingBalance).toString()));
                    String message = new GsonBuilder().setPrettyPrinting().create().toJson(openingBalancesBean[0].getMessage());
                    String statusCode = new GsonBuilder().setPrettyPrinting().create().toJson(openingBalancesBean[0].getStatusCode());
                    channel.sendMessage("**Opening Balance \\| DOGE**").queue();
                    EmbedBuilder dogeCost = new EmbedBuilder()
                            .setColor(Color.GREEN)
                            .setTitle("Opening Balance")
                            .setDescription("message   ==> " + message + "\n" + "status Code  ==>  " + statusCode);
                    channel.sendMessage(dogeCost.build()).queue();
                    Thread.sleep(86400);
                    channel.sendMessage("$openingbalance").queue();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
