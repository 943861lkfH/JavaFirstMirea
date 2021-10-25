package ru.mirea.task12.num1;

public class TestStudents {

    private static Students student[];

    public static void setMas(){
        student = new Students[10];
        student[0] = new Students(12,"Sem","Brown",1);
        student[1] = new Students(5,"Bob","Bob",2);
        student[2] = new Students(10,"Mike","Shell",1);
        student[3] = new Students(7,"Lora","Palmer",3);
        student[4] = new Students(1,"Donna","Hayward",3);
        student[5] = new Students(2,"Bobby","Briggs",4);
        student[6] = new Students(8,"Natan","Brush",1);
        student[7] = new Students(11,"Audrey","Horne",3);
        student[8] = new Students(4,"Joan","Chen",2);
        student[9] = new Students(3,"Henk","Jennings",2);
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
