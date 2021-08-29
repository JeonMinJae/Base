package mj.project.tablayout

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayoutMediator
import mj.project.tablayout.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityMain3Binding

    private val tabIcon = listOf(
        R.drawable.ic_baseline_format_list_bulleted_24,
        R.drawable.ic_baseline_map_24,
        R.drawable.ic_baseline_info_24
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewpager3.apply {
            adapter = MyPagerAdapter3(context as FragmentActivity)
            setPageTransformer(ZoomOutPageTransformer3())
        }

        TabLayoutMediator(binding.tabs3, binding.viewpager3) { tab, position ->
            tab.text = "Title $position"
            tab.setIcon(tabIcon[position])
        }.attach()
    }
}