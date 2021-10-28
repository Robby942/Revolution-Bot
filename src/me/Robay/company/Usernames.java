package me.Robay.company;

import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Usernames extends ListenerAdapter {
    String username;
    JSONObject object;
    JSONArray array;
    String UUID;
    ArrayList<String> nameList = new ArrayList<String>();

    public Usernames(String username) {

        this.username = username;

        try {


            URL url = new URL("https://api.mojang.com/users/profiles/minecraft/" + this.username);


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

                //Close the scanner
                scanner.close();
                JSONParser parser = new JSONParser();
                object = (JSONObject) parser.parse(inline);

                System.out.println(inline);
                UUID = object.get("id").toString();
                System.out.println(UUID);


            }
        } catch (
                Exception e) {
            e.printStackTrace();

        }

        try {


            URL url = new URL("https://api.mojang.com/user/profiles/" + this.UUID + "/names");


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

                //Close the scanner
                scanner.close();
                JSONParser parser = new JSONParser();
                array = (JSONArray) parser.parse(inline);



                for (int i = 0; i < array.size(); i++) {


                    nameList.add(((JSONObject) array.get(i)).get("name").toString());


                }
                System.out.println(nameList);

            }


        } catch (
                Exception e) {
            e.printStackTrace();

        }


    }


    public String UUID() {


        return this.UUID;
    }
}