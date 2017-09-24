package test;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class AtomicReferenceFieldUpdaterTest {

	public static void main(String[] args) {
		MainDomain mDomain = new MainDomain();
		Domain domain = new Domain();
		AtomicReferenceFieldUpdater<MainDomain, Domain> updater = AtomicReferenceFieldUpdater
				.newUpdater(MainDomain.class, Domain.class, "domain");
		System.out.println("------------get---------------");
		Domain get = updater.get(mDomain);
		System.out.println("get(mDomain);获取对象的字段值" + get);
		System.out.println("------------------set----------------");
		updater.set(mDomain, getDomain());
		System.out.println("set(mDomain, getDomain())设值对象的字段值为新的对象" + updater.get(mDomain));
		System.out.println("-----------------------getAndSet------------------");
		Domain getAndSet = updater.getAndSet(mDomain, getDomain());
		System.out
				.println("getAndSet(mDomain, getDomain())获取对象字段值" + getAndSet + " \r\n 并设值为新的值" + updater.get(mDomain));
		System.out.println("--------------------compareAndSet---------------");
		Domain newD = getDomain();
		System.out.println("新传入的值" + newD);
		boolean compareAndSet = updater.compareAndSet(mDomain, domain, newD);
		System.out.println("compareAndSet(mDomain, domain, newD)\r\n比较传入的值是否与对象的字段相同" + compareAndSet
				+ " ,相同就将新值覆盖原来的字段，否则维持原来的值 " + updater.get(mDomain));
		System.out.println("-------------------accumulateAndGet---------------");
		Domain passD = getDomain();
		System.out.println("passD --- " + passD);
		Domain accumulateAndGet = updater.accumulateAndGet(mDomain, passD, (Domain prev, Domain passIn) -> {
			Domain domain2 = getDomain();
			domain2.setName(prev.getName());
			domain2.setTemp(passIn.getTemp());
			return domain2;
		});
		System.out.println(
				"accumulateAndGet(mDomain,passD , (Domain prev, Domain passIn) ->\r\n将原来的字段与传入的对象和算法运算后，返回运算后的值"
						+ accumulateAndGet);
		
		System.out.println("-----------------------getAndAccumulate-------------------");
		
		Domain pass2 = getDomain();
		System.out.println("pass2  ---" + pass2);
		Domain getAndAccumulate = updater.getAndAccumulate(mDomain, pass2, (Domain prev, Domain passIn) -> {
			Domain domain2 = getDomain();
			domain2.setName(prev.getName());
			domain2.setTemp(passIn.getTemp());
			return domain2;
		});
		System.out.println("getAndAccumulate(mDomain, pass2, (Domain prev, Domain passIn) ->\r\n"
				+ "将原来对象的字段根据传入的值和算法进行运算，将结果覆盖字段，将原来字段的值返回" + getAndAccumulate);
	
//	=====================================================================
		
		System.out.println("\r\n现在字段的值是"+updater.get(mDomain));
	
		System.out.println("--------------getAndUpdate---------------");
		Domain getAndUpdate = updater.getAndUpdate(mDomain, (Domain prev) -> {
			Domain domain2 = getDomain();
			domain2.setName(prev.getName());
			domain2.setTemp(10000);
			return domain2;
		});
		System.out.println("getAndUpdate(mDomain, (Domain prev) ->\r\n根据传入的算法将对象的字段进行运算，覆盖原来的字段，\r\n并返回原来的值" + getAndUpdate
				+ "现在的值是" + updater.get(mDomain));
		System.out.println("---------------updateAndGet---------------");
		Domain updateAndGet = updater.updateAndGet(mDomain, (Domain prev) -> {
			Domain domain2 = getDomain();
			domain2.setTemp(prev.getTemp());
			return domain2;
		});
		System.out
				.println("updateAndGet(mDomain, (Domain prev) ->\r\n根据传入的算法将对象的字段进行运算，覆盖原来的字段，\r\n并返回更新的值" + updateAndGet);

		System.out.println("----------------weakCompareAndSet-----------------");
		Domain df = getDomain();
		System.out.println(df);
		boolean weakCompareAndSet = updater.weakCompareAndSet(mDomain, updateAndGet, df);
		System.out.println("如果传入的值与对象的字段一致" + weakCompareAndSet + "就将新值覆盖原来的字段,现在的值是" + updater.get(mDomain));
		System.out.println("ToString" + updater.toString());
	}

	static int index;

	public static Domain getDomain() {
		Domain domain = new Domain(index++);
		domain.setName(UUID.randomUUID().toString());
		return domain;
	}
}