package mj.project.tablayout

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyPagerAdapter3(fa: FragmentActivity): FragmentStateAdapter(fa) {
    private val NUM_PAGES = 3

    override fun getItemCount(): Int = NUM_PAGES

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> { Fragment31.newInstance("Page 1","")}
            1 -> { Fragment31.newInstance("Page 2","")}
            else -> { Fragment31.newInstance("Page 3","")}
        }
    }
}