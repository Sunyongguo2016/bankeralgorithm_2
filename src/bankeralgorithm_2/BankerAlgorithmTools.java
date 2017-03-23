package bankeralgorithm_2;

/**
 * 对银行家算法进行代码实现，模拟教材113页进行检测
 * 
 * 班级：软件4班
 * 学号：2014011725 
 * 姓名：孙永国 
 * 完成时间：2016-4-15
 * 
 * @author dell-sun
 * @version 1.1.1
 * 
 */
/**
 * BankerAlgorithmTools 这个类是银行家算法工具类，包括算法用到的一些基础函数
 * 例如：一维数组加减法，二维数组加减法函数，矩阵比较函数，矩阵内容打印函数；
 * 
 */
public class BankerAlgorithmTools {
	
	//该类中的方法都是静态的，所以该类是不需要的创建对象的。为了保证不让其他成创建该类对象
	//可以将构造函数私有化。
	BankerAlgorithmTools(){}

	/**
	 * 写一个一维数组矩阵减法函数；
	 * 
	 * @param first
	 *            一维数组
	 * @param second
	 *            一维数组
	 * @return 一维数组
	 */
	 public int[] oneMatrixSub(int[] first, int[] second) {
		for (int i = 0; i < first.length; i++) {
			first[i] = first[i] - second[i];
		}
		return first;
	}
	 
	 /**
	 * 写一个一维数组矩阵加法函数；
	 * 
	 * @param first
	 *            一维数组
	 * @param second
	 *            一维数组
	 * @return 一维数组
	 */
	 public int[] oneMatrixAdd(int[] first, int[] second) {
		for (int i = 0; i < first.length; i++) {
			first[i] = first[i] + second[i];
		}
		return first;
	}
	 
	 /**
	 * 写一个二维数组矩阵加法函数；
	 * 
	 * @param a
	 *            二维数组
	 * @param b
	 *            二维数组
	 * @return 二维数组
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
	 * 写一个二维数组矩阵减法函数；
	 * 
	 * @param a
	 *            二维数组
	 * @param b
	 *            二维数组
	 * @return 二维数组
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
	 * 矩阵比较函数，判断两个矩阵每个相应位置上的数是否都大于另一个矩阵,如果第一个小于等于第二个返回true,否则为false
	 * 
	 * @param a
	 *            一维数组
	 * @param b
	 *            一维数组
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
	 * 打印一维数组内容
	 * 
	 * @param temp 
	 * 				一维数组
	 */
	 public void printOneMa(int[] temp) {
		for (int i = 0; i < temp.length; i++) {
			System.out.print(temp[i]);
			System.out.print("   ");
		}
		System.out.println();
	}
	
}
