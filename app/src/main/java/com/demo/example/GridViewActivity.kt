package com.demo.example

import android.content.Context
import android.graphics.Color
import android.graphics.Point
import android.os.Bundle
import android.view.Display
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.BaseAdapter
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_grid_view.gridView

class GridViewActivity : AppCompatActivity() {
    public override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.activity_grid_view)
        val intentVal = intent.getIntExtra("UserNumber",-1)
        val totleItem = intentVal * intentVal
        if(!intentVal.equals(-1)){
            val array = Array(totleItem) { index -> index}
            val gridAdapter = GridAdapter(this, array, intentVal)
            gridView.adapter = gridAdapter
            gridView.numColumns = intentVal
        }
    }


    class GridAdapter(private val context: Context, private val items: Array<Int>, val intentVal: Int) : BaseAdapter() {

        private var selectedItemPosition: Int? = null

        override fun getCount(): Int {
            return items.size
        }

        override fun getItem(position: Int): Any {
            return items[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view: View
            val viewHolder: ViewHolder

            if (convertView == null) {
                view = LayoutInflater.from(context).inflate(R.layout.grid_item_layout, parent, false)
                viewHolder = ViewHolder(view)
                view.tag = viewHolder
            } else {
                view = convertView
                viewHolder = view.tag as ViewHolder
            }

            val item = items[position]
            viewHolder.textView.tag = item

            if (selectedItemPosition != null && isHighlighted(position)) {
                view.setBackgroundColor(ContextCompat.getColor(context, R.color.highlightColor))
            } else {
                view.setBackgroundColor(Color.TRANSPARENT)
            }
            view.setOnClickListener {
                selectedItemPosition = position
                notifyDataSetChanged()
            }



            val display: Display = (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay
            val size = Point()
            display.getSize(size)
            val width: Int = size.x
            val height: Int = size.y
            val itemWidth = width / intentVal
            val itemHeight = height / intentVal
            val layoutParams = ViewGroup.LayoutParams(itemWidth, itemHeight)
            view.layoutParams = layoutParams


            return view
        }

        private fun isHighlighted(position: Int): Boolean {
            val selectedRow = selectedItemPosition!! / intentVal
            val selectedCol = selectedItemPosition!! % intentVal
            val row = position / intentVal
            val col = position % intentVal

//            return position / intentVal == selectedItemPosition!! / intentVal || position % intentVal == selectedItemPosition!! % intentVal
//            return row + col == selectedRow + selectedCol || row - col == selectedRow - selectedCol
            return row == selectedRow || col == selectedCol || row + col == selectedRow + selectedCol || row - col == selectedRow - selectedCol
        }


        private class ViewHolder(view: View) {
            val textView: ImageView = view.findViewById(R.id.imageView)
        }
    }

}