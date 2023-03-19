package test;

public class Person {
    private Integer age;
    private Integer height;
    private String name;

    public Person(Integer age,Integer height,String name){
        this.age = age;
        this.height = height;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return "test.Person{"+
                "age="+age+
                ",height="+height+
                ",name='"+name+'\''+
                '}';
    }
}
