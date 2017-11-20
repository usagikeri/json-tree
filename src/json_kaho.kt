/**
 * Created by shinya on 2017/11/16.
 */

package ohkura

import com.google.gson.Gson
import com.google.gson.JsonArray

class Child(url: String, mine: String, source: String)  {

    var url = ""
    var mime = ""
    var source = ""
    val children: MutableList<Child> = mutableListOf()

    init{
    this.set_data(url,mine,source)
    }

    companion object {
        var parentList: MutableList<String> = mutableListOf()
    }

    fun add_child(child:Child): Child{
        this.children.add(child)
        return child
    }

    fun add_child(url:String ,mime:String ,source:String ):Child{
        var child = Child(url, mime, source)
        this.children.add(child)
        return child
    }

    fun set_data(url:String,mime:String,source:String){
        this.url = url
        this.mime = mime;
        this.source = source;
    }

    fun add_list(c:Child){
        parentList.add(c.url)
    }

    fun tree_print(){
        println(this.url)
        println(this.mime)
        println(this.source)

        for (i in this.children) {
            println("   ${i.url}")
            println("   ${i.mime}")
            println("   ${i.source}")
        }

    }

    fun json_tree():String{
       val g = Gson()

        return g.toJson(this)
    }
}

fun main(args: Array<String>){
    var c1 = Child("Parent_url","Parent_mime","Parent_source")
    var c2 = c1.add_child("Child_url","Child_mime","Child_source")

    c2.add_child("GChild_url","GChild_mime","GChild_source")

    println(c1.json_tree())
}
