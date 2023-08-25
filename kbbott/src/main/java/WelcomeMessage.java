import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class WelcomeMessage extends ListenerAdapter {
    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent e){
        Member member = e.getMember();
        member.getUser().openPrivateChannel().queue(channel -> {channel.sendMessage("Welcome to Khubayb's server discord. Have a blast").queue();});
    }
}
