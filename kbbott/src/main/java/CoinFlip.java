import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Random;

public class CoinFlip extends ListenerAdapter {

        @Override
        public void onMessageReceived(MessageReceivedEvent e) {
            if (e.getMessage().getContentRaw().equalsIgnoreCase("!CoinFlip")) {
              Random rnd = new Random();
                int value = 0 + rnd.nextInt(2);
                System.out.println(value);
                if(value == 0){
                    e.getChannel().sendMessage("Heads").queue();
                }
                else{
                    e.getChannel().sendMessage("Tails").queue();
                }
            }
        }
    }


