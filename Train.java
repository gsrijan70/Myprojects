import java.util.*;
    public class Train {
    public static void main(String []args){                         //train name,phonenumber,hashset
    Scanner sc=new Scanner(System.in);
    HashMap<String,String> track=new HashMap<>();
    HashSet<String> hs=new HashSet<>();
    System.out.println("----------------------------------WEL-COME TO RAILWAY APP--------------------------------");
    track.put("bilaspur","raipur");
    track.put("raipur","nagpur");
 //   track.put("raipur","kolkata");
  //  track.put("nagpur","pune");
    track.put("nagpur","mumbai");
    track.put("kolkata","bihar");
  //  track.put("raipur","kota");
    track.put("kota","jaipur");
    track.put("jaipur","delhi");
    System.out.print("Enter Departure Platform : ");
    String dep=sc.nextLine();
    System.out.print("Enter Arrival Platform : ");
    String arr=sc.nextLine();
    System.out.print("Enter Date : ");
    String date=sc.nextLine();
    boolean tell=search(track,dep,arr);
    Passanger[] p=new Passanger[100];
    if(tell) {
        price1(track, dep, arr);
        System.out.print("Enter P to Procceed : ");
        char c=sc.next().charAt(0);
        sc.nextLine();
        if(c=='P') {
            System.out.print("Enter Department : ");
            String depar = sc.nextLine();
            int price = price2(track, dep, arr, depar);
            System.out.print("How many Ticket you want's to book : ");
            int book=sc.nextInt();
            p=new Passanger[book];
            int count = 0;
            sc.nextLine();
            for (int i = 0; i < book; i++) {
                System.out.print((i + 1) + " Enter Name : ");
                String name = sc.nextLine();
                hs.add(name);
                System.out.print("  Enter Age : ");
                int age = sc.nextInt();
                System.out.print("  Enter Phone Number : ");
                long phone=sc.nextLong();
                System.out.print("  Enter Gender : ");
                String gender = sc.nextLine();
                sc.nextLine();
                System.out.print("  Enter Berth : ");
                String berth = sc.nextLine();
                p[i] = new Passanger(name, age, phone, gender, berth);
                System.out.println();
                count = 1 + i;
            }
            int totalp=price*count;
            System.out.println("Total ticket price is : "+ totalp);
            System.out.print("Enter P to Pay : ");
            char c1=sc.next().charAt(0);
            sc.nextLine();
            if(c1=='P'){
                System.out.print("Enter Name : ");
                String namer = sc.nextLine();
               System.out.print("Enter Phone Number : ");
               long pn=sc.nextLong();
               System.out.print("Enter Card Number : ");
               long card =sc.nextLong();
               System.out.print("Enter Amount : ");
               int amount=sc.nextInt();
               boolean tell1=payment(amount,totalp);
               while(true) {
                   if (tell1){
                       break;
                   }else{
                       System.out.print("Enter Amount : ");
                       amount=sc.nextInt();
                       tell1=payment(amount,totalp);
                   }
               }
           }
        System.out.println("For more Queires Enter Q and E to Exit ");
        System.out.print("Enter Here : ");
        char c3 = sc.next().charAt(0);
        if (c3 == 'Q') {
            boolean b = true;
            while (b) {
                System.out.println();
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("Enter D to Display tickets                             Enter S to Search ticket");
                System.out.println("Enter C to Cancel ticket                               Enter E to Exit         ");
                System.out.print("Enter Here : ");
                char c4 = sc.next().charAt(0);
                switch (c4) {
                    case 'D':
                        double ran = Math.random() * 20 + 1;
                        int n7 = (int) ran;
                        for (int i = 0; i < p.length; i++) {
                           if(hs.contains(p[i].name)) {
                               p[i].display(dep.toUpperCase(), arr.toUpperCase());
                               System.out.println("Date : " + date);
                               System.out.println("Coach number is  : " + "S-" + n7);
                           }
                        }
                        break;
                    case 'S':
                        sc.nextLine();
                        System.out.print("Enter Name : ");
                        String name3 = sc.nextLine();
                        sc.nextLine();
                        System.out.print("Enter Phone-Number : ");
                        long n3 = sc.nextLong();
                        if (hs.contains(name3)) {
                            System.out.println("Yes Passanger Ticket is Booked ");
                            for (int i = 0; i < p.length; i++) {
                                if (p[i].phone == n3) {
                                    p[i].display(dep.toUpperCase(), arr.toUpperCase());
                                }
                            }
                        } else {
                            System.out.println("Passanger Ticket is not Booked");
                        }
                        break;
                    case 'C':
                        boolean v = true;
                        sc.nextLine();
                        while (v) {
                            System.out.print("Enter Name : ");
                            String name4 = sc.nextLine();
                            System.out.print("Enter Phone-Number : ");
                            char c5 = '1';
                            long n4 = sc.nextInt();
                            if (hs.contains(name4)) {
                                System.out.println("Ticket is cancelled Successfully !");
                                System.out.println("Your Ticket Amount will be Refunded within One Week");
                                System.out.println("-----Thank You------");
                                hs.remove(name4);
                                v = false;
                                break;
                            } else {
                                System.out.println("Ticket is not Found");
                                System.out.println("Enter R to try again and E to Exit");
                                c5 = sc.next().charAt(0);
                            }
                            if (c5 == 'R') {
                                v = true;
                            } else if (c5 == 'E') {
                                v = false;
                            }
                        }
                        break;
                    case 'E':
                        System.out.print("--------Thank You-----------");
                        b = false;
                }
            }
        } else {
            System.out.print("-------------Thank You-----------------");
        }
    }}else{
            System.out.print("----------------Thank You-------------------");
        }
 }
    public static boolean search(HashMap<String,String> track,String dep,String arr){
        String dep1=dep;
        while(track.containsKey(dep)){
            if(track.get(dep).equals(arr)){
                System.out.println("Train is available from "+dep1.toUpperCase()+" to "+arr.toUpperCase());
                return true;
            }else{
                dep=track.get(dep);
            }
        }
        System.out.println("Train is not available");
        return false;
    }
    public static void price1(HashMap<String,String> track,String dep,String arr){
    int ac=1000;
    int ac2=800;
    int ac3=600;
    int sle=450;
    int gen=200;
    int count=0;
        while(track.containsKey(dep)){
            count++;
            if(track.get(dep).equals(arr)){
                    break;
            }else{
                dep=track.get(dep);
            }
        }
        System.out.println();
        System.out.println("Price of Ticket for 1-AC is : "+ ac*count);
        System.out.println("Price of Ticket for 2-AC is : "+ ac2*count);
        System.out.println("Price of Ticket for 3-AC is : "+ ac3*count);
        System.out.println("Price of Ticket for Sleeper is : "+ sle*count);
        System.out.println("Price of Ticket for General is : "+ gen*count);
    }
        public static int price2(HashMap<String,String> track,String dep,String arr,String department) {
        int ac=0;
            switch (department) {
                case "1-AC":
                    ac = 1000;
                    break;
                case "2-AC":
                    ac = 800;
                    break;
                case "3-AC":
                    ac = 600;
                    break;
                case "Sleeper":
                    ac = 450;
                    break;
                case "General":
                    ac = 200;
                    break;
            }
            int count=0;
            while(track.containsKey(dep)){
                count++;
               // System.out.print(count);
                if(track.get(dep).equals(arr)){
                   return ac*count;

                }else{
                    dep=track.get(dep);
                }
            }
            return 0;
        }
        public static boolean payment(int price,int realprice){
            if(price==realprice){
                System.out.println("Payment Completed Successfully!");
                System.out.println("-----------Thank You------------");
                return true;
            }else{
                System.out.println("You have Entered Wrong Amount Please Try again !");
                return false;
            }
        }
    }
    class Passanger{
        String name;
        int age;
        String gender;
        long phone;
        String berth ;

        public Passanger(String name,int age,long phone,String gender,String berth) {
            this.name = name;
            this.age = age;
            this.phone=phone;
            this.gender = gender;
            this.berth = berth;
        }
        public void display(String dep1,String arr1){
            double n=Math.random()*100 +1;
            int ni=(int)n;
            System.out.println("---------------ticket-----------------");
            System.out.println("Departure from "+dep1+" and Arrival to "+arr1);
            System.out.println("Name : " +name);
            System.out.println("Age : "+ age);
          //  System.out.println("Gender : "+gender);
            System.out.println("Berth : "+berth);
            System.out.println("Seat No : "+ ni);
        }
   }