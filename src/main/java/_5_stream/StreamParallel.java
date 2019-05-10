package _5_stream;

import java.util.*;

/**
 * @author: yuhaifeng
 * @create: 2019-04-12 10:01
 **/
public class StreamParallel {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("num", 50);
		Map<String, Integer> map1 = new HashMap<>();
		map1.put("num", 50);
		List<Integer> list = Collections.synchronizedList(new ArrayList<>());
		for (int i = 0;i<5000000;i++){
			list.add(i);
		}
		StringBuffer stringBuffer1 = new StringBuffer();
		StringBuffer stringBuffer2 = new StringBuffer();
		long l = System.currentTimeMillis();
		list.stream().forEach(e->{
			stringBuffer1.append(e);
		});
		long i = System.currentTimeMillis();
		System.out.println("============================="+(i-l));
		list.parallelStream().forEach(e->{
			stringBuffer2.append(e);
		});
		System.out.println(System.currentTimeMillis() - i);
		if (stringBuffer1.length() == stringBuffer2.length()) {
			System.out.println("长度相等");
		}else{
			System.out.println("长度不相等");
		}
	}
}
