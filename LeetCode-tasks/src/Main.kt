import easy.ListNode
import easy.mergeTwoLists

fun main() {
    val list1 = ListNode(1)
    val list2 = ListNode(2)
    var s = mergeTwoLists(list1 = list1, list2 = list2)
    while (s != null) {
        println(s.`val`)
        s = s.next
    }
}
