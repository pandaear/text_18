package _5_stream;


import com.sun.org.apache.bcel.internal.generic.RETURN;
import jdk.nashorn.internal.ir.IfNode;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author: yuhaifeng
 * @create: 2019-01-07 15:51
 **/
public class StreamTest {

	public static void main(String[] args) {
		/*// 1. Individual values
		Stream stream = Stream.of("a", "b", "c");
		// 2. Arrays
		String [] strArray = new String[] {"a", "b", "c"};
		stream = Stream.of(strArray);
		stream = Arrays.stream(strArray);
		// 3. Collections
		List<String> list = Arrays.asList(strArray);
		stream = list.stream();
		// 并行流 多个线程执行
		//List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);*/
		/*numbers.parallelStream()
				.forEach(System.out::print);

		//
		System.out.println("=========================");
		numbers.stream()
				.sequential()
				.forEach(System.out::print);*/
		/*long start1 = System.currentTimeMillis();
		for (int i : array) {
			if(i<5){
				System.out.print(i);
			}
		}
		long end1 = System.currentTimeMillis();
		System.out.println("耗时:"+(end1 - start1)+"ms");


		long start2 = System.currentTimeMillis();

		Arrays.stream(array)
				.filter(e->e<5)
				*//*.limit(4)
				.skip(2)*//*
				.forEach(System.out::print);
		long end2 = System.currentTimeMillis();
		System.out.println("耗时:"+(end2 - start2)+"ms");*/
		/*Stream.of(1,2,3,4,5,6,7,8,9)
				.peek(x->System.out.print("\nA"+x))
				.limit(4)
				.peek(x->System.out.print("B"+x))
				.forEach(x->System.out.print("C"+x));
		Stream.of(1,2,3,4,5,6,7,8,9)
				.peek(x->System.out.print("\nA"+x))
				.skip(6)
				.peek(x->System.out.print("B"+x))
				.forEach(x->System.out.print("C"+x));*/
		/*List<Integer> list = getList();
		list.stream().forEach(System.out::println);*/
//		List<User> list = new ArrayList<>();
//		list.add(new User("小明","男",10));
//		list.add(new User("小黄","女",11));
//		list.add(new User("小新","女",12));
//		list.add(new User("小李","男",14));
//		list.add(new User("小坤","男",9));
//		list.stream().sorted((e1, e2) -> {
//			if (e1.getAge().equals(e2.getAge())) {
//				return e1.getName().compareTo(e2.getName());
//			} else {
//				return e1.getAge().compareTo(e2.getAge());
//			}
//		}).forEach(System.out::println);

		/*List<Integer> list = getList();
		long l = System.currentTimeMillis();
		int sum = list.stream().sorted((x, y) -> x + y).mapToInt(x -> x).sum();
		long i = System.currentTimeMillis();
		System.out.println(sum);
		System.out.println(i-l);

		int result = 0;
		for (Integer integer : list) {
			result += integer;
		}
		long k = System.currentTimeMillis();
		System.out.println(result);
		System.out.println(k-i);*/
//		List<Integer> list = getList();
//		long l = System.currentTimeMillis();
//		Optional<Integer> reduce1 = list.stream().reduce((x, y) -> x + y);
//		long i = System.currentTimeMillis();
//		System.out.println(reduce1.get());
//		System.out.println("串行耗时:"+(i - l));
//		Optional<Integer> reduce2 = list.parallelStream().reduce((x, y) -> x + y);
//		long k = System.currentTimeMillis();
//		System.out.println(reduce2.get());
//		System.out.println("并行耗时:"+(k - i));
//		Iterator<Integer> iterator = list.iterator();
//		Integer result = 0;
//		while (iterator.hasNext()){
//			Integer next = iterator.next();
//			result+=next;
//		}
//		System.out.println(result);
//		long j = System.currentTimeMillis();
//		System.out.println("普通遍历耗时:"+(j - k));
		/**
		 * stream:
		 * 	1.创建流
		 * 	2.聚合操作(filter 过滤,map 映射,sorted 自然排序 定制排序)
		 * 	3.终止操作
		 *      查找和匹配
		 *          allMatch-检查是否匹配所有元素
		 *          anyMatch-检查是否至少匹配一个元素
		 *          noneMatch-检查是否没有匹配所有元素
		 *          findFirst-返回第一个元素
		 *          findAny-返回当前流中的任意元素
		 *          count-返回流中元素的总个数
		 *          max-返回流中最大值
		 *          min-返回流中最小值
		 *          reduce操作： reduce:(T identity,BinaryOperator)/reduce(BinaryOperator)-可以将流中元素反复结合起来，得到一个值
		 *          collect操作：Collect-将流转换为其他形式，接收一个Collection接口的实现，用于给Stream中元素做汇总的方法
		 */
//		List<Integer> list = getList();
		//排序 naturalOrder()升序 reverseOrder()降序
//		System.out.println(list);
//		list.sort(Comparator.naturalOrder());
//		System.out.println(list);
		//取最大值 max()
		/*Optional<Integer> max = list.stream().min((x,y)-> {
			return x.compareTo(y);
		});
		System.out.println(max.get());*/

		//取随机值
//		Integer random = list.stream().findFirst().get();
//		System.out.println(random);
//		boolean e = list.stream().anyMatch(x->x.equals(1));
//		System.out.println(e);
//		Long j = System.currentTimeMillis();
//		StringBuffer s = new StringBuffer();
//		for (Integer i : list) {
//			s.append(i);
//		}
//		Long k = System.currentTimeMillis();
//		System.out.println("\n 耗时:"+(k - j)+"ms");
//
//		list.forEach(x->{
//			s.append(x);
//		});
//		Long l = System.currentTimeMillis();
//		System.out.println("\n 预热耗时:"+(l - k)+"ms");
//		list.forEach(x->{
//			s.append(x);
//		});
//		Long m = System.currentTimeMillis();
//		System.out.println("\n forEach()耗时:"+(m - l)+"ms");

//		List<String> list = new ArrayList<String>();
//		list.add("I am a boy");
//		list.add("I love the girl");
//		list.add("But the girl loves another girl");
//		List<String> collect = list.stream()
//				.map(x->x.split(" "))
//				.flatMap(Arrays::stream)
//				.distinct()
//				.collect(Collectors.toList());
//		System.out.println(collect);
		show(getList());
		/*List<Integer> list = getList();
		list.stream().forEach(x->{});
		List<Integer> result3 = Collections.synchronizedList(new ArrayList<>());
		long l = System.currentTimeMillis();
		List<Integer> result1 = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
		long j = System.currentTimeMillis();
		List<Integer> result2 = list.parallelStream().filter(x -> x % 2 == 0).collect(Collectors.toList());
		long k = System.currentTimeMillis();
		list.parallelStream().filter(x -> x % 2 == 0).forEach(x->{
			result3.add(x);
		});
		long i = System.currentTimeMillis();
		System.out.println(result1.size()+"耗时:"+(j-l));
		System.out.println(result2.size()+"耗时:"+(k-j));
		System.out.println(result3.size()+"耗时:"+(i-k));
		Map map = new ConcurrentHashMap();*/
	}

