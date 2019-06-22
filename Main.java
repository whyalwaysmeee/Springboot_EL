package com.EL;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class Main {
public static void main(String[] args) {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ELConfig.class);
	
	ELConfig ELService = context.getBean(ELConfig.class);
	
	ELService.outputResources();
	
	context.close();
}
}
