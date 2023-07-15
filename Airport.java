import java.util.*;
public class Airport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> h = new HashMap();
        HashSet<String> hs = new HashSet();//give reverse
        h.put("JFK", "SFO");
        h.put("SFO", "HKO");
        h.put("YYZ", "SFO");
        h.put("YUL", "YYZ");
        h.put("HKO", "ORD");
        boolean j=true;//use while loop also
        System.out.println();
        System.out.println("---------------------------------------WELCOME TO MY AIRPORT APP------------------------------------");
        System.out.println();
            System.out.print("Departure Airport : ");
            String dep = sc.nextLine();//TO UPPRT CASE
            System.out.print("Arrival Airport : ");
            String arr = sc.nextLine();
            System.out.print("Enter Date : ");
            String date=sc.nextLine();
            boolean order = ticket(dep.toUpperCase(), arr.toUpperCase(), h, 0, dep.toUpperCase());
            Passanger[] p = new Passanger[0];
            if (order) {
                int price1 = ticket1(dep.toUpperCase(), arr.toUpperCase(), h);
                //      System.out.print(price1);
                System.out.println();
                System.out.println("Enter B to Book your ticket and E to Exit ! ");
                System.out.print("Enter Here : ");
                char c = sc.next().charAt(0);
                if (c == 'B') {
                    System.out.print("How many tickets you wanted to Book : ");
                    int book = sc.nextInt();
                    p = new Passanger[book];
                    int price = 0;
                    sc.nextLine();
                    for (int i = 0; i < book; i++) {
                        System.out.print((i + 1) + " Enter Name : ");
                        String name = sc.nextLine();
                        System.out.print("  Enter Age : ");
                        int age = sc.nextInt();
                        System.out.print("  Enter Phone-number : ");
                        long phone = sc.nextLong();
                        System.out.print("  Enter ID_PROOF : ");
                        sc.nextLine();
                        String idproof = sc.nextLine();
                        System.out.println();
                        p[i] = new Passanger(name, age, phone, idproof);
                        price = 1 + i;
                    }
                    for (int i = 0; i < p.length; i++) {
                        hs.add(p[i].name1);                                 //we have use name1 not name
                        //    System.out.print(hs);
                    }
                    int price2 = price * price1;
                    System.out.println("Your to Total tickets price is : " + (price * price1));
                    System.out.println("Enter P to Proceed with Payment and E to Exit !");
                    System.out.print("Enter Here : ");
                    char c1 = sc.next().charAt(0);
                    if (c1 == 'P') {
                        boolean pay = true;
                        while (pay) {
                            sc.nextLine();
                            System.out.print("Enter Name : ");
                            String name2 = sc.nextLine();
                            System.out.print("Enter Your Account Number : ");
                            int accnum = sc.nextInt();
                            System.out.print("Enter Phone-Number : ");
                            long pn = sc.nextLong();
                            int bok = 0;
                            sc.nextLine();
                            for (int i = 0; i < book; i++) {
                                if (p[i].phone1 == pn) {                            // string not works in if condition
                                    //  System.out.print("jj");
                                    System.out.print("Enter Amount : ");
                                    int amo = sc.nextInt();
                                    boolean procced = p[i].payment(amo, price2);
                                    bok = 1;
                                    pay = false;
                                    break;
                                }
                            }
                            char c2 = 'y';
                            if (bok == 0) {
                                System.out.println("Account number is not Found");
                                System.out.println("please enter T to try again or E to Exit! ");
                                System.out.print("Enter Here : ");
                                c2 = sc.next().charAt(0);
                            }
                            if (c2 == 'E') {
                                pay = false;
                            } else if (c2 == 'T') {
                                pay = true;
                            }
                        }
                    }
                } else {
                    order = false;
                }
            } else {
                System.out.println("------------Thank You-------------");
                return;
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
                            double ran = Math.random() * 300 + 1;
                            int n7 = (int) ran;
                            for (int i = 0; i < p.length; i++) {
                                p[i].display(dep.toUpperCase(), arr.toUpperCase());
                                System.out.println("Date : "+ date);
                                System.out.println("Flight : " + "IN" + n7);
                  /*  double n = Math.random() * 150 + 1;
                    int n1 = (int) n;
                    System.out.println("---------------ticket-----------------");
                    System.out.println("Departure from " + dep.toUpperCase() + " and Arrival to " + arr.toUpperCase());
                    System.out.println("Name : " + p[i].name1);
                    System.out.println("Age : " + p[i].age1);
                    System.out.println("Phone-Number : " + p[i].phone1);
                    System.out.println("ID-PROOF : " + p[i].id_proof);
                    System.out.println("Seat No : " + n1);*/
                            }
                            break;
                        case 'S':
                            sc.nextLine();
                            System.out.print("Enter Name : ");
                            String name3 = sc.nextLine();
                            System.out.print("Enter Phone-Number : ");
                            long n3 = sc.nextLong();
                            if (hs.contains(name3)) {
                                System.out.println("Yes Passanger Ticket is Booked ");
                                for (int i = 0; i < p.length; i++) {
                                    if (p[i].phone1 == n3) {
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
        }
        public static boolean ticket (String key, String value, HashMap < String, String > h,int count, String key1){
            Stack<Boolean> s1 = new Stack();
            int tell = 0;
            int price = 3000;
            boolean tru = true;
            boolean n = true;
            while (tru) {
                count++;
                if (h.containsKey(key)) {
                    String value1 = h.get(key);
                    char[] c = value.toCharArray();
                    char[] c1 = value1.toCharArray();
                    if (c.length == c1.length) {
                        for (int i = 0; i < c.length; i++) {
                            if (c[i] == c1[i]) {
                                tell++;                                                        //
                            }
                        }
                        if (tell == c.length) {
                            System.out.println("Flight from " + key1 + " to " + value + " is avalable ");
                            System.out.println("TICKET price is " + (price * count));
                            n = true;
                            tru = false;
                            break;
                        } else {
                            value1 = value1.valueOf(c1);
                            value = value.valueOf(c);
                            //ticket(value1, value, h, count,key1);
                            key = value1;
                        }
                    }
                } else {
                    System.out.println("Flight is not available for that route");
                    n = false;
                    tru = false;
                }
            }
            return n;
        }
        public static int ticket1 (String key, String value, HashMap < String, String > h){
            int tell = 0;
            int price = 3000;
            boolean tru = true;
            int count = 0;
            //   System.out.print(count);
            while (tru) {
                count++;
                if (h.containsKey(key)) {
                    String value1 = h.get(key);
                    char[] c = value.toCharArray();
                    char[] c1 = value1.toCharArray();
                    if (c.length == c1.length) {
                        for (int i = 0; i < c.length; i++) {
                            if (c[i] == c1[i]) {
                                tell++;                                                        //
                            }
                        }
                        if (tell == c.length) {
                            return price * count;

                        } else {
                            value1 = value1.valueOf(c1);
                            value = value.valueOf(c);
                            //ticket1(value1, value, h, count);
                            key = value1;
                        }
                    }
                } else {
                    tru = false;
                }
            }
            return price * count;
        }
    }
    class Passanger{
        public String name1;
        public int age1;
        public long phone1;
        public String id_proof ;
        Passanger(String name1,int age1,long phone1,String id_proof){
            this.name1=name1;
            this.age1=age1;
            this.phone1=phone1;
            this.id_proof=id_proof;
        }
        public boolean payment(int price,int realprice){
            if(price==realprice){
                System.out.println("Payment Completed Successfully!");
                System.out.println("-----------Thank You------------");
                return true;
            }else{
              System.out.print("You have Entered Wrong Amount Please Try again !");
              return false;
            }
        }public void display(String dep1,String arr1){
                double n=Math.random()*150 +1;
                int ni=(int)n;
                System.out.println("---------------ticket-----------------");
                System.out.println("Departure from "+dep1+" and Arrival to "+arr1);
                System.out.println("Name : " +name1);
                System.out.println("Age : "+ age1);
                System.out.println("Phone-Number : "+phone1);
                System.out.println("ID-PROOF : "+id_proof);
                System.out.println("Seat No : "+ ni);
            }
        }

























  /*  public static boolean ticket(String key,String value,HashMap<String ,String> h,int count,String key1){
        Stack<Boolean> s1=new Stack();
        int tell=0;
        int price=3000;
        boolean tru=true;
        boolean n=true;
        if(tru) {
            count++;
            if (h.containsKey(key)) {
                String value1 = h.get(key);
                char[] c = value.toCharArray();
                char[] c1 = value1.toCharArray();
                if (c.length == c1.length) {
                    for (int i = 0; i < c.length; i++) {
                        if (c[i] == c1[i]) {
                            tell++;                                                        //
                        }
                    }
                    if (tell == c.length) {
                        System.out.println("Flight from " + key1 + " to " + value + " is avalable ");
                        System.out.println("TICKET price is " + (price * count));
                        n=true;
                    } else {
                        value1 = value1.valueOf(c1);
                        value = value.valueOf(c);
                        ticket(value1, value, h, count,key1);
                    }
                }
            }else{
                System.out.println("Fllight is not available for that route");
                n=false;
            }
        } s1.push(n);
     //   System.out.print(s1.size());
        return s1.peek();
    }*///****************************************************************************************************
 /*   public static int ticket1(String key,String value,HashMap<String ,String> h){
        int tell=0;
        int price=3000;
        boolean tru=true;
        int count=0;
     //   System.out.print(count);
        while(tru) {
            count++;
            if (h.containsKey(key)) {
                String value1 = h.get(key);
                char[] c = value.toCharArray();
                char[] c1 = value1.toCharArray();
                if (c.length == c1.length) {
                    for (int i = 0; i < c.length; i++) {
                        if (c[i] == c1[i]) {
                            tell++;                                                        //
                        }
                    }
                    if (tell == c.length) {
                       return  price * count;

                    } else {
                        value1 = value1.valueOf(c1);
                        value = value.valueOf(c);
                        //ticket1(value1, value, h, count);
                        key=value1;
                    }
                }
            }else{
                tru=false;
            }
        }return price*count;
    }**************************************************************************************************
    public static boolean ticket(String key,String value,HashMap<String ,String> h,int count,String key1){
        Stack<Boolean> s1=new Stack();
        int tell=0;
        int price=3000;
        boolean tru=true;
        boolean n=true;
        while(tru) {
            count++;
            if (h.containsKey(key)) {
                String value1 = h.get(key);
                char[] c = value.toCharArray();
                char[] c1 = value1.toCharArray();
                if (c.length == c1.length) {
                    for (int i = 0; i < c.length; i++) {
                        if (c[i] == c1[i]) {
                            tell++;                                                        //
                        }
                    }
                    if (tell == c.length) {
                        System.out.println("Flight from " + key1 + " to " + value + " is avalable ");
                        System.out.println("TICKET price is " + (price * count));
                        n=true;
                        tru=false;
                        break;
                    } else {
                        value1 = value1.valueOf(c1);
                        value = value.valueOf(c);
                        //ticket(value1, value, h, count,key1);
                        key=value1;
                    }
                }
            }else{
                System.out.println("Fllight is not available for that route");
                n=false;
                tru=false;
            }
        }
        return n;
    }
}//**********************************************************************************************************8
class Passanger{
    public String name1;
    public int age1;
    public String phone1;
    public String id_proof ;
    Passanger(String name1,int age1,String phone1,String id_proof){
    this.name1=name1;
    this.age1=age1;
    this.phone1=phone1;
    this.id_proof=id_proof;
    }
}*/























/*else{
            System.out.println("Flight is not available for that route");
            return false;
        }*/