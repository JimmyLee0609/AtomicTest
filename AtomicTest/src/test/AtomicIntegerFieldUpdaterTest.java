package test;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdaterTest {
	int temp;

	public static void main(String[] args) {
//		�½�һ������������ֶ� int temp��
		Domain domain = new Domain(3);
//		�½���������������ֶα����� volatile int����   ��integer�����С�
		AtomicIntegerFieldUpdater<Domain> updater = AtomicIntegerFieldUpdater.newUpdater(Domain.class, "temp");

		updater.set(domain, 100);
		System.out.println("set(domain, 100)��ֵ�������ֶε�ֵ");
		int get = updater.get(domain);
		System.out.println("updater.get(domain)��ȡ�������ֶε�ֵ"+get);		

		int incrementAndGet = updater.incrementAndGet(domain);
		int getAndIncrement = updater.getAndIncrement(domain);
		System.out.println("incrementAndGet(domain)��ȡ�����ֵ��+1���棬���ظ��µ�ֵ"+incrementAndGet);
		System.out.println("getAndIncrement(domain)��ȡ�����ֵ��+1���棬����ԭ����ֵ"+getAndIncrement);
		
		int decrementAndGet = updater.decrementAndGet(domain);
		int getAndDecrement = updater.getAndDecrement(domain);
		System.out.println("decrementAndGet(domain)��ȡ�����ֵ��-1���棬���ظ��µ�ֵ"+decrementAndGet);
		System.out.println("getAndDecrement(domain)��ȡ�����ֵ��-1���棬����ԭ����ֵ"+getAndDecrement);
		
		int addAndGet = updater.addAndGet(domain, 4);
		int getAndAdd = updater.getAndAdd(domain, 7);
		System.out.println("addAndGet(domain, 4)��ȡ�����ֵ����+4�����ظ��µ�ֵ"+addAndGet);
		System.out.println("getAndAdd(domain, 7)��ȡ�����ֵ����+4������ԭ����ֵ"+getAndAdd);
		
		boolean compareAndSet = updater.compareAndSet(domain, 9, 8);
		System.out.println("compareAndSet(domain, 9, 8)��������ֵ��9�ͽ�ֵ��ֵΪ8���Ƿ���ֵ�ɹ�"+compareAndSet+"���ڵ�ֵ"+updater.get(domain));
		
		int getAndSet = updater.getAndSet(domain, 11);
		System.out.println("getAndSet(domain, 11)��ȡ�����ֵ���� "+getAndSet+" ,�����½������ֵ����Ϊ  "+updater.get(domain));
		
		int getAndUpdate = updater.getAndUpdate(domain, (int prev) -> {
			return 3;
		});
		System.out.println("getAndUpdate(domain,��ȡ������ֵ����ȡ������ԭ����ֵ"+getAndUpdate);
		
		int updateAndGet = updater.updateAndGet(domain, (int prev) -> {
			return 10;
		});
		System.out.println("updateAndGet(domain��ȡ������ֵ����ȡ�����Ǹ��µ�ֵ"+updateAndGet);
		
		int accumulateAndGet = updater.accumulateAndGet(domain, 5, (int prev, int last) -> {
			return 5;
		});
		System.out.println("accumulateAndGet(domain, 5,��ȡ�����ֵ���봫��Ĳ������д����㷨�����㲢���棬��ȡ�����º��ֵ"+accumulateAndGet);
		
		int getAndAccumulate = updater.getAndAccumulate(domain, 4, (int prev, int last) -> {
			return 6;
		});
		System.out.println("getAndAccumulate(domain, 4��ȡ�����ֵ������������д����㷨�����㲢���棬��ȡ��ԭ����ֵ"+getAndAccumulate);
		System.out.println("toString" + updater.toString());
	}
}
