package test;

import java.util.concurrent.atomic.DoubleAccumulator;

public class DoubleAccumulatorTest {

	public static void main(String[] args) {
		//DoubleAccumulator根据传入的算法和原来传入的基础值进行运算得到初始值
		
		DoubleAccumulator accumulator = new DoubleAccumulator((double prev, double last) -> {
			return prev-last;
		}, 8.0);
		System.out.println("新建对象时accumulator的值"+accumulator);
//		根据传入的算法和保存在DoubleAccumulator里面的值 与 accumulate(10.0)里面的值进行运算并保存新值。
		accumulator.accumulate(10.0);
		accumulator.accumulate(10.0);
		System.out.println("accumulate后accumulator的值"+accumulator);
		double d = accumulator.get();
		System.out.println("get获取的值"+d);
		double thenReset = accumulator.getThenReset();
		System.out.println("getThenReset 后accumulater的值"+accumulator);
		System.out.println("getThenReset获取的值"+thenReset);
		accumulator.reset();
		
	}

}
