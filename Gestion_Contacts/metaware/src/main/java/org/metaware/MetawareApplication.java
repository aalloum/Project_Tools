package org.metaware;

import org.springframework.boot.SpringApplication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.metaware.dao.ContactRepository;
import org.metaware.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextListener;

@SpringBootApplication
public class MetawareApplication implements CommandLineRunner {
	
	@Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }

	@Autowired
	private ContactRepository contactRepository;
	public static void main(String[] args) {
		SpringApplication.run(MetawareApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
	    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		contactRepository.save(new Contact("ALLOUM1","Abderrahim1",df.parse("12/01/1998"),"alloum1abderrahim@gmail.com", 648387 ,"hhh"));
		contactRepository.save(new Contact("ALLOUM2","Abderrahim2",df.parse("12/01/1998"),"alloum1abderrahim@gmail.com", 648387 ,"hhh"));
		contactRepository.save(new Contact("ALLOUM3","Abderrahim3",df.parse("12/01/1998"),"alloum1abderrahim@gmail.com", 648387 ,"hhh"));
		contactRepository.save(new Contact("ALLOUM3","Abderrahim3",df.parse("12/01/1998"),"alloum1abderrahim@gmail.com", 648387 ,"hhh"));
		contactRepository.save(new Contact("ALLOUM3","Abderrahim3",df.parse("12/01/1998"),"alloum1abderrahim@gmail.com", 648387 ,"hhh"));
		contactRepository.save(new Contact("ALLOUM3","Abderrahim3",df.parse("12/01/1998"),"alloum1abderrahim@gmail.com", 648387 ,"hhh"));
		contactRepository.save(new Contact("ALLOUM3","Abderrahim3",df.parse("12/01/1998"),"alloum1abderrahim@gmail.com", 648387 ,"hhh"));
	    contactRepository.findAll().forEach(c -> {
		  System.out.println(c.getNom());
	  });
	}
}
