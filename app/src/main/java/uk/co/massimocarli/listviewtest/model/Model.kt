package uk.co.massimocarli.listviewtest.model

import java.util.*

/**
 * ToDo Entity
 */
data class ToDo(
  val id: Int,
  val name: String,
  val description: String?,
  val dueDate: Date,
  var completed: Boolean = false
)

val MODEL = Array<ToDo>(100) {
  ToDo(it, "Task #$it", "This is the task #$it", Date(), it % 2 == 0)
}

val SIMPLE_MODEL = MODEL.fold(mutableListOf<Map<String, Any?>>()) { acc, item ->
  acc.add(mutableMapOf<String, Any?>().apply {
    with(item) {
      put("id", id)
      put("name", name)
      put("description", description)
      put("dueDate", dueDate)
      put("completed", completed)
    }
  })
  acc
}


fun main() {
  println(SIMPLE_MODEL)
}