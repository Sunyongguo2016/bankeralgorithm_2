package bankeralgorithm_2;

/**
 * �����м��㷨���д���ʵ�֣�ģ��̲�113ҳ���м��
 * 
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
 * BankerAlgorithmTools ����������м��㷨�����࣬�����㷨�õ���һЩ��������
 * ���磺һά����Ӽ�������ά����Ӽ�������������ȽϺ������������ݴ�ӡ������
 * 
 */
public class BankerAlgorithmTools {
	
	//�����еķ������Ǿ�̬�ģ����Ը����ǲ���Ҫ�Ĵ�������ġ�Ϊ�˱�֤���������ɴ����������
	//���Խ����캯��˽�л���
	BankerAlgorithmTools(){}

	/**
	 * дһ��һά����������������
	 * 
	 * @param first
	 *            һά����
	 * @param second
	 *            һά����
	 * @return һά����
	 */
	 public int[] oneMatrixSub(int[] first, int[] second) {
		for (int i = 0; i < first.length; i++) {
			first[i] = first[i] - second[i];
		}
		return first;
	}
	 
	 /**
	 * дһ��һά�������ӷ�������
	 * 
	 * @param first
	 *            һά����
	 * @param second
	 *            һά����
	 * @return һά����
	 */
	 public int[] oneMatrixAdd(int[] first, int[] second) {
		for (int i = 0; i < first.length; i++) {
			first[i] = first[i] + second[i];
		}
		return first;
	}
	 
	 /**
	 * дһ����ά�������ӷ�������
	 * 
	 * @param a
	 *            ��ά����
	 * @param b
	 *            ��ά����
	 * @return ��ά����
	 */
	 public int[][] twoMatrixAdd(int[][] a, int[][] b) {
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				a[i][j] = a[i][j] + b[i][j];
			}
		}
		return a;
	}

	/**
	 * дһ����ά����������������
	 * 
	 * @param a
	 *            ��ά����
	 * @param b
	 *            ��ά����
	 * @return ��ά����
	 */
	 public int[][] twoMatrixSub(int[][] a, int[][] b) {
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				a[i][j] = a[i][j] - b[i][j];
			}
		}
		return a;
	}

	/**
	 * ����ȽϺ������ж���������ÿ����Ӧλ���ϵ����Ƿ񶼴�����һ������,�����һ��С�ڵ��ڵڶ�������true,����Ϊfalse
	 * 
	 * @param a
	 *            һά����
	 * @param b
	 *            һά����
	 * @return boolean
	 */
	 public boolean compare(int[] first, int[] second) {
		int count = 0;
		for (int i = 0; i < first.length; i++) {
			if (first[i] <= second[i]) {
				count++;
			}
		}
		
		return count == first.length;
	}

	/**
	 * ��ӡһά��������
	 * 
	 * @param temp 
	 * 				һά����
	 */
	 public void printOneMa(int[] temp) {
		for (int i = 0; i < temp.length; i++) {
			System.out.print(temp[i]);
			System.out.print("   ");
		}
		System.out.println();
	}
	
}
