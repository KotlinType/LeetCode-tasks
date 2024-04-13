package easy

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 *
 * Example:
 * Input: strs = ["flower","flow","flight"]
 *
 * Output: "fl"
 */
fun longestCommonPrefix(strs: Array<String>): String {
    var prefix = ""
    strs[0].forEachIndexed { index, value ->
        for (i in 1..<strs.size) {
            if (strs[i].length == index || strs[i][index] != value) return prefix
        }
        prefix += value
    }
    return prefix
}
