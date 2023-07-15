import java.util.Scanner;
public class calculator{
public static void main(String []args){

//  ~ = squareroot , @ = cuberoot , # = reverse of number , 2 = square , $ = 10^a , e=e^a , C = start new
// y = a^(b)/2 , x = closing , ! = factorial of number
                Scanner sc=new Scanner(System.in);
                System.out.println();
                System.out.println("**************************** Wel Come To My Calculator ****************************");
                System.out.print("Enter first Number : ");
                float a = sc.nextFloat();
                boolean cal = true;                                                   //here we have taken boolean true
                while (cal == true) {                                                 // now we have used while loop
                System.out.print("Enter Operator : ");
                char c = sc.next().charAt(0);
                if (c == 'x') {                                                   // to end the code
                System.out.print("Thank You");
                break;
                }
                if (c == '+' || c == '-' || c == '*' || c == '/' || c == '%' || c == '^' || c == 'y') {
                System.out.print("Enter Number : ");
                float b = sc.nextFloat();
                switch (c) {
                case '+':                                                 // addition of two number
                float add = addition(a, b);
                System.out.println("= " + add);
                a = add;
                break;
                case '-':                                                 //subtration of two number
                float sub = subtration(a, b);
                System.out.println("= " + sub);
                a = sub;
                break;
                case '*':                                                 //multiplication of two number
                float mul = multiplication(a, b);
                System.out.println("= " + mul);
                a = mul;
                break;
                case '/':                                                  //division of two number
                float div = division(a, b);
                System.out.println("= " + div);
                a = div;
                break;
                case '%':                                                   //module of two number
                float mod = module(a, b);
        System.out.println("= " + mod);
        a = mod;
        break;
        case '^':                                                     //power of number
        float pow = (float) power(a, b);
        System.out.println("= " + pow);
        a = pow;
        break;
        case 'y':                                                     //root of number
        float xpow = (float) xpower(a, b);
        System.out.println("= " + xpow);
        a = xpow;
        break;
        }
        } else {
        switch (c) {
        case '~':                                                      // square root of a number
        float sqrt = (float) squareroot(a);
        System.out.println("= " + sqrt);
        a = sqrt;
        break;
        case '@':                                                       //cube root of a number
        float cbrt = (float) cube(a);
        System.out.println("= " + cbrt);
        a = cbrt;
        break;
        case '!':                                                        // factorial of a number
        float fact = (float) factorial(a);
        System.out.println("= " + fact);
        a = fact;
        break;
        case '#':                                                         // int to float
        float rev = reverse(a);
        System.out.println("= " + rev);
        a = rev;
        break;
        case '2':                                                         // square of a number
        float sqr = (float) square(a);
        System.out.println("= " + sqr);
        a = sqr;
        break;
        case '$':                                                         // 10^a
        float ten = (float) tenpow(a);
        System.out.println("= " + ten);
        a = ten;
        break;
        case 'e':                                                         // e^a
        float expo = (float) exponantial(a);
        System.out.println("= " + expo);
        a = expo;
        break;
        case 'C':                                                          //starting new calculation
        System.out.println();
        System.out.println("*********************Start new calculation*********************");
        System.out.print("Enter First Number :");
        a=sc.nextInt();
        break;
        default:
        System.out.println("You have entered invalid operator ");
        break;
        }
        }
        }
        }

        public static float addition(float a,float b) { return a+b;}
        public static float subtration(float a,float b){
        return (a-b);
        }
        public static float division(float a,float b){
        return a/b ;
        }
        public static float multiplication(float a,float b){
        return a*b;
        }
        public static float module(float a,float b){
        return a%b;
        }
        public static double power(float a,float b){return Math.pow(a,b);}
        public static double squareroot(float a){return Math.sqrt(a);}
        public static double cube(float a){return Math.cbrt(a);}
        public static float factorial(float a){int fac=1;
        for(int i=1;i<=a;i++){ fac*=i; } return fac;
        }
        public static float reverse(float a){ return 1/a;}
        public static double square(float a){ return Math.pow(a,2);}
        public static double tenpow(float a){ return Math.pow(10,a);}
        public static double exponantial(float a){ double e=2.718; return Math.pow(e,a);}
        public static double xpower(float a,float b){ return Math.pow(a,b/2);}
        }

