package DS.LinkedList;

/*
Palindrome Linked List

Given the head of a singly linked list, return true if it is a palindrome.


Example 1:
Input: head = [1,2,2,1]
Output: true

Example 2:
Input: head = [1,2]
Output: false

Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9

Follow up: Could you do it in O(n) time and O(1) space?

*/

public class PalindromeLinkedList {
    public ListNode head = null;
    public ListNode current = null;

    public void acceptInput(int num, int index){
       if(null == head){
           head = new ListNode(num);
           current = head;
       }else {
           ListNode tmp = new ListNode(num);
           current.next = tmp;
           current = tmp;
       }
    }

    public boolean isPalindrome() {
        if(head == null || head.next == null) return true;
        ListNode middle = findMiddle(head);
        ListNode nextMiddle = reverse(middle.next);
        middle.next = null;
        while(head != null && nextMiddle != null){
            if(head.val != nextMiddle.val){
                return false;
            }
            head = head.next;
            nextMiddle = nextMiddle.next;
        }

        return true;
    }

    public static ListNode findMiddle(ListNode head){
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static ListNode reverse(ListNode head){
        ListNode prev = null, curr = head, next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
