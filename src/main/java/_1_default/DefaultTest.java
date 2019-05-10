package _1_default;

/**
 * @author: yuhaifeng
 * @create: 2019-01-07 11:09
 **/
interface Animal{

	void eat();
	//default:接口中的默认方法,所有的实现类都拥有此方法(可以被覆盖)
	default void run(){
		System.out.println("奔跑");
	}

}
class Cat implements Animal{
	@Override
	public void eat() {
		System.out.println("吃狗粮");
	}
	@Override
	public void run(){
		System.out.println("狗,四腿奔跑!");
	}
}
public class DefaultTest {
	public static void main(String[] args) {
		Animal cat = new Cat();
		cat.eat();
		cat.run();
	}
}
