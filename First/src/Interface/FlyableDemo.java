package Interface;

interface Flyable {
 void fly_obj();
}


class Spacecraft implements Flyable {
 public void fly_obj() {
     System.out.println("Spacecraft flies in outer space.");
 }
}


class Airplane implements Flyable {
 public void fly_obj() {
     System.out.println("Airplane flies in the sky at high altitudes.");
 }
}


class Helicopter implements Flyable {
 public void fly_obj() {
     System.out.println("Helicopter flies at lower altitudes and can hover.");
 }
}


public class FlyableDemo {
    public static void main(String[] args) {
        Spacecraft spacecraft = new Spacecraft();
        Airplane airplane = new Airplane();
        Helicopter helicopter = new Helicopter();

        spacecraft.fly_obj();
        airplane.fly_obj();
        helicopter.fly_obj();
    }
}

