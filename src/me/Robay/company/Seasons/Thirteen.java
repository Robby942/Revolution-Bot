package me.Robay.company.Seasons;

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


    public Thirteen () {

        registerTeamInformation();

    }

    public void registerTeamInformation() {

        SEA.add("SEA");
        SEA.add("Seattle Golden Eagles");

        COL.add("COL");
        COL.add("Colorado Comets");

        NYR.add("NYR");
        NYR.add("New York Revolution");

        PAN.add("PAN");
        PAN.add("Panama City Panic");

        SJB.add("SJB");
        SJB.add("San Jose Blaze");

        HOU.add("HOU");
        HOU.add("Houston Bandits");

        HFX.add("HFX");
        HFX.add("Halifax Highlanders");

        SUR.add("SUR");
        SUR.add("Surrey Hitmen");


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
            return true;

        } else {

            return false;
        }


    }

}
