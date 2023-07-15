import java.util.Scanner;
public class Bankingsystem {
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        System.out.println("-------------------------WELCOME TO BANKING SYSTEM----------------------------- ");
        System.out.println("Enter R if you wanted to register new account ");
        //   System.out.println("Enter k if you wanted to check you account ");
        System.out.print("Enter here : ");
        char enter=sc.next().charAt(0);
        long amount4=0;
        if(enter=='R'){
            System.out.println("To create Saving Account enter S");
            System.out.println("To Create Checking Account enter C ") ;
            System.out.print("Enter here : ");
            char acc=sc.next().charAt(0);
            if(acc=='S'){
                System.out.print("How many account you want to register : ");
                int number=sc.nextInt();
                SavingAccount[] a=new SavingAccount[number];
                sc.nextLine();
                for(int i=0;i<number;i++){
                    a[i]=new SavingAccount();
                    System.out.print("Enter your name : ");
                    a[i].accountHolderName=sc.nextLine();
                    System.out.print("Enter your account balance :");
                    a[i].setAccountBalance(sc.nextLong());
                    System.out.print("Enter your account number : ");
                    a[i].setAccountNumber(sc.nextLong());
                    System.out.println("Enter D if you wanted to deposite ");
                    System.out.println("Enter W if you wanted to withdraw");
                    System.out.println("Enter N if nothing to do ");
                    System.out.print("Enter here : ");
                    char type=sc.next().charAt(0);
                    if(type=='D'){
                        System.out.print("Enter Amoumt to deposit : ");
                        amount4=sc.nextLong();
                        a[i].deposit(a[i].getAccountBalance(),amount4);
                    } else if (type=='N') {}

                    else{
                        System.out.print("Enter Amoumt to deposit : ");
                        amount4=sc.nextLong();
                        a[i].withdraw(a[i].getAccountBalance(),amount4);

                    } sc.nextLine();
                }
                System.out.println("Enter Y if you wanted to transfer money ");
                System.out.print("Enter here : ");
                char trans=sc.next().charAt(0);
                if(trans=='Y') {
                    System.out.print("Enter how many account you wanted to transfer  : ") ;
                    int no=sc.nextInt();
                    System.out.print("Enter your accout number that is registered : ");
                    long urAcc = sc.nextLong();//print
                    //System.out.print("Enter amount");
                    long amount2=0;
                    for(int k=0;k<no;k++) {
                        System.out.print("Enter amount you wanted to transfer : ");
                        amount2 = sc.nextLong();
                        for (int i = 0; i < number; i++) {
                            if (a[i].getAccountNumber() == urAcc) {
                                a[i].transferfundS(a[i].getAccountBalance(), amount2);
                            }
                        }
                        System.out.print("Enter Account number in which you  wanted to transfer : ");
                        long thrAcc = sc.nextLong();
                        for (int j = 0; j < number; j++) {
                            if (a[0].getAccountNumber() == thrAcc) {
                                a[j].transferfundR(a[j].getAccountBalance(), amount2);
                            }
                        }
                    }
                    System.out.print("Enter H to See your Account History otherwise Enter E to Exit ");
                    char check=sc.next().charAt(0);
                    sc.nextLine();
                    if(check=='H'){
                        System.out.print("Enter your Account number : ");
                        long nam=sc.nextLong();
                        for(int i=0;i<number;i++){
                            if(a[i].getAccountNumber()==nam){
                                System.out.println("Your name is : " + a[i].accountHolderName);
                                System.out.println("Your account number is : " + a[i].getAccountNumber());
                                System.out.println("Your account balance is : "+ a[i].getAccountBalance());
                                System.out.println("Your amount after you transfer :" +a[i].transferfundS(a[i].getAccountBalance(), amount2));
                                System.out.println("Your amount after you receive : "+ a[i].transferfundR(a[i].getAccountBalance(), amount2));
                                System.out.println("Amount you transfer : "+ amount2);
                                System.out.print("Thank you");
                            }
                        }
                    }else{
                        System.out.print("Thank you");
                    }
                }else{
                    System.out.print("Enter H to See your Account History otherwise Enter E to Exit ");
                    char check=sc.next().charAt(0);
                    sc.nextLine();
                    if(check=='H'){
                        System.out.print("Enter your Account number");
                        long nam=sc.nextLong();
                        for(int i=0;i<number;i++){
                            if(a[i].getAccountNumber()==nam){ //try with Account number
                                System.out.println("Your name is : " + a[i].accountHolderName);
                                System.out.println("Your account number is : " + a[i].getAccountNumber());
                                System.out.println("Your account balance is : "+ a[i].getAccountBalance());
                                System.out.println("Your amount after you diposit : " +a[i].deposit(a[i].getAccountBalance(),amount4) );
                                System.out.println("Your amount after you withdraw  : "+ a[i].withdraw(a[i].getAccountBalance(),amount4));
                                System.out.print("Thank you");
                            }
                        }
                    }else{
                        System.out.print("Thank you");
                    }
                }
            }//****************************************************************************************************
            else{
                System.out.print("How many account you want to register : ");
                int number=sc.nextInt();
                CheckingAccount[] a=new CheckingAccount[number];
                sc.nextLine();
                for(int i=0;i<number;i++){
                    a[i]=new CheckingAccount();
                    System.out.print("Enter your name : ");
                    a[i].accountHolderName=sc.nextLine();
                    System.out.print("Enter your account balance :");
                    a[i].setAccountBalance(sc.nextLong());
                    System.out.print("Enter your account number : ");
                    a[i].setAccountNumber(sc.nextLong());
                    System.out.println("Enter D if you wanted to deposite ");
                    System.out.println("Enter W if you wanted to withdraw");
                    System.out.print("Enter here : ");
                    char type=sc.next().charAt(0);
                    long amount2;
                    if(type=='D'){
                        System.out.print("Enter Amoumt to deposit : ");
                        amount2=sc.nextLong();
                        a[i].deposit(a[i].getAccountBalance(),amount2);
                    }else{
                        System.out.print("Enter Amoumt to deposit : ");
                        amount2=sc.nextLong();
                        a[i].withdraw(a[i].getAccountBalance(),amount2);

                    } sc.nextLine();
                }
                System.out.print(a[0].getAccountNumber());
                long urAcc = sc.nextLong();
                long amount2;
                System.out.print("Enter amount you wanted to transfer : ");//withdraw and dep in Y and -----,decoration
                amount2 = sc.nextLong();
                for (int i = 0; i < number; i++) {
                    if (a[i].getAccountNumber() == urAcc) {
                        a[i].transferfundS(a[i].getAccountBalance(),amount2);
                    }
                } System.out.print("Enter Account number in which you  wanted to transfer : ");
                long thrAcc = sc.nextLong();
                for (int j = 0; j < number; j++) {
                    if (a[0].getAccountNumber() == thrAcc) {
                        a[j].transferfundR( a[j].getAccountBalance(),  amount2);
                    }
                }
            }
        }
    }
}//*************************************************************************************************************
abstract class Account{
    private long accountNumber;
    public String accountHolderName;
    private long accountBalance;

