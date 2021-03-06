package com.heading.examples.iostreams;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println(createInputStreamFromClassPath());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String createInputStreamFromClassPath() throws IOException {
        Class clazz = Main.class;
        InputStream inputStream = clazz.getResourceAsStream("../../resources/source.txt");
        String data = readFromInputStream(inputStream);

        return data;
    }

    public static String readFromInputStream(InputStream is) throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }

    public static String readFromBufferedReader() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/com/heading/app/source.txt"));
        String currentLine = reader.readLine();
        reader.close();

        return currentLine;
    }
}
