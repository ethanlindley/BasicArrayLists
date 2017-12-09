import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    /*
    Class Main.java written by Ethan Lindley, 12-8-17

    Basically, the main class stores 4 integer arrays in an object.  The program then uses these arrays to generate
    several array lists for output.  In the main method, the program outputs a menu and allows the user to select which
    student they want lists for.  Then, the user will ask the program for the number of lists and the size of the lists
    to pull sample data from.  These lists will be filled with random numbers from that user’s array.
     */

    private int[] array1 = {60, 60, 60, 60, 60, 60, 58, 58, 58, 58, 58, 59, 59, 59, 59, 59, 61, 61, 61, 61, 61, 62, 62,
            62, 62, 62, 56, 56, 56, 56, 57, 57, 57, 57, 63, 63, 63, 63, 64, 64, 64, 64, 55, 55, 55, 65, 65, 65, 53, 53,
            54, 54, 66, 66, 67, 67, 51, 52, 68, 69};

    private int[] array2 = {20, 20, 20, 20, 20, 20, 20, 25, 25, 25, 25, 25, 25, 25, 95, 95, 95, 95, 95, 95, 95, 100,
            100, 100, 100, 100, 100, 100, 15, 15, 15, 15, 30, 30, 30, 30, 90, 90, 90, 90, 105, 105, 105, 105, 10, 10,
            10, 110, 110, 110, 5, 5, 35, 35, 85, 85, 115, 115, 40, 80};

    private int[] array3 = {100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 90, 90, 90, 90, 90,
            90, 115, 115, 115, 115, 115, 115, 55, 55, 55, 55, 70, 70, 70, 70, 10, 10, 10, 30, 30, 30, 40, 40, 40, 50,
            50, 50, 25, 25, 65, 65, 75, 75, 80, 80, 85, 85, 105,
            105, 5, 60};

    private int[] array4 = {105, 105, 105, 105, 105, 105, 105, 105, 105, 105, 105, 105, 105, 105, 40, 40, 40, 40, 40,
            40, 40, 40, 40, 40, 40, 70, 70, 70, 70, 70, 70, 70, 70, 10, 10, 10, 10, 10, 10, 85, 85, 85, 85, 5, 5, 5,
            50, 50, 50, 0, 0, 15, 15, 75, 75, 80, 80, 90, 90, 45};

    private ArrayList<Integer> finalList = new ArrayList<>();

    // should this method just be contained within the main method?
    // keep it static for now
    private void mainMenu() {
        Scanner in;
        Integer choice, lists, sampleSize;

        in = new Scanner(System.in);

        while (true) {
            System.out.println("enter 1 for jimmy\nenter 2 for johnny\nenter 3 for john\nenter 4 for jimbo");
            choice = in.nextInt();

            System.out.println("enter the number of lists to be included::");
            lists = in.nextInt();

            System.out.println("enter the sample size::");
            sampleSize = in.nextInt();

            getFinalList(lists, sampleSize, choice);
        }
    }

    private void getFinalList(Integer lists, Integer sampleSize, Integer choice) {
        setFinalList(finalList, lists, sampleSize);

        String name = getName(choice);
        System.out.println("\nfinal list for:: " + name);

        for (Integer i: finalList) {
            System.out.println(i);
        }

        System.out.println("\n");
    }

    private int[] getRandomList(Integer howMany) {
        int[] whichList;
        whichList = array1;
        int randList = ThreadLocalRandom.current().nextInt(0, howMany + 1);
        System.out.println(randList);

        if (randList == 1) {
            whichList = array1;
            return whichList;
        }
        else if (randList == 2) {
            whichList = array2;
            return whichList;
        }
        else if (randList == 3) {
            whichList = array3;
            return whichList;
        }
        else if (randList == 4) {
            whichList = array4;
            return whichList;
        }
        return whichList;
    }

    private void setFinalList(List<Integer> finalList, Integer lists, Integer sampleSize) {
        if (lists == 1) {
            while (finalList.size() < sampleSize) {
                int rand = ThreadLocalRandom.current().nextInt(0, array1.length);
                finalList.add(array1[rand]);
            }
        }
        else if (lists == 2) {
            while (finalList.size() < sampleSize) {
                int[] whichList = getRandomList(2);
                int rand = ThreadLocalRandom.current().nextInt(0, whichList.length);
                finalList.add(whichList[rand]);
            }
        }
        else if (lists == 3) {
            while (finalList.size() < sampleSize) {
                int[] whichList = getRandomList(3);
                int rand = ThreadLocalRandom.current().nextInt(0, whichList.length);
                finalList.add(whichList[rand]);
            }
        }
        else if (lists == 4) {
            while (finalList.size() < sampleSize) {
                int[] whichList = getRandomList(4);
                int rand = ThreadLocalRandom.current().nextInt(0, whichList.length);
                finalList.add(whichList[rand]);
            }
        }
    }

    private String getName(Integer choice) {
        String name;
        name = "";

        if (choice == 1) {
            name = "jimmy";
            return name;
        }
        else if (choice == 2) {
            name = "johnny";
            return name;
        }
        else if (choice == 3) {
            name = "john";
            return name;
        }
        else if (choice == 4) {
            name = "jimbo";
            return name;
        }
        return name;
    }

    public static void main(String[] args) {
        // cheeky workaround for calling a non static method
        // from our main static method ;)
        Main x = new Main();
        x.mainMenu();
    }

}
