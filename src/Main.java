import java.util.Scanner;
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

    // let's define some of our lists which contain all of the data that our user's list will pull from

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

    private ArrayList<ArrayList<Integer>> finalArrayList = new ArrayList<>();

    private ArrayList<Integer> newList = new ArrayList<>();

    private ArrayList<Integer> newList2 = new ArrayList<>();

    private ArrayList<Integer> newList3 = new ArrayList<>();

    private ArrayList<Integer> newList4 = new ArrayList<>();

    // should this method's contents just be apart of the main method?
    private void mainMenu() {
        Scanner in;
        Integer choice, lists, sampleSize;

        in = new Scanner(System.in);

        /*
        for now, we will allow the program to run forever
        but in the future, i will have the program give the user
        the option to continue running the program or exit once through
        */
        while (true) {
            System.out.println("enter 1 for generic person 1\nenter 2 for generic person 2\nenter 3" +
                    " for generic person 3\nenter 4 for generic person 4");
            choice = in.nextInt();

            System.out.println("enter the number of lists to be included::");
            lists = in.nextInt();

            System.out.println("enter the sample size::");
            sampleSize = in.nextInt();

            getFinalList(lists, sampleSize, choice);
        }
    }

    private void getFinalList(Integer lists, Integer sampleSize, Integer choice) {
        /*
        let's clear our lists and ArrayList just in case the
        program has already ran and looped before
        */

        newList.clear();
        newList2.clear();
        newList3.clear();
        newList4.clear();
        finalArrayList.clear();

        setFinalList(finalArrayList, lists, sampleSize);

        String name = getName(choice);
        System.out.println("\nfinal list for:: " + name);

        System.out.println(newList + "\n" + newList2 + "\n" + newList3 + "\n" + newList4);

        System.out.println("\n");
    }

    private int[] getRandomList(Integer howMany) {
        /*
        using the ThreadLocalRandom import module, we can randomize which list
        and what number we wish to choose

        i decided to go ahead and create this method as the setFinalList was
        cluttered enough as it was
         */

        int[] whichList;
        whichList = array1; // the default list is the first list defined above
        int randList = ThreadLocalRandom.current().nextInt(0, howMany + 1);

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

    private void setFinalList(ArrayList<ArrayList<Integer>> finalArrayList, Integer lists, Integer sampleSize) {
        /*
        here, we will attempt to finalize the user's data in our list

        notice that we call the method getRandomList, which can be found above

        TODO:: allow the user to create as many lists as possible without limiting them to a max of 4
        TODO:: further cleanup, as this current implementation is ugly and not the best
        */

        if (lists == 1) {
            while (finalArrayList.size() < lists) {
                while (newList.size() < sampleSize) {
                    int[] whichList = getRandomList(1);
                    int whichIndex = ThreadLocalRandom.current().nextInt(0, whichList.length);
                    int rand = whichList[whichIndex];
                    newList.add(rand);
                    finalArrayList.add(newList);
                }
            }
        }
        else if (lists == 2) {
            while (finalArrayList.size() < lists) {
                while (newList.size() < sampleSize) {
                    int[] whichList = getRandomList(1);
                    int whichIndex = ThreadLocalRandom.current().nextInt(0, whichList.length);
                    int rand = whichList[whichIndex];
                    newList.add(rand);
                    finalArrayList.add(newList);
                }
                while (newList2.size() < sampleSize) {
                    int[] whichList = getRandomList(2);
                    int whichIndex = ThreadLocalRandom.current().nextInt(0, whichList.length);
                    int rand = whichList[whichIndex];
                    newList2.add(rand);
                    finalArrayList.add(newList2);
                }
            }
        }
        else if (lists == 3) {
            while (finalArrayList.size() < lists) {
                while (newList.size() < sampleSize) {
                    int[] whichList = getRandomList(1);
                    int whichIndex = ThreadLocalRandom.current().nextInt(0, whichList.length);
                    int rand = whichList[whichIndex];
                    newList.add(rand);
                    finalArrayList.add(newList);
                }
                while (newList2.size() < sampleSize) {
                    int[] whichList = getRandomList(2);
                    int whichIndex = ThreadLocalRandom.current().nextInt(0, whichList.length);
                    int rand = whichList[whichIndex];
                    newList2.add(rand);
                    finalArrayList.add(newList2);
                }
                while (newList3.size() < sampleSize) {
                    int[] whichList = getRandomList(3);
                    int whichIndex = ThreadLocalRandom.current().nextInt(0, whichList.length);
                    int rand = whichList[whichIndex];
                    newList3.add(rand);
                    finalArrayList.add(newList3);
                }
            }
        }
        else if (lists == 4) {
            while (finalArrayList.size() < lists) {
                while (newList.size() < sampleSize) {
                    int[] whichList = getRandomList(1);
                    int whichIndex = ThreadLocalRandom.current().nextInt(0, whichList.length);
                    int rand = whichList[whichIndex];
                    newList.add(rand);
                    finalArrayList.add(newList);
                }
                while (newList2.size() < sampleSize) {
                    int[] whichList = getRandomList(2);
                    int whichIndex = ThreadLocalRandom.current().nextInt(0, whichList.length);
                    int rand = whichList[whichIndex];
                    newList2.add(rand);
                    finalArrayList.add(newList2);
                }
                while (newList3.size() < sampleSize) {
                    int[] whichList = getRandomList(3);
                    int whichIndex = ThreadLocalRandom.current().nextInt(0, whichList.length);
                    int rand = whichList[whichIndex];
                    newList3.add(rand);
                    finalArrayList.add(newList3);
                }
                while (newList4.size() < sampleSize) {
                    int[] whichList = getRandomList(4);
                    int whichIndex = ThreadLocalRandom.current().nextInt(0, whichList.length);
                    int rand = whichList[whichIndex];
                    newList4.add(rand);
                    finalArrayList.add(newList4);
                }
            }
        }
    }

    private String getName(Integer choice) {
        String name;
        name = ""; // initialize the variable as an empty string, will get overridden in other scopes

        if (choice == 1) {
            name = "generic person 1";
            return name;
        }
        else if (choice == 2) {
            name = "generic person 2";
            return name;
        }
        else if (choice == 3) {
            name = "generic person 3";
            return name;
        }
        else if (choice == 4) {
            name = "generic person 4";
            return name;
        }
        return name;
    }

    public static void main(String[] args) {
        /*
        cheeky workaround for calling a non static method from
        our main static method that i was not aware of before!!
        ;)
         */
        Main x = new Main();
        x.mainMenu();
    }

}
