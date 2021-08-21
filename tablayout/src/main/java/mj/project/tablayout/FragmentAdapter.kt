package mj.project.tablayout

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.banner_list_item.view.*
import kotlinx.android.synthetic.main.idol_list_item5.view.*

class FragmentAdapter (bannerList: ArrayList<Int>): RecyclerView.Adapter<FragmentAdapter.PagerViewHolder>() {

    var item = bannerList
    //tab의 개수만큼 return
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PagerViewHolder((parent))

    override fun getItemCount(): Int = Int.MAX_VALUE	// 무한 반복하려고 아이템의 갯수를 임의로 확 늘린다.

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.banner.setImageResource(item[position%3])    // %3을 사용해서 4라면 1이 보이게 한다.
    }

    inner class PagerViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder
        (LayoutInflater.from(parent.context).inflate(R.layout.banner_list_item, parent, false)){

        val banner = itemView.imageView_banner1!!
    }
}