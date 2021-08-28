package mj.project.tablayout

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {

    /*만약 텍스트 옆에 이미지 추가하고 싶을때 사용
val tabIconList = arrayListOf(R.drawable.아이콘이름, R.drawable.아이콘이름) // 이미지를 리스트로 선언하고
tab.setIcon(tabIconList[position]) // TabLayoutMediator{} 안에 이걸 넣어주세요*/

    private lateinit var viewPager: ViewPager2
    val tabTextList = arrayListOf("여행지", "내 티켓") // 메뉴에 들어갈 이름 (순서대로)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        viewPager_icon2.adapter = ScreenSlidePagerAdapter(this)
        viewPager_icon2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        // 뷰페이저와 탭레이아웃을 붙임
        TabLayoutMediator(tabLayout2, viewPager_icon2) { tab, position ->
            tab.text = tabTextList[position]
        }.attach()
    }

    private inner class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = 2

        override fun createFragment(position: Int): Fragment {
            return when(position){
                0 -> Fragment41()
                else -> Fragment42()
            }
        }
    }
}