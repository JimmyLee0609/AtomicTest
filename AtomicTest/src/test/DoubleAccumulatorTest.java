package test;

import java.util.concurrent.atomic.DoubleAccumulator;

public class DoubleAccumulatorTest {

	public static void main(String[] args) {
		//DoubleAccumulator���ݴ�����㷨��ԭ������Ļ���ֵ��������õ���ʼֵ
		
		DoubleAccumulator accumulator = new DoubleAccumulator((double prev, double last) -> {
			return prev-last;
		}, 8.0);
		System.out.println("�½�����ʱaccumulator��ֵ"+accumulator);
//		���ݴ�����㷨�ͱ�����DoubleAccumulator�����ֵ �� accumulate(10.0)�����ֵ�������㲢������ֵ��
		accumulator.accumulate(10.0);
		accumulator.accumulate(10.0);
		System.out.println("accumulate��accumulator��ֵ"+accumulator);
		double d = accumulator.get();
		System.out.println("get��ȡ��ֵ"+d);
		double thenReset = accumulator.getThenReset();
		System.out.println("getThenReset ��accumulater��ֵ"+accumulator);
		System.out.println("getThenReset��ȡ��ֵ"+thenReset);
		accumulator.reset();
		
	}

}
