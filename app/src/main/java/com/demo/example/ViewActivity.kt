package com.demo.example

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_view.EdNum
import kotlinx.android.synthetic.main.activity_view.btnNest

class ViewActivity : AppCompatActivity() {
    public override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.activity_view)

        btnNest.setOnClickListener(View.OnClickListener {

            val num = EdNum.text.toString().toInt()

            if(EdNum.text.toString().isNotEmpty()){
                if(num in 1..10){
                    val intent = Intent(this,GridViewActivity::class.java)
                    intent.putExtra("UserNumber", num)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "Please Enter Number between 1-10", Toast.LENGTH_SHORT).show()
                }
            }

        })

    }
}