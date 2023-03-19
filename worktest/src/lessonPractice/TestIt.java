package lessonPractice;


import test.Person;

class TestIt {
    public static void main(String[] args) {
        int[] myArray = {1, 2, 3, 4, 5};
        Person lzl = new Person(32,175,"廖再亮");
        ChangeIt.change(lzl);
        System.out.println(lzl);
//        ChangeIt.doIt(myArray);
//        for (int j = 0; j < myArray.length; j++)
//            System.out.print(myArray[j] + " ");
    }
}

class ChangeIt {
    static void doIt(int[] z) {
        z = null;
    }
    static void change(Person person){
        person.setAge(18);
    }
}
