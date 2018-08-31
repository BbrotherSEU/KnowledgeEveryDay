package fanbin.KnowledgeEveryDay.Collections;

import java.util.LinkedHashSet;

public class MyLinkedHashSet<E> {
	private LinkedHashSet<E> myLinkedHashSet;
	
	/**
	 * LinkedHashSet是不可重复，且根据插入顺序排序的结构
	 */
	public MyLinkedHashSet() {
		this.myLinkedHashSet = new LinkedHashSet<E>();
	}
	
	/**
	 * 可自定义初始大小
	 * @param cap
	 */
	public MyLinkedHashSet(int cap) {
		this.myLinkedHashSet = new LinkedHashSet<>(cap);
	}
	
	/**
	 * 可自定义扩展因子
	 * @param cap
	 * @param factor
	 */
	public MyLinkedHashSet(int cap, float factor) {
		this.myLinkedHashSet = new LinkedHashSet<E>(cap, factor);
	}
	
	public boolean add(E object) {
		return myLinkedHashSet.add(object);
	}
	
	public boolean remove(E object) {
		return myLinkedHashSet.remove(object);
	}
	
	public void show() {
		for (E string : myLinkedHashSet) {
			System.out.println("容器中有" + string.toString());
		}
	}
}
