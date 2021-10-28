package me.Robay.company.Seasons;

import me.Robay.company.Commands.Commands;
import me.Robay.company.RosterCreator;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Thirteen {


    public ArrayList<String> SEA = new ArrayList<String>();
    public ArrayList<String> COL = new ArrayList<String>();
    public ArrayList<String> NYR = new ArrayList<String>();
    public ArrayList<String> PAN = new ArrayList<String>();
    public ArrayList<String> SJB = new ArrayList<String>();
    public ArrayList<String> HOU = new ArrayList<String>();
    public ArrayList<String> HFX = new ArrayList<String>();
    public ArrayList<String> SUR = new ArrayList<String>();
    ArrayList<String> roster = new ArrayList<String>();
    ArrayList<String> teamData = new ArrayList<String>();
    ArrayList<String> ratings = new ArrayList<String>();
    public int teamColor;



    public Thirteen() {

        registerTeamInformation();

    }

    public void registerTeamInformation() {

        SEA.add("SEA");
        SEA.add("Seattle Golden Eagles");
        SEA.add("https://cdn.discordapp.com/emojis/790778810088816680.png?size=96");

        COL.add("COL");
        COL.add("Colorado Comets");
        COL.add("https://cdn.discordapp.com/emojis/890780066139734017.png?size=96");

        NYR.add("NYR");
        NYR.add("New York Revolution");
        NYR.add("https://cdn.discordapp.com/emojis/892903401195712534.png?size=96");

        PAN.add("PAN");
        PAN.add("Panama City Panic");
        PAN.add("https://cdn.discordapp.com/emojis/888989531309764618.png?size=96");

        SJB.add("SJB");
        SJB.add("San Jose Blaze");
        SJB.add("https://cdn.discordapp.com/emojis/888989560527290388.png?size=96");


        HOU.add("HOU");
        HOU.add("Houston Bandits");
        HOU.add("https://cdn.discordapp.com/emojis/710972511558303914.png?size=96");

        HFX.add("HFX");
        HFX.add("Halifax Highlanders");
        HFX.add("https://cdn.discordapp.com/emojis/847461300060684288.png?size=96");

        SUR.add("SUR");
        SUR.add("Surrey Hitmen");
        SUR.add("https://cdn.discordapp.com/emojis/819294775999725589.png?size=96");


    }

    public boolean checkForTeamMatch(String teamSearched) {

        if (SEA.get(0).equalsIgnoreCase(teamSearched) ||
                COL.get(0).equalsIgnoreCase(teamSearched) ||
                NYR.get(0).equalsIgnoreCase(teamSearched) ||
                PAN.get(0).equalsIgnoreCase(teamSearched) ||
                SJB.get(0).equalsIgnoreCase(teamSearched) ||
                HOU.get(0).equalsIgnoreCase(teamSearched) ||
                HFX.get(0).equalsIgnoreCase(teamSearched) ||
                SUR.get(0).equalsIgnoreCase(teamSearched)) {

            RosterCreator rosterCreator = new RosterCreator(teamSearched);
            this.roster = rosterCreator.getPlayers();
            this.ratings = rosterCreator.getRatings();
            addTeamData(teamSearched);


            return true;

        } else {

            return false;
        }


    }

    public ArrayList<String> getRoster() {

        return this.roster;

    }

    public void addTeamData(String teamSearched) {

        if (SEA.get(0).equalsIgnoreCase(teamSearched)) {
            this.teamData = this.SEA;
            this.teamColor = 0xffc01b;

        } else if (COL.get(0).equalsIgnoreCase(teamSearched)) {
            this.teamData = this.COL;
            this.teamColor = 0x8acbe9;

        } else if (NYR.get(0).equalsIgnoreCase(teamSearched)) {
            this.teamData = this.NYR;
            this.teamColor = 0x0a2728;

        } else if (PAN.get(0).equalsIgnoreCase(teamSearched)) {
            this.teamData = this.PAN;
            this.teamColor = 0xd7907a;

        } else if (SJB.get(0).equalsIgnoreCase(teamSearched)) {
            this.teamData = this.SJB;
            this.teamColor = 0x963a33;

        } else if (HOU.get(0).equalsIgnoreCase(teamSearched)) {
            this.teamData = this.HOU;
            this.teamColor = 0x0b2f85;

        } else if (HFX.get(0).equalsIgnoreCase(teamSearched)) {
            this.teamData = this.HFX;
            this.teamColor = 0xca5438;

        } else if (SUR.get(0).equalsIgnoreCase(teamSearched)) {
            this.teamData = this.SUR;
            this.teamColor = 0x75283c;

        }

    }

    public ArrayList<String> getTeamData() {


        return this.teamData;
    }

    public ArrayList<String> getRatings() {

        return this.ratings;

    }

}
