package ProblemsType;

// LeetCode-526
public class Dfs_Arrangement {
	private int count = 0;
	private int[] numArr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dfs_Arrangement solution = new Dfs_Arrangement();
		System.out.println(solution.countArrangement(4));

	}

	public int countArrangement(int n) {
		numArr = new int[n];
		for (int i = 0; i < n; i++) {
			numArr[i] = i + 1;
		}
		dfs(1, n);
		return count;
	}

	public void dfs(int nNum, int input) {
		int i = 1;
		if (nNum > input) {
			count++;
			return;
		}
		for (i = 0; i < input; i++) {
			if (numArr[i] != -1 && ((i + 1) % nNum == 0 || nNum % (i + 1) == 0)) {
				numArr[i] = -1;
				dfs(nNum + 1, input);
				numArr[i] = i + 1;
			}
		}
	}

}
