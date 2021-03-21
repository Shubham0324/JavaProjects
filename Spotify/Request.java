package advisor;

import java.util.Scanner;

public class Request {
    boolean auth = false;
    Scanner sc = new Scanner(System.in);


    protected void userChoice(String choice) {

            switch (choice) {
                case "auth":
                    this.auth();
                    break;
                case "new":
                    this.newRelease();
                    break;
                case "featured":
                    this.featured();
                    break;
                case "categories":
                    this.categories();
                    break;
                case "playlists Mood":
                    this.playlist();
                    break;
                case "exit":
                    this.shutdown();
                    break;
            }
    }

    protected void auth(){
        //String accessData  = sc.nextLine();
        System.out.println("https://accounts.spotify.com/authorize?client_id=522c2b385a7c415a977a2587479d6d91&redirect_uri=http://localhost:8080&response_type=code");
        this.auth = true;
        System.out.println("---SUCCESS---");
    }

    protected void newRelease(){
        if(!userAuthStatus()){
            return;
        }
        System.out.println("---NEW RELEASES---\n" +
                "Mountains [Sia, Diplo, Labrinth]\n" +
                "Runaway [Lil Peep]\n" +
                "The Greatest Show [Panic! At The Disco]\n" +
                "All Out Life [Slipknot]");
    }

    protected void featured(){
        if(!userAuthStatus()){
            return;
        }
        System.out.println("---FEATURED---\n" +
                "Mellow Morning\n" +
                "Wake Up and Smell the Coffee\n" +
                "Monday Motivation\n" +
                "Songs to Sing in the Shower");
    }

    protected void categories(){
        if(!userAuthStatus()){
            return;
        }
        System.out.println("---CATEGORIES---\n" +
                "Top Lists\n" +
                "Pop\n" +
                "Mood\n" +
                "Latin");
    }

    protected void playlist(){
        if(!userAuthStatus()){
            return;
        }
        System.out.println("---MOOD PLAYLISTS---\n" +
                "Walk Like A Badass  \n" +
                "Rage Beats  \n" +
                "Arab Mood Booster  \n" +
                "Sunday Stroll");
    }

    protected void shutdown(){
        System.out.println("---GOODBYE!---");
        System.exit(0);
    }


    protected boolean userAuthStatus(){
        if (!this.auth){
            System.out.println("Please, provide access for application.");
            return false;
        }
        return true;
    }
}


