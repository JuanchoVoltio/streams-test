package com.heading.examples.serialization;

import com.heading.examples.model.TestClass;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        String fs = System.getProperty("file.separator");
        String filePath = "src" + fs + "com" + fs + "heading" + fs + "resources" + fs + "object.txt";
        TestClass testSubject = TestClass.build()
                                            .attribute1(2)
                                            .atribute2(Boolean.TRUE)
                                            .transientAttribute(4F);

        try {
            serializeObjectUsingObjectOutputStream(filePath, testSubject);
            deserializeObjectUsingObjectOutputStream(filePath);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void serializeObjectUsingObjectOutputStream(String filePath, TestClass object) throws IOException {
        System.out.println("Writing object: " + object.toString());

        File file = new File(filePath);
        file.createNewFile();

        try (FileOutputStream toFileStream = new FileOutputStream(new File(filePath));
             ObjectOutputStream output = new ObjectOutputStream(toFileStream)) {
            output.writeObject(object);
        }

        System.out.println("Success!");
    }

    public static TestClass deserializeObjectUsingObjectOutputStream(String filePath) throws IOException, ClassNotFoundException {
        System.out.println("Reading object....");

        TestClass result;

        try (FileInputStream fromFileStream = new FileInputStream(filePath);
             ObjectInputStream input = new ObjectInputStream(fromFileStream)) {
            result = (TestClass) input.readObject();
        }

        System.out.println("Object obtained: " + result);
        return result;
    }
}
