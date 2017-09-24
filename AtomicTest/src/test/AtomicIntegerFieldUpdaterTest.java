package test;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdaterTest {
	int temp;

	public static void main(String[] args) {
//		新建一个对象，里边有字段 int temp。
		Domain domain = new Domain(3);
//		新建更新器，对象的字段必须是 volatile int类型   连integer都不行。
		AtomicIntegerFieldUpdater<Domain> updater = AtomicIntegerFieldUpdater.newUpdater(Domain.class, "temp");

		updater.set(domain, 100);
		System.out.println("set(domain, 100)设值对象中字段的值");
		int get = updater.get(domain);
		System.out.println("updater.get(domain)获取对象中字段的值"+get);		

		int incrementAndGet = updater.incrementAndGet(domain);
		int getAndIncrement = updater.getAndIncrement(domain);
		System.out.println("incrementAndGet(domain)获取对象的值并+1保存，返回更新的值"+incrementAndGet);
		System.out.println("getAndIncrement(domain)获取对象的值并+1保存，返回原来的值"+getAndIncrement);
		
		int decrementAndGet = updater.decrementAndGet(domain);
		int getAndDecrement = updater.getAndDecrement(domain);
		System.out.println("decrementAndGet(domain)获取对象的值并-1保存，返回更新的值"+decrementAndGet);
		System.out.println("getAndDecrement(domain)获取对象的值并-1保存，返回原来的值"+getAndDecrement);
		
		int addAndGet = updater.addAndGet(domain, 4);
		int getAndAdd = updater.getAndAdd(domain, 7);
		System.out.println("addAndGet(domain, 4)获取对象的值，并+4，返回更新的值"+addAndGet);
		System.out.println("getAndAdd(domain, 7)获取对象的值，并+4，返回原来的值"+getAndAdd);
		
		boolean compareAndSet = updater.compareAndSet(domain, 9, 8);
		System.out.println("compareAndSet(domain, 9, 8)如果对象的值是9就将值设值为8，是否设值成功"+compareAndSet+"现在的值"+updater.get(domain));
		
		int getAndSet = updater.getAndSet(domain, 11);
		System.out.println("getAndSet(domain, 11)获取对象的值返回 "+getAndSet+" ,并重新将对象的值保存为  "+updater.get(domain));
		
		int getAndUpdate = updater.getAndUpdate(domain, (int prev) -> {
			return 3;
		});
		System.out.println("getAndUpdate(domain,获取并更新值，获取到的是原来的值"+getAndUpdate);
		
		int updateAndGet = updater.updateAndGet(domain, (int prev) -> {
			return 10;
		});
		System.out.println("updateAndGet(domain获取并更新值，获取到的是更新的值"+updateAndGet);
		
		int accumulateAndGet = updater.accumulateAndGet(domain, 5, (int prev, int last) -> {
			return 5;
		});
		System.out.println("accumulateAndGet(domain, 5,获取对象的值并与传入的参数进行传入算法的运算并保存，获取到更新后的值"+accumulateAndGet);
		
		int getAndAccumulate = updater.getAndAccumulate(domain, 4, (int prev, int last) -> {
			return 6;
		});
		System.out.println("getAndAccumulate(domain, 4获取对象的值并传入参数进行传入算法的运算并保存，获取到原来的值"+getAndAccumulate);
		System.out.println("toString" + updater.toString());
	}
}
