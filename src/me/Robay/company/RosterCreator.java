package me.Robay.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class RosterCreator {

    ArrayList<String> players = new ArrayList<String>();
    ArrayList<Double> ratings = new ArrayList<Double>();
    ArrayList<String> franchiseRoles = new ArrayList<String>();

    public RosterCreator(String team) {
        try {


            URL url = new URL("https://gsx2json.com/api?id=131lTmiKejbX6Mttdj8wcCAnW6lagGsYScPKlhoJciYU&sheet=Contracts&integers=false");


            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();


            int responsecode = conn.getResponseCode();

            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {

                String inline = "";
                Scanner scanner = new Scanner(url.openStream());


                while (scanner.hasNext()) {


                    inline = scanner.nextLine();

                }


                scanner.close();
                JSONParser parser = new JSONParser();
                JSONObject object = (JSONObject) parser.parse(inline);
                object = (JSONObject) object.get("columns");
                JSONArray array = (JSONArray) object.get("undefined");
                for (int i = 0; i < array.size(); i++) {
                    if (array.get(i).equals(team.toUpperCase())) {
                        players.add(array.get(i - 6).toString());
                        ratings.add(Double.parseDouble(array.get(i + 1).toString()));
                        franchiseRoles.add(array.get(i + 3).toString());


                    }

                }

                System.out.println("Console Debug: " + this.players.toString());


            }


        } catch (
                Exception e) {
            e.printStackTrace();

        }


    }

    public ArrayList<String> getPlayers() {

        return this.players;
    }

    public ArrayList<Double> getRatings() {

        return this.ratings;

    }

    public ArrayList<String> getFranchiseRoles() {

        for (int i = 0; i < franchiseRoles.size(); i++) {
            if (franchiseRoles.get(i).equalsIgnoreCase("Owner")) {
                franchiseRoles.set(i, "Owner");


            } else if (franchiseRoles.get(i).equalsIgnoreCase("GM")) {
                franchiseRoles.set(i, "General Manager");

            } else if (franchiseRoles.get(i).equalsIgnoreCase("-") || franchiseRoles.get(i).equalsIgnoreCase("BHL") || franchiseRoles.get(i).equalsIgnoreCase("NAMHL") || franchiseRoles.get(i).equalsIgnoreCase("JBHL")) {
                franchiseRoles.set(i, "Player");

            }


        }

        return this.franchiseRoles;

    }


}



