package test;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicMarkableReference;

public class AtomicMarkableReferenceTest {

	public static void main(String[] args) {
		AtomicMarkableReference<Domain> markableReference 
			= new AtomicMarkableReference<Domain>(new Domain(3), true);
		boolean attemptMark = markableReference.attemptMark(new Domain(21), true);
		boolean compareAndSet = markableReference.compareAndSet(getDomain(), getDomain(), true, true);
		Domain reference = markableReference.getReference();
		boolean marked = markableReference.isMarked();
		markableReference.set(getDomain(), false);
		boolean weakCompareAndSet = markableReference.weakCompareAndSet(getDomain(), getDomain(), true, false);
		
	}
	static int index;

	public static Domain getDomain() {
		Domain domain = new Domain(index++);
		domain.setName(UUID.randomUUID().toString());
		return domain;
	}
}
