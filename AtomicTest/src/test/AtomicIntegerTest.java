package test;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

	public static void main(String[] args) {
//		�½�һ��ԭ����
		AtomicInteger integer = new AtomicInteger();
//		��ȡֵ
		int value = integer.get();
		System.out.println("��ȡֵ "+value);
//		����ֵ
		integer.set(100);
		System.out.println("set���ֵ"+integer.get());
		
		int incrementAndGet = integer.incrementAndGet();
		int getAndIncrement = integer.getAndIncrement();
		System.out.println("incrementAndGet��ȡֵ����ֵ��1���ȥ�����µĽ�����أ�"+incrementAndGet
				+"  getAndIncrement��ȡֵ����ֵ���أ���ֵ��1���ȥ"+getAndIncrement);
		int decrementAndGet = integer.decrementAndGet();
		int getAndDecrement = integer.getAndDecrement();
		System.out.println("decrementAndGet��ȡֵ����ֵ��1���ȥ�����µĽ�����أ�"+decrementAndGet
				+"  getAndDecrement��ȡֵ����ֵ���أ���ֵ��1���ȥ"+getAndDecrement);
		
		int getAndAdd = integer.getAndAdd(5);
		int addAndGet = integer.addAndGet(5);
		System.out.println("��ȡֵ��������Ĳ�����ֵ�������㣬getAndAdd(5)��������ǰ��ֵ"+getAndAdd+
				"addAndGet(5)����������ֵ"+addAndGet);
		int getAndSet = integer.getAndSet(10);
		System.out.println("getAndSet(10)��ȡ��ǰ��ֵ��������ֵ��Ϊ�������"+getAndSet);
		
		boolean compareAndSet = integer.compareAndSet(10, 12);
		System.out.println("compareAndSet(10, 12)�Ƚϵ�һ��ֵ�ʹ洢��ֵ�Ƿ�һ�£�һ�¾ͽ��ڶ���ֵ����"
		+"�Ƿ�ɹ�"+compareAndSet+"�������ֵ"+integer.get());
		boolean compareAndSet2 = integer.compareAndSet(11, 12);
		System.out.println("compareAndSet(10, 12)�Ƚϵ�һ��ֵ�ʹ洢��ֵ�Ƿ�һ�£�һ�¾ͽ��ڶ���ֵ����"
				+"�Ƿ�ɹ�"+compareAndSet2+"�������ֵ"+integer.get());
		
		int prevv = integer.get();
		int getAndUpdate = integer.getAndUpdate((int prev) -> {
			return prev + 10;
		});
		System.out.println("����ǰ��ֵ"+prevv+"getAndUpdate��ȡֵ����������㷨��ԭ����ֵ���и��±��棬���ص���֮ǰ��ֵ"+getAndUpdate);
		
		int prevvv = integer.get();
		int accumulateAndGet = integer.accumulateAndGet(3, (int prev, int passInValue) -> {
			return prev * passInValue;
		});
		System.out.println("����֮ǰ��ֵ"+prevvv+"accumulateAndGet��ȡֵ�������ݴ�����㷨�봫���ֵ�������㣬���ص�ֵ������ֵ"+accumulateAndGet);
		
		int prevvvv = integer.get();
		int getAndAccumulate = integer.getAndAccumulate(10, (int prev, int passInValue) -> {
			return prev-passInValue;
		});
		System.out.println("����֮ǰ��ֵ"+prevvvv+"accumulateAndGet��ȡֵ�������ݴ�����㷨�봫���ֵ�������㣬���ص�ֵ����ǰ��ֵ"+getAndAccumulate);
		
		
		byte byteValue = integer.byteValue();
		System.out.println("ת��Ϊ�ֽ�ֵ"+byteValue);
		String string = integer.toString();
		System.out.println(string);
	}

}
