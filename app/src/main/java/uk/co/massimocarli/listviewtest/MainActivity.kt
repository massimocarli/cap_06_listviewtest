package uk.co.massimocarli.listviewtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import uk.co.massimocarli.listviewtest.ui.fragments.MainFragment
import uk.co.massimocarli.listviewtest.ui.navigation.Navigation

class MainActivity : AppCompatActivity(), Navigation {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    if (savedInstanceState == null) {
      replaceFragment(MainFragment())
    }
  }

  override fun replaceFragment(
    fragment: Fragment,
    backStackName: String?,
    tag: String?
  ) {
    supportFragmentManager.beginTransaction().apply {
      replace(R.id.anchor, fragment)
      backStackName?.let {
        addToBackStack(it)
      }
      commit()
    }
  }

  override fun back() {
    supportFragmentManager.popBackStack()
  }
}
