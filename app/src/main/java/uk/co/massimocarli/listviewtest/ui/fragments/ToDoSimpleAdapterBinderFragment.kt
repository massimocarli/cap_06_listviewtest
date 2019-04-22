package uk.co.massimocarli.listviewtest.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SimpleAdapter
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_simple_listview.view.*
import uk.co.massimocarli.listviewtest.R
import uk.co.massimocarli.listviewtest.model.SIMPLE_MODEL
import uk.co.massimocarli.listviewtest.model.ToDo

/**
 * Example of a Fragment with a simple ListView
 */
class ToDoSimpleAdapterBinderFragment : Fragment() {

  companion object {
    val FROM = arrayOf("name", "description", "completed")
    val TO = intArrayOf(R.id.todoName, R.id.todoDescription, R.id.taskDoneImage)
  }


  val toDoViewBinder = object : SimpleAdapter.ViewBinder {
    override fun setViewValue(
      view: View?,
      data: Any?,
      textRepresentation: String?
    ): Boolean {
      if (view?.id == R.id.taskDoneImage) {
        if (view is ImageView) {
          view.setImageResource(
            if ("true" == textRepresentation)
              R.drawable.ic_check_black_24dp
            else R.drawable.ic_crop_square_black_24dp
          )
          return true
        }
      }
      return false
    }
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
    ).apply {
      viewBinder = toDoViewBinder
    }
    view.listView.adapter = adapter
    return view
  }
}
