import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Random;

public class PersonSelector extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.getMessage().getContentRaw().toLowerCase().startsWith("!ps")) {
            System.out.println(e.getMessage().getContentRaw());
            int i = 0;
            try {
                Member[] members = new Member[e.getMessage().getMentionedMembers().size()];
                for (Member member : e.getMessage().getMentionedMembers()) {
                    members[i] = member;
                    i++;
                }
                Random rnd = new Random();
                int value = 0 + rnd.nextInt(members.length);
                e.getChannel().sendMessage(members[value].getUser().getAsMention()).queue();
            }
            catch (IllegalArgumentException exception){
                e.getChannel().sendMessage("You must include members").queue();
            }
        }
    }
}
