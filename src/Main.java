import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //1
        System.out.println("\n\n\n");
        System.out.println("1 - filtering even numbers");
        List<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 2, 2, 3, 3, 4, 4, 5, 6, 20, 405, 203, 201, 21, 1);
        System.out.println(numbers.stream().filter(number -> number % 2 == 0 ).collect(Collectors.toList()));



        //2
        System.out.println("\n\n\n");
        System.out.println("2 - doubling");
        List<Integer> doubledNumbers = new ArrayList<>();
        doubledNumbers.addAll(numbers.stream().map(number -> number*2).toList());
        System.out.println(doubledNumbers);



        //3
        System.out.println("\n\n\n");
        System.out.println("3 - finding if it's bigger than a certain number");
        System.out.println("bigger than 120? "+doubledNumbers.stream().allMatch(doubledNumber-> doubledNumber > 120));
        System.out.println("bigger than 1? "+doubledNumbers.stream().allMatch(doubledNumber-> doubledNumber > 1));



        //4
        System.out.println("\n\n\n");
        System.out.println("4 - finding maximum element");
        doubledNumbers.stream().max(Integer::compareTo).ifPresent(max->System.out.println("maximum element: "+max));



        //5
        System.out.println("\n\n\n");
        System.out.println("5 - making upper case");
        List<String> strings = new ArrayList<>();
        Collections.addAll(strings, "ball", "dolphin", "cannon", "mountain", "bee");
        strings.stream().map(string->string.toUpperCase()).forEach(System.out::println);



        //6
        System.out.println("\n\n\n");
        System.out.println("6 - sorting strings");
        strings.stream().sorted((s1,s2)-> Integer.compare(s1.length(), s2.length())).forEach(System.out::println);



        //7
        class Person{
            private String name;
            private int age;
            public Person(){}
            public Person(String name, int age){
                this.name = name;
                this.age = age;
            }
            public String getName() {
                return name;
            }
            public void setName(String name) {
                this.name = name;
            }
            public int getAge() {
                return age;
            }
            public void setAge(int age) {
                this.age = age;
            }
            @Override
            public String toString() {
                return "Person{" +
                        "name='" + name + '\'' +
                        ", age=" + age +
                        '}';
            }
        }
        System.out.println("\n\n\n");
        System.out.println("7 - map´of people");
        List<Person> people = Arrays.asList(
                new Person("joao", 12),
                new Person("jonas", 13),
                new Person("joaquim", 14),
                new Person("jorge", 15),
                new Person("benjamin", 40)
        );
        Map<Integer,List<Person>> mapOfPeople = people.stream().collect(Collectors.groupingBy(Person::getAge));
        mapOfPeople.forEach((age, person)->{
            System.out.println(age);
            System.out.println(person);
            System.out.println();
        });


        //8
        System.out.println("\n\n\n");
        System.out.println("8 - average number");
        System.out.println("average nubmer: "+numbers.stream().collect(Collectors.averagingDouble(Integer::doubleValue)));


        //9
        System.out.println("\n\n\n");
        System.out.println("9 - removing duplicates to 2, 3 and 4");
        numbers.stream().distinct().forEach(System.out::println);



        //10
        System.out.println("\n\n\n");
        System.out.println("10 - combining numbers and doubledNumbers");
        System.out.println(Stream.of(numbers,doubledNumbers).flatMap(List::stream).sorted().collect(Collectors.toList()));
//        System.out.println(Stream.of(numbers,doubledNumbers).flatMap(List::stream).collect(Collectors.toList()));
    }
}

