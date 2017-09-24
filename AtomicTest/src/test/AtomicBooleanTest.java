package test;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicBooleanTest {

	public static void main(String[] args) {
		
		AtomicBoolean boolean1 = new AtomicBoolean();
		AtomicBoolean boolean2 = new AtomicBoolean(true);
		System.out.println("boolean1ԭ����ֵ��"+boolean1.get());
		boolean cSet = boolean1.compareAndSet(false, false);
		System.out.println("compareAndSet�趨���ֵ"+boolean1.get()+
				"  compareAndSet�ɹ��ķ���ֵ��"+cSet);
		boolean gSet = boolean1.getAndSet(true);
		System.out.println("boolean1�趨���ֵ"+boolean1.get()+"getAndSet�ķ���ֵ"+gSet);
		boolean1.set(true);
		
		boolean equals = boolean1.equals(boolean2);
		System.out.println("�Ƚ�����ԭ�Ӷ���"+equals);
		
	}

}
