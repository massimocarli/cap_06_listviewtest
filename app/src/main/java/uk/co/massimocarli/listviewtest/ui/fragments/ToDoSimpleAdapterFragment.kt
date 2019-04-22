package uk.co.massimocarli.listviewtest.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SimpleAdapter
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_simple_listview.view.*
import uk.co.massimocarli.listviewtest.R
import uk.co.massimocarli.listviewtest.model.SIMPLE_MODEL

/**
 * Example of a Fragment with a simple ListView
 */
class ToDoSimpleAdapterFragment : Fragment() {

  companion object {
    val FROM = arrayOf("name", "description", "completed")
    val TO = intArrayOf(R.id.todoName, R.id.todoDescription, R.id.action_image)
  }


  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val view = inflater.inflate(
      R.layout.fragment_simple_listview,
      container,
      false
    )
    val adapter = SimpleAdapter(
      context,
      SIMPLE_MODEL,
      R.layout.todo_list_item,
      FROM,
      TO
    )
    view.listView.adapter = adapter
    return view
  }
}
