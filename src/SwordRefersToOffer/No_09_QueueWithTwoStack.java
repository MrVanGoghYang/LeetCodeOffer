package SwordRefersToOffer;
/* LeetCode.09
 * 方法一：插入用stack1，删除将stack1元素全部pop后push入stack2，stack2 pop栈顶元素，再将stack2元素全部pop后push入stack1；
 * 方法二：用stack1作插入用，stack2作删除用，当stack2中没有元素时将stack1元素全部pop后push入stack2；当stack2中有元素时直接pop；
 */
import java.util.Stack;

public class No_09_QueueWithTwoStack
{
	private Stack<Integer> stack1;
	private Stack<Integer> stack2;
	private int length;

	public No_09_QueueWithTwoStack() {
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
		length = 0;
    }
    
    public void appendTail(int value) {
    	stack1.push(value);
    	length++;
    }
    
    public int deleteHead() {
    	Object deleteEle;
    	Object item;
    	if(length == 0)		return -1;
    	for(int i = 0;i < length - 1;i++)
    	{
    		item = stack1.pop();
    		stack2.push((Integer) item);
    	}
    	deleteEle = stack1.pop();
    	for(int i = 0;i < length - 1;i++)
    	{
    		item = stack2.pop();
    		stack1.push((Integer) item);
    	}
    	length--;
    	return (int)deleteEle;
    }
}
