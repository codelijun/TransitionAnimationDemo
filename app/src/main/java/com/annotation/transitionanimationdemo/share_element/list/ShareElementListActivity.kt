package com.annotation.transitionanimationdemo.share_element.list

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.annotation.transitionanimationdemo.R
import kotlinx.android.synthetic.main.activity_share_element_list.*

class ShareElementListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_element_list)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val viewModel1 = ViewModel("共享元素1", R.mipmap.ic_launcher)
        val viewModel2 = ViewModel("共享元素2", R.mipmap.ic_launcher)
        val viewModel3 = ViewModel("共享元素3", R.mipmap.ic_launcher)
        val viewModel4 = ViewModel("共享元素4", R.mipmap.ic_launcher)
        val viewModelList = ArrayList<ViewModel>()
        viewModelList.add(viewModel1)
        viewModelList.add(viewModel2)
        viewModelList.add(viewModel3)
        viewModelList.add(viewModel4)
        recycler_view.adapter = ShareAdapter(viewModelList)
        recycler_view.layoutManager = LinearLayoutManager(this)
    }

    class ShareAdapter(private val viewModelList: List<ViewModel>) :
        RecyclerView.Adapter<ShareAdapter.ShareViewHolder>() {

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): ShareViewHolder {
            val itemView = TextView(parent.context)
            itemView.gravity = Gravity.CENTER
            return ShareViewHolder(itemView)
        }

        override fun getItemCount(): Int {
            return viewModelList.size
        }

        override fun onBindViewHolder(holder: ShareViewHolder, position: Int) {
            holder.bindData(viewModelList[position])
        }

        class ShareViewHolder(private val itemView2: TextView) :
            RecyclerView.ViewHolder(itemView2) {

            init {
                itemView.setOnClickListener {

                }
            }

            fun bindData(viewModel: ViewModel) {
                itemView2.text = viewModel.name
                val drawable: Drawable = itemView2.context.resources.getDrawable(viewModel.icon)
                val size = itemView2.context.resources.getDimensionPixelOffset(R.dimen.dp_100)
                drawable.setBounds(0, 0, size, size)
                itemView2.setCompoundDrawables(drawable, null, null, null)
            }
        }

    }

    class ViewModel(val name: String, val icon: Int) {
    }
}