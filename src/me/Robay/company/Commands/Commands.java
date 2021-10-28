package me.Robay.company.Commands;


import me.Robay.company.Main;
import net.dv8tion.jda.api.EmbedBuilder;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;






public class Commands extends ListenerAdapter {


    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {


        String[] args = event.getMessage().getContentRaw().split("\\s+");



        if (args[0].equalsIgnoreCase(Main.prefix + "help")) {

            EmbedBuilder embed = new EmbedBuilder();
            embed.setAuthor("Bot Commands and Information", "https://cdn.discordapp.com/attachments/544035531667800064/893077183994671145/aa1fbea97c1d987e1c78040a8f72c214-removebg-preview.png", "https://cdn.discordapp.com/attachments/544035531667800064/893077183994671145/aa1fbea97c1d987e1c78040a8f72c214-removebg-preview.png");
            embed.setColor(0x132d63);
            embed.setTitle("Version BETA 0.1");
            embed.setDescription("Commands and Description");
            embed.setThumbnail("https://cdn.discordapp.com/attachments/893126126447235104/893152790375964682/help-icon-transparent-background-28.jpg");
            embed.addField("", "", false);
            embed.addField("!team", "Get basic information about a team\n```Usage: !team <team>```", false);
            embed.setFooter("Current Season: S13");
            event.getChannel().sendMessage(embed.build()).queue();

        }
    }
}