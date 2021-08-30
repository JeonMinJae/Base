package mj.project.tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main4.*

class MainActivity4 : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        viewPager_icon.adapter = ScreenSlidePagerAdapter(this)
        viewPager_icon.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        spring_dots_indicator4.setViewPager2(viewPager_icon)
    }

    override fun onBackPressed() {
        if (viewPager_icon.currentItem == 0) {
            // 사용자가 첫 번째 페이지에서 뒤로가기 버튼을 누르면 finish 하도록 하고
            super.onBackPressed()
        } else {
            // 그렇지 않으면 이전 페이지로 이동하게 한다.
            viewPager_icon.currentItem = viewPager_icon.currentItem - 1
        }
    }

    private inner class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = 3 // 페이지 수 리턴

        override fun createFragment(position: Int): Fragment {
            return when(position){ // 페이지 포지션에 따라 그에 맞는 프래그먼트를 보여줌
                0 -> Fragment41()
                1 -> Fragment42()
                else -> Fragment43()
            }
        }
    }
}