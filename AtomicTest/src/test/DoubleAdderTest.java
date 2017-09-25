package test;

import java.util.concurrent.atomic.DoubleAdder;

public class DoubleAdderTest {

	public static void main(String[] args) {
DoubleAdder doubleAdder = new DoubleAdder();
DoubleAdder doubleAdder2 = new DoubleAdder();

doubleAdder.add(35d);
doubleAdder2.add(35d);
System.out.println(doubleAdder.equals(doubleAdder2));//false
System.out.println(doubleAdder.toString());//35.0

double sum = doubleAdder.sum();//35.0
System.out.println(sum);
doubleAdder.reset();//0.0

System.out.println(doubleAdder.toString());

doubleAdder.add(35d);//0.0+35.0
System.out.println(doubleAdder.toString());
double sumThenReset = doubleAdder.sumThenReset();
System.out.println(sumThenReset);
System.out.println(doubleAdder);

doubleAdder.add(35d);//0.0+35.0
doubleAdder.add(35d);//0.0+35.0+35.0
doubleAdder.add(35d);//0.0+35.0+35.0+35.0
doubleAdder.add(35d);//0.0+35.0+35.0+35.0+35.0
double sunadd = doubleAdder.sumThenReset();

System.out.println(sunadd);



	}

}
