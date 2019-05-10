package _6_test_foreach;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class J8Loop {
	public static Map<Integer,List<Dog>> dogMap=new HashMap<>();
	static {
		dogMap.put(10, getDogs(10));
		dogMap.put(100, getDogs(100));
		dogMap.put(1000, getDogs(1000));
		dogMap.put(10000, getDogs(10000));
		dogMap.put(100000, getDogs(100000));
		dogMap.put(1000000, getDogs(1000000));
	}

	private static List<Dog> getDogs(int num) {
		List<Dog> dogs=new ArrayList<>();
		for(int i=0;i<num;i++){
			dogs.add(new Dog(i,"dog"+i));
		}
		return dogs;
	}

	private void loop(List<Dog> list) {
		list.forEach(dog->{
			dog.hashCode();
		});
	}

	@Benchmark//方法注解，表示该方法是需要进行 benchmark 的对象
	@OperationsPerInvocation(10)
	public void measureWrong_10() {
		List<Dog> list = dogMap.get(10);
		loop(list);
	}

	@Benchmark
	@OperationsPerInvocation(100)
	public void measureWrong_100() {
		List<Dog> list = dogMap.get(100);
		loop(list);
	}

	@Benchmark
	@OperationsPerInvocation(1000)
	public void measureWrong_1000() {
		List<Dog> list = dogMap.get(1000);
		loop(list);
	}

	@Benchmark
	@OperationsPerInvocation(10000)
	public void measureWrong_10000() {
		List<Dog> list = dogMap.get(10000);
		loop(list);
	}

	@Benchmark
	@OperationsPerInvocation(100000)
	public void measureWrong_100000() {
		List<Dog> list = dogMap.get(100000);
		loop(list);
	}

	@Benchmark
	@OperationsPerInvocation(1000000)
	public void measureWrong_1000000() {
		List<Dog> list = dogMap.get(1000000);
		loop(list);
	}

	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder()
				.include(J8Loop.class.getSimpleName())
				.warmupIterations(2)
				.measurementIterations(2).forks(1).build();

		new Runner(opt).run();
	}

}

class Dog{
	private int age;
	private String name;
	public Dog(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Dog [age=" + age + ", name=" + name + "]";
	}
}