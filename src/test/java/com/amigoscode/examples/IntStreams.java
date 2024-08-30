package com.amigoscode.examples;


import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreams {

    @Test
    public void range() throws Exception {
        System.out.println("For i");
        for (int i = 0; i <= 10; i++) {
            System.out.println(i);
        }

        System.out.println("Exclusive");
        IntStream.range(0,10).forEach(System.out::println);

        System.out.println("Inclusive");
        IntStream.rangeClosed(0,10).forEach(System.out::println);

    }

    // Loop through people using IntStream
    @Test
    public void rangeIteratingLists() throws Exception {
        List<Person> people = MockData.getPeople();
        IntStream.range(0, people.size())
                .forEach(index -> {
                    Person person = people.get(index);
                    System.out.println(person);
                });
    }

    @Test
    public void intStreamIterate()  {
        IntStream.iterate(0, operand -> ++operand)
                .filter(num -> num % 2 == 0) // printing only even numbers
                .limit(20)
                .forEach(System.out::println);
    }
}
