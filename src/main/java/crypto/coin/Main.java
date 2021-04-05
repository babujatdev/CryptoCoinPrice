package crypto.coin;

import crypto.coin.commands.Ping;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class Main {

    public static final String prefix ="$";
    public static void main(String[] args) {
        String Token = System.getenv().get("TOKEN");
        DiscordApi api = new DiscordApiBuilder().setToken(Token).login().join();
        System.out.println(api.createBotInvite());
        api.addListener(new Ping());
        System.out.println("Bot is online: Owner of the server is "+api.getOwner());
    }
}
