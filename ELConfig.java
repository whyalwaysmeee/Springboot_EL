package com.EL;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.Resource;
import org.apache.*;
import org.apache.commons.io.IOUtils;

@Configuration
@ComponentScan("com.EL")
@PropertySource("classpath:com/EL/test.properties")      //指定文件地址
public class ELConfig {
 @Value("I LOVE U")     //注入普通字符串
 private String normal;
 
 @Value("#{systemProperties['os.name']}")   //注入操作系统名称
 private String osName;
 
 @Value("#{T(java.lang.Math).random()*100.0}")    //注入计算结果
 private double randomNumber;

 @Value("#{demoService.another}")          //注入一个Bean
 private String fromAnother;

 @Value("classpath:com/EL/test.txt")        //注入一个文件资源
 private Resource testFile;
 
 @Value("http://www.sina.com")             //注入一个网址资源
 private Resource testUrl;
 
 @Value("${book.name}")                    //使用Bean注入一个配置文件的一个属性
 private String bookName;
 
 @Value("${book.author}")                 //使用Bean注入一个配置文件的一个属性
 private String bookAuthor;
 
 @Value("${book.year}")                  //使用Bean注入一个配置文件的一个属性
 private String bookYear;
 
 @Autowired                               //注入一个环境
 private Environment environment;
 
 @Bean                                       //PSPC用于使用@Value注入
 public static PropertySourcesPlaceholderConfigurer propertyConfigure() {       
	 return new PropertySourcesPlaceholderConfigurer();
 }
 
 public void outputResources() {
	 try {
		 System.out.println(normal);
		 System.out.println(osName); 
		 System.out.println(randomNumber);
		 System.out.println(fromAnother);                   
		 System.out.println(IOUtils.toString(testFile.getInputStream()));
		 System.out.println(IOUtils.toString(testUrl.getInputStream()));
		 System.out.println(bookName);
		 System.out.println(bookAuthor);
		 System.out.println(bookYear);
		 System.out.println(environment.getProperty("book.name"));
		 System.out.println(environment.getProperty("book.author"));
		 System.out.println(environment.getProperty("book.year"));}
	     
		 catch(Exception e) {
			 e.printStackTrace();
		 
		 }
 }
}
