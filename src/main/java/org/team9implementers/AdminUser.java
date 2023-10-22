package org.team9implementers;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminUser {

    public Questions[] createQuestions() {

        Questions quest[]=null;
        System.out.println("Create Quiz - Be prepared to enter \n" +
                "1. No of Questions \n"+
                "2. Questions \n" +
                "3. Answers for the questions \n"+
                "4. Index in which the answer is placed \n");

        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Enter the no of questions ");
            int noOfQuestions = scan.nextInt();
            quest = new Questions[noOfQuestions];

            System.out.println("In AdminUser "+quest);

            for (int i = 0; i < noOfQuestions; i++) {
                int count = i+1;
                System.out.println("Enter question ID "+ count + ": ");
                quest[i].setQuestId(scan.nextInt());

                System.out.println("Enter question title "+ count + ": ");
                quest[i].setQuestion(scan.next());

                System.out.println("Enter the option 1 of "+ count + ": ");
                quest[i].setOption1(scan.next());
                System.out.println("Enter the option 2 of "+ count + ": ");
                quest[i].setOption2(scan.next());
                System.out.println("Enter the option 3 of "+ count + ": ");
                quest[i].setOption3(scan.next());
                System.out.println("Enter the option 4 of "+ count + ": ");
                quest[i].setOption4(scan.next());

                System.out.println("Enter the answer of "+ count + ": ");
                quest[i].setAnswer(scan.next());
            }

        }
        catch(InputMismatchException ime){
            System.out.println("Wrong Input Type "+ime.getMessage());
        }
        catch(Exception e){
            System.out.println("Unknown exception occurred "+e.getMessage());
        }
        return quest;
    }


}
