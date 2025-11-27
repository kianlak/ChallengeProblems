package data_structure;

public class ListNode {
  public int val;
  public ListNode next;

  public ListNode() {}

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  @Override
  public String toString() {
    return toString(this);
  }

  public static String toString(ListNode head) {
    if (head == null) return "[]";

    StringBuilder stringBuilder = new StringBuilder("[");
    ListNode curr = head;

    while (curr != null) {
      stringBuilder.append(curr.val);
      curr = curr.next;
      if (curr != null) stringBuilder.append(", ");
    }
    
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}