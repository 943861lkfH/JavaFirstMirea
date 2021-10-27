package ru.mirea.task12.num3;
import ru.mirea.task12.num1.Students;

public class MergeSort {
    void Merge(Students[] array, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        Students[] L = new Students[n1];
        Students[] R = new Students[n2];

        System.arraycopy(array, l, L, 0, n1);
        for (int i = 0; i < n2; i++)
            R[i] = array[m + 1 + i];

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].getIDNumber() < R[j].getIDNumber()) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }
    public Students[] Sort(Students[] array, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            Sort(array, l, m);
            Sort(array, m + 1, r);
            Merge(array, l, m, r);
        }
        return array;
    }
}
