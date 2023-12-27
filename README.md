# SortTime
This is from one of my school assignments. The program compares Bubble Sort vs Selection Sort

## Watch SortTime Run
See the code run through my Replit link below. I commented out both of the large sorting methods to help with the slowness of Replit

https://replit.com/@jhale40/SortTime#Main.java


## Assignment Instructions
BACKGROUND

Module 7 showed that one way of comparing different algorithms for accomplishing the same task is complexity analysis.
You will recall that in complexity analysis we express the time an algorithm takes to run as a function of the size of
the input, and we used the big-Oh notation. For example, if an algorithm has a complexity of O(1), then it always runs
in the same amount of time, no matter what the size of the input is; if it O(n), then the time it takes for the algorithm
to run is proportional to the size of the input.

However, complexity analysis has a number of limitations. For example, big-Oh analysis concerns the worst case scenario.
For example, some sorting algorithms with a complexity of O(n^2) often run considerably faster if the list that it receives
as input is (almost) sorted; other sorting algorithms with a complexity of O(n^2) always take the same amount of time,
no matter what state the list is in. Also, in big-Oh, we look at the dominant term in our calculation of the complexity
of the algorithm. Thus, when we analyze an algorithm and discover that it runs in 75,312 + n time units, we still say
that it has a complexity of O(n). It is therefore deemed to be better than an algorithm that run in .007 + n^2 time
units, as this algorithm has a complexity of O(n^2). We also saw the rationale behind this: If n becomes sufficiently
large, the other factors become insignificant.

Fortunately, there is another way to determine how long it takes for an algorithm to run, namely timing experiments.
In a timing experiment, you actually implement the algorithm in a programming language, such as Java or C++, and simply
measure how long it takes for the algorithm to run.

In the term project for this course, you are going to conduct a timing experiment and compare the results with the results
you would get from a complexity analysis. We will compare Bubble Sort with Selection Sort.

In its least sophisticated form, bubble sort (http://en.wikipedia.org/wiki/Bubble_sort) works as follows:

Assuming that the list contains n elements.
Compare the first and the second element in the list, and swap them if the last element is smaller than the preceding
one; otherwise, do nothing to this pair.
Now, compare second and third element t and swap them if the first of them is larger than the second; otherwise, do
nothing to this pair.
Move on the next pair and continue the process until you reach the end of the list.
A little reflection will show that at the end of this iteration, the last element in the list is now the largest element
in the list. The last element has bubbled to the top.
Now repeat the process but rather than going to the end of the list, stop when you reach n-1.
Now repeat the process again, but rather than going to the end of the list, stop when you reach n-2.
Keep repeating this until you reach 1.
The Wikipedia entry has a little simulation that shows how bubble sort works. The code looks something like:

bubbleSort(array A){
n = length(A);

for(j = n; j > 0, j--)
for(i = 1; i < j; i++) {
if A[i-1] > A[i]
swap(A,i-1, i);
}
}
}

swap obviously swaps the elements and can be defined as:

swap(A, pos1, pos2) {
temp = A[pos1];
A[pos1] = A[pos2];
A[pos2] = temp;
}

Another sort is selection sort (http://en.wikipedia.org/wiki/Selection_sort). We saw selection sort in the question in
the sub-module on how to determine the complexity of an algorithm. Array A contains n elements, the elements to be
sorted.  The algorithm starts at the first position in the array and looks through the array for the smallest element.
Once it reaches the end of the array, it puts that element in the first cell of the array.  It then restarts the whole
process from the second position in the array, and continues until the entire array has been sorted.

selection_sort(array A) {
int i,j
int iMin;
for(j = 0; j < n; j++){
iMin = j;

for ( i = j+1; i < n; i++) {
if (a[i] < a[iMin]) {
iMin = i;
}
}

if ( iMin != j ) {
swap(a[j], a[iMin]);
}
}
}

If you like the Hungarian dancers, they perform selection sort at http://www.youtube.com/watch?v=Ns4TPTC8whw
THE PROJECT

The purpose of the project is to perform a timing experiment. You are required to complete the following activities:

Write a computer program that prompts the user for a number, creates an array for that number of random integers, and
then use the bubble sort to order the array. The program should print out the array prior to the call to the sorting
algorithm and afterwards. You can write the program in either Java, C++, C#, or whatever language you are most
comfortable in.
Repeat 1 but use selection sort this time.
1 and 2 are primarily intended to make sure that your algorithms work.

Once you are convinced your programs work, do the following

Write a computer program that prompts the user for one number, n for the number of items in the array to sort, and
create and sort 1000 arrays of this size timing the run to get an average time to sort an array of this size. Then do
the following:

Initiate a variable running_time to 0

Create a for loop that iterates 1000 times.

In the body of the loop,

Create an array of n random integers

Get the time and set this to start-time. You will have to figure out what the appropriate command is in the programming
language you are using to find the time (Important: Do not start the timer until after the array is created).

Use bubble sort to sort the array

Get the time and set this to end-time Subtract start-time from end-time and add the result to total_time

Once the program has run, note

The number of items sorted

The average running time for each array (total_time/1000)

Repeat the process six times, using 500, 2500 and 5000 as the size of the array for each of the two algorithms.

Repeat 3 using selection sort.
Create a spreadsheet showing the results of 3 and 4 and create a graph to graphically represent the information. Show
both sort algorithms on the same graph for comparison.
Write a one page document explaining the results, bearing in mind that both algorithms have a complexity of O(n^2) and
what you know about complexity analysis. Use your knowledge of complexity analysis to explain your results.
Please submit

Program code for 1
Program code for 2
Program code used in 3 and the results of the nine program runs
Program code used in 4 and the results of the nine program runs
The spreadsheet created in 5
The report. In the report, say which machine you ran the experiments on (type of processor, RAM, etc).
Use the associated drop box.  You can submit all of this in a single file, or in separate files.  If you have any
questions, post them on the discussion forum.

Grading will be determined by your data , graphs and your write-up including observations and what you have learned.
