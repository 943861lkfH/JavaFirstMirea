package ru.mirea.task3.Human;

public class TestHuman
{
    public static void main(String[] args) {
        Human a1 = new Human ("Lidiya", 26, 55, 170);
        System.out.println(a1.toString());
        System.out.println(a1.getName()+'\n');
        System.out.println("Age: "+a1.getAge()+'\n');
        System.out.println("Weight: "+a1.getWeight()+'\n');
        System.out.println("Height: "+a1.getHeight()+'\n');
        Leg l1 = new Leg(36);
        System.out.println("Size of leg: "+l1.getSize());
        l1.setSize(39);
        System.out.println("New size: "+l1.getSize()+'\n');
        Hand h1 = new Hand(75);
        System.out.println("Length: "+h1.getLength()+'\n');
        h1.setLength(78);
        System.out.println("New length: "+h1.getLength()+'\n');
        Head h2 = new Head();
        h2.setEyes("green");
        h2.setHair("brown");
        System.out.println("Color eyes: "+h2.getEyes()+'\n'+"Color hair: "+h2.getHair());
    }
}
