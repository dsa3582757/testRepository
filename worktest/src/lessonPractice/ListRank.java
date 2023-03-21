package lessonPractice;

import test.Person;

import java.util.*;

;

public class ListRank {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.addAll(Arrays.asList(
                new Person(15, 178, "张三"),
                new Person(12, 176, "李四"),
                new Person(16, 180, "王五"))
        );
        int[] arr = {1,2,3};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(2);
        arrayList.add(2);
        arrayList.sort(new Comparator() {
            @Override
            public int compare(Object o, Object t1) {
                Integer a1 = Integer.parseInt(o.toString());
                Integer a2 = Integer.parseInt(t1.toString());
                return a1.compareTo(a2);
            }
        });
        HashMap hashMap = new HashMap();
        hashMap.put("a",1);
        hashMap.put("b",2);
        hashMap.put("c",3);
        hashMap.put("d",4);
        for (Object o : hashMap.keySet()) {
            System.out.println(o);
        }
        List<Person> personList1 = new ArrayList<>(personList);
        System.out.println(personList1);
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
        personList = null;
        personList1.sort((a1,a2)->a1.getAge().compareTo(a2.getAge()));
        System.out.println(arr);
//        System.out.println(personList.equals(personList1));

    }
}