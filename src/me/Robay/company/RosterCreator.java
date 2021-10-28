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
    ArrayList<String> ratings = new ArrayList<String>();

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
                        ratings.add(array.get(i + 1).toString());


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

    public ArrayList<String> getRatings() {

        return this.ratings;

    }


}

