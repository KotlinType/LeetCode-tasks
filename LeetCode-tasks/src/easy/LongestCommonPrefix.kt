package easy

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
