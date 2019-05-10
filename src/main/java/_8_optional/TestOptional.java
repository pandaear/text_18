package _8_optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

/**
 * @author: yuhaifeng
 * @create: 2019-01-18 10:21
 **/
public class TestOptional {
	public static void main(String[] args) {
		User user1 = new User("小军", "xiaojun@163.com",null,null);
		User user2 = new User("Tom","Tom@163.com",null,null);
		//of()创建Optional对象,当接收的参数为null时,会触发空指针异常
		//Optional<User> user11 = Optional.of(null);
		Optional<User> user11 = Optional.of(user1);
		System.out.println(user11);
		//ofNullable()创建Optional对象,当接收的参数为null时,调用get()时会触发NoSuchElementException
		//Optional<User> user21 = Optional.ofNullable(null);
		Optional<User> user21 = Optional.ofNullable(user2);
		System.out.println(user21);
		/**
		 * orElse()设置默认值,
		 * 当ofNullable()中的参数为null时,会将orElse()中的参数返回
		 * 当ofNullable()中的参数不为null时,ofNullable()中的参数返回
		 */
		User user = Optional.ofNullable(user2).orElse(user1);
		System.out.println(user);

		/**
		 * orElse()和orElseGet()区别
		 * 当ofNullable()中的参数不为null时,orElse()还是会创建对象,而orElseGet()不会创建对象
		 */
		System.out.println("orElse()");
		User user3 = Optional.ofNullable(user2).orElse(creatUser());
		System.out.println("orElseGet()");
		User user4 = Optional.ofNullable(user2).orElseGet(() -> creatUser());
		System.out.println(user3);
		System.out.println(user4);

		/**
		 * 使用orElseThrow(),当ofNullable()的参数为null时,将抛出自定义的异常
		 */
		System.out.println("orElseThrow()");
		//user2 = null;
		User user5 = Optional.ofNullable(user2).orElseThrow(()->new IllegalStateException());
		System.out.println(user5);

		/**
		 * map() 对值应用(调用)作为参数的函数，然后将返回的值包装在 Optional 中
		 */
		User user6 = new User();
		user6.setName("kaka");
		String email = Optional.ofNullable(user6).map(u->u.getEmail()).orElse("kaka@163.com");
		System.out.println(email);

		/**
		 * Optional 对象调用 flatMap() 时,用它作为参数,其返回的值是解除包装的 String 值
		 */
		user6.setPosition("manager");
		String position = Optional.ofNullable(user6).flatMap(u->u.getPosition()).orElse("manager");
		System.out.println(position);
		System.out.println("=======================");

		/**
		 * filter()过滤方法,返回boolean值,当返回false时,结果值为空,当返回true时,ofNullable()的参数设置到Optional中
		 */
		user6.setEmail("kaka@163.com");
		Optional user61 = Optional.ofNullable(user6).filter(u->u.getEmail()!=null&&u.getEmail().contains("@"));
		System.out.println(user61.isPresent());
		System.out.println("=======================");

		/**
		 * 多层嵌套,使用flatMap()直接取Optional中的值
		 */
		user6.setAddress(new Address(new Country("china")));
		user6.setAddress(null);
		String name = Optional.ofNullable(user6)
						.flatMap(u->u.getAddress())
						.flatMap(a->a.getCountry())
						.flatMap(c->c.getName())
						.orElse("default");
		//简化
		name = Optional.ofNullable(user6)
				.flatMap(User::getAddress)
				.flatMap(Address::getCountry)
				.flatMap(Country::getName)
				.orElse("default");
		System.out.println(name);


	}

	public static User creatUser(){
		System.out.println("创建User对象");
		return new User("Tom","Tom@163.com",null,null);
	}
}
@Data
@AllArgsConstructor
@NoArgsConstructor
class User{
	private String name;
	private String email;
	private String position;
	private Address address;


	public Optional<String> getPosition(){
		return Optional.ofNullable(position);
	}
	public Optional<Address> getAddress(){
		return Optional.ofNullable(address);
	}
}
@AllArgsConstructor
class Address{
	private Country country;
	public Optional<Country> getCountry(){
		return Optional.ofNullable(country);
	}
}
@AllArgsConstructor
class Country{
	private String name;
	public Optional<String> getName(){
		return Optional.ofNullable(name);
	}
}