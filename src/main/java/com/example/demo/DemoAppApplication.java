package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoAppApplication.class, args);
	}

}

@RestController
class HelloController {

	String[] strArray = { "Apple", "Banana", "Cherry" };

	List<String> list;

	HelloController() {
		list = new ArrayList<String>();
		list.add("Apple");
		list.add("Banana");
		list.add("Cherry");
	}

	@GetMapping
	String getDef() {
		return "<h1>Hello, App Testing!!!</h1>";
	}

	@GetMapping("/test")
	String[] getArr() {
		return strArray;
	}

	@GetMapping("/test2")
	List<String> getList() {
		return list;
	}

	@DeleteMapping("/test/{id}")
	String delete(@PathVariable int id) {

		System.out.println(Arrays.toString(strArray));

		String[] newArray = new String[strArray.length - 1];
		for (int i = 0, k = 0; i < strArray.length; i++) {
			if (i == id) {
				continue; // Skip the element to remove
			}
			newArray[k++] = strArray[i];
		}

		strArray = newArray;

		System.out.println(Arrays.toString(strArray));

		return "id: " + id;
	}

	@DeleteMapping("/test2/{id}")
	String delete2(@PathVariable int id) {

		System.out.println(list);

		list.remove(id);

		System.out.println(list);

		return "id: " + id;
	}

}