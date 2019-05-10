package dome._2_introspection;

import dome._1_reflect.User;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * @author: yuhaifeng
 * @create: 2019-04-30 14:05
 **/
public class IntrospectorTest {
	public static void main(String[] args) {
		User user = new User();

		try {
			//操作指定属性名称的属性
			PropertyDescriptor pd = null;
			pd = new PropertyDescriptor("name", User.class);
			Method w = pd.getWriteMethod();//获取属性的set方法
			w.invoke(user, "mini");
			Method r = pd.getReadMethod();//获取属性的get方法
			r.invoke(user, null);
			System.out.println(user.toString());

			//操作所有属性
			BeanInfo bi = Introspector.getBeanInfo(User.class);
			PropertyDescriptor[] pds = bi.getPropertyDescriptors();
			for(PropertyDescriptor p : pds){

			}
		} catch (Exception e) {
			e.printStackTrace();
		}


	}
}
