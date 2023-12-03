package com.jsonparser.aksonparser.application;

import com.jsonparser.aksonparser.parser.AksonParser;
import com.jsonparser.aksonparser.resources.Person;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String person = "{\"name\": \"Akhil\", \"age\": 23}";
        Person Akhil = AksonParser.parseToObject(person, Person.class);

        System.out.println("Name : " + Akhil.getName() + " , age: " + Akhil.getAge());
	}

}
