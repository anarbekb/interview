package com.company.interview;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonServiceImplTest {
    private static final List<String> PERSONS_EXPECTED = List.of(
            "6 - Amelia - (1)",
            "7 - Amelia - (2)",
            "8 - Amelia - (3)",
            "9 - Amelia - (4)",
            "4 - Emily - (1)",
            "1 - Harry - (1)",
            "2 - Harry - (2)",
            "3 - Harry - (3)",
            "5 - Jack - (1)"
    );

    @Test
    void test_sort() {
        PersonService personService = new PersonServiceImpl();
        List<Person> sourcePersons = List.of(
                new Person(1, "Harry"),
                new Person(1, "Harry"), // дубликат
                new Person(2, "Harry"), // однофамилец
                new Person(3, "Harry"),
                new Person(4, "Emily"),
                new Person(5, "Jack"),
                new Person(9, "Amelia"),
                new Person(5, "Jack"),
                new Person(6, "Amelia"),
                new Person(6, "Amelia"),
                new Person(7, "Amelia"),
                new Person(8, "Amelia")
        );

        assertEquals(PERSONS_EXPECTED, personService.sort(sourcePersons));
    }
}