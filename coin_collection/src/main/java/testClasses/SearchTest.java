package testClasses;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by joseph on 9/29/2014.
 */
public class SearchTest
{
    public static void main(String args[]) {

        //searching element on unsorted Java array
        //searching java array using ArrayList
        List<Integer> array = Arrays.asList(1, 3, 5, 2, 4);
        if (array.contains(3)) {
            System.out.println("Element found inside Java array using ArrayList contains() method");
        };

        Set<Integer> arraySet = new HashSet<Integer>(array);

        if (arraySet.contains(3)) {
            System.out.println("Element found on Java array using HashSet contains method");
        };

        //searching element on sorted Java array
        //unsorted String array
        String[] cities = new String[]{"Washington", "London", "Paris", "NewYork"};

        //sorting array in java
        Arrays.sort(cities);

        //searching on sorted array in java using Arrays binarySearch() method
        if(Arrays.binarySearch(cities, "Paris") >=0 ){
            System.out.println("Element found on sorted String Java array using binary search");
        }

        //plain old for loop for searching elements in Java array
        String input = "London";
        for(String city: cities){
            if(city.equals(input)){
                System.out.println("Found elements in Java array using for loop" + input);
            }
        }

    }
}
