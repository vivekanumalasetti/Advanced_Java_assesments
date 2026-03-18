package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("localStorage")
@Scope("prototype")
public class LocalStorageService implements StorageService {
	
	public LocalStorageService() {
		System.out.println("LocalStorageService Bean Created");
	}
	
	@PostConstruct
	public void inti() {
		System.out.println("LocalStorageService has been Initialized");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("LocalStorageService has been Destory");
	}

	@Override
	public void storeFile(String fileName) {
		System.out.println("File stored in Local Storage: " + fileName);
		
	}

}
