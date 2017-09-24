package test;

import java.util.concurrent.atomic.AtomicMarkableReference;

public class AtomicMArkableReferenceExample {
	private static Person person;

	private static AtomicMarkableReference<Person> aMRperson;

	public static void main(String[] args) throws InterruptedException {

		Thread t1 = new Thread(new MyRun1());

		Thread t2 = new Thread(new MyRun2());

		person = new Person(15);

		aMRperson = new AtomicMarkableReference<Person>(person, false);

		System.out.println("Person is " + aMRperson.getReference() + "\nMark: "

				+ aMRperson.isMarked());

		t1.start();

		t2.start();

		t1.join();

		t2.join();

		System.out.println("\nNow Person is " + aMRperson.getReference() + "\nMark: "

				+ aMRperson.isMarked());

	}

	static class MyRun1 implements Runnable {

		public void run() {

			for (int i = 0; i <= 5; i++) {

				aMRperson.getReference().setAge(person.getAge() + 1);

				aMRperson.compareAndSet(new Person(18), new Person(18), false, true);

				aMRperson.set(aMRperson.getReference(), true);

				System.out.println("\n" + Thread.currentThread().getName()

						+ " ---> " + aMRperson.getReference().toString()

						+ "\nMark: " + aMRperson.isMarked());

			}

		}

	}

	static class MyRun2 implements Runnable {

		public void run() {

			for (int i = 0; i <= 5; i++) {

				aMRperson.getReference().setAge(person.getAge() - 1);

				aMRperson.attemptMark(new Person(40), true);

				System.out.println("\n" + Thread.currentThread().getName()

						+ " ---> " + aMRperson.getReference().toString() + "\nMark: "

						+ aMRperson.isMarked());

			}

		}

	}

	static class Person {

		private int age;

		public Person(int age) {

			this.age = age;

		}

		public int getAge() {

			return age;

		}

		public void setAge(int age) {

			this.age = age;

		}

		@Override

		public String toString() {

			return "Person age is " + this.age;

		}

	}
}
