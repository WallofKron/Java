package projecttwo;

import projectTwo.UserInput;

/**
 * @author RobertFlorence Java 182 - Project 2 - compares linear search and
 * binary search for effectiveness
 */
public class ProjectTwo {

    public static void main(String[] args) throws Exception {
        int k = 0, h = 0, j = 0, lavg = 0, bavg = 0, inputs = 0, totall = 0;
        int totalb = 0, saves = 0;
        String[] namesarray = ProjectTwo.getNamesArray();
        String[] sortednames = new String[namesarray.length];
        String input = "typy";
        System.out.println("Type 'exit' or 'quit' to exit program");

        copyArray(namesarray, sortednames);
        h = insertionSort(sortednames);

        while (!input.equalsIgnoreCase("quit") && !(input.equalsIgnoreCase("exit"))) {
            System.out.print("Enter name to search for: ");
            input = UserInput.getString();
            System.out.print("\n");
            k = ProjectTwo.linearSearch(namesarray, input) + 1;
            j = binarySearch(sortednames, input);


            if (k != -1 && j != -2) {

                inputs++;
                totall = totall + k;
                totalb = totalb + j;
                lavg = totall / inputs;
                bavg = totalb / inputs;
                saves = lavg - bavg;

                System.out.print("Number of linear searches: " + k + "   ");
                System.out.println("Average # of linear searches: " + lavg);

                System.out.print("Number of binary searches: " + j + "   ");
                System.out.println("Average # of binary searches: " + bavg);

                if (saves > 0) {

                    System.out.println("binary search saves " + saves + " comparisons");
                    System.out.println("It will take " + (h / ((totall / inputs) - (totalb / inputs))) + " searches before binary sort overhead of " + h + " comparisons is crossed.\n");
                } else {
                    System.out.println("Linear Search is faster than Binary Search...\n");
                }
            }
        }
    }

    protected static int linearSearch(String[] namesarray, String input) {

        if (input.equalsIgnoreCase("quit") || (input.equalsIgnoreCase("exit"))) {
            return -2;
        }
        for (int i = 0; i < namesarray.length; i++) {
            if (input.equalsIgnoreCase(namesarray[i])) {
                return i;
            }
        }
        return -2;
    }

    protected static void copyArray(String[] source, String[] target) throws Exception {

        System.arraycopy(source, 0, target, 0, source.length);

    }

    protected static int binarySearch(String[] sortedarray, String key) {
        int low = 0, counter = 0;
        int high = sortedarray.length;
        int mid;

        if (key.equalsIgnoreCase("quit") || (key.equalsIgnoreCase("exit"))) {
            return -1;

        }
        while (low <= high) {
            counter++;
            mid = (low + high) / 2;
            if (key.compareToIgnoreCase(sortedarray[mid]) < 0) {
                high = mid - 1;
            } else if (key.compareToIgnoreCase(sortedarray[mid]) > 0) {
                low = mid + 1;
            } else {
                return counter;
            }
        }
        return -1;

    }

    protected static int insertionSort(String[] sortednames) {

        int in, out, counter;
        counter = 0;
        for (out = 1; out < sortednames.length; out++) {
            String temp = sortednames[out];
            in = out;
            while (in > 0 && sortednames[in - 1].compareToIgnoreCase(temp) > 0) {
                counter++;
                sortednames[in] = sortednames[in - 1];
                --in;
            }
            counter++;
            sortednames[in] = temp;
        }
        return counter;
    }

    protected static String[] getNamesArray() {
        String[] names = {"fred", "barney", "tom", "jerry", "larry", "moe", "curly",
            "betty", "wilma", "bart", "homer", "marge", "maggie", "lisa",
            "pebbles", "bambam", "smithers", "burns", "milhouse", "george", "astro",
            "dino", "mickey", "minnie", "pluto", "goofy", "donald", "huey",
            "louie", "dewey", "snowwhite", "happy", "doc", "grumpy", "sneezy",
            "dopey", "sleepy", "bambi", "belle", "gaston", "tarzan", "jane",
            "simba", "scar", "mufasa", "ariel", "flounder", "bugs", "daffy",
            "elmer", "foghorn", "chickenhawk", "roger", "jessica", "hank", "bobby",
            "peggy", "spot", "pongo", "perdy", "buzz", "potatohead", "woody",
            "chuckie", "tommy", "phil", "lil", "angelica", "dill", "spike",
            "pepe", "speedy", "yosemite", "sam", "tweety", "sylvester", "granny",
            "spiderman", "batman", "superman", "supergirl", "robin", "catwoman", "penguin",
            "thing", "flash", "silversurfer", "xmen", "pokemon", "joker", "wonderwoman"};
        return names;
    }
}