    public long getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }
    public long getAccountBalance() {
        return accountBalance;
    }
    public void setAccountBalance(long accountBalance) {
        this.accountBalance = accountBalance;
    }
    abstract public long deposit(long accountBalance,long amount);  //we can get private variable also as parameter
    abstract public long withdraw(long accountBalance,long amount1);
    abstract public long transferfundS(long accountBalance, long amount3);
    abstract public long transferfundR(long accountBalance, long amount3);

}
class SavingAccount extends Account {
    public long deposit(long accountBalance,long amount){
        accountBalance+=amount;
        return accountBalance;
    }
    public long withdraw(long accountBalance,long amount1){
        accountBalance-=amount1;
        return accountBalance;
    }
    public long transferfundS(long accountBalance, long amount3) {
        return withdraw(accountBalance, amount3);

    }
    public long transferfundR(long accountBalance, long amount3) {
        return deposit(accountBalance,amount3);

    }
}
class CheckingAccount extends Account {
    Scanner sc=new Scanner(System.in);
    public long deposit(long accountBalance, long amount) {
        accountBalance += amount;
        return accountBalance;

    }

    public long withdraw(long accountBalance, long amount1) {
        accountBalance -= amount1;
        return accountBalance;
    }

    public long transferfundS(long accountBalance, long amount3) {
        return withdraw(accountBalance, amount3);

    }
    public long transferfundR(long accountBalance, long amount3) {
        return deposit(accountBalance,amount3);

    }
}




