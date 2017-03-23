package bankeralgorithm_2;

/**
 * �����м��㷨���д���ʵ�֣�ģ��̲�113ҳ���м��
 * �༶�����4��
 * ѧ�ţ�2014011725 
 * ������������ 
 * ���ʱ�䣺2016-4-150
 * 
 * @author dell-sun
 * @version 1.1.1
 * 
 */

public class BankerAlgorithmDemo {
	static final int m = 3; // ��Դ����Ŀ
	static int[] request = new int[m]; // ������
	
	// ������ main����
	public static void main(String[] args) {
		
		BankerAlgorithmTools tools = new BankerAlgorithmTools();
		BankerAlgorithm bankeralgorithm = new BankerAlgorithm();
		
		// (1)�ж�t0ʱ�̵İ�ȫ��	 p113
		System.out.println("�ж�t0ʱ�̵İ�ȫ�ԣ�");
		if (bankeralgorithm.securityAlgorithm()) {
			System.out.println("t0ʱ���ǰ�ȫ��");
		} else {
			System.out.println("t0ʱ���ǲ���ȫ��");
		}

		// (2)p1������Դ	request(1,0,2)	p114
		System.out.println("/*************************************************************/");
		request[0] = 1;
		request[1] = 0;
		request[2] = 2;
		bankeralgorithm.bankerAlgorithm(request, 1);

		// (3)p4������Դ	request(3,3,0)	p114
		System.out.println("/*************************************************************/");
		request[0] = 3;
		request[1] = 3;
		request[2] = 0;
		bankeralgorithm.bankerAlgorithm(request, 4);

		// (4)p0  request(0,2,0) ������Դ		p114
		System.out.println("/***************************7**********************************/");
		request[0] = 0;
		request[1] = 2;
		request[2] = 0;
		bankeralgorithm.bankerAlgorithm(request, 0);

		// p0  request(0,1,0)  ������Դ		p114
		System.out.println("/*************************************************************/");
		System.out.println("������м��㷨�а�p0���������������Ϊrequest(0,1,0)");
		request[0] = 0;
		request[1] = 1;
		request[2] = 0;
		bankeralgorithm.bankerAlgorithm(request, 0);
	}

}
