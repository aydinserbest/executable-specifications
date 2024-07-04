package starter.parametrized.methodSource;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
//when executing this example, the parameterized test is exercise twice,
// once per Person objects contained in the Stream ("John Doe" and "Jane Roe").
//as an inner class with two properties (name and surname).


public class MethodSourceObjectsParameterizedTest {
    static Stream<Person> personProvider() {
        Person john = new Person("John", "Doe");
        Person jane = new Person("Jane", "Roe");
        return Stream.of(john, jane);
    }
    @ParameterizedTest
    @MethodSource("personProvider")
    void testWithPersonProvider(Person argument) {
        System.out.println("Parameterized test with (Person) argument: " +
                argument);
        assertNotNull(argument);
    }
    @ParameterizedTest
    @MethodSource("personProvider")
    void testWithPersonProvider2(Person argument) {
        System.out.println("Parameterized test with (Person) argument: " + argument);
        assertNotNull(argument);
        assertNotNull(argument.getName());
        assertNotNull(argument.getSurname());
        System.out.println("Name: " + argument.getName());
        System.out.println("Surname: " + argument.getSurname());
    }
    //as an inner class with two properties (name and surname).

    static class Person {
        String name;
        String surname;
        public Person(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getSurname() {
            return surname;
        }
        public void setSurname(String surname) {
            this.surname = surname;
        }
        @Override
        public String toString() {
            return "Person [name=" + name + ", surname=" + surname + "]";
        }
    }
}



