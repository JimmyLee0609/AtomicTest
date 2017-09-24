package test;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayTest {

	public static void main(String[] args) {
		// ���ֹ��췽��
		int[] array2 = new int[20];
		AtomicIntegerArray integerArray = new AtomicIntegerArray(array2);

		AtomicIntegerArray array = new AtomicIntegerArray(10);

		int incrementAndGet = array.incrementAndGet(5);
		int getAndIncrement = array.getAndIncrement(5);
System.out.println("incrementAndGet(5)��ȡ�����е�5��ֵ������ֵ��1����󷵻��½��"+incrementAndGet);
System.out.println("getAndIncrement(5)��ȡ�����е�5��ֵ������ֵ��1����󷵻�ԭ�����"+getAndIncrement);
		int get = array.get(0);
		System.out.println(".get(0)��ȡ0��λ��ֵ"+get);
		array.set(7, 8);
System.out.println(".set(7, 8)��ֵ7��λ��ֵΪ8"+array.get(7));

		int addAndGet = array.addAndGet(0, 10);
		int getAndAdd = array.getAndAdd(0, 11);
System.out.println("addAndGet(0, 10),��ȡ0��λ��ֵ������ֵ+10�����½������"+addAndGet);		
System.out.println("addAndGet(0, 11),��ȡ0��λ��ֵ������ֵ+11����ԭ���Ľ������"+getAndAdd);	

		boolean compareAndSet = array.compareAndSet(1, 2, 4);
System.out.println("compareAndSet(1, 2, 4),1��λ��ֵ��2�ͽ�1��λ��ֵ����Ϊ4�������Ƿ�ɹ�"+compareAndSet
		+"����1��λ��ֵ��"+array.get(1));
		int decrementAndGet = array.decrementAndGet(1);
		int getAndDecrement = array.getAndDecrement(3);
		System.out.println("decrementAndGet(1)��ȡ1��λ��ֵ��-1�����½������"+decrementAndGet);
		System.out.println("getAndDecrement(3)��ȡ3��λ��ֵ��-1����ԭ���Ľ������"+getAndDecrement);
		
		int getAndSet = array.getAndSet(5, 3);
System.out.println("getAndSet(5, 3)��ȡ5��Ϊ��ֵ����ֵ���أ�"+getAndSet+"����5��λ��ֵ��ֵΪ3��"+array.get(5));


		
		int getAndUpdate = array.getAndUpdate(5, (int prev) -> {
			return prev + 5;
		});
		System.out.println("getAndUpdate(5,��ȡ5��λ��ֵ�����ݴ�����㷨����, "+array.get(5)+" ,������ԭ����ֵ"+getAndUpdate);
		
		int updateAndGet = array.updateAndGet(6, (int prev) -> {
			return prev + 6;
		});
		
		System.out.println("updateAndGet(6,��ȡ6��λ��ֵ�����ݴ�����㷨���� "+array.get(6)+" ��������ֵ"+updateAndGet);
		int accumulateAndGet = array.accumulateAndGet(1, 2, (int prev, int after) -> {
			return prev + after;
		});
		System.out.println("accumulateAndGet(1, 2,   ��ȡ1��λ��ֵ�������ݴ�����㷨����, "+array.get(1)+" , ��������ֵ"+accumulateAndGet);
		int getAndAccumulate = array.getAndAccumulate(1, 3, (int prev, int after) -> {
			return prev + after;
		});
		System.out.println("getAndAccumulate(1, 3,   ��ȡ1��λ��ֵ�������ݴ�����㷨����, "+array.get(1)+" ,������ԭ����ֵ"+getAndAccumulate);
		String string = array.toString();
System.out.println("toString"+string);
	}

}
