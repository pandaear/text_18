package _3_function_reference;

/**
 * @author: yuhaifeng
 * @create: 2019-01-07 11:51
 **/
//@FunctionalInterface:定义函数式接口(接口中只有一个<<抽象方法>>,每一个该类型的lambda表达式都会被匹配到这个抽象方法)
@FunctionalInterface
interface TestConverT<T, F> {
	F convert(T t);
}
class User{
	private String name;
	private String sex;
	public User(String name,String sex){
		this.name = name;
		this.sex = sex;
	}
}
@FunctionalInterface
interface UserFactory<T>{
	T get(String name,String sex);
}
@FunctionalInterface
interface Converter<S,I>{
	S valueOf(I i);
}
public class FunctionReferenceTest {
	//方法与构造函数引用
	public static void main(String[] args) {
		//::获取方法的引用
		//::配合lambda表达式,可以引用别人的方法来实现自己的接口方法
		TestConverT<String,Integer> t = Integer::valueOf;
		Integer convert = t.convert("123");
		System.out.println(convert);

		//构造函数的引用
		UserFactory<User> userFactory = User::new;
		User user = userFactory.get("小明", "man");

		//lambda表达式引用局部变量,局部变量必须显式声明为final，或事实上是final
		int num = 12;
		Converter<String,Integer> converter = (form)->String.valueOf(form+num);
		String value = converter.valueOf(33);
		System.out.println(value);
	}
}
