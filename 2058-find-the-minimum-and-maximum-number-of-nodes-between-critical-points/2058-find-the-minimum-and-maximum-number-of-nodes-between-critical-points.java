/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        if(head.next.next == null){
            return new int[]{-1, -1};
        }

        int []ans = new int[2];
        List<Integer>local = new ArrayList<>();

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode forw = curr.next;


        int cnt = 2;
        while(forw != null){
            if(prev.val < curr.val && curr.val > forw.val){
                local.add(cnt);
            }
            else if(prev.val > curr.val && curr.val < forw.val){
                local.add(cnt);
            }
            cnt++;
            prev = curr;
            curr = forw;
            forw = forw.next;
        }

        // int firstMin = Integer.MAX_VALUE;
        // int secondMin = Integer.MAX_VALUE;
        // int max = Integer.MIN_VALUE;

        // for(int i = 0; i < local.size(); i++){
        //     if(firstMin > local.get(i)){
        //         secondMin = firstMin;
        //         firstMin = local.get(i);
        //     }
        //     else if(secondMin > local.get(i)){
        //         secondMin = local.get(i);
        //     }
        //     else if(max < local.get(i)){
        //         max = local.get(i);
        //     }
        // } 

        if(local.size() < 2){
            return new int[]{-1, -1};
        }

        if(local.size() == 2){
            int a = local.get(1)-local.get(0);
            int b = a;
            return new int[]{a, b};
        }

        Collections.sort(local);

        int min = Integer.MAX_VALUE;
        int max = local.get(local.size()-1) - local.get(0);

        for(int i = 1; i < local.size(); i++){
            min = Math.min(min, local.get(i)-local.get(i-1));
        }

        return new int[]{min, max};

    }
}