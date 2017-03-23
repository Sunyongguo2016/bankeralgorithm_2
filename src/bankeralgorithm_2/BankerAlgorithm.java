package bankeralgorithm_2;

/**
 * ���м��㷨
 * �༶�����4��
 * ѧ�ţ�2014011725 
 * ������������ 
 * ���ʱ�䣺2016-4-15
 * 
 * @author dell-sun
 * @version 1.1.1
 * 
 */

/**
 * ���м��㷨���������м��㷨�������м��㷨�еİ�ȫ���㷨
 * 
 *
 */
public class BankerAlgorithm {
	BankerAlgorithm(){}
	BankerAlgorithmTools tools = new BankerAlgorithmTools();
	
	// ������5����Դ3�࣬ģ��̲�113ҳ
	static final int n = 5; // ������
	static final int m = 3; // ��Դ����Ŀ

	// static int[] available = new int[m]; // ������Դ
	// static int[][] max = new int[n][m]; // ���������
	// static int[][] allocation = new int[n][m]; // �ѷ������Դ
	// static int[][] need = new int[n][m]; // �������
	// static int[] request = new int[m]; // ������

	static int[] available = { 3, 3, 2 }; // ������Դ
	static int[][] max = { { 7, 5, 3 }, 
						   { 3, 2, 2 }, 
						   { 9, 0, 2 }, 
						   { 2, 2, 2 }, 
						   { 4, 3, 3 } }; // ���������
	static int[][] allocation = { { 0, 1, 0 }, 
							      { 2, 0, 0 },
							      { 3, 0, 2 }, 
							      { 2, 1, 1 }, 
							      { 0, 0, 2 } };; // �ѷ������Դ
	static int[][] need = { { 7, 4, 3 }, 
							{ 1, 2, 2 }, 
							{ 6, 0, 0 }, 
							{ 0, 1, 1 }, 
							{ 4, 3, 1 } };; // �������
	static int[] request = new int[m]; // ������
	
	/**
	 * ���м��㷨���õ���ά����ӷ�twoMatrixAdd����ά�������twoMatrixSub������Ƚ�compare,
	 * ��ӡ��Ϊ����printOneMa,��tools������ʵ��
	 * 
	 * @param request[]
	 *            ��������
	 * @param i
	 *            ��������,�������1,2,3
	 * @return
	 */
	 public void bankerAlgorithm(int request[], int i) {
		// ����1
		// ��ӡ��ǰ�����Ƚϵ�request��need����һЩ��Ϣ
		System.out.println("����" + i + "ִ���������м��㷨����");
		System.out.print("request:    ");
		tools.printOneMa(request);
		System.out.print("need"+i+":      ");
		tools.printOneMa(need[i]);

		if (tools.compare(request, need[i])) {
			System.out.println("request<=need");
			// ����2
			// ��ӡ��ǰ�����Ƚϵ�request��available����һЩ��Ϣ
			System.out.print("request:    ");
			tools.printOneMa(request);
			System.out.print("available:  ");
			tools.printOneMa(available);

			if (tools.compare(request, available)) {
				System.out.println("request<=available");
				// ����3
				available = tools.oneMatrixSub(available, request);
				allocation[i] = tools.oneMatrixAdd(allocation[i], request);
				need[i] = tools.oneMatrixSub(need[i], request);

				// ����4
				// ���ð�ȫ���㷨
				if (securityAlgorithm()) {
					System.out.println("�˴���Դ�����ϵͳ���ڰ�ȫ״̬���������󣬽���Դ�����" + i + "����");
					System.out.println("��ʱ��available��");
					tools.printOneMa(available);
				} else {
					System.out.println("�˴���Դ�����ϵͳ���ڲ���ȫ״̬�����������󣬴˴η������ϣ���Դ��������" + i + "����");

					available = tools.oneMatrixAdd(available, request);
					allocation[i] = tools.oneMatrixSub(allocation[i], request);
					need[i] = tools.oneMatrixAdd(need[i], request);

					System.out.println(i + "���̴��ڵȴ�״̬��");
					System.out.println("��ʱ��available��");
					tools.printOneMa(available);
				}
			} else {
				System.out.println("request>available");
				System.out.println("�����㹻��Դ������" + i + "�ȴ� (wait)");
			}
		} else {
			System.out.println("request>need");
			System.out.println("����Ҫ��Դ�����Ѿ������˽���" + i + "���������ֵ��request>need��");
		}
	}

	/**
	 * ��ȫ���㷨���жϵ�ǰ���̷����ϵͳ�Ƿ��ڰ�ȫ״̬ �����ȫ������true������false
	 * 
	 * @return ��ȫ����true
	 */
	 public  boolean securityAlgorithm() {
		// ����1
		// ��ʼ��һЩ����
		// int[] work = available; ����ĸ�ֵ�����������Ļ�����������work���и�ֵ�������ı���availabe,
		// ���¶���һ��һά���飬��available��ֵ���������Ϊ����work
		System.out.println("-----��ȫ���㷨ִ�У�-----");
		int[] work = new int[m];

		for (int i = 0; i < work.length; i++) {
			work[i] = available[i];
		}

		boolean[] finish = new boolean[n];
		for (int i = 0; i < finish.length; i++) {
			finish[i] = false;
		}
		int count = 0; // �������������ж��Ƿ�finish[n]������Boolean����true

		// ����2
		for (int i = 0; i < n; i++) {
			if (tools.compare(need[i], work) && finish[i] == false) // �ҵ�������������Ľ���i
			{
				// ����3
				System.out.print("����" + i + "�����Դ����˳��ִ�У�ֱ����ɣ����ͷ���Դ");
				work = tools.oneMatrixAdd(work, allocation[i]);
				System.out.print("	 " + "Work+Allocation:");

				tools.printOneMa(work);// ��ӡwork+allocation

//				System.out.println(); �����������������ӡ�����ݱȽϷ�ɢ
				finish[i] = true;
				// go to step2
				// ��Ϊforѭ���ڵĲ���ִ�к󣬻���i++����������Ϊ�˱�֤i��0��ʼ������i=-1,i++ = 0;
				if (i == n - 1) {
					i = -1;
				}
			}
		}
		// ����4

		for (int j = 0; j < finish.length; j++) {
			if (finish[j] == true) {
				count++;
			}
		}

		return count == n;
	}

}
