package com.minle;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.min.DemoApplication;
import com.min.entity.Book;
import com.min.entity.User;
import com.min.mapper.BookMapper;
import com.min.mapper.UserMapper;
import com.min.service.BookService;
import com.min.service.UserService;
@RunWith(SpringRunner.class)  // 这里相当于SpringJUnit4ClassRunner.class  SpringRunner 是其子类
// 在springboot1.4.1以前的版本时候，网上用如下加载方式(这个方式笔者没试过，因为是aliyun的依赖库1.4.1以前的已经不支持了) @SpringApplicationConfiguration(classes = SpringBootSampleApplication.class)
// 或者使用@ContextConfiguration
@SpringBootTest(classes=DemoApplication.class)   // 指定使用的单元测试执行类
public class PropagationTest {
	
	
	@Autowired
	private UserMapper  userMapper;
	
	@Autowired
	private BookMapper  bookMapper;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserService userService;
	
	
	
	@Test
	// 测试单个的写入语句
	// 使用的是哪个传播级别呢？
	public void testUserMapper(){
		new Thread(new Runnable(){
			@Override
			public void run() {
				User user = new User();
				user.setId(1);
				user.setName("drivid");
				// 这里是可以不在xml下写sql语句的
				userMapper.insert(user);
			}
			
		}).start();
		
		new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					TimeUnit.MILLISECONDS.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				User user = new User();
				user.setId(2);
				user.setName("drivid2");
				// 这里是可以不在xml下写sql语句的
				userMapper.insert(user);
			}
			
		}).start();
	}
	
	@Test
	public void testBookMapper(){
		Book book = new Book();
		book.setId(2);
		book.setName("悲惨的世界");
		// 这里是可以不在xml下写sql语句的
		bookMapper.insert(book);
	}
	
	
	@Test
	public void testBookService(){
		Book book = new Book();
		book.setId(1);
		book.setName("悲惨的世界");
		// 这里是可以不在xml下写sql语句的
		bookService.addBook(book);
//		new Thread(new Runnable(){
//			@Override
//			public void run() {
//				try {
//					TimeUnit.MILLISECONDS.sleep(5);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				Book book = new Book();
//				book.setId(2);
//				book.setName("世界的悲惨");
//				// 这里是可以不在xml下写sql语句的
//				bookService.addBook(book);
//			}
//			
//		}).start();
	}
	
	
	@Test 
	// 验证事物的传播行为Propagation.Mandatory
	public void testPropagationMandatory(){
		Book book = new Book();
		book.setId(1);
		book.setName("悲惨的世界");
		User user = new User();
		user.setId(1);
		user.setName("drivid");
		userService.addUserPropagationMandatory(book, user);
	}
	
	
	@Test 
	// 验证事物的传播行为Propagation.Required
	public void testPropagationRequired(){
		Book book = new Book();
		book.setId(1);
		book.setName("悲惨的世界");
		User user = new User();
		user.setId(1);
		user.setName("drivid");
		userService.addUserPropagationRequired(book, user);
	}
	
	
	
	
	
	
	
}
