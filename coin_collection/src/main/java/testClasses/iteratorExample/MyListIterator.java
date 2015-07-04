package testClasses.iteratorExample;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by joseph on 10/4/2014.
 * Code Location - http://www.java2novice.com/java-collections-and-util/listiterator-example/
 */
public class MyListIterator
{
    public static void main(String a[]){
        List<Integer> li = new ArrayList<Integer>();
        ListIterator<Integer> litr = null;
        li.add(23);
        li.add(98);
        li.add(29);
        li.add(71);
        li.add(5);
        litr=li.listIterator();
        System.out.println("Elements in forward directiton");
        while(litr.hasNext()){
            System.out.println(litr.next());
        }
        System.out.println("Elements in backward directiton");
        while(litr.hasPrevious()){
            System.out.println(litr.previous());
        }
    }
}
