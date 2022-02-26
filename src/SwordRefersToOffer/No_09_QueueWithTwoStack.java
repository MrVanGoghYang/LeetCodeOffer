package SwordRefersToOffer;
/* LeetCode.09
 * ����һ��������stack1��ɾ����stack1Ԫ��ȫ��pop��push��stack2��stack2 popջ��Ԫ�أ��ٽ�stack2Ԫ��ȫ��pop��push��stack1��
 * ����������stack1�������ã�stack2��ɾ���ã���stack2��û��Ԫ��ʱ��stack1Ԫ��ȫ��pop��push��stack2����stack2����Ԫ��ʱֱ��pop��
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
