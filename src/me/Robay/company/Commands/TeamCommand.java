package me.Robay.company.Commands;

import me.Robay.company.Seasons.Thirteen;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class TeamCommand {

    String team;

    public TeamCommand(String teamSearched, GuildMessageReceivedEvent event) {
        Thirteen thirteen = new Thirteen();
        if (!thirteen.checkForTeamMatch(teamSearched)) {

            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("Team Not Found");
            embed.setColor(0x132d63);


            event.getChannel().sendMessage(embed.build()).queue();


        } else {

            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("Team Found");
            embed.setColor(0x132d63);


            event.getChannel().sendMessage(embed.build()).queue();


        }


    }
}
