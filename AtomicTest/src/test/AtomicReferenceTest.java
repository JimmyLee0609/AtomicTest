package test;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {

	public static void main(String[] args) {
		// �½���������
		Domain domain = new Domain(4);
		Domain pass = new Domain(100);
		// �½�һ����������
		AtomicReference<Domain> reference = new AtomicReference<Domain>(domain);

		Domain get = reference.get();
		System.out.println("get()��ȡ�������ڵ�ֵ" + get);

		reference.set(pass);
		System.out.println("set(pass)��ֵ�������ڵ�ֵ" + reference.get());

		Domain getAndSet = reference.getAndSet(domain);
		System.out.println("getAndSet(domain)��������ֵΪ�µ�ֵ������ȡԭ����ֵ" + getAndSet);

		boolean compareAndSet = reference.compareAndSet(domain, pass);
		System.out.println(
				"compareAndSet(domain, pass)�����ǵ�һ��ֵ��" + compareAndSet + "�Ǿͽ��ڶ���ֵ���浽�����У����ڵ�ֵ��" + reference.get());

		Domain temp = new Domain(55);
		temp.setName("����");
		Domain accumulateAndGet = reference.accumulateAndGet(temp, (Domain prev, Domain passIn) -> {
			passIn.setName(prev.getName());
			return passIn;
		});
		System.out.println("accumulateAndGet(pass   �����õĶ��󣬰��մ���Ķ���ʹ�����㷨���д������棬�����µ�ֵ" + accumulateAndGet);

		Domain getAndAccumulate = reference.getAndAccumulate(temp, (Domain prev, Domain passIn) -> {
			passIn.setTemp(prev.getTemp());
			passIn.setName("����getAndAccumulate");
			return passIn;
		});
		System.out.println("getAndAccumulate(get   �����õĶ��󣬰��մ���Ķ���ʹ�����㷨���д������棬����ԭ���Ľ��" + getAndAccumulate);
		System.out.println("�������õ�ֵ��" + reference.get());

		Domain getAndUpdate = reference.getAndUpdate((Domain prev) -> {
			Domain domain2 = new Domain(100);
			domain2.setName(prev.getName());
			return domain2;
		});
		System.out.println("getAndUpdate((Domain  �����õĶ����մ�����㷨���д������棬����ԭ����ֵ" + getAndUpdate+"@"+getAndUpdate.hashCode());
		System.out.println("���ڵ�ֵ��" + reference.get());
	
		String name = "temtemp";
		Domain updateAndGet = reference.updateAndGet((Domain prev) -> {
			Domain domain2 = new Domain(prev.getTemp());
			domain2.setName(name);
			return domain2;
		});
		System.out.println("gupdateAndGet((Domain  �����õĶ����մ�����㷨���д������棬�����µ�ֵ" +updateAndGet +"@"+updateAndGet.hashCode());

		System.out.println("ToString" + reference.toString());
	}
	static int index;

	public static Domain getDomain() {
		Domain domain = new Domain(index++);
		domain.setName(UUID.randomUUID().toString());
		return domain;
	}
}
