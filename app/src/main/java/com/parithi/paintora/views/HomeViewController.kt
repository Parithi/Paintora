package com.parithi.paintora

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.parithi.paintora.contracts.HomeContract
import com.parithi.paintora.models.PaintingData
import com.parithi.paintora.presenters.HomePresenter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf


class HomeViewController : AppCompatActivity(), HomeContract.View {

    val presenter : HomePresenter by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.prepareData(applicationContext)
    }

    override fun displayData(data: List<PaintingData>) {
        recyclerView.adapter = PaintingDataListAdapter(data)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
    }

    inner class PaintingDataListAdapter(var data: List<PaintingData>) : RecyclerView.Adapter<PaintingDataViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, p1: Int): PaintingDataViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.paintora_card_view, parent, false)
            return PaintingDataViewHolder(view)
        }

        override fun getItemCount(): Int {
            return data.size
        }

        override fun onBindViewHolder(viewHolder: PaintingDataViewHolder, position: Int) {
            val paintingData = data.get(position)
            Glide.with(this@HomeViewController)
                .load(data.get(position).imageUrl)
                .into(viewHolder.imageView)
        }

    }

    inner class PaintingDataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView : ImageView = itemView.findViewById(R.id.imageView)
    }
}
