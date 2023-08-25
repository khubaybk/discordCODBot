import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Rank extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.getMessage().getContentRaw().toLowerCase().startsWith("!rank")) {
            String url = "";
            String message = e.getMessage().getContentRaw();
            StringBuilder sb = new StringBuilder(message);
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
                    e.getChannel().sendMessage("For battlenet - !rank battlenet [username] [id without hashtag]").queue();
                    e.getChannel().sendMessage("For console - !rank [psn/xbox] [username] \nFor anything stats related, the format is as follows: \n!rank battlenet banned 11321").queue();
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
                //  System.out.println(splitted.length);
                if (splitted.length != 3) {
                    // System.out.println(message);
                    e.getChannel().sendMessage("Invalid input. Valid input is:").queue();
                    e.getChannel().sendMessage("For battlenet - !rank battlenet [username] [id without hashtag]").queue();
                    e.getChannel().sendMessage("For console - !rank [psn/xbox] [username] \nFor anything stats related, the format is as follows: \n!rank battlenet banned 11321").queue();

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
                    //  System.out.println(url);
                    //   System.out.println(userName);
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
                    //row.
                    // if
                    // System.out.println(row + "row");
                    // String startP = "<span title='K/D Ratio' class='name' data-v-5edf1b22>K/D Ratio</span>\n" +
                    // "<span class='value' data-v-5edf1b22>";
                    System.out.println(row.toString());
                    if (row.toString().contains("rank")) {
                        //System.out.println(row.nextElementSibling()+ "row found KD");
                        found = row;
                        System.out.println(found);
                        //   System.out.println(found.toString());
                        break;
                    }
                }
                if (found != null) {
                    String line = found.toString();
                    StringBuilder sbl = new StringBuilder(line);
                    String wins = sbl.substring(35, sbl.lastIndexOf("</span>")).toString();
                    e.getChannel().sendMessage(wins+ e.getMember().getAsMention()).queue();
                } else {
                    e.getChannel().sendMessage("Invalid input. Valid input is:").queue();
                    e.getChannel().sendMessage("For battlenet - !rank battlenet [username] [id without hashtag]").queue();
                    e.getChannel().sendMessage("For console - !rank [psn/xbox] [username] \nFor anything stats related, the format is as follows: \n!rank battlenet banned 11321").queue();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
