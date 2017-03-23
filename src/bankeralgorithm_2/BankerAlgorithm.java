package bankeralgorithm_2;

/**
 * 银行家算法
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
 * 银行家算法，包含银行家算法，和银行家算法中的安全性算法
 * 
 *
 */
public class BankerAlgorithm {
	BankerAlgorithm(){}
	BankerAlgorithmTools tools = new BankerAlgorithmTools();
	
	// 进程数5，资源3类，模拟教材113页
	static final int n = 5; // 进程数
	static final int m = 3; // 资源类数目

	// static int[] available = new int[m]; // 可用资源
	// static int[][] max = new int[n][m]; // 最大需求量
	// static int[][] allocation = new int[n][m]; // 已分配的资源
	// static int[][] need = new int[n][m]; // 需求矩阵
	// static int[] request = new int[m]; // 请求量

	static int[] available = { 3, 3, 2 }; // 可用资源
	static int[][] max = { { 7, 5, 3 }, 
						   { 3, 2, 2 }, 
						   { 9, 0, 2 }, 
						   { 2, 2, 2 }, 
						   { 4, 3, 3 } }; // 最大需求量
	static int[][] allocation = { { 0, 1, 0 }, 
							      { 2, 0, 0 },
							      { 3, 0, 2 }, 
							      { 2, 1, 1 }, 
							      { 0, 0, 2 } };; // 已分配的资源
	static int[][] need = { { 7, 4, 3 }, 
							{ 1, 2, 2 }, 
							{ 6, 0, 0 }, 
							{ 0, 1, 1 }, 
							{ 4, 3, 1 } };; // 需求矩阵
	static int[] request = new int[m]; // 请求量
	
	/**
	 * 银行家算法，用到二维矩阵加法twoMatrixAdd，二维矩阵减法twoMatrixSub，矩阵比较compare,
	 * 打印以为数组printOneMa,在tools类中已实现
	 * 
	 * @param request[]
	 *            请求向量
	 * @param i
	 *            进程名称,例如进程1,2,3
	 * @return
	 */
	 public void bankerAlgorithm(int request[], int i) {
		// 步骤1
		// 打印当前即将比较的request，need，的一些信息
		System.out.println("进程" + i + "执行请求：银行家算法运行");
		System.out.print("request:    ");
		tools.printOneMa(request);
		System.out.print("need"+i+":      ");
		tools.printOneMa(need[i]);

		if (tools.compare(request, need[i])) {
			System.out.println("request<=need");
			// 步骤2
			// 打印当前即将比较的request，available，的一些信息
			System.out.print("request:    ");
			tools.printOneMa(request);
			System.out.print("available:  ");
			tools.printOneMa(available);

			if (tools.compare(request, available)) {
				System.out.println("request<=available");
				// 步骤3
				available = tools.oneMatrixSub(available, request);
				allocation[i] = tools.oneMatrixAdd(allocation[i], request);
				need[i] = tools.oneMatrixSub(need[i], request);

				// 步骤4
				// 调用安全性算法
				if (securityAlgorithm()) {
					System.out.println("此次资源分配后，系统处于安全状态，允许请求，将资源分配给" + i + "进程");
					System.out.println("此时的available：");
					tools.printOneMa(available);
				} else {
					System.out.println("此次资源分配后，系统处于不安全状态，不允许请求，此次分配作废，资源不会分配给" + i + "进程");

					available = tools.oneMatrixAdd(available, request);
					allocation[i] = tools.oneMatrixSub(allocation[i], request);
					need[i] = tools.oneMatrixAdd(need[i], request);

					System.out.println(i + "进程处于等待状态！");
					System.out.println("此时的available：");
					tools.printOneMa(available);
				}
			} else {
				System.out.println("request>available");
				System.out.println("尚无足够资源，进程" + i + "等待 (wait)");
			}
		} else {
			System.out.println("request>need");
			System.out.println("所需要资源数，已经超出了进程" + i + "宣布的最大值（request>need）");
		}
	}

	/**
	 * 安全性算法，判断当前进程分配后系统是否处于安全状态 如果安全，返回true，否则false
	 * 
	 * @return 安全返回true
	 */
	 public  boolean securityAlgorithm() {
		// 步骤1
		// 初始化一些变量
		// int[] work = available; 错误的赋值方法，这样的话，下面程序对work进行赋值操作，改变了availabe,
		// 重新定义一个一维数组，将available的值赋给这个以为数组work
		System.out.println("-----安全性算法执行：-----");
		int[] work = new int[m];

		for (int i = 0; i < work.length; i++) {
			work[i] = available[i];
		}

		boolean[] finish = new boolean[n];
		for (int i = 0; i < finish.length; i++) {
			finish[i] = false;
		}
		int count = 0; // 计数器，用于判断是否finish[n]里所有Boolean都是true

		// 步骤2
		for (int i = 0; i < n; i++) {
			if (tools.compare(need[i], work) && finish[i] == false) // 找到满足这个条件的进程i
			{
				// 步骤3
				System.out.print("进程" + i + "获得资源，可顺利执行，直至完成，并释放资源");
				work = tools.oneMatrixAdd(work, allocation[i]);
				System.out.print("	 " + "Work+Allocation:");

				tools.printOneMa(work);// 打印work+allocation

//				System.out.println(); 加了这行整个程序打印的数据比较分散
				finish[i] = true;
				// go to step2
				// 因为for循环内的部分执行后，会有i++操作，所以为了保证i从0开始，设置i=-1,i++ = 0;
				if (i == n - 1) {
					i = -1;
				}
			}
		}
		// 步骤4

		for (int j = 0; j < finish.length; j++) {
			if (finish[j] == true) {
				count++;
			}
		}

		return count == n;
	}

}