	public static void show(List<Integer> list){
		IntSummaryStatistics statistics = list.stream().mapToInt(Integer::intValue).summaryStatistics();
		double average = statistics.getAverage();
		System.out.println("平均数为:"+average);
		HashMap<Integer, Integer> map = new HashMap<>();
		for (Integer i : list) {
			Integer integer = map.get(i);
			if (integer != null) {
				integer++;
				map.put(i,integer);
			}else {
				map.put(i,1);
			}
		}
		Integer max = map.values().stream().max((x, y) -> x.compareTo(y)).get();
		int size = map.size();
		String[][] s = new String[max+1][size];
		for(int i=0;i<max+1;++i){
			for(int j=0;j<size;++j) {
				s[i][j] = " ";
			}
		}
		List<Integer> values = map.values().stream().collect(Collectors.toList());
		for (Integer j = 0; j < values.size(); j++) {
			Integer value = values.get(j);
			for (Integer i = 0; i < value; i++) {
				s[i+1][j] ="=";
			}
		}
		List<Integer> keys = map.keySet().stream().collect(Collectors.toList());
		for (int i = 0;i<keys.size();i++) {
			Integer key = keys.get(i);
			s[0][i] = key+"";
		}
		System.out.print("\n");
		arrayToString(s);
	}
	public static void arrayToString(String[][] s){
		for (int i = s.length - 1; i >= 0 ; i--) {
			String[] v = s[i];
			for (int j = 0;j<v.length;j++) {
				if (i != 0) {
					String s1 = s[0][j];
					char[] chars = s1.toCharArray();
					switch(chars.length){
						case 2:System.out.print(" ");break;
						case 3:System.out.print("  ");break;
						case 4:System.out.print("   ");break;
					}
				}
				System.out.print(v[j]+"   ");
			}
			System.out.print("\n");
		}
	}
	public static List<Integer> getList(){
		List<Integer> list = Collections.synchronizedList(new ArrayList<>());
		for(int i = 0;i<10;i++){
			Random random = new Random();
			int num = random.nextInt(100);
			list.add(num);
		}
		return list;
	}
	public static List<Integer> getMathList(){
		List<Integer> list = Collections.synchronizedList(new ArrayList<>());
		for(int i = 0;i<100;i++){
			int v = (int)(Math.random() * 10);
			list.add(v);
		}
		return list;
	}
}
@NoArgsConstructor
class User{
	private String name;
	private String sex;
	private Integer age;
	private List<User> students;

	public User(String name,String sex,Integer age){
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public List<User> getStudents() {
		return students;
	}

	public void setStudents(List<User> students) {
		this.students = students;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User{" + "name='" + name + '\'' + ", sex='" + sex + '\'' + ", age=" + age + ", students=" + students
				+ '}';
	}
}
