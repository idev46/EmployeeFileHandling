import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CatchingExceptions {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> myAl = new ArrayList<>();


        try {
            System.out.print("Please enter the number of integers to enter into an Integer ArrayList: ");
            int numOfIntegers = scanner.nextInt();

            for (int i = 0; i < numOfIntegers; i++) {

                System.out.print("Please enter an integer for entry ");
                int entry = scanner.nextInt();
                myAl.add(entry);
            }

            System.out.print("Please enter the index to read and print a value from: ");
            int index = scanner.nextInt();

            System.out.printf("The value at index %d is %d%n", index, myAl.get(index));

        } catch (InputMismatchException | IndexOutOfBoundsException exception) {
            exception.printStackTrace();

            if (exception instanceof InputMismatchException)
                System.out.println("You must enter an integer!  ");
            else System.out.println("You cannot enter an out of bounds index!");
            //else if(exception instanceof IndexOutOfBoundsException)
        } finally {
            scanner.close();
            System.out.println("The program is now ending!!!");
        }
    }
}
