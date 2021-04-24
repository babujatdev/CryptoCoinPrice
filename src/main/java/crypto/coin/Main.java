package crypto.coin;

import crypto.coin.commands.DogeRate;
import crypto.coin.commands.OpeningBalance;
import crypto.coin.commands.Ping;
import crypto.coin.commands.Prices;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class Main {

    public static final String prefix = "$";
    private static JDA jda;
    public static void main(String[] args) {
        try {
            String Token = System.getenv().get("TOKEN");
            //DiscordApi api = new DiscordApiBuilder().setToken(Token).login().join();
            JDABuilder builder = JDABuilder.createDefault(Token);
            jda = builder.build();
            jda.addEventListener(new Prices());
            jda.addEventListener(new Ping());
            jda.addEventListener(new DogeRate());
            jda.addEventListener(new OpeningBalance());
            //System.out.println(api.createBotInvite());
            //api.addListener(new Ping());
            //api.addListener(new Prices());
            System.out.println("Bot is online: Owner of the server is ");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}