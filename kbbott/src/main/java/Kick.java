import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Kick extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent e){
        if(e.getMessage().getContentRaw().startsWith("!kick")){
            if(e.getMember().hasPermission(Permission.KICK_MEMBERS)){
              for(Member member :  e.getMessage().getMentionedMembers()){
                member.kick().queue();
              }
            }
        }
    }
}
