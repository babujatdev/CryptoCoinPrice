package crypto.coin.commands;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import crypto.coin.Main;
import crypto.coin.beans.DogeRateBean;
import crypto.coin.beans.EthereumBean;
import crypto.coin.beans.PingBean;
import crypto.coin.connectionRequests.HttpConnection;
import crypto.coin.connectionRequests.URLs;
import crypto.coin.utils.GsonService;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Ping extends ListenerAdapter {
    Message message;
    TextChannel channel;

    public Ping(){
    }

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        PingBean pingBean;
        try {
            message = event.getMessage();
            channel = message.getTextChannel();
            Guild guild = event.getGuild();
            String msg = message.getContentDisplay();

            if (msg.startsWith(Main.prefix)) {
                String[] args = msg.substring(Main.prefix.length()).split(" ");
                pingBean = GsonService.getInstance().getGsonInstance().fromJson(HttpConnection.getJsonResponse("GET", URLs.ping).toString(), PingBean.class);
                if (args[0].equalsIgnoreCase("ping")) {
                    channel.sendMessage(new GsonBuilder().setPrettyPrinting().create().toJson(pingBean.getGecko_says())).queue();
                } else if (args[0].equalsIgnoreCase("ethusa") || args[0].equalsIgnoreCase("ethus") || args[0].equalsIgnoreCase("eth")) {
                    EthereumBean ethereumBean = GsonService.getInstance().getGsonInstance().fromJson(HttpConnection.getJsonResponse("GET", URLs.pricesUS).toString(), EthereumBean.class);
                    System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(ethereumBean.getEthereum().getUsd()));
                    String ETHPrice = new GsonBuilder().setPrettyPrinting().create().toJson(ethereumBean.getEthereum().getUsd()).replaceAll("^\"|\"$", "");
                    channel.sendMessage("**Ethereum \\| ETH**").queue();
                    EmbedBuilder ebethPrice = new EmbedBuilder()
                            .setColor(Color.BLACK)
                            .setTitle("EthUSA")
                            .setDescription("ETH          : 1.000000\nUSD          : " + ETHPrice)
                            .setAuthor("CoinGecko", "https://www.coingecko.com/en/coins/ethereum")
                            .setFooter("ETHUSA", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/Ethereum_logo_2014.svg/64px-Ethereum_logo_2014.svg.png");

                    channel.sendMessage(ebethPrice.build()).queue();
                }
                /*else if (args[0].equalsIgnoreCase("d")) {
                    DogeRateBean[] dogeRateBean = GsonService.getInstance().getGsonInstance().fromJson(HttpConnection.getJsonArrayResponse("GET", URLs.dogerate).toString(), DogeRateBean[].class);
                    System.out.println("Gson  "+new Gson().toJson(HttpConnection.getJsonArrayResponse("GET", URLs.dogerate).toString()));
                    String currentPercentage = new GsonBuilder().setPrettyPrinting().create().toJson(dogeRateBean[0].getCurrentPercentage());
                    String currentPrice = new GsonBuilder().setPrettyPrinting().create().toJson(dogeRateBean[0].getCurrentPrice());
                    String estimatedPrice = new GsonBuilder().setPrettyPrinting().create().toJson(dogeRateBean[0].getEstimatedPrice());
                    String percentageDiff = new GsonBuilder().setPrettyPrinting().create().toJson(dogeRateBean[0].getPercentageDiff());
                    String statusCode = new GsonBuilder().setPrettyPrinting().create().toJson(dogeRateBean[0].getStatusCode());
                    String totalCurrentBalance = new GsonBuilder().setPrettyPrinting().create().toJson(dogeRateBean[0].getTotalCurrentBalance());
                    String totalPreviousBalance = new GsonBuilder().setPrettyPrinting().create().toJson(dogeRateBean[0].getTotalPreviousBalance());
                    channel.sendMessage("**DogeRate \\| DOGE**").queue();
                    EmbedBuilder dogeCost = new EmbedBuilder()
                            .setColor(Color.GREEN)
                            .setTitle("DOGE")
                            .setDescription("currentPercentage    " + currentPercentage + "\n" + "currentPrice    " + currentPrice + "\n" + "estimatedPrice    " + estimatedPrice + "\n"
                                    + "percentageDiff    " + percentageDiff + "\n" + "statusCode    " + statusCode + "\n" + "totalCurrentBalance    " + totalCurrentBalance + "\n"
                                    + "totalPreviousBalance    " + totalPreviousBalance);
                    channel.sendMessage(dogeCost.build()).queue();
                }*/
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}