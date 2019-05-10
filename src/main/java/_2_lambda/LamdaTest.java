package _2_lambda;


/**
 * @author: yuhaifeng
 * @create: 2019-01-07 11:27
 **/
//@FunctionalInterface:定义函数式接口(接口中只有一个<<抽象方法>>,每一个该类型的lambda表达式都会被匹配到这个抽象方法)
@FunctionalInterface
interface MyLambda{
	void test1(String y,int b);
	//default方法可以任意定义
	default String test2(){
		return "123";
	}

	default String test3(){
		return "123";
	}

	//static方法也可以定义
	static void test4(){
		System.out.println("234");
	}
}
public class LamdaTest {
	public static void main(String[] args) {
		//定义Lambda表达式
		MyLambda m = (y,b) -> {System.out.println("test1"+y+b);};
		m.test1("aaa",1);
	}
}
