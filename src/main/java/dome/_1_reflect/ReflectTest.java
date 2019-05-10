package dome._1_reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射
 * @author: yuhaifeng
 * @create: 2019-04-30 11:53
 **/
public class ReflectTest {
	public static void main(String[] args) {
		User user = new User();
		try {
			Field nameField = user.getClass().getDeclaredField("name");
			nameField.setAccessible(true);
			nameField.set(user,"xiaomi");
			String name = (String)nameField.get(user);
			System.out.println(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
