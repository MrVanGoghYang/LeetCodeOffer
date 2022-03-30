package ProblemsByType.Array;

public class No_169_MajorityElement
{
    /*
    ˼·��Ħ��ͶƱ����ά��һ��candidate��һ��count����ʼʱcandidateΪ���⣬countΪ0������ɨ������Ԫ�أ���count = 0 ʱ����ѡ�ٸ���candidate������ɨ�赽��ͬcandidate��count++��ɨ�赽��ͬcandidate��count--������candidate��Ϊ������
    ԭ����candidate��������ʱ����ô���⵽�����ķ��Ե���count < 0��̨���죻
         ��candidate������ʱ�����⵽�������ķ��ԣ����Ǽ�ʹcount�����Լ�Ϊ0����ô����Ҳ��ͬ���ھ����ķ�����������������ĵ����з���������󻹻�ʣ��һЩ����ֱ�ӵ�ѡ��
     */
    public int majorityElement(int[] nums) {
        // Ħ��ͶƱ��
        if(nums.length == 1)
            return nums[0];
        int candidate = nums[0];
        int count = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(count == 0)
                candidate = nums[i];
            if(nums[i] == candidate)
                count++;
            else
                count--;
        }
        return candidate;
    }
}
