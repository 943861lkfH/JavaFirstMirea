package ru.mirea.task1.opt6;

public class TestArray {
    public static void main(String[] args){
        Array mas1 = new Array();
        System.out.println("Array1: ");
        mas1.rand1();
        mas1.setArray();
        System.out.println();
        mas1.sort();
        mas1.setArray();
        System.out.println();
        Array mas2 = new Array();
        System.out.println("Array2: ");
        mas2.rand2();
        mas2.setArray();
        System.out.println();
        mas2.sort();
        mas2.setArray();
    }
}
