package crypto.coin.commands;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import crypto.coin.Main;
import crypto.coin.beans.DogeRateBean;
import crypto.coin.connectionRequests.HttpConnection;
import crypto.coin.connectionRequests.URLs;
import crypto.coin.utils.GsonService;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DogeRate extends ListenerAdapter {
      public DogeRate() {
    }

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        super.onGuildMessageReceived(event);
        try {
            Message message = event.getMessage();
            TextChannel channel = message.getTextChannel();
            String msg = message.getContentDisplay();
                       
            if (msg.startsWith(Main.prefix)) {
                String[] args = msg.substring(Main.prefix.length()).split(" ");
                if (args[0].equalsIgnoreCase("whales")) {
                    DogeRateBean[] dogeRateBean = GsonService.getInstance().getGsonInstance().fromJson(HttpConnection.getJsonArrayResponse("GET", URLs.dogerate).toString(), DogeRateBean[].class);
                    System.out.println("Gson  " + new Gson().toJson(HttpConnection.getJsonArrayResponse("GET", URLs.dogerate).toString()));
                    String currentPercentage = new GsonBuilder().setPrettyPrinting().create().toJson(dogeRateBean[0].getCurrentPercentage());
                    String currentPrice = new GsonBuilder().setPrettyPrinting().create().toJson(dogeRateBean[0].getCurrentPrice());
                    String estimatedPrice = new GsonBuilder().setPrettyPrinting().create().toJson(dogeRateBean[0].getEstimatedPrice());
                    String coinsPumpedDumped = new GsonBuilder().setPrettyPrinting().create().toJson(dogeRateBean[0].getCoinsPumpedDumped());
                    String statusCode = new GsonBuilder().setPrettyPrinting().create().toJson(dogeRateBean[0].getStatusCode());
                    String totalCurrentBalance = new GsonBuilder().setPrettyPrinting().create().toJson(dogeRateBean[0].getTotalCurrentBalance());
                    String totalPreviousBalance = new GsonBuilder().setPrettyPrinting().create().toJson(dogeRateBean[0].getTotalPreviousBalance());
                    channel.sendMessage("**Doge Transactions \\| DOGE**").queue();                   
                    EmbedBuilder dogeCost = new EmbedBuilder()
                            .setColor(Color.GREEN)
                            .setTitle("DOGE WHALES")
                            .setDescription("Percentage Pumped or Dumped ==> " + currentPercentage + "\n" + "Current Price  ==>  " + currentPrice + "\n" + "Estimated Price  ==>  " + estimatedPrice + "\n"
                                    + "Coins Pumped or Dumped ==>  " + coinsPumpedDumped + "\n" + "Status Code  ==>  " + statusCode + "\n" + "Current Balance  ==>  " + totalCurrentBalance + "\n"
                                    + "Opening Balance   ==> " + totalPreviousBalance);
                    channel.sendMessage(dogeCost.build()).queue();
                    Thread.sleep(60000);
                    channel.sendMessage("$whales").queue();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
