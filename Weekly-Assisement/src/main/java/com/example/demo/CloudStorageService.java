package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("cloudStorage")
@Scope("singleton")
@Primary
public class CloudStorageService implements StorageService{
	public CloudStorageService() {
		System.out.println("CloudStorageService Bean Created");
	}
	
	@PostConstruct
	public void inti() {
		System.out.println("CloudStorageService has been Initialized");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("CloudStorageService has been Destory");
	}
	
	@Override
	public void storeFile(String fileName) {
		System.out.println("File stored in Cloud Storage: "+ fileName);
		
	}
	
	
}
