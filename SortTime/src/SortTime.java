import java.util.*;
import java.math.*;

import static java.lang.System.in;

// CSE 2300-01
// 84503 Lecture
// Discrete Structures
// Term Project
// 11/22/2022
// Justin Hale

public class SortTime {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {


        String selection = "";


        do {
            System.out.print("=================================================" +
                    "\nProgram 1\n" +
                    "Program 2\n" +
                    "Program 3\n" +
                    "Program 4\n" +
                    "Exit 5\n" +
                    "\nType the number of the program you want to run: ");
            selection = in.nextLine();
            System.out.println("\n=================================================");



            switch (selection) {
                case "1": {
                    program_1();
                    break;
                }
                case "2": {
                    program_2();
                    break;
                }
                case "3": {
                    program_3();
                    break;
                }
                case "4": {
                    program_4();
                    break;
                }
                case "5": {
                    break;
                }
                default: {
                    System.out.println("Invalid input");
                    break;
                }
            }

        } while (!(selection.equalsIgnoreCase("5")));{
            System.out.println("Exiting");
        }




    }//main

    /** Prompt User for size of array **/
    public static int prompt_User_Array_Size() {
        System.out.println();
        System.out.print("Enter a number for size of array: ");
        int N = in.nextInt();
        in.nextLine();
        System.out.println();
        return N;
    }

    /** Creates and returns a number_Array of size N with randomly generated integers **/
    public static int[] createRandomNumberArray(int N) {
        Random random = new Random();
        int randInt = random.nextInt();
        int[] number_Array = new int[N];

        //Populate number_Array with random integers
        for (int i = 0; i < N; i++) {
            number_Array[i] = randInt;
            //System.out.println(randInt);
            randInt = random.nextInt();
        }

        return number_Array;
    }


    /** Prints integers inside number_Array **/
    public static void printArray(int[] number_Array) {
        for (int i : number_Array) {
            System.out.println(i);
        }
        System.out.println();
    }


    /** Bubble Sort Method**/
    public static int[] bubbleSort(int[] array) {


        int[] bubble_Array = array;
        int n = bubble_Array.length;

        for (int j = n; j > 0; j--) {
            for (int i = 1; i < j; i++) {
                if (bubble_Array[i - 1] > bubble_Array[i]) {
                    swap(bubble_Array, i - 1, i);
                }
            }
        }

        return bubble_Array;
    }



    /** Swap Method. Swaps around two indexes in an array. This is Used in both Bubble and Selection Sort **/
    public static int[] swap(int[] array, int position1, int position2) {
        int[] swap_Array = array;
        int temp = swap_Array[position1];
        swap_Array[position1] = swap_Array[position2];
        swap_Array[position2] = temp;

        return swap_Array;
    }

    /** Selection Sort Method **/
    public static int[] selection_Sort(int[] array) {

        int[] selection_Sort_Array = array;
        int i;
        int j;
        int iMin;
        int n = selection_Sort_Array.length;

        for (j = 0; j < n; j++) {
            iMin = j;
            for (i = j + 1; i < n; i++) {
                if (selection_Sort_Array[i] < selection_Sort_Array[iMin]) {
                    iMin = i;
                }
            }
            if (iMin != j) {
                swap(selection_Sort_Array, j, iMin);
            }
        }

        return selection_Sort_Array;
    }



    /** Program 1 **/
    public static void program_1() {

        int N = prompt_User_Array_Size();

        int[] random_array = createRandomNumberArray(N);

        System.out.println("Before sorting");
        printArray(random_array);

        System.out.println("Bubble Sort");
        printArray(bubbleSort(random_array));
    }


    /** Program 2 **/
    public static void program_2() {

        int N = prompt_User_Array_Size();

        int[] random_array = createRandomNumberArray(N);

        System.out.println("Before sorting");
        printArray(random_array);

        System.out.println("Selection Sort");
        printArray(selection_Sort(random_array));
    }


