package test;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {

	public static void main(String[] args) {
		// 新建两个对象
		Domain domain = new Domain(4);
		Domain pass = new Domain(100);
		// 新建一个更改引用
		AtomicReference<Domain> reference = new AtomicReference<Domain>(domain);

		Domain get = reference.get();
		System.out.println("get()获取引用现在的值" + get);

		reference.set(pass);
		System.out.println("set(pass)设值引用现在的值" + reference.get());

		Domain getAndSet = reference.getAndSet(domain);
		System.out.println("getAndSet(domain)将对象设值为新的值，并获取原来的值" + getAndSet);

		boolean compareAndSet = reference.compareAndSet(domain, pass);
		System.out.println(
				"compareAndSet(domain, pass)引用是第一个值，" + compareAndSet + "是就将第二个值保存到引用中，现在的值是" + reference.get());

		Domain temp = new Domain(55);
		temp.setName("测试");
		Domain accumulateAndGet = reference.accumulateAndGet(temp, (Domain prev, Domain passIn) -> {
			passIn.setName(prev.getName());
			return passIn;
		});
		System.out.println("accumulateAndGet(pass   将引用的对象，按照传入的对象和传入的算法进行处理并保存，返回新的值" + accumulateAndGet);

		Domain getAndAccumulate = reference.getAndAccumulate(temp, (Domain prev, Domain passIn) -> {
			passIn.setTemp(prev.getTemp());
			passIn.setName("测试getAndAccumulate");
			return passIn;
		});
		System.out.println("getAndAccumulate(get   将引用的对象，按照传入的对象和传入的算法进行处理并保存，返回原来的结果" + getAndAccumulate);
		System.out.println("现在引用的值是" + reference.get());

		Domain getAndUpdate = reference.getAndUpdate((Domain prev) -> {
			Domain domain2 = new Domain(100);
			domain2.setName(prev.getName());
			return domain2;
		});
		System.out.println("getAndUpdate((Domain  将引用的对象按照传入的算法进行处理并保存，返回原来的值" + getAndUpdate+"@"+getAndUpdate.hashCode());
		System.out.println("现在的值是" + reference.get());
	
		String name = "temtemp";
		Domain updateAndGet = reference.updateAndGet((Domain prev) -> {
			Domain domain2 = new Domain(prev.getTemp());
			domain2.setName(name);
			return domain2;
		});
		System.out.println("gupdateAndGet((Domain  将引用的对象按照传入的算法进行处理并保存，返回新的值" +updateAndGet +"@"+updateAndGet.hashCode());

		System.out.println("ToString" + reference.toString());
	}
	static int index;

	public static Domain getDomain() {
		Domain domain = new Domain(index++);
		domain.setName(UUID.randomUUID().toString());
		return domain;
	}
}
