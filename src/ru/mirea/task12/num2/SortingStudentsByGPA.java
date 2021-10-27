package ru.mirea.task12.num2;
import java.util.Comparator;

import ru.mirea.task12.num1.Students;

public class SortingStudentsByGPA implements Comparator<Students> {

    @Override
    public int compare(Students o1, Students o2) {
        return (int) ((int) o2.getGPA() - o1.getGPA());
    }

    public static void quickSort(Students[] arrayStudents, int low, int high) {
        if (low < high) {
            int pi = partition(arrayStudents, low, high);
            quickSort(arrayStudents, low, pi - 1);
            quickSort(arrayStudents, pi + 1, high);
        }
    }

    public static int partition(Students[] arrayStudents, int low, int high) {
        Students pivot = arrayStudents[high];
        int left = low;
        int right = high - 1;
        while (true) {
            while (left <= right && arrayStudents[left].getGPA() > pivot.getGPA()) left++;
            while (right >= left && arrayStudents[right].getGPA() < pivot.getGPA()) right--;
            if (left >= right) break;
            Students temps = arrayStudents[left];
            arrayStudents[left] = arrayStudents[right];
            arrayStudents[right] = temps;

            left++;
            right--;
        }
        Students temps = arrayStudents[left];
        arrayStudents[left] = arrayStudents[high];
        arrayStudents[high] = temps;
        return left;
    }
}
