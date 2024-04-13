package easy

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 *
 * 1) Open brackets must be closed by the same type of brackets.
 * 2) Open brackets must be closed in the correct order.
 * 3) Every close bracket has a corresponding open bracket of the same type.
 */
fun isValid(s: String): Boolean {
    val isRecursive = false
    return if (isRecursive) recursive(s) else loop(s)
}

private fun recursive(s: String): Boolean {
    if (s == "") { return true }
    val simplified = s.replace("()", "").replace("{}", "").replace("[]", "")
    if (simplified == s) { return false }
    return recursive(simplified)
}

private fun loop(s: String): Boolean {
    val stack = arrayListOf<Char>()
    s.forEach {
        when (it) {
            '(','[','{' -> stack.add(it)
            ')' -> if (stack.isEmpty() || stack.removeLast() != '(') return false
            ']' -> if (stack.isEmpty() || stack.removeLast() != '[') return false
            '}' -> if (stack.isEmpty() || stack.removeLast() != '{') return false
        }
    }
    return stack.isEmpty()
}