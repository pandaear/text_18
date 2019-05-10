package _9_guibing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: yuhaifeng
 * @create: 2019-01-31 15:53
 **/
public class TestGuiBing {
	public static void main(String[] args) {
//		List<Integer> primeNumber = getPrimeNumber();
//		System.out.println(primeNumber);
		List<String> strs = new ArrayList<>();
		strs.add("aa");
		strs.add("bb");
		strs.add("cc");
		System.out.println(String.join(":", strs));

	}

	/**
	 * 判断是否是质数
	 * @param num
	 * @return
	 */
	public static boolean isPrimeNumber(int num){
		int abs = Math.abs(num);
		int start = abs-1;
		for (int i = start; i > 1; i--) {
			if (num%i == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 获取元数据
	 * @return
	 */
	public static List<Integer> getList(){
		List<Integer> list = new ArrayList<>();
		for(int i = 1 ;i<100;i++){
			list.add(i);
		}
		return list;
	}

	/**
	 * 获取质数集合
	 * @return
	 */
	public static List<Integer> getPrimeNumber(){
		List<Integer> ele = getList();
		List<Integer> list = ele.parallelStream().filter(TestGuiBing::isPrimeNumber).collect(Collectors.toList());
		return list;
	}
}
