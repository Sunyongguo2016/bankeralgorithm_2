package bankeralgorithm_2;

/**
 * 对银行家算法进行代码实现，模拟教材113页进行检测
 * 班级：软件4班
 * 学号：2014011725 
 * 姓名：孙永国 
 * 完成时间：2016-4-150
 * 
 * @author dell-sun
 * @version 1.1.1
 * 
 */

public class BankerAlgorithmDemo {
	static final int m = 3; // 资源类数目
	static int[] request = new int[m]; // 请求量
	
	// 主函数 main函数
	public static void main(String[] args) {
		
		BankerAlgorithmTools tools = new BankerAlgorithmTools();
		BankerAlgorithm bankeralgorithm = new BankerAlgorithm();
		
		// (1)判断t0时刻的安全性	 p113
		System.out.println("判断t0时刻的安全性：");
		if (bankeralgorithm.securityAlgorithm()) {
			System.out.println("t0时刻是安全的");
		} else {
			System.out.println("t0时刻是不安全的");
		}

		// (2)p1请求资源	request(1,0,2)	p114
		System.out.println("/*************************************************************/");
		request[0] = 1;
		request[1] = 0;
		request[2] = 2;
		bankeralgorithm.bankerAlgorithm(request, 1);

		// (3)p4请求资源	request(3,3,0)	p114
		System.out.println("/*************************************************************/");
		request[0] = 3;
		request[1] = 3;
		request[2] = 0;
		bankeralgorithm.bankerAlgorithm(request, 4);

		// (4)p0  request(0,2,0) 请求资源		p114
		System.out.println("/***************************7**********************************/");
		request[0] = 0;
		request[1] = 2;
		request[2] = 0;
		bankeralgorithm.bankerAlgorithm(request, 0);

		// p0  request(0,1,0)  请求资源		p114
		System.out.println("/*************************************************************/");
		System.out.println("如果银行家算法中吧p0发出的向量请求改为request(0,1,0)");
		request[0] = 0;
		request[1] = 1;
		request[2] = 0;
		bankeralgorithm.bankerAlgorithm(request, 0);
	}

}
