//http://tinyurl.com/leetcode063
package leetcode.stack

import java.util.*

fun main() {
    for (path in listOf("/a/./b/../../c/","/home/", "/../", "/home//foo/")) {
        println(simplifyPath(path))
    }

}



fun simplifyPath(path: String): String {
    return Stack<String>().apply {
        for( str in path.split('/')) {
            if(str == ".." && isNotEmpty()) pop()
            else if (str.isNotBlank() && str != "." && str !="..") push(str)
        }
    }.joinToString("/","/")
}

