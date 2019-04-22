package uk.co.massimocarli.listviewtest.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_simple_listview.view.*
import kotlinx.android.synthetic.main.todo_list_item.view.*
import uk.co.massimocarli.listviewtest.R
import uk.co.massimocarli.listviewtest.model.MODEL

/**
 * Example of a Fragment with a simple ListView
 */
class ToDoListViewFragment : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val view = inflater.inflate(
      R.layout.fragment_simple_listview,
      container,
      false
    )
    view.listView.adapter = SimpleToDoListViewFragment()
    return view
  }


  inner class SimpleToDoListViewFragment : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
      val newView: View
      if (convertView == null) {
        newView = LayoutInflater.from(context)
          .inflate(R.layout.todo_list_item, null)
      } else {
        newView = convertView
      }
      // Current item
      val item = MODEL[position]
      // We get the UI items (obsolete with ktx)
      val taskDoneImage = newView.taskDoneImage
      val todoName = newView.todoName
      val todoDescription = newView.todoDescription
      // UI logic
      taskDoneImage.setImageResource(
        if (item.completed) R.drawable.ic_check_black_24dp else R.drawable.ic_crop_square_black_24dp
      )
      todoName.text = item.name
      todoDescription.text = item.description
      // Return the item
      return newView
    }

    override fun getItem(position: Int): Any =
      MODEL[position]

    override fun getItemId(position: Int): Long =
      MODEL[position].id.toLong()

    override fun getCount(): Int =
      MODEL.size
  }
}
