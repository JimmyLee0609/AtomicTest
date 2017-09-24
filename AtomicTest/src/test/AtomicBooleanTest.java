package test;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicBooleanTest {

	public static void main(String[] args) {
		
		AtomicBoolean boolean1 = new AtomicBoolean();
		AtomicBoolean boolean2 = new AtomicBoolean(true);
		System.out.println("boolean1原来的值："+boolean1.get());
		boolean cSet = boolean1.compareAndSet(false, false);
		System.out.println("compareAndSet设定后的值"+boolean1.get()+
				"  compareAndSet成功的返回值："+cSet);
		boolean gSet = boolean1.getAndSet(true);
		System.out.println("boolean1设定后的值"+boolean1.get()+"getAndSet的返回值"+gSet);
		boolean1.set(true);
		
		boolean equals = boolean1.equals(boolean2);
		System.out.println("比较两个原子对象"+equals);
		
	}

}
