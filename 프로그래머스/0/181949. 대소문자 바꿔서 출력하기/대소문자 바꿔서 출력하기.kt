fun main(args: Array<String>) {
    val s1 = readLine()!!
    val toString = s1.toCharArray().map { word -> if (word.isUpperCase()) word.lowercase() else word.uppercase() }
        .joinToString("")
    println(toString)
}