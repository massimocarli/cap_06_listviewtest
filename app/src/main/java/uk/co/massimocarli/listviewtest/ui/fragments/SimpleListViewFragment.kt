package uk.co.massimocarli.listviewtest.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_simple_listview.view.*
import uk.co.massimocarli.listviewtest.R
import uk.co.massimocarli.listviewtest.model.MODEL
import uk.co.massimocarli.listviewtest.model.ToDo

/**
 * Example of a Fragment with a simple ListView
 */
class SimpleListViewFragment : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val view = inflater.inflate(
      R.layout.fragment_simple_listview,
      container,
      false
    )
    val arrayAdapter = ArrayAdapter<ToDo>(
      context,
      android.R.layout.simple_list_item_1,
      MODEL
    )
    view.listView.adapter = arrayAdapter
    return view
  }
}
