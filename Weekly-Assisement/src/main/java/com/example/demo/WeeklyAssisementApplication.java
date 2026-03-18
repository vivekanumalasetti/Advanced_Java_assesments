package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class WeeklyAssisementApplication {


	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(WeeklyAssisementApplication.class, args);
		
//		CloudStorageService cloudStorageService = context.getBean(CloudStorageService.class);
//		cloudStorageService.storeFile("file.txt");
		
		StorageService defalutStorageService = context.getBean(StorageService.class);
		StorageService CloudStorageService = context.getBean(CloudStorageService.class);
		StorageService LocalStorageService =  context.getBean(LocalStorageService.class);
		StorageService LocalStorageService1 = context.getBean(LocalStorageService.class);
		
		CloudStorageService.storeFile("file.txt");
		LocalStorageService.storeFile("file1.txt");
		LocalStorageService1.storeFile("file2.txt");
		defalutStorageService.storeFile("file4.txt");
		
		
		((ConfigurableApplicationContext) context).close();   
	}

}
