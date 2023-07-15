import java.util.Scanner;
public class Guessingtheno {
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("-----------------------------------WelCome to GuessTheNumber game! -----------------------------------");
        System.out.println("You have to guess a number between 1 and 100. You'll have limited choices based on level you choose.Good luck!\n");
        System.out.println("Enter the difficulty level \n ");
        System.out.println(" 1 for easy!" + "          " + " 2 for medium!" + "           " + " 3 for difficult!" + "           " + " 0 for ending the game! \n");
        System.out.print("Enter difficulty Level : ");
        boolean letsplay =true;
        int count=0;                          //counts number of time user play game
        int won=0;                            //total count user won the game before ending game
        while (letsplay) {                    //while loop wil run if letsplay is true
            int level = sc.nextInt();
            switch (level) {
                case 1:
                    System.out.println();
                    System.out.println("You have 10 choices for finding the secret number between 1 to 100 \n");
                    won+=play(1);
                    System.out.println("---thank you---"+ "  "+"Play again! \n");
                    System.out.print("Enter difficulty Level : ");
                    break;
                case 2:
                    System.out.println();
                    System.out.println("You have 7 choices for finding the secret number between 1 to 100 \n");
                    won+=play(2);
                    System.out.println("---thank you---"+ "  "+"Play again! \n");
                    System.out.print("Enter difficulty Level : ");
                    break;
                case 3:
                    System.out.println();
                    System.out.println("You have 3 choices for finding the secret number between 1 to 100 \n");
                    won+=play(3);
                    System.out.println("---thank you---"+ "  "+"Play again! \n");
                    System.out.print("Enter difficulty Level : ");
                    break;
                case 0:
                    letsplay=false;
                    break;
            }
            count++;                                          //count number of times user play
        }System.out.println();                                //count-1 don't count level 0
        System.out.println("You have won "+ won +" games out of " +(count-1) + " games.");
        System.out.println("-----------------------thank you----------------------------!");
    }

    public static int play(int level) {
        int won1=0;                                        //won1 counts number of times you have won
        int choices=0;                                     //count the number of choices you have left
        if(level==1){
            choices=10;
        }else if(level==2){
            choices=7;
        }else if(level==3){
            choices=3;
        }
        Scanner sc = new Scanner(System.in);
        double random1 = Math.random() * 100 + 1;         //Math.random gives random number between 0 to 0.99
        int random = (int)random1;
        while (choices > 0) {                             //choices should be greater then zero
            System.out.print("Enter the Number : ");
            int number = sc.nextInt();                    //enter your number
            choices--;
            if(number==random){
                System.out.println("Well played! you won,"+ random + " is the secret number. ");
                if(level==1){
                    choices=10-choices;
                    System.out.println("Congratulation You won only in "+ choices + " choices out of 10 choices");
                }else if(level==2){
                    choices=7-choices;
                    System.out.println("Congratulation You won only in "+ choices + " choices out of 7 choices");
                }else if(level==3){
                    choices=3-choices;
                    System.out.println("Congratulation You won only in "+ choices + " choices out of 3 choices");
                }won1++;
                break;
            }if(number<=0||number>100){
                System.out.println("Please Enter valid input number should be between 1 to 100 ! \n");
                choices++;                   //choices++ because i not wanted that player loss 1 choices due to invalid input
            }else{
                switch (number / 10) {
                    case 10:
                        check(number, random, choices);
                        break;
                    case 9:
                        check(number, random, choices);
                        break;
                    case 8:
                        check(number, random, choices);
                        break;
                    case 7:
                        check(number, random, choices);
                        break;
                    case 6:
                        check(number, random, choices);
                        break;
                    case 5:
                        check(number, random, choices);
                        break;
                    case 4:
                        check(number, random, choices);
                        break;
                    case 3:
                        check(number, random, choices);
                        break;
                    case 2:
                        check(number, random, choices);
                        break;
                    case 1:
                        check(number, random, choices);
                        break;
                    case 0:
                        check(number, random, choices);
                        break;
                }
            }
        }if(choices==0) {                      //if player can't get correct choices
            System.out.println("You lost!, Secret number is " + random + " .Better luck for next time. \n");
        }
        return won1;                           //return 1 if user won the match
    }


    public static void check(int number, int random,int choices){
        if(number>random){
            System.out.println("Nope," + number + " is not the right number." );
            System.out.println("The secret number is lesser than the number you have chosen "+ choices + " choices left. \n");

        }else {
            System.out.println("Nope," + number + " is not the right number." );
            System.out.println("The secret number is greater than the number you have chosen "+ choices + " choices left. \n");
        }
    }

}


