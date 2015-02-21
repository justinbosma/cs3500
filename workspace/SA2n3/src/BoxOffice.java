import java.util.*;

public class BoxOffice{
    public static int A = 2010; //year
    public static int B=8;//avatar weekday matinee
    public static int C=10;//avatar reg
    public static int D=6;//matinee los otros
    public static int E=8;//weekday reg others
    public static int F=3;//surcharge
    public static int G=2;//student discount


    public static void main(String [] args) {
        userInterface();
    }

    //Return true if the date is a valid date between March 1 & May 15
    //Return false otherwise 
    public static boolean isValidDate (int month, int day){
        if(month==3){
            if(day>=1 && day<=30){ 
                return true;
            }
        } else if (month ==4){
            if(day>=1&&day<=30){
                return true;
            }
        }else if (month==5){
            if(day>=1&&day<=15){
                return true;
            }
        }
        return false;
    }

    //This method must use Zeller's algorithm described below.
    //Return true if date falls on Monday through Thursday
    //Return false if date falls on Friday through Sunday
    //You may assume the month and day are valid
    public static boolean isWeekday (int month, int day) {
        int w = A-(14-month)/12;
        int x = w+w/4-w/100+w/400+w;
        int z = month+12*((14-month)/12)-2;
        int dow = (day+x+(31*z)/12)%7;
        if (dow>=1&&dow<=4){
            return true;
        }
        return false;
    }

    //Return cost of tickets or 
    //-1 if movie and/or date is/are invalid or number of tickets < 0
    public static int getCost (String movie, int month, int day, 
            boolean isMatinee,
            int numberOfAdultTickets, int numberOfStudentTickets) {
        if(!helperC(movie)||!isValidDate(month,day)||
           !helperA(numberOfAdultTickets)||
           !helperA(numberOfStudentTickets)){
            return -1;
        }
        int cost = 0;
        String lowMovie = movie.toLowerCase();
        boolean weekday = isWeekday(month, day);
        if(lowMovie.equals("avatar")){
            if(isMatinee){ 
                if(weekday){
                    cost=cost+B*(numberOfAdultTickets+
                         numberOfStudentTickets);
                } else{
                    cost=cost+(B+F)*(numberOfAdultTickets+
                         numberOfStudentTickets);
                }
            } else{ 
                if(weekday){
                    cost=cost+(C)*numberOfAdultTickets+(C-G)*
                         numberOfStudentTickets;
                } else{
                    cost=cost+(C+F)*numberOfAdultTickets+(C+F-G)*
                         numberOfStudentTickets;
                }
            }
        }else {
            if(isMatinee){ 
                if(weekday){
                    cost=cost+D*(numberOfAdultTickets+
                         numberOfStudentTickets);
                } else{
                    cost=cost+(D+F)*(numberOfAdultTickets+
                         numberOfStudentTickets);
                }
            } else{ 
                if(weekday){
                    cost=cost+(E)*numberOfAdultTickets+(E-G)*numberOfStudentTickets;
                } else{
                    cost=cost+(E+F)*numberOfAdultTickets+(E+F-G)*numberOfStudentTickets;
                }
            }
        }
        return cost*2;
    }

    /**
     * Provides the user interface.
     */
    public static void userInterface() {
        System.out.println("Welcome to Oscar Movie Madness!\n"+
          "When prompted, please enter the movie you would like see, the date,"+ 
          "\nwhether or not it is a matinee, and the number of adult and "+
          "student tickets \nyou would like to purchase.");
        Scanner console = new Scanner(System.in);
        System.out.print("Movie (Avatar, The Blind Side, Up): ");
        String movie = console.nextLine();
        boolean valid = helperC(movie);
        helperD(valid);

        System.out.print("Month: ");
        int month = console.nextInt();

        System.out.print("Day: ");
        int day = console.nextInt();

        valid = isValidDate(month,day);
        helperD(valid);

        System.out.print("Matinee (y,n): ");
        String matinee = console.next();

        valid = helperB(matinee);
        helperD(valid);

        System.out.print("Number of adult tickets: ");
        int adult = console.nextInt();
        valid = helperA(adult);
        helperD(valid);

        System.out.print("Number of student tickets: ");
        int student = console.nextInt();
        valid = helperA(student);
        helperD(valid);

        boolean boolMatinee=false;
        if(matinee.charAt(0)=='y'||matinee.charAt(0)=='Y'){
            boolMatinee = true;
        }

        System.out.println("Cost of Tickets: $"+
                   getCost(movie, month, day, boolMatinee, 
                   adult, student));
    }
    //is the number > 0
    //@param num - the number
    public static boolean helperA(int num){ 
        if(num>=0){
            return true;
        }
        return false;
    }
    //Checks if String is correct format y,Y,n,N
    //Spec. for matinee field in user input
    //@param yn - the String
    public static boolean helperB(String yn){
        if(yn.length()==1){
            if(yn.charAt(0)=='y'||yn.charAt(0)=='n'
               ||yn.charAt(0)=='Y'||yn.charAt(0)=='N'){
                return true;
            }
        }
        return false;
    }

    //Checks if user input movie name is one of the
    //current available movies
    //@param movie - the movie title
    public static boolean helperC(String movie){
        String lowMovie = movie.toLowerCase();    
        if (lowMovie.equals("Avatar")
            ||lowMovie.equals("the blind side")
            ||lowMovie.equals("up")){
            return true;
        }
        return false;
    }
    //Valid/Invalid input messages
    //if the parameter(valid) is true
    //prints message to screen
    //@param valid - boolean value
    public static void helperD(boolean valid){
        if(!valid){
            System.out.println("Invalid Input");
            System.exit(1);
        }
    }
}
