package org.team9implementers;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserRoles {

    String adminUserName="admin";
    String adminUserPasswd="1111";

    public final static int ADMIN_ROLE = 1;
    public final static int PLAYER_ROLE = 2;

    public final static int SUPER_ADMIN_ROLE = 0;

    public void identifyUser() {

        int adminOrPlayer=0;
        System.out.println("Hi, welcome to the Quiz App - Let's know whether you are Admin or Player - For Admin, press 1, To play, press 2");
        Scanner scan = new Scanner(System.in);
        try {
            adminOrPlayer = scan.nextInt();
        }
        catch (InputMismatchException ime){
            System.out.println("Wrong Input type: Expected Int - Retry " + ime.getMessage());
        }
        catch(Exception e){
            System.out.println("Unknown exception occurred in User Roles " + e);
        }

        validateUser(adminOrPlayer);
    }

    public void validateUser(int adminOrPlayer) {

        Questions quest[]=null;
        if(adminOrPlayer == ADMIN_ROLE) {
            // Admin User
            System.out.println("Welcome Admin to create the quiz");

            Scanner scan = new Scanner(System.in);
            try {
                System.out.println("Enter the admin user name");
                String userName = scan.next();
                System.out.println("Enter the admin password");
                String password = scan.next();
                if (userName.equalsIgnoreCase(adminUserName) && password.equalsIgnoreCase(adminUserPasswd)) {
                    AdminUser au = new AdminUser();
                    quest = au.createQuestions();
                }
            }
            catch(InputMismatchException iue){
                System.out.println("Wrong Input type: Expected String - Retry " + iue.getMessage());
            }
            catch (Exception e){
                System.out.println("Unknown exception occurred in User Roles " + e);
            }
        }
        else if(adminOrPlayer == PLAYER_ROLE) {
            // Player
            System.out.println("Welcome Player to play the quiz");
            System.out.println("Enter the player user name");
            Player player = new Player();
            player.playQuiz();

        } else if (adminOrPlayer == SUPER_ADMIN_ROLE) {
            System.out.println("I am the ultimate user of this app.");
            System.out.println("I am gonna cut down all the access");
        }

    }
}
