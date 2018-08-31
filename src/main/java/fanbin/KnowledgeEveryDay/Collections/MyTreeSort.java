package fanbin.KnowledgeEveryDay.Collections;

import java.util.Comparator;
import java.util.TreeSet;

public class MyTreeSort<E> {

	private TreeSet<E> myTreeSet;


	/**
	 * TreeSort的内部结构是红黑树
	 * TreeSort其实就是TreeMap
	 * TreeSort会自动排序，当然也可以指定排序方式
	 */
	public MyTreeSort() {
		this.myTreeSet = new TreeSet<E>(); 
	}
	
	/**
	 * 默认从小到大排序
	 * 也可以指定排序
	 * @param comparator
	 */
	public MyTreeSort(Comparator<E> comparator) {
		this.myTreeSet = new TreeSet<E>(comparator); 
	}
	
	public boolean add(E object) {
		return myTreeSet.add(object);
	}
	
	public boolean remove(E object) {
		return myTreeSet.remove(object);
	}
	
	public void show() {
		for (E string : myTreeSet) {
			System.out.println("容器中有" + string.toString());
		}
	}
}
