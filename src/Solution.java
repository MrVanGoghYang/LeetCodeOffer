
import java.util.*;

public class Solution
{
    class Node
    {
        String val;
        List<Node> children;
        int depth;
        Node() {};
        Node(String val)
        {
            this.val = val;
            this.children = new ArrayList<>();
        };
        Node(String val, List<Node> children)
        {
            this.val = val;
            this.children = children;
        };

    }

    public Node findDeepestAncestor(Node root, Node p, Node q)
    {
        if(root == null || root.val == p.val || root.val == q.val)
            return root;
        Node[] resArr = new Node[2];

        int index = 0;
        for(Node child : root.children)
        {
            Node subRes = findDeepestAncestor(child, p, q);
            if(subRes != null)
                resArr[index++] = subRes;
            if(index == 2)
                break;
        }
        if(index == 0)
        {
            return null;
        }
        else if(index == 1)
        {
            return resArr[0];
        }
        else
        {
            return root;
        }
    }


    HashMap<String, Node> map = new HashMap<>();
    int findCnt = 0;

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        Node aa = solution.new Node("aa");
        Node bb = solution.new Node("bb");
        Node cc = solution.new Node("cc");
        Node ddd = solution.new Node("ddd");
        Node ee = solution.new Node("ee");
        Node ff = solution.new Node("ff");
        Node gg = solution.new Node("gg");
        Node hh = solution.new Node("hh");
        Node iii = solution.new Node("iii");
        Node j = solution.new Node("j");
        Node kk = solution.new Node("kk");
        Node ll = solution.new Node("ll");
        Node mm = solution.new Node("mm");

        j.children.add(kk);
        j.children.add(ll);
        j.children.add(mm);

        ddd.children.add(j);

        bb.children.add(ee);
        bb.children.add(ff);
        bb.children.add(gg);

        cc.children.add(hh);
        cc.children.add(iii);

        aa.children.add(bb);
        aa.children.add(cc);
        aa.children.add(ddd);

        System.out.println(solution.findDeepestAncestor(aa, ee, kk).val);
    }

    public Node findDeepestAncestor2(Node root, Node p, Node q)
    {
        if(root == null || root.val == p.val || root.val == q.val)
            return root;
        map.put(root.val, null);
        dfs(root, p, q);
        Set<String> visited = new HashSet<>();
        while(p != null)
        {
            visited.add(p.val);
            p = map.get(p.val);
        }

        while(q != null)
        {
            if(visited.contains(q.val))
                return q;
            q = map.get(q.val);
        }
        return q;
    }


    public void dfs(Node root, Node p, Node q)
    {
        if(root == null)
            return;
        for(Node child : root.children)
        {
            map.put(child.val, root);
            if(child.val == p.val || child.val == q.val)
                findCnt++;
            if(findCnt == 2)
                return;
            dfs(child, p, q);
        }
    }


}
