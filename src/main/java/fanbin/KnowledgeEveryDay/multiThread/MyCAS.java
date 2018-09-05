package fanbin.KnowledgeEveryDay.multiThread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS是英文单词CompareAndSwap的缩写，中文意思是：比较并替换。CAS需要有3个操作数：内存地址V，旧的预期值A，即将要更新的目标值B。
 * CAS指令执行时，当且仅当内存地址V的值与预期值A相等时，将内存地址V的值修改为B，否则就什么都不做。整个比较并替换的操作是一个原子操作。
 * @author kevin
 *
 */
class CAS {
	// 内存值
	private volatile int value;

	// 获取内存值
	public synchronized int getValue() {
		return value;
	}

	// 无论更新成功还是失败，都会返回旧的内存值
	public synchronized int compareAndSwap(int expectedValue, int newValue) {
		int oldValue = value;

		if (oldValue == expectedValue) {
			this.value = newValue;
		}

		return oldValue;
	}

	// 判断更新是否成功，如果更新成功，旧的内存值会和预估值相等
	public synchronized boolean compareAndSet(int expectedValue, int newValue) {
		return expectedValue == compareAndSwap(expectedValue, newValue);
	}
}

/**
 * 
 * @author kevin
 *
 */
public class MyCAS {

	public static void main(String[] args) {

		AtomicInteger atomicInteger = new AtomicInteger(0);
		/**
		 * 借鉴atomic包的做法，unsafe中的方法
		 * getAndAddInt方法解析：拿到内存位置的最新值v，使用CAS尝试修将内存位置的值修改为目标值v+delta，如果修改失败，则获取该内存位置的新值v，然后继续尝试，直至修改成功。
		 */
		atomicInteger.getAndAdd(10);
		
		CAS cas = new CAS();

		// 创建10个线程来模拟多线程环境
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j< 100; j++) {
						int expectedValue = cas.getValue();
						boolean b = cas.compareAndSet(expectedValue, (int) (Math.random() * 101));
//						System.out.println("try: " + expectedValue + "|" + cas.getValue() + "|" + b);
						while (!b) {
							// 借鉴unsafe中的思路重试
							expectedValue = cas.getValue();
							b = cas.compareAndSet(expectedValue, (int) (Math.random() * 101));
							System.out.println("CAS: " + expectedValue + "|" + cas.getValue() + "|" + b);
						}
					}
				}
			}).start();
		}
	}
}
