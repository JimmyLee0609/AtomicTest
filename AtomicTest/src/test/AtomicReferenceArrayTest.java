package test;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class AtomicReferenceArrayTest {

	public static void main(String[] args) {
		AtomicReferenceArray<Domain> referenceArray = new AtomicReferenceArray<Domain>(10);

		Domain get = referenceArray.get(0);
		System.out.println("get(0)获取0号位的对象" + get);

		referenceArray.set(5, getDomain());
		System.out.println("set(5, getDomain())设值5号位的对象为给定对象,5号位的对象现在是 " + referenceArray.get(5));

		Domain getAndSet = referenceArray.getAndSet(2, getDomain());
		System.out.println("getAndSet(2, getDomain())获取2号位的对象" + getAndSet + "并设值2号位的对象保存新的值" + referenceArray.get(2));

		boolean compareAndSet = referenceArray.compareAndSet(2, referenceArray.get(2), getDomain());
		System.out.println("compareAndSet(2, referenceArray.get(2), getDomain())比较2号位的对象是否与传入的对象一致。" + compareAndSet
				+ "如果一致就将新对象覆盖到2号位" + referenceArray.get(2));

		Domain domain = getDomain();
		System.out.println("0号位的对象是" + referenceArray.get(0) + "传入的对象是" + domain);

		Domain accumulateAndGet = referenceArray.accumulateAndGet(2, domain, (Domain prev, Domain passIn) -> {
			Domain temp = getDomain();
			temp.setName(prev.getName());
			temp.setTemp(passIn.getTemp());
			return temp;
		});
		System.out.println("accumulateAndGet(2,domain , (Domain prev, Domain passIn) ->根据传入的对象和算法,将0号位的对象进行运算,并返回更新后的值"
				+ accumulateAndGet);

		Domain getAndAccumulate = referenceArray.getAndAccumulate(2, getDomain(), (Domain prev, Domain passIn) -> {
			Domain temp = getDomain();
			temp.setName(prev.getName());
			temp.setTemp(passIn.getTemp());
			return temp;
		});
		System.out.println(
				"getAndAccumulate(2, getDomain(), (Domain prev, Domain passIn) ->根据传入的对象和算法，将2号位的对象进行运算，并返回原来2号位的对象"
						+ getAndAccumulate + "  现在2号位的值是" + referenceArray.get(2));

		Domain getAndUpdate = referenceArray.getAndUpdate(5, (Domain prev) -> {
			Domain temp = getDomain();
			temp.setName(prev.getName());
			return temp;
		});
		System.out.println(
				"getAndUpdate(5, (Domain prev) -> 获取5号位的值" + getAndUpdate + "并按照传入的算法更新5号位的值" + referenceArray.get(5));

		Domain updateAndGet = referenceArray.updateAndGet(2, (Domain prev) -> {
			Domain temp = getDomain();
			temp.setName(prev.getName());
			return temp;
		});
		System.out.println("updateAndGet(2, (Domain prev) ->获取并按照传入的算法更新2号位的值" + updateAndGet);

		boolean weakCompareAndSet = referenceArray.weakCompareAndSet(6, null, getDomain());
		System.out.println("weakCompareAndSet(6, null, getDomain())，如果6号位的对象与传入对象一致" + weakCompareAndSet
				+ "一致就将传入的值覆盖6号位的值" + referenceArray.get(6));
	}

	static int index;

	public static Domain getDomain() {
		Domain domain = new Domain(index++);
		domain.setName(UUID.randomUUID().toString());
		return domain;
	}
}
