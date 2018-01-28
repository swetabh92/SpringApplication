package com.nareshit.client;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.nareshit.pojo.Message;

public class Client {

	public static void main(String[] args) {

		/*Resource resource = new ClassPathResource("beans.xml");
		BeanFactory beanFactory = new XmlBeanFactory(resource);*/
		
		ApplicationContext context = new FileSystemXmlApplicationContext("src/beans.xml");
        
		Message message = (Message) context.getBean("message");
        message.setMessage("hi there");
        message.setMessageID(1001);
		System.out.println(message.getMessageID() + "\t" + message.getMessage());

		System.out.println("---------------------------------------------------------------");
		 
		Message message1 = (Message)context.getBean("message");
	    System.out.println(message1.getMessageID()+"\t"+message1.getMessage());
	 
	   ((AbstractApplicationContext) context).close();
	}

}
