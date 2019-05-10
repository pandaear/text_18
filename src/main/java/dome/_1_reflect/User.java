package dome._1_reflect;

/**
 * @author: yuhaifeng
 * @create: 2019-04-30 11:53
 **/
public class User {
	private String name;

	public User() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User{" + "name='" + name + '\'' + '}';
	}
}
