package fanbin.KnowledgeEveryDay;

import fanbin.KnowledgeEveryDay.Collections.MyHashSet;
import fanbin.KnowledgeEveryDay.UserClass.HashPerson;
import fanbin.KnowledgeEveryDay.UserClass.Person;

/**
 * 了解每一种集合的源码逻辑
 * @author kevin
 *
 */
public class MyCollection {
	public static void main(String[] args) {
		/**
		 * 1. Set
		 * Set中主要讨论HashSet->LinkedHashSet+SortSet->TreeSet
		 * 每种Set会单独进行编写，并在最后比较各个Set的异同
		 */
		MyHashSet<String> myHashSet = new MyHashSet<String>(10);
		myHashSet.add("fanbin");
		myHashSet.show();
		
		Person p1 = new Person("fanbin", 24, "male", "develop");
		Person p2 = new Person("fanbin", 24, "male", "develop");
		MyHashSet<Person> myPersonHashSet = new MyHashSet<Person>(20);
		myPersonHashSet.add(p2);
		myPersonHashSet.add(p1);
		System.out.println("不重写HashCode");
		myPersonHashSet.show(); // 不重写HashCode，容器中会有两条记录
		
		HashPerson hp1 = new HashPerson("fanbin", 24, "male", "develop");
		HashPerson hp2 = new HashPerson("fanbin", 24, "male", "develop");
		MyHashSet<HashPerson> myHashPersonHashSet = new MyHashSet<HashPerson>(20);
		myHashPersonHashSet.add(hp1);
		myHashPersonHashSet.add(hp2);
		System.out.println("重写HashCode后");
		myHashPersonHashSet.show(); // 重写HashCode，容器中只会有一条记录
		
		// Queue
		
		// List
		
	}
}
