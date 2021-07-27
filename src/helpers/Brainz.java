package helpers;

import objects.User;

import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Brainz {

    private Reader reader;
    private Scanner sc;

    private boolean sleep = true;

    public Brainz(Scanner sc){
        this.sc = sc;
        reader = new Reader();
    }

    public void  welcome(){
        System.out.printf("There are %s users%n",reader.getAllUsersDB().size());
        System.out.printf("%s of them doesn't have emails%n", reader.getUserNoMail().size());
        System.out.printf("There are %s countries%n", reader.getCountries().size());
    }

    public boolean aintSleepin(){
        return sleep;
    }

    public void work(){
        System.out.println("Do you wanna search user? Y/N");
        String answer = sc.nextLine().toLowerCase();

        switch (answer){
            case "y" -> workMore();
            case "n" -> sleep = false;
            case "s" -> printCountryStats();
            default -> {
                System.out.println("Wrong answer :( try again.");
                work();
            }
        }
    }

    private void workMore(){
        System.out.println("You wanna search by (F)irst name or (L)ast name?");
        String answer = sc.nextLine().toLowerCase();

        switch (answer){
            case "f" -> search(true);
            case "l" -> search(false);
            default -> {
                System.out.println("Wrong answer :( try again.");
                workMore();
            }
        }
    }

    private void search(boolean byFirstName){
        System.out.println("What name are we looking for?");
        String name = sc.nextLine();
        List<User> results;

        if(byFirstName){
            results = reader.getAllUsersDB()
                    .values()
                    .stream()
                    .filter(user -> user.getFirstName().toLowerCase().contains(name.toLowerCase().trim()))
                    .toList();

        }else{
            results =reader.getAllUsersDB()
                    .values()
                    .stream()
                    .filter(user -> user.getLastName().toLowerCase().contains(name.toLowerCase().trim()))
                    .toList();

        }

        System.out.printf("There are %s results%n",results.size());
        for(User user:results){
            System.out.printf("ID: %s FIRST NAME: %s LAST NAME: %s%n", user.getId(),user.getFirstName(),user.getLastName());
        }



    }

    private void printCountryStats(){
    }


}
