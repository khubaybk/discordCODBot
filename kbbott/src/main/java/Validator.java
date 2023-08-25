import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Validator extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.getMessage().getContentRaw().equalsIgnoreCase("!commands")) {
            e.getChannel().sendMessage("The Commands are as follows \nFor battlenet wins-  !wins battlenet [username] [id without hashtag]\nFor console wins - !wins [psn/xbox] [username]\nFor battlenet KD - " +
                    " !kd battlenet [username] [id without hashtag] \nFor console KD - !kd [psn/xbox] [username] \nFor battlenet rank - !rank battlenet [username] [id without hashtag] \nFor console rank - !rank [psn/xbox] [username] " +
                    "\n!ping - returns pong\n!kick if your an admin\n!invite for bot\n!coinflip\n!PS [@user] [@user]... - random person selector \nFor anything stats related, the format is as follows: \n!rank battlenet banned 11321" + e.getMember().getAsMention()).queue();
        }
    }
}
