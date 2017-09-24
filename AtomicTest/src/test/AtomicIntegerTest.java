package test;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

	public static void main(String[] args) {
//		新建一个原子类
		AtomicInteger integer = new AtomicInteger();
//		获取值
		int value = integer.get();
		System.out.println("获取值 "+value);
//		设置值
		integer.set(100);
		System.out.println("set后的值"+integer.get());
		
		int incrementAndGet = integer.incrementAndGet();
		int getAndIncrement = integer.getAndIncrement();
		System.out.println("incrementAndGet获取值并将值加1存回去，将新的结果返回，"+incrementAndGet
				+"  getAndIncrement获取值并将值返回，将值加1存回去"+getAndIncrement);
		int decrementAndGet = integer.decrementAndGet();
		int getAndDecrement = integer.getAndDecrement();
		System.out.println("decrementAndGet获取值并将值减1存回去，将新的结果返回，"+decrementAndGet
				+"  getAndDecrement获取值并将值返回，将值减1存回去"+getAndDecrement);
		
		int getAndAdd = integer.getAndAdd(5);
		int addAndGet = integer.addAndGet(5);
		System.out.println("获取值并将传入的参数与值进行运算，getAndAdd(5)返回运算前的值"+getAndAdd+
				"addAndGet(5)返回运算后的值"+addAndGet);
		int getAndSet = integer.getAndSet(10);
		System.out.println("getAndSet(10)获取当前的值，并将新值作为结果保存"+getAndSet);
		
		boolean compareAndSet = integer.compareAndSet(10, 12);
		System.out.println("compareAndSet(10, 12)比较第一个值和存储的值是否一致，一致就将第二个值存入"
		+"是否成功"+compareAndSet+"操作后的值"+integer.get());
		boolean compareAndSet2 = integer.compareAndSet(11, 12);
		System.out.println("compareAndSet(10, 12)比较第一个值和存储的值是否一致，一致就将第二个值存入"
				+"是否成功"+compareAndSet2+"操作后的值"+integer.get());
		
		int prevv = integer.get();
		int getAndUpdate = integer.getAndUpdate((int prev) -> {
			return prev + 10;
		});
		System.out.println("操作前的值"+prevv+"getAndUpdate获取值并传入操作算法对原来的值进行更新保存，返回的是之前的值"+getAndUpdate);
		
		int prevvv = integer.get();
		int accumulateAndGet = integer.accumulateAndGet(3, (int prev, int passInValue) -> {
			return prev * passInValue;
		});
		System.out.println("操作之前的值"+prevvv+"accumulateAndGet获取值，并根据传入的算法与传入的值进行运算，返回的值运算后的值"+accumulateAndGet);
		
		int prevvvv = integer.get();
		int getAndAccumulate = integer.getAndAccumulate(10, (int prev, int passInValue) -> {
			return prev-passInValue;
		});
		System.out.println("操作之前的值"+prevvvv+"accumulateAndGet获取值，并根据传入的算法与传入的值进行运算，返回的值运算前的值"+getAndAccumulate);
		
		
		byte byteValue = integer.byteValue();
		System.out.println("转换为字节值"+byteValue);
		String string = integer.toString();
		System.out.println(string);
	}

}
