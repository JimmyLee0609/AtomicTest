package test;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class AtomicReferenceArrayTest {

	public static void main(String[] args) {
		AtomicReferenceArray<Domain> referenceArray = new AtomicReferenceArray<Domain>(10);

		Domain get = referenceArray.get(0);
		System.out.println("get(0)��ȡ0��λ�Ķ���" + get);

		referenceArray.set(5, getDomain());
		System.out.println("set(5, getDomain())��ֵ5��λ�Ķ���Ϊ��������,5��λ�Ķ��������� " + referenceArray.get(5));

		Domain getAndSet = referenceArray.getAndSet(2, getDomain());
		System.out.println("getAndSet(2, getDomain())��ȡ2��λ�Ķ���" + getAndSet + "����ֵ2��λ�Ķ��󱣴��µ�ֵ" + referenceArray.get(2));

		boolean compareAndSet = referenceArray.compareAndSet(2, referenceArray.get(2), getDomain());
		System.out.println("compareAndSet(2, referenceArray.get(2), getDomain())�Ƚ�2��λ�Ķ����Ƿ��봫��Ķ���һ�¡�" + compareAndSet
				+ "���һ�¾ͽ��¶��󸲸ǵ�2��λ" + referenceArray.get(2));

		Domain domain = getDomain();
		System.out.println("0��λ�Ķ�����" + referenceArray.get(0) + "����Ķ�����" + domain);

		Domain accumulateAndGet = referenceArray.accumulateAndGet(2, domain, (Domain prev, Domain passIn) -> {
			Domain temp = getDomain();
			temp.setName(prev.getName());
			temp.setTemp(passIn.getTemp());
			return temp;
		});
		System.out.println("accumulateAndGet(2,domain , (Domain prev, Domain passIn) ->���ݴ���Ķ�����㷨,��0��λ�Ķ����������,�����ظ��º��ֵ"
				+ accumulateAndGet);

		Domain getAndAccumulate = referenceArray.getAndAccumulate(2, getDomain(), (Domain prev, Domain passIn) -> {
			Domain temp = getDomain();
			temp.setName(prev.getName());
			temp.setTemp(passIn.getTemp());
			return temp;
		});
		System.out.println(
				"getAndAccumulate(2, getDomain(), (Domain prev, Domain passIn) ->���ݴ���Ķ�����㷨����2��λ�Ķ���������㣬������ԭ��2��λ�Ķ���"
						+ getAndAccumulate + "  ����2��λ��ֵ��" + referenceArray.get(2));

		Domain getAndUpdate = referenceArray.getAndUpdate(5, (Domain prev) -> {
			Domain temp = getDomain();
			temp.setName(prev.getName());
			return temp;
		});
		System.out.println(
				"getAndUpdate(5, (Domain prev) -> ��ȡ5��λ��ֵ" + getAndUpdate + "�����մ�����㷨����5��λ��ֵ" + referenceArray.get(5));

		Domain updateAndGet = referenceArray.updateAndGet(2, (Domain prev) -> {
			Domain temp = getDomain();
			temp.setName(prev.getName());
			return temp;
		});
		System.out.println("updateAndGet(2, (Domain prev) ->��ȡ�����մ�����㷨����2��λ��ֵ" + updateAndGet);

		boolean weakCompareAndSet = referenceArray.weakCompareAndSet(6, null, getDomain());
		System.out.println("weakCompareAndSet(6, null, getDomain())�����6��λ�Ķ����봫�����һ��" + weakCompareAndSet
				+ "һ�¾ͽ������ֵ����6��λ��ֵ" + referenceArray.get(6));
	}

	static int index;

	public static Domain getDomain() {
		Domain domain = new Domain(index++);
		domain.setName(UUID.randomUUID().toString());
		return domain;
	}
}
