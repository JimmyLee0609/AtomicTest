package test;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReferenceTest {

	public static void main(String[] args) {
		/*Domain domain = getDomain();
		AtomicStampedReference<Domain> stampedReference = new AtomicStampedReference<Domain>(domain,10);
		
		boolean attemptStamp = stampedReference.attemptStamp(domain, 55);
		boolean compareAndSet = stampedReference.compareAndSet(domain, getDomain(), 55, 60);
		int[] stampHolder=new int[]{1,55,60,33,516,3,5,6,8,2};
		Domain domain2 = stampedReference.get(stampHolder);
		Domain reference = stampedReference.getReference();
		int stamp = stampedReference.getStamp();
		stampedReference.set(getDomain(), 60);
		stampedReference.toString();*/
		AtomicStampedReference<Integer> atomicStampedReference 
			= new AtomicStampedReference<Integer>(0, 55);
		final int stamp = atomicStampedReference.getStamp();
		
        final Integer reference = atomicStampedReference.getReference();
        System.out.println(reference+"============"+stamp);
        
        Thread t1 = new Thread(()-> {
                System.out.println(reference + "-" + stamp + "-"
                + atomicStampedReference.compareAndSet(reference, reference + 10, stamp, stamp + 1));
        });

        Thread t2 = new Thread(()-> {
                Integer reference2 = atomicStampedReference.getReference();
                System.out.println(reference2 + "-" + stamp + "-"
                + atomicStampedReference.compareAndSet(reference2, reference2 + 10, stamp, stamp + 1));
        });
        
        t1.start();
        try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        System.out.println(atomicStampedReference.getReference());
        System.out.println(atomicStampedReference.getStamp());
    }

	
	static int index;

	public static Domain getDomain() {
		Domain domain = new Domain(index++);
		domain.setName(UUID.randomUUID().toString());
		return domain;
	}
}
