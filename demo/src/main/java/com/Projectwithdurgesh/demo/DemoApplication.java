package com.Projectwithdurgesh.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.Projectwithdurgesh.demo.Model.User;
import com.Projectwithdurgesh.demo.repository.UserRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		ApplicationContext context =SpringApplication.run(DemoApplication.class, args);

		User u = new User();
		u.setAddress("delhi");
		u.setCity("new Delhi");
		u.setName("intel");

		User u1 = new User();
		u1.setAddress("delhi");
		u1.setCity("new Delhi");
		u1.setName("intel");
		
		User u2 = new User();
		u2.setAddress("delhi");
		u2.setCity("new Delhi");
		u2.setName("intel");
		
		UserRepository user=context.getBean(UserRepository.class);
		
//		List<User> list= new ArrayList();
//		list.add(u2);
//		list.add(u1);
//		list.add(u);
//		
//		Iterable t=user.saveAll(list);
//		t.forEach(ug->{
//			System.out.println(ug);
//		});
		
//		Optional<User> optional=user.findById(9);
//		User userok =optional.get();
//		System.out.println("get the value "+userok);
//		userok.setAddress("new Delhi India");
//		userok.setName("Gaurav kumar");
//		
//		User save=user.save(userok);
//		System.out.println(save);
	
	
//	Iterable y=user.findAll();
//	
//	Iterator gp =y.iterator();
//	int count=0;
//	while(gp.hasNext()) {
//		System.out.println(gp.next());
//		count++;
//	}
//	System.out.println(count);
	
//	for(int i=1; i<=count; i++) {
//		System.out.println(y);
//	}
	
//	y.forEach(ugh->{
//		System.out.println(ugh);
//	});
	
//	y.forEach(new Consumer<User>() {
//
//		@Override
//		public void accept(User t) {
//			// TODO Auto-generated method stub
//			System.out.println(t);
//		}
//	});
	
	
//	user.delete();
	
	
	}

}
