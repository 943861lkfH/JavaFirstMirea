package ru.mirea.task23;

public class Label {
    public static void main(String[] args) {
        String labelMenu = "Press s to start";
        String labelDownMenu1 = "Score: ";
        String labelDownMenu2 = " Time: ";
        String labelIcon = "Pacman";
        String labelIcon2 = "Pacman";

        System.out.println("Хэш-код для Str: " + labelIcon.hashCode());
        System.out.println("Хэш-код для Str: " + labelMenu.hashCode());
        System.out.println("Хэш-код для Str: " + labelDownMenu1.hashCode());
        System.out.println("Хэш-код для Str: " + labelDownMenu2.hashCode());

        System.out.println("Сравнение: " + labelIcon.equals(labelIcon2));
        System.out.println("Сравнение: " + labelIcon.equals(labelDownMenu2));

    }
}
