/**
 * ICE 5/14/14
 * 
 * @author Nicholas Scheuring, Justin Bosma, Hussein Abou Nassif Mourad,
 * Jarred Lien
 * @version May 14, 2014
 */
public class ICE51414 {
    
    /**
     * Main method
     */
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9};
        int[] b = {3,45,5,6,2,1,1,3,4,5,6,8,4,5,7,7,43,2,65,6};
        
        sum(a);
        System.out.println("The sum of a is ::" + sum(a));
        System.out.println("The sum of b is ::" + sum(b));
        System.out.println("The sum of a and b is::" + (sum(a) + sum(b)) );
        
        System.out.println("racecare is a palindrome:" + palindrome("racecar"));
        System.out.println("jeep is a palindrome:" + palindrome("jeep"));
        System.out.println("poop is a palindrome :" + palindrome("poop"));
        
    }
    
    /**
     * Sums the elements of an array
     * REQUIRES:: an non empty array of integers
     * MODIFIES:: primitive representing the sum of the integers
     * EFFECTS::  returns a sum of array elements
     * @param a the array to sum
     * @return the sum of the array elements
     */
    public static int sum(int[] a) {
        int sum = 0;
        
        for(int i = 0; i < a.length; i++) {
            sum = sum + a[i];
        }
        return sum;
        
    }
    /**
     * Checks if a string reads the same backwards and forwards
     * REQUIRES::a non-empty string
     * MODIFIES::no modifications
     * EFFECTS:::Returns true if a palindrome, false if not
     * @param s - the string
     * @return the boolean value- true if a palindrome false if not
     */
    public static boolean palindrome(String s) {
        
        for (int i = 0; i <= (s.length() / 2); i++) {
            if (!(s.charAt(i) == (s.charAt((s.length() - 1) - i)))) {
                return false;
            }
        }
        return true;
    }
}