import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Invite extends ListenerAdapter {
    final String url = "https://discord.com/oauth2/authorize?client_id=813561118941118554&scope=bot";

    @Override
    public void onMessageReceived(MessageReceivedEvent e){
        if(e.getMessage().getContentRaw().equals("!invite")){
            e.getChannel().sendMessage(String.format(url, e.getJDA().getSelfUser().getId())).queue();
        }

    }
}
