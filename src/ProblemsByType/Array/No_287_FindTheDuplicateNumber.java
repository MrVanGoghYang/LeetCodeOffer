package ProblemsByType.Array;

public class No_287_FindTheDuplicateNumber
{
    // ����ؼ�������Ԫ�صķ�ΧҲ�����鳤���ڼ�[1, n]�ڣ��ɴ˿��Խ�����Ԫ�ص����±��ҵ���һ������Ԫ�أ���nums[1] = nums[nums[0]]
    // ˳��˼·�ߣ���nums[0]��ʼ-> nums[nums[0]]...���������ߣ���������а����ظ�Ԫ�أ���ôһ���ᵽ��֮ǰ�������±괦���������˻���ѭ���ˣ������������ھ����ظ�Ԫ�أ�ת��Ϊ�Ҵ����������ڣ�����ָ�롣
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}
