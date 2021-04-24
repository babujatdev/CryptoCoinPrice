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

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

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
                    String percentageDiff = new GsonBuilder().setPrettyPrinting().create().toJson(dogeRateBean[0].getPercentageDiff());
                    String statusCode = new GsonBuilder().setPrettyPrinting().create().toJson(dogeRateBean[0].getStatusCode());
                    String totalCurrentBalance = new GsonBuilder().setPrettyPrinting().create().toJson(dogeRateBean[0].getTotalCurrentBalance());
                    String totalPreviousBalance = new GsonBuilder().setPrettyPrinting().create().toJson(dogeRateBean[0].getTotalPreviousBalance());
                    channel.sendMessage("**Doge Transactions \\| DOGE**").queue();
                    EmbedBuilder dogeCost = new EmbedBuilder()
                            .setColor(Color.GREEN)
                            .setTitle("DOGE WHALES")
                            .setDescription("currentPercentage   ==> " + currentPercentage + "\n" + "currentPrice  ==>  " + currentPrice + "\n" + "estimatedPrice  ==>  " + estimatedPrice + "\n"
                                    + "percentageDiff  ==>  " + percentageDiff + "\n" + "statusCode  ==>  " + statusCode + "\n" + "totalCurrentBalance  ==>  " + totalCurrentBalance + "\n"
                                    + "totalPreviousBalance   ==> " + totalPreviousBalance);
                    channel.sendMessage(dogeCost.build()).queue();
                    Thread.sleep(15000);
                    channel.sendMessage("$whales").queue();
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
