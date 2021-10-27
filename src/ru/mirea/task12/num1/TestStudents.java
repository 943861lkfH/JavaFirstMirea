package ru.mirea.task12.num1;

public class TestStudents {

    private static Students student[];

    public static void setMas(){
        student = new Students[10];
        student[0] = new Students(6,"Sem","Brown",3.5,1);
        student[1] = new Students(5,"Bob","Bob", 4.0, 2);
        student[2] = new Students(10,"Mike","Shell",4.7, 1);
        student[3] = new Students(7,"Lora","Palmer",3.9, 3);
        student[4] = new Students(1,"Donna","Hayward",2.8, 3);
        student[5] = new Students(2,"Bobby","Briggs",4.65, 4);
        student[6] = new Students(8,"Natan","Brush",4.33, 1);
        student[7] = new Students(9,"Audrey","Horne",3.75, 3);
        student[8] = new Students(4,"Joan","Chen",3.5, 2);
        student[9] = new Students(3,"Henk","Jennings", 4.6, 2);
    }

    public static void sortInsertion(){
        for(int i = 0; i < student.length; i++)
            for(int j = i; j > 0; j--)
                if(student[j-1].getIDNumber()>student[j].getIDNumber())
                {
                    Students st = student[j-1];
                    student[j-1] = student[j];
                    student[j] = st;
                }
    }

    public static void main(String[] args) {
        setMas();
        sortInsertion();
        for(int i = 0; i < student.length; i++)
            System.out.println(student[i].toString());
    }
}
