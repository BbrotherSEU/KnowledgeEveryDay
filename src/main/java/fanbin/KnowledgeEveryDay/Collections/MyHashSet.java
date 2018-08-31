package fanbin.KnowledgeEveryDay.Collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MyHashSet<E>{
	
	private Set<E> myHashSet;
	
	/**
	 * 1. Set有初始化大小
	 * 2. HashSet可以认为是无序的
	 * 3. HashSet 线程不安全
	 * 4. 最好重写HashCode
	 * @param cap
	 */
	public MyHashSet(int cap) {
		this.myHashSet = new HashSet<E>(cap);
	}
	
	/**
	 * 遍历打印
	 * 1. 注意不要在遍历的时候进行添加，ConcurrentModificationException
	 */
	public void show() {
		// 通过iterator的方式遍历
//		Iterator<E> iterator = myHashSet.iterator();
//		while (iterator.hasNext()) {
//			E string = (E) iterator.next();
//			System.out.println("容器中有" + string.toString());
//		}
		// 通过for循环的方式遍历
		for (E string : myHashSet) {
			System.out.println("容器中有" + string.toString());
		}
	};
	
	public boolean add(E object) {
		return myHashSet.add(object);
	};
	
	public int getSize() {
		return myHashSet.size();
	}
}
