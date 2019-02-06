/*
Program Name: Assignment_1
Author: Brianna Drew
Student No.: 0622446
Date Created: 02/02/2019
Last Modified: 02/05/2019
*/


// import required java libraries.
import java.util.Scanner;
import java.lang.System;
import java.util.concurrent.TimeUnit;


/*
Class: FibonacciNumbers
Description: This class will take an integer from the user representing how many Fibonacci numbers they want to be calculated
             and printed. It will then calculate this using a recursive function, and output the Fibonacci sequence. It will
             then calculate the time elapsed (in nanoseconds) to perform the calculations and outputs, and will output this
             result. It will then repeat this entire process using an iterative function (for loop). This is mainly meant to
             show the difference in time between recursive and iterative functions.
*/
public class Fibonacci_Numbers {


    private static int n1 = 0, n2 = 1; // first two Fibonacci numbers (no need to calculate).


    /*
    Method: main
    Description: The primary method of the program. This introduces the program and the recursive and iterative functions to the
                 user. For the recursive function, it calls the reader function to get the integer representing the number of
                 Fibonacci numbers to be printed/calculated, then passes it to the recursive function. It also calculates and outputs
                 the time elapsed (in nanoseconds) to complete the recursive function. Before it calls the iterative function, it
                 resets the previously defined variables representing the first two numbers of the Fibonacci sequence to their
                 original values after they were altered within the recursive function. After calling and the completion of the
                 iterative function, it then exits the program.
    Usage: primary method in class FibonacciNumbers
    Parameters: String args[]
    Return Type: void
    */
    public static void main(String args[]) {

        System.out.println(); // blank line, for output formatting.
        System.out.println("Welcome to the Fibonacci Sequence Recursion/Iteration Comparison Program!"); // welcome message.
        System.out.println(); // blank line, for output formatting.
        System.out.println("RECURSIVE FUNCTION:"); // introduce recursive function.

        int n; // define integer variable to store user-entered number
        boolean exit = false; // boolean variable (set to false so it will run through do while at least once)
        do {
            n = reader(); // call reader function.
            if (n > 0){ // if n is greater than 0 (valid)...
                exit = true; // exit do while loop
            }
            else { // if n is an invalid integer...
                System.out.println("Invalid integer. Please try again."); // print error message
            }
        } while (!exit); // do while exit is false

        long startTime = System.nanoTime(); // get and store time at beginning of recursive function.
        fibSeriesRec(n); // call recursive function.
        long endTime = System.nanoTime(); // get and store time at end of recursive function.
        long timeElapsed = endTime - startTime; // calculate total time elapsed during recursive function.
        System.out.println(); // blank line, for output formatting.
        System.out.println("Elapsed Time for Recursive Function: " + timeElapsed + " nanoseconds."); // print total time elapsed during recursive function.
        System.out.println(); // blank line, for output formatting.

        n1 = 0; // reset first number of Fibonacci sequence.
        n2 = 1; // reset second number of Fibonacci sequence.
        System.out.println("ITERATIVE FUNCTION:"); // introduce iterative function.
        fibSeriesIte(); // call iterative function.

        System.exit(0); // exit program.

    }


    /*
    Method: reader
    Description: Reads integer n from user to represent number of Fibonacci numbers to be calculated/printed, then returns n.
    Usage: called in main and fibSeriesIte methods
    Parameters: none
    Return Type: integer
    */
    private static int reader() {

        Scanner scanner = new Scanner(System.in); // create new scanner object to scan user input.
        System.out.println("How many Fibonacci numbers would you like to generate?: "); // prompt user to enter number.
        int n = scanner.nextInt(); // read user-entered number and store as integer.
        return n; // return user-entered integer.
    }


    /*
    Method: fibSeriesRec
    Description: Takes user-inputted integer n from main method (from reader method) and calculates and prints the Fibonacci sequence of n
                 numbers recursively. At the end of the function (within the if statement), the method calls itself again (for each number).
                 Each time through the function, n decreases by 1, and it will only run through the if statement while n is greater than 0.
                 Therefore, it will go through the function the original, user-inputted value of n times.
    Usage: called in main method as well as within itself, fibSeriesRec method (recursion)
    Parameters: integer n (from main, from reader. number of Fibonacci numbers to be calculated/printed)
    Return Type: void
    */
    private static void fibSeriesRec(int n) {

        if(n>0){ // if the number entered by user is greater than 0...

            System.out.print(n1 + " "); // print next Fibonacci number in sequence.
            int sum = n1 + n2; // calculate sum of previous two numbers in Fibonacci sequence.
            n1 = n2; // set value of first number to second number (move first number that will be added in calculation of next number in sequence over).
            n2 = sum; // set value of second number to the sum of previous two numbers (move second number that will be added in calculation of next number in sequence over).
            fibSeriesRec(n-1); // call to restart recursive function and decrease n by 1.
        }

    }


    /*
    Method: fibSeriesIte
    Description: Calls reader method to get a user-inputted integer to represent the amount of Fibonacci numbers to be printed in the
                 Fibonacci sequence. Will then use a for loop to iteratively calculate and output Fibonacci sequence. The time elapsed
                 during the for loop will be calculated and output as well.
    Usage: called in main method
    Parameters: none
    Return Type: void
    */
    private static void fibSeriesIte() {

        int n; // define integer variable to store user-entered number
        boolean exit = false; // boolean variable (set to false so it will run through do while at least once)
        do {
            n = reader(); // call reader function.
            if (n > 0){ // if n is greater than 0 (valid)...
                exit = true; // exit do while loop
            }
            else { // if n is an invalid integer...
                System.out.println("Invalid integer. Please try again."); // print error messages
            }
        } while (!exit); // do while exit is false

        long startTime = System.nanoTime(); // get and store time at start of iterative function.

        for (int i = 1; i <= n; i++) { // for loop that will run n times (number of Fibonacci numbers desired by user).

            System.out.print(n1 + " "); // print next Fibonacci number in sequence.
            int sum = n1 + n2; // calculate sum of previous two numbers in Fibonacci sequence.
            n1 = n2; // set value of first number to second number (move first number that will be added in calculation of next number in sequence over).
            n2 = sum; // set value of second number to the sum of previous two numbers (move second number that will be added in calculation of next number in sequence over).

        }

        long endTime = System.nanoTime(); // get and store time at end of iterative function.
        long timeElapsed = endTime - startTime; // calculate total time elapsed during iterative function.
        System.out.println(); // blank line, for output formatting.
        System.out.println("Elapsed Time for Iterative Function: " + timeElapsed + " nanoseconds."); // print total elapsed time during iterative function.

    }

}
