package me.Robay.company.Commands;

import me.Robay.company.Seasons.Thirteen;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class TeamCommand {

 
    public TeamCommand(String teamSearched, GuildMessageReceivedEvent event) {
        Thirteen thirteen = new Thirteen();
        if (!thirteen.checkForTeamMatch(teamSearched)) {

            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("Team Not Found");
            embed.setColor(0x132d63);


            event.getChannel().sendMessage(embed.build()).queue();


        } else {

            EmbedBuilder embed = new EmbedBuilder();
            embed.setThumbnail(thirteen.getTeamData().get(2));
            embed.setAuthor("Team Information", "https://cdn.discordapp.com/attachments/544035531667800064/893077183994671145/aa1fbea97c1d987e1c78040a8f72c214-removebg-preview.png", "https://cdn.discordapp.com/attachments/544035531667800064/893077183994671145/aa1fbea97c1d987e1c78040a8f72c214-removebg-preview.png");
            embed.setTitle(thirteen.getTeamData().get(1));
            embed.setDescription("Season 13");
            embed.addField("", "", true);
            embed.addField("", "", true);
            embed.addField("", "", true);
            for (int i = 0; i < thirteen.getRoster().size(); i++) {


                embed.addField(thirteen.getRoster().get(i).toString(), "```" + thirteen.getRatings().get(i).toString() +  "```", true);
            }

            embed.setColor(thirteen.teamColor);

            event.getChannel().sendMessage(embed.build()).queue();


        }


    }
}
