public class Project1 {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    private static int remove( char array[], int[] count, int removeIndex) {
        if (removeIndex < 0 || removeIndex >= array.length) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        char removedChar = array[removeIndex];
        for (int i = removeIndex; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = '\0'; // Optional: Set the last element to null character
        count[0]--; // Decrease the count of elements
        return removedChar;
    }

    private static void arrayChanger(int[] arr, int index, int newValue) {
        if (index < 0 || index >= arr.length) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        arr[index] = newValue;
        // Print the modified array
        System.out.print("Modified array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    private static String arrayPrinter(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num).append(" ");
        }
        return sb.toString().trim();
    }
}
