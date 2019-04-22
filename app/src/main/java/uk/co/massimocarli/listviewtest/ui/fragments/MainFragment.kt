package uk.co.massimocarli.listviewtest.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_main.view.*
import uk.co.massimocarli.listviewtest.R
import uk.co.massimocarli.listviewtest.ui.OPTIONS
import uk.co.massimocarli.listviewtest.ui.navigation.Navigation

class MainFragment : Fragment() {

  private lateinit var navigation: Navigation

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val view = inflater.inflate(R.layout.fragment_main, container, false)
    val optionAdapter = ArrayAdapter<String>(
      context,
      android.R.layout.simple_list_item_1,
      OPTIONS.map { it.first }
    )
    view.mainListView.apply {
      adapter = optionAdapter
      onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
        navigation.replaceFragment(OPTIONS[position].second, OPTIONS[position].first)
      }
    }
    return view
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    val activityAsNavigation = activity as? Navigation
    if (activityAsNavigation != null) {
      navigation = activityAsNavigation
    } else {
      throw IllegalStateException("Navigation Needed!")
    }
  }
}
