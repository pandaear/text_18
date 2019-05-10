package _6_test_foreach;

import java.util.Arrays;

/**
 * @author: yuhaifeng
 * @create: 2019-01-15 18:49
 **/
public class TestForeach {
	public static void main(String[] args) {
		int arr[][][] = {
				{{1, 2}, {3, 4}},
				{{5, 6}, {7, 8}}
		};
		Arrays.stream(arr).forEach(x->{
			Arrays.stream(x).forEach(y->{
				Arrays.stream(y).forEach(System.out::println);
			});
		});
	}
}
