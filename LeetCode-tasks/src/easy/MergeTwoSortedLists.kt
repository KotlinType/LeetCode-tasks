package easy

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    return recursive(list1, list2)
}

private fun recursive(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 == null) return list2
    if (list2 == null) return list1
    if (list1.`val` <= list2.`val`) {
        list1.next = recursive(list1.next, list2)
        return list1
    }
    list2.next = recursive(list1, list2.next)
    return list2
}

private fun loop(list1: ListNode?, list2: ListNode?): ListNode? {
    var head1: ListNode? = list1 ?: return list2
    var head2: ListNode? = list2 ?: return list1
    var mergedListHead: ListNode? = null
    var tmp: ListNode? = null

    fun put(v: Int) {
        val node = ListNode(v)
        if (mergedListHead == null) mergedListHead = node
        tmp?.next = node
        tmp = node
    }

    while (head1 != null) {
        while (head2 != null && head2.`val` <= head1.`val`) {
            put(head2.`val`)
            head2 = head2.next
        }
        put(head1.`val`)
        head1 = head1.next
    }

    if (head2 != null) tmp?.next = head2

    return mergedListHead
}