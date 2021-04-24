package crypto.coin.commands;

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

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        super.onGuildMessageReceived(event);
        try {
            Message message = event.getMessage();
            String msg = message.getContentDisplay();
            TextChannel channel = message.getTextChannel();
            Timer timer = new Timer();

            /*if (msg.startsWith(Main.prefix)) {
                String[] sys = msg.substring(Main.prefix.length()).split(" ");
                if (sys[0].equalsIgnoreCase("b")) {
                    DogeRateBean dogeRateBean = GsonService.getInstance().getGsonInstance().fromJson(HttpConnection.getJsonResponse("GET", URLs.dogerate).toString(), DogeRateBean.class);
                    String dogeBalance = new GsonBuilder().setPrettyPrinting().create().toJson(dogeRateBean.getBalance());
                    String dogeStatus = new GsonBuilder().setPrettyPrinting().create().toJson(dogeRateBean.getSuccess());
                    channel.sendMessage("**DogeRate \\| DOGE**").queue();
                    EmbedBuilder dogeCost = new EmbedBuilder()
                            .setColor(Color.GREEN)
                            .setTitle("DOGE")
                            .setDescription("Balance   " + dogeBalance +"\n"+ "Success    "+dogeStatus);
                    channel.sendMessage(dogeCost.build()).queue();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            channel.sendMessage("$b").queue();
                        }
                    },10000);
                }
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
