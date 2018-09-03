package fanbin.KnowledgeEveryDay.Collections;

import java.util.concurrent.ConcurrentLinkedQueue;

public class MyConcurrentLinkedQueue<E> {
	private ConcurrentLinkedQueue<E> concurrentLinkedQueue;
	
	/**
	 * new一个空的队列
	 */
	public MyConcurrentLinkedQueue() {
		this.concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
	}
	
	/**
	 * add就是offer
	 * @param object
	 * @return
	 */
	public boolean add(E object) {
		return concurrentLinkedQueue.add(object);
	}
	
	/**
	 * offer
	 * 利用volatile保证内存可见性
	 * 利用cas保证数据原子性
	 * 此处需要扩展volatile和cas
	 * @param object
	 * @return
	 */
	public boolean offer(E object) {
		return concurrentLinkedQueue.offer(object);
	}
	
	/**
	 * 移除头部
	 * @return
	 */
	public E remove() {
		return concurrentLinkedQueue.remove();
	}
	
	public void show() {
		for (E e : concurrentLinkedQueue) {
			System.out.println("容易中的内容是： " + e.toString());
		}
	}

	/**
	 * 移出并获得头
	 * 当队列为空时得到空
	 * @return
	 */
	public E poll() {
		return concurrentLinkedQueue.poll();
	}
}
