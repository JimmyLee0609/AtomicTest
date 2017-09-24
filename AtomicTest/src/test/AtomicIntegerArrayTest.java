package test;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayTest {

	public static void main(String[] args) {
		// 两种构造方法
		int[] array2 = new int[20];
		AtomicIntegerArray integerArray = new AtomicIntegerArray(array2);

		AtomicIntegerArray array = new AtomicIntegerArray(10);

		int incrementAndGet = array.incrementAndGet(5);
		int getAndIncrement = array.getAndIncrement(5);
System.out.println("incrementAndGet(5)获取数组中第5个值，并将值加1保存后返回新结果"+incrementAndGet);
System.out.println("getAndIncrement(5)获取数组中第5个值，并将值加1保存后返回原来结果"+getAndIncrement);
		int get = array.get(0);
		System.out.println(".get(0)获取0号位的值"+get);
		array.set(7, 8);
System.out.println(".set(7, 8)设值7号位的值为8"+array.get(7));

		int addAndGet = array.addAndGet(0, 10);
		int getAndAdd = array.getAndAdd(0, 11);
System.out.println("addAndGet(0, 10),获取0号位的值，并将值+10，将新结果返回"+addAndGet);		
System.out.println("addAndGet(0, 11),获取0号位的值，并将值+11，将原来的结果返回"+getAndAdd);	

		boolean compareAndSet = array.compareAndSet(1, 2, 4);
System.out.println("compareAndSet(1, 2, 4),1号位的值是2就将1号位的值更新为4，操作是否成功"+compareAndSet
		+"现在1号位的值是"+array.get(1));
		int decrementAndGet = array.decrementAndGet(1);
		int getAndDecrement = array.getAndDecrement(3);
		System.out.println("decrementAndGet(1)获取1号位的值并-1，将新结果返回"+decrementAndGet);
		System.out.println("getAndDecrement(3)获取3号位的值并-1，将原来的结果返回"+getAndDecrement);
		
		int getAndSet = array.getAndSet(5, 3);
System.out.println("getAndSet(5, 3)获取5号为的值，将值返回，"+getAndSet+"并将5号位的值设值为3，"+array.get(5));


		
		int getAndUpdate = array.getAndUpdate(5, (int prev) -> {
			return prev + 5;
		});
		System.out.println("getAndUpdate(5,获取5号位的值并根据传入的算法计算, "+array.get(5)+" ,并返回原来的值"+getAndUpdate);
		
		int updateAndGet = array.updateAndGet(6, (int prev) -> {
			return prev + 6;
		});
		
		System.out.println("updateAndGet(6,获取6号位的值并根据传入的算法计算 "+array.get(6)+" 并返回新值"+updateAndGet);
		int accumulateAndGet = array.accumulateAndGet(1, 2, (int prev, int after) -> {
			return prev + after;
		});
		System.out.println("accumulateAndGet(1, 2,   获取1号位的值，并根据传入的算法计算, "+array.get(1)+" , 并返回新值"+accumulateAndGet);
		int getAndAccumulate = array.getAndAccumulate(1, 3, (int prev, int after) -> {
			return prev + after;
		});
		System.out.println("getAndAccumulate(1, 3,   获取1号位的值，并根据传入的算法计算, "+array.get(1)+" ,并返回原来的值"+getAndAccumulate);
		String string = array.toString();
System.out.println("toString"+string);
	}

}
