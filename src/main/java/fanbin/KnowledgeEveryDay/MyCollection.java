package fanbin.KnowledgeEveryDay;

import fanbin.KnowledgeEveryDay.Collections.MyHashSet;
import fanbin.KnowledgeEveryDay.Collections.MyTreeSort;
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
		System.out.println("----------HashSet-----------");
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
		
		System.out.println("----------TreeSet-----------");		
		MyTreeSort<String> myTreeSort = new MyTreeSort<String>((o1, o2)->o2.compareTo(o1)); //可以指定compareTo
		myTreeSort.add("1");
		myTreeSort.add("3");
		myTreeSort.add("2");
		myTreeSort.add("2");
		myTreeSort.add("2");
		myTreeSort.add("0");
		myTreeSort.show(); // 3 2 1 0
		
		MyTreeSort<HashPerson> myHashTreeSort = new MyTreeSort<HashPerson>((o1, o2)->o2.compareTo(o1)); //可以指定compareTo
		HashPerson hp3 = new HashPerson("fanbin", 25, "male", "develop");
		myHashTreeSort.add(hp1);
		myHashTreeSort.add(hp3);
		myHashTreeSort.show();
		// Queue
		
		// List
		
	}
}
