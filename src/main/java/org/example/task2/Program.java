package org.example.task2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;


public class Program {
    public static void main(String[] args) throws IOException {

        StudentV2 studentV2 = new StudentV2("Stanislav", 31, 4.6);
        XmlMapper xmlMapper = new XmlMapper();
        ObjectMapper objectMapper = new ObjectMapper();
        File xml = new File("studentV2.xml");
        File json = new File("studentV2.json");

        // XML

        xmlMapper.writeValue(xml, studentV2);

        StudentV2 studentV2xml = xmlMapper.readValue(xml, StudentV2.class);
        System.out.println(studentV2xml);

        //JSON

        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        objectMapper.writeValue(json, studentV2);

        StudentV2 studentV2json = objectMapper.readValue(json,StudentV2.class);
        System.out.println(studentV2json);


    }
}
