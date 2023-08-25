import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.List;

public class Thotiana {

    public static void main(String[] args) throws Exception {
        //for dm's
        List<GatewayIntent> gatewayIntents = new ArrayList<>();
        gatewayIntents.add(GatewayIntent.GUILD_MEMBERS);
        JDABuilder jdaBuilder = JDABuilder.createDefault("ODEzNTYxMTE4OTQxMTE4NTU0.YDRF1Q.wKiuAu2zyll18kpxsd9JOKeX-to");
        jdaBuilder.enableIntents(gatewayIntents);
        JDA jda = null;
        Validator validator = new Validator();
        PingPong pingPong = new PingPong();
        Invite invite = new Invite();
        RoleReactions roleReactions = new RoleReactions();
        WelcomeMessage welcomeMessage = new WelcomeMessage();
        Kick kick = new Kick();
        PersonSelector personSelector = new PersonSelector();
        CoinFlip coinFlip = new CoinFlip();
        Stat stat = new Stat();
        Wins wins = new Wins();
        Rank rank = new Rank();
        jdaBuilder.addEventListeners(validator);
        jdaBuilder.addEventListeners(rank);
        jdaBuilder.addEventListeners(wins);
        jdaBuilder.addEventListeners(pingPong);
        jdaBuilder.addEventListeners(personSelector);
        jdaBuilder.addEventListeners(invite);
        jdaBuilder.addEventListeners(welcomeMessage);
        jdaBuilder.addEventListeners(roleReactions);
        jdaBuilder.addEventListeners(kick);
        jdaBuilder.addEventListeners(coinFlip);
        jdaBuilder.addEventListeners(stat);
        jdaBuilder.setActivity(Activity.watching("Khubayb not get a placement"));
        try {
            jda = jdaBuilder.build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
        try {
            jda.awaitReady();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
