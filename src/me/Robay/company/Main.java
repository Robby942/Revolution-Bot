package me.Robay.company;



import me.Robay.company.Commands.Commands;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.utils.Compression;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;


public class Main {
    public static JDABuilder jda;
    public static String prefix = "!";

    public static void main(String[] args) throws LoginException {

        jda = JDABuilder.createDefault("");

        jda.setActivity(Activity.playing(""));
        jda.setStatus(OnlineStatus.ONLINE);
        jda.disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE);
        jda.setBulkDeleteSplittingEnabled(false);
        jda.setCompression(Compression.NONE);
        registerListeners();
        jda.build();
    }


        public static void registerListeners() {

            jda.addEventListeners(new Commands());
        }
    }



