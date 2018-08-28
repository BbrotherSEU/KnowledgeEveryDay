package fanbin.KnowledgeEveryDay.UserClass;

public class Person {

	private String name;
	private int age;
	private String sex;
	private String title;
	
	public Person(String name, int age, String sex, String title) {
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", sex=" + sex + ", title=" + title + "]";
	}
}
