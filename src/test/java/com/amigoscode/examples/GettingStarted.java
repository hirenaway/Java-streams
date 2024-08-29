package com.amigoscode.examples;

import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class GettingStarted {

    @Test
    public void imperativeApproach() throws IOException {
        // 1. Find people aged less or equal 18
        // 2. Then change implementation to find first 10 people
        List<Person> people = MockData.getPeople();
        List<Person> youngGroup = new ArrayList<>();

        int count = 0;
        int limit = 10;

        for (Person person : people){
            if(person.getAge() <= 18){
                youngGroup.add(person);
                count++;
                if(count == limit){
                    break;
                }
            }
        }
        System.out.println(youngGroup);
    }

    @Test
    public void declarativeApproachUsingStreams() throws Exception {
        System.out.println(MockData.getPeople()
                .stream()
                .filter(person -> person.getAge() <= 18)
                .limit(10)
                .collect(Collectors.toList()));
    }
}
