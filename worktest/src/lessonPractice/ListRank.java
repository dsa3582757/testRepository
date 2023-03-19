package lessonPractice;

import test.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

;

public class ListRank {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.addAll(Arrays.asList(
                new Person(15, 178, "张三"),
                new Person(12, 176, "李四"),
                new Person(16, 180, "王五"))
        );
        System.out.println(personList);
//        personList.sort(new Comparator<test.Person>() {
//            @Override
//            public int compare(test.Person person, test.Person t1) {
//                return t1.getAge().compareTo(person.getAge());
//            }
//        });
//        personList.sort((test.Person a1, test.Person a2) -> a1.getAge().compareTo(a2.getAge()));
//        personList.sort(Comparator.comparing(test.Person::getAge).thenComparing(test.Person::getHeight));

        personList.sort((Person a1, Person a2) -> {
            if (a1.getAge() == a2.getAge()) {
                return a1.getHeight() - a2.getHeight();
            } else {
                return a1.getAge() - a2.getAge();
            }
        });
        System.out.println(personList);
    }
}