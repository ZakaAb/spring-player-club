package dz.services.opensmtp;


import lombok.Data;

@Data
public class Person {
    private int id;
    private String name;
    private int age;


    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String description(){
        return "My name is " + this.name + " and I have " + this.age + " years old.";
    }
}
