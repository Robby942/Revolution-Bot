package me.Robay.company.Commands;

import me.Robay.company.Teams;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.Locale;

public class TeamCommand {

    String team;

    public TeamCommand(String teamSearched, GuildMessageReceivedEvent event) {
        Teams teams = new Teams();
        if (!teams.season13().containsKey(teamSearched.toUpperCase())) {

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
