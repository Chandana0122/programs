package encapsulation;

public class PersonDemo {
    public static void main(String[] args) {
        
        Person person = new Person();

        person.setName("chandana");
        person.setAge(22);
        person.setCountry("India");
        
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Country: " + person.getCountry());
    }
}

