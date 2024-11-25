package org.example.task1;

import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Student student = new Student("Vladimir", 25, 4.4);

        try(FileOutputStream fileOutputStream = new FileOutputStream("studentV1.bin")) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(student);
        }

        try(FileInputStream fileInputStream = new FileInputStream("studentV1.bin")) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Student studentV1 = (Student) objectInputStream.readObject();
            System.out.println(studentV1);
            // Значение поля GPA не было восстановлено т.к. использовался модификатор transient, который
            // обозначает, что данное поле не должно быть сериализовано
        }



    }
}