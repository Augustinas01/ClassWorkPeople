package helpers;

import objects.User;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Reader {

    private HashMap<Integer, User> allUsersDB = new HashMap<>();
    private HashMap<Integer, User> userNoMail = new HashMap<>();

    private ArrayList<String> countries = new ArrayList<>();

//    private HashMap<String, HashMap
//                                <String, HashMap
//                                        <Integer,User>>> countries = new HashMap<>();


    public Reader(){
        initUsersDB();

    }

    public HashMap<Integer, User> getAllUsersDB() {
        return allUsersDB;
    }

    public HashMap<Integer, User> getUserNoMail() {
        return userNoMail;
    }

    public ArrayList<String> getCountries() {
        return countries;
    }

    private void initUsersDB(){

        File usersDB = new File("src/data/" + "People.csv");

        HashMap<String,String> userInfo = new HashMap<>();

        User user;
        String[] keys = null;


        try (BufferedReader br = new BufferedReader(new FileReader(usersDB))) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                //Sets keys
                if(data[0].equals(User.ID)){
                    keys = data;
                    continue;
                }

                int i = 0;

                //User info to HashMap
                if(keys != null) {
                    for (String key : keys) {
                        userInfo.put(key, data[i]);
                        i++;
                    }
                }


                user = new User(userInfo);
                allUsersDB.put(Integer.parseInt(user.getId()),user);

                if(userInfo.get(User.EMAIL).equals("")){
                    userNoMail.put(Integer.parseInt(user.getId()),user);
                }
                if(!countries.contains(userInfo.get(User.COUNTRY))){
                    countries.add(userInfo.get(User.COUNTRY));
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}
