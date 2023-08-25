import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class RoleReactions extends ListenerAdapter {
    final long channelID = 813797038080655410L;
    final long roleID = 813797255722827776L;
    final long cod = 813847816442740738L;
    final long rleague = 813847869631102986L;
    final long gta = 813847911850442764L;
    final long coldwar = 813847949125353513L;
    private MessageReaction.ReactionEmote reactionEmote;

    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent e){
    if(e.getTextChannel().getIdLong() == channelID) {
    Member reactee = e.getMember();
        reactionEmote = e.getReactionEmote();
        if(reactionEmote.toString().equals(("RE:U+1f52b"))){
            e.getGuild().addRoleToMember(reactee, e.getJDA().getRoleById(cod)).queue();
        }
        if(reactionEmote.toString().equals(("RE:U+1f699"))){
            e.getGuild().addRoleToMember(reactee, e.getJDA().getRoleById(rleague)).queue();
        }
        if(reactionEmote.toString().equals(("RE:U+1f1fb"))){
            e.getGuild().addRoleToMember(reactee, e.getJDA().getRoleById(gta)).queue();
        }
        if(reactionEmote.toString().equals(("RE:U+1f976"))){
            e.getGuild().addRoleToMember(reactee, e.getJDA().getRoleById(coldwar)).queue();
        }

    }
    }
}
