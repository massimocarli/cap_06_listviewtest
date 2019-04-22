package uk.co.massimocarli.listviewtest.ui

import uk.co.massimocarli.listviewtest.ui.fragments.*

val OPTIONS = arrayOf(
  "Simple List" to SimpleListViewFragment(),
  "Simple ToDo layout" to SimpleToDoListViewFragment(),
  "Simple custom ToDo layout" to ToDoListViewFragment(),
  "Simple custom ToDo layout with Holder" to HolderToDoListViewFragment(),
  "Simple Adapter ToDo" to ToDoSimpleAdapterFragment(),
  "Simple Adapter ToDo With ViewBinder" to ToDoSimpleAdapterBinderFragment(),
  "Multiple item types" to MultipleHolderToDoListViewFragment()


)