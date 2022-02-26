package ProblemsType;

// LeetCode.841
// 该题目无需回溯已经改变的条件，可以多次尝试不同方案，只要能进入所有房间即可； 
// DFS不一定需要用到栈，直接定义好DFS函数进行过程模拟即可；
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;


public class Dfs_KeyAndRoom {
	private HashSet<Integer> flag = new HashSet<Integer>();
	private List<List<Integer>> roomInfo;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> room1 = new LinkedList<Integer>();
		room1.add(2);
		room1.add(3);
		List<Integer> room2 = new LinkedList<Integer>();
		List<Integer> room3 = new LinkedList<Integer>();
		room3.add(2);
		List<Integer> room4 = new LinkedList<Integer>();
		room4.add(1);
		room4.add(3);
		room4.add(1);
		List<List<Integer>> rooms = new LinkedList<List<Integer>>();
		rooms.add(room1);
		rooms.add(room2);
		rooms.add(room3);
		rooms.add(room4);

		Dfs_KeyAndRoom solution = new Dfs_KeyAndRoom();
		System.out.println(solution.canVisitAllRooms(rooms));

	}

	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		roomInfo = rooms;
		return dfs(0);
	}

	public boolean dfs(int roomNo) {
		// 先尝试进入该房间，修改flag
		if (!flag.contains(roomNo)) {
			flag.add(roomNo);
		} else {
			return false;
		}
		// 成功退出条件为所有门的编号都加入了flag中
		if (flag.size() == roomInfo.size())
			return true;
		// 对该房间里的所有钥匙尝试进入钥匙的房间
		for (int i = 0; i < roomInfo.get(roomNo).size(); i++) {
			// 如果拿一把钥匙进入下一个房间后发现能进入了所有房间则成功退出
			if (dfs(roomInfo.get(roomNo).get(i)))
				return true;
		}
		// 注：此处无需回溯条件，若有需要回溯的情况比如是BFS遍历，则需要添加 flag.remove(roomNo)；
		// 所有钥匙都尝试过后均无法进入所有房间返回false
		return false;
	}
}