    /** Program 3 **/
    public static void program_3() {

        int N = prompt_User_Array_Size();
        average_Bubble_Sort_Time(N);
        average_Bubble_Sort_Time(N);
        average_Bubble_Sort_Time(N);
        average_Bubble_Sort_Time(N);
        average_Bubble_Sort_Time(N);
        average_Bubble_Sort_Time(N);

        average_Bubble_Sort_Time(500);
        average_Bubble_Sort_Time(2500);
        average_Bubble_Sort_Time(5000);
    }

    /** Program 4 **/
    public static void program_4() {

        int N = prompt_User_Array_Size();
        average_Selection_Sort_Time(N);
        average_Selection_Sort_Time(N);
        average_Selection_Sort_Time(N);
        average_Selection_Sort_Time(N);
        average_Selection_Sort_Time(N);
        average_Selection_Sort_Time(N);

        average_Selection_Sort_Time(500);
        average_Selection_Sort_Time(2500);
        average_Selection_Sort_Time(5000);
    }


    /** Creates and Bubble sorts 1000 arrays of size N random integers. Timing how long it takes
     * to sort each array and finding the average of the thousand runs  **/
    public static void average_Bubble_Sort_Time(int N) {

        long total_time = 0;

        for (int i = 0; i < 1000; i++) {

            int[] random_array = createRandomNumberArray(N);

            // millisecond = (nanosecond / 1 million)
            long startTime = System.nanoTime();
            int [] number_Array_Sorted = bubbleSort(random_array);
            long running_time = System.nanoTime() - startTime;

            //System.out.println("TEST PRINT RUNNING TIME: "+running_time+" NanoSeconds");

            total_time = total_time + running_time;

            //System.out.println("TEST PRINT TOTAL TIME: "+total_time+" NanoSeconds" );
        }

        /** Average running time of 1000 runs **/
        long average_running_time = Long.divideUnsigned(total_time,1000);
        System.out.println();


        //System.out.println("AVERAGE RUN TIME IN NANOS: "+average_running_time);

        /** Converts back to milliseconds if big enough, else stays in nanoseconds **/
        if (Long.divideUnsigned(average_running_time, 1000000) > 0) {

            average_running_time = Long.divideUnsigned(average_running_time, 1000000);

            System.out.println("Size of array Bubble sorted: " + N);
            System.out.println("Average running time: "+ average_running_time+" ms");

        } else {
            System.out.println("Size of array Bubble sorted: " + N);
            System.out.println("Average running time: "+ average_running_time+" nanoseconds");

        }
    }


    /** Creates and Bubble sorts 1000 arrays of size N random integers. Timing how long it takes
     * to sort each array and finding the average of the thousand runs  **/
    public static void average_Selection_Sort_Time(int N) {

        long total_time = 0;

        for (int i = 0; i < 1000; i++) {

            int[] random_array = createRandomNumberArray(N);

            // millisecond = (nanosecond / 1 million)
            long startTime = System.nanoTime();
            int [] number_Array_Sorted = selection_Sort(random_array);
            long running_time = System.nanoTime() - startTime;

            //System.out.println("TEST PRINT RUNNING TIME: "+running_time+" NanoSeconds");

            total_time = total_time + running_time;

            //System.out.println("TEST PRINT TOTAL TIME: "+total_time+" NanoSeconds" );
        }

        /** Average running time of 1000 runs **/
        long average_running_time = Long.divideUnsigned(total_time,1000);
        System.out.println();


        //System.out.println("AVERAGE RUN TIME IN NANOS: "+average_running_time);

        /** Converts back to milliseconds if big enough, else stays in nanoseconds **/
        if (Long.divideUnsigned(average_running_time, 1000000) > 0) {

            average_running_time = Long.divideUnsigned(average_running_time, 1000000);

            System.out.println("Size of array Selection sorted: " + N);
            System.out.println("Average running time: "+ average_running_time+" ms");

        } else {
            System.out.println("Size of array Selection sorted: " + N);
            System.out.println("Average running time: "+ average_running_time+" nanoseconds");

        }
    }


}//Class
