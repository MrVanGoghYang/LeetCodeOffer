package ProblemsType;

// LeetCode.841
// ����Ŀ��������Ѿ��ı�����������Զ�γ��Բ�ͬ������ֻҪ�ܽ������з��伴�ɣ� 
// DFS��һ����Ҫ�õ�ջ��ֱ�Ӷ����DFS�������й���ģ�⼴�ɣ�
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
		// �ȳ��Խ���÷��䣬�޸�flag
		if (!flag.contains(roomNo)) {
			flag.add(roomNo);
		} else {
			return false;
		}
		// �ɹ��˳�����Ϊ�����ŵı�Ŷ�������flag��
		if (flag.size() == roomInfo.size())
			return true;
		// �Ը÷����������Կ�׳��Խ���Կ�׵ķ���
		for (int i = 0; i < roomInfo.get(roomNo).size(); i++) {
			// �����һ��Կ�׽�����һ����������ܽ��������з�����ɹ��˳�
			if (dfs(roomInfo.get(roomNo).get(i)))
				return true;
		}
		// ע���˴��������������������Ҫ���ݵ����������BFS����������Ҫ��� flag.remove(roomNo)��
		// ����Կ�׶����Թ�����޷��������з��䷵��false
		return false;
	}
}
