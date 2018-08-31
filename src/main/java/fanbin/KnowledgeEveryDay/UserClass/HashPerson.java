package fanbin.KnowledgeEveryDay.UserClass;

public class HashPerson implements Comparable{

	private String name;
	private int age;
	private String sex;
	private String title;
	
	public HashPerson(String name, int age, String sex, String title) {
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", sex=" + sex + ", title=" + title + "]";
	}
	
	/**
	 * 重写HashCode
	 * 1. 如果两个对象使用equals()方法比较，返回true（即相等），那么两个比较对象返回的hashCode()必须相等
	 * 2. 多次调用同一对象的hashCode()方法，如果equals()方法里所使用的变量没有任何变化
	 * 3. 返回hashCode相等的对象，不一定equals()相等，也即是不同对象出现hash值碰撞
	 */
	@Override
	public int hashCode() { // 重写HashCode
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HashPerson other = (HashPerson) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Object o1) {
		return this.hashCode() - o1.hashCode();
	}
}
