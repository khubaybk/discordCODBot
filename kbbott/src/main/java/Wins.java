import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Wins extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.getMessage().getContentRaw().toLowerCase().startsWith("!wins")) {
            String url = "";
            //System.out.println(e.getMessage().getContentRaw());
            String message = e.getMessage().getContentRaw();
            if (e.getMessage().getContentRaw().contains("battlenet")) {
                String[] splitted = message.split(" ");
                //check for string size
                String urlP1 = "https://cod.tracker.gg/warzone/profile/";
                String platForm = "";
                String userName = "/";
                String id = "%23";
                String end = "/overview";
                if (splitted.length != 4) {
                    e.getChannel().sendMessage("Invalid input. Valid input is:").queue();
                    e.getChannel().sendMessage("For battlenet - !wins battlenet [username] [id without hashtag]").queue();
                    e.getChannel().sendMessage("For console - !wins [psn/xbox] [username] \nFor anything stats related, the format is as follows: \n!rank battlenet banned 11321").queue();

                } else {
                    for (int i = 0; i < splitted.length; i++) {
                        if (splitted[i].contains("!")) {

                        } else {
                            if (i == 1) {
                                platForm = splitted[i].toLowerCase();
                            } else if (i == 2) {
                                userName = "/" + splitted[i].toLowerCase();
                            } else if (i == 3) {
                                id += splitted[i];
                            }
                        }
                    }
                    // final String url = "https://cod.tracker.gg/warzone/profile/psn/IAMAPROV2/overview";
                    url = urlP1 + platForm + userName + id + end;
                    System.out.println(url);
                    System.out.println(userName);
                }
            } else {

                String[] splitted = message.split(" ");
                //check for string size
                String urlP1 = "https://cod.tracker.gg/warzone/profile/";
                String platForm = "";
                String userName = "/";
                String end = "/overview";
                if (splitted.length != 3) {
                    e.getChannel().sendMessage("Invalid input. Valid input is:").queue();
                    e.getChannel().sendMessage("For battlenet - !stat battlenet [username] [id without hashtag]").queue();
                    e.getChannel().sendMessage("For console - !stat [psn/xbox] [username] \nFor anything stats related, the format is as follows: \n!rank battlenet banned 11321").queue();

                } else {
                    for (int i = 0; i < splitted.length; i++) {
                        if (splitted[i].contains("!")) {

                        } else {
                            if (i == 1) {
                                platForm = splitted[i].toLowerCase();

                            } else if (i == 2) {
                                userName = "/" + splitted[i].toLowerCase();
                            }
                        }
                    }

                    // final String url = "https://cod.tracker.gg/warzone/profile/psn/IAMAPROV2/overview";
                    url = urlP1 + platForm + userName + end;
                }
            }
            if(url != "") {
                url(url, e);
            }
        }
    }

    public void url (String url, MessageReceivedEvent e){
        try {
            try {
                final Document document = Jsoup.connect(url).get();
                Element found = null;
                for (Element row : document.select("div.stat.align-left.giant.expandable span")) {
                    System.out.println(row.toString());
                    if (row.toString().contains("Wins")) {
                        found = row.nextElementSibling();
                        System.out.println(found);
                        break;
                    }
                }
                if (found != null) {
                    String line = found.toString();
                    StringBuilder sbl = new StringBuilder(line);
                    String wins = sbl.substring(36, sbl.lastIndexOf("</span>")).toString();
                    e.getChannel().sendMessage(wins +" " +e.getMember().getAsMention()).queue();
                } else {
                    e.getChannel().sendMessage("Invalid input. Valid input is:").queue();
                    e.getChannel().sendMessage("For battlenet - !stat battlenet [username] [id without hashtag]").queue();
                    e.getChannel().sendMessage("For console - !stat [psn/xbox] [username] \nFor anything stats related, the format is as follows: \n!rank battlenet banned 11321").queue();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
