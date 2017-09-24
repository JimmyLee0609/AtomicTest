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
		System.out.println("get(mDomain);��ȡ������ֶ�ֵ" + get);
		System.out.println("------------------set----------------");
		updater.set(mDomain, getDomain());
		System.out.println("set(mDomain, getDomain())��ֵ������ֶ�ֵΪ�µĶ���" + updater.get(mDomain));
		System.out.println("-----------------------getAndSet------------------");
		Domain getAndSet = updater.getAndSet(mDomain, getDomain());
		System.out
				.println("getAndSet(mDomain, getDomain())��ȡ�����ֶ�ֵ" + getAndSet + " \r\n ����ֵΪ�µ�ֵ" + updater.get(mDomain));
		System.out.println("--------------------compareAndSet---------------");
		Domain newD = getDomain();
		System.out.println("�´����ֵ" + newD);
		boolean compareAndSet = updater.compareAndSet(mDomain, domain, newD);
		System.out.println("compareAndSet(mDomain, domain, newD)\r\n�Ƚϴ����ֵ�Ƿ��������ֶ���ͬ" + compareAndSet
				+ " ,��ͬ�ͽ���ֵ����ԭ�����ֶΣ�����ά��ԭ����ֵ " + updater.get(mDomain));
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
				"accumulateAndGet(mDomain,passD , (Domain prev, Domain passIn) ->\r\n��ԭ�����ֶ��봫��Ķ�����㷨����󣬷���������ֵ"
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
				+ "��ԭ��������ֶθ��ݴ����ֵ���㷨�������㣬����������ֶΣ���ԭ���ֶε�ֵ����" + getAndAccumulate);
	
//	=====================================================================
		
		System.out.println("\r\n�����ֶε�ֵ��"+updater.get(mDomain));
	
		System.out.println("--------------getAndUpdate---------------");
		Domain getAndUpdate = updater.getAndUpdate(mDomain, (Domain prev) -> {
			Domain domain2 = getDomain();
			domain2.setName(prev.getName());
			domain2.setTemp(10000);
			return domain2;
		});
		System.out.println("getAndUpdate(mDomain, (Domain prev) ->\r\n���ݴ�����㷨��������ֶν������㣬����ԭ�����ֶΣ�\r\n������ԭ����ֵ" + getAndUpdate
				+ "���ڵ�ֵ��" + updater.get(mDomain));
		System.out.println("---------------updateAndGet---------------");
		Domain updateAndGet = updater.updateAndGet(mDomain, (Domain prev) -> {
			Domain domain2 = getDomain();
			domain2.setTemp(prev.getTemp());
			return domain2;
		});
		System.out
				.println("updateAndGet(mDomain, (Domain prev) ->\r\n���ݴ�����㷨��������ֶν������㣬����ԭ�����ֶΣ�\r\n�����ظ��µ�ֵ" + updateAndGet);

		System.out.println("----------------weakCompareAndSet-----------------");
		Domain df = getDomain();
		System.out.println(df);
		boolean weakCompareAndSet = updater.weakCompareAndSet(mDomain, updateAndGet, df);
		System.out.println("��������ֵ�������ֶ�һ��" + weakCompareAndSet + "�ͽ���ֵ����ԭ�����ֶ�,���ڵ�ֵ��" + updater.get(mDomain));
		System.out.println("ToString" + updater.toString());
	}

	static int index;

	public static Domain getDomain() {
		Domain domain = new Domain(index++);
		domain.setName(UUID.randomUUID().toString());
		return domain;
	}
}