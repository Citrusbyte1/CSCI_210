## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
===========================================================================

Instructions for Module 5, Exercise #3
In this exercise you will use two stacks to sort an array of numbers. We'll use two of our dynamic stacks (using singly-linked lists as the underlying data structure) to sort the array.

Part 1 - Initialize the project
    Start by using these programs which will create an array of numbers in either ascending, random, or descending order:
        1. Use Sorter.java, StackLinkedList.java, and UnderflowException.java classes in the project
        2. Notice that in Sorter.java's main()
            a. The program prompts for one of three ways to initialize an array (ascending, random, or descending).
            b. An array of numbers is then created with that many numbers in the specified order.
            c. The contents of the array are printed on the screen.
            d. The array is passed to a method named sorter() which uses two of our dynamic linked lists to put the array in order.
            e. The number of pushes required to sort the array is displayed along with the contents of the array again (this time in sorted order).
        3. Notice the heading of the sorter() method which sorts the array. The sequence <E extends Comparable<E>> defines a generic type represented by E which must have a compareTo() method so that objects of that class can be sorted. The sorter() method returns an int which is the number of pushes on a stack required to sort the parameter array.
        4. Run the program using a "random" sequence of 100 numbers. Notice that the initial array initially shows 100 numbers in a random sequence, but the second "sorted" array isn't sorted at all. Let's complete the "sorter" method.

Complete the sorter() method
    This method takes an array of generic elements in an unspecified order and uses two dynamic stacks to sort the array (stack1 and stack2).
        1. In the sorter() method, create two stacks of type E (the generic type), then copy the contents of the array passed as a parameter into stack1. Add this code immediately under the comment line "Start Adding Code Here".
            a. "// holds the array to be sorted
                StackLinkedList<E> stack1 = new StackLinkedList<>() ;
                // holds the sorted array when finished
                StackLinkedList<E> stack2 = new StackLinkedList<>() ; 

                // Load the array onto stack1
                for (E element : arr) {
                    stack1.push(element) ;
                }"
        2. Under that code, create a loop that finishes when the first stack becomes empty:
            a. "while (! stack1.isEmpty()) {  
                // to be filled in below
                }"
        3. Inside the while loop from step 2, pop the top element from stack1 and store in a temporary variable, then push all elements currently on stack2 that are less than the temporary variable back onto stack1. Notice that we had to assure Java that the class being sorted has a compareTo() method in the heading of the sorter() method. Increment the "push" count each time an element is pushed back. Insert this code inside the while loop above:
            a. " E temp = stack1.pop() ;
                while (! stack2.isEmpty() && 
                        temp.compareTo(stack2.peek()) > 0 ) {  
                    stack1.push(stack2.pop()) ;
                    count++ ;
                }
        4. Still inside the while loop from step 2, add this code to push the number in the temporary variable onto stack2. Remember that all elements on stack2 are always in sorted order when viewed from top to bottom:
            a. "stack2.push(temp) ;  
                count++ ;"
        5. When the while loop in step 2 completes, the contents of stack2 are loaded back into the array and the sorting process is complete. Copy this code outside of the while loop (just before returning to the calling method):
            a. "// Reload the elements from stack2 onto the array
                for (int i = 0 ; i < arr.length ; i++) {
                    arr[i] = stack2.pop() ;
                }"

Test the sorter() method
    Run the program using a random sequence of 100 numbers. The program should show the initial unsorted array, then show the number of pushes used by the sorter() method to sort the array followed by the resulting sorted array. The number of pushes should be approximately 5,000 (the number will vary). Sorting a random set of numbers is considered an "average" or "typical" case.
    Run the program again using 1,000 numbers in a random sequence. Both the unsorted and sorted arrays should be displayed, but the number of elements in the array was incresed by a factor of 10 and the number of pushes increased by a factor of 100.
    Do the same two runs again with 100 numbers and again with 1,000 numbers, but using an initial array in descending order. Again the number of pushes increases by a factor of 100 when the number of elements in the array was increased by 10, but the number of pushes is much worse than using an array in random order.
    Finally, do the same two runs again with 100 numbers and with 1,000 numbers using an array initially in ascending order. Looking at the results, this represents the best-case behavior of the sorting algorith, -- the array is already sorted. Does the sorting algorithm have a time complexity of O(n^2) in both average and worst case and O(n) in the best case?

Please submit the final version of the programs for this exercise showing the results when sorting an array initially in a random sequence of 100 or more numbers. (Submission of the results of other runs is unnesecarry.)