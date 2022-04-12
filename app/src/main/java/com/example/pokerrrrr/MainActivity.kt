package com.example.pokerrrrr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import com.example.pokerrrrr.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnTouchListener, GestureDetector.OnGestureListener {

    private lateinit var binding: ActivityMainBinding
    //宣告GestureDetector物件，lateinit表示延遲初始化(非null類型需要初始化，後面再進行)
    lateinit var g: GestureDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txv.text = "撲克牌魔術"

        binding.img.setOnTouchListener(this)
        //Context(目前的應用系統) Listener(目前的監聽事件)
        g = GestureDetector(this,this)
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        if (event?.action == MotionEvent.ACTION_DOWN){
            binding.txv.text = "手指按下"
        }
        else if (event?.action == MotionEvent.ACTION_UP){
            binding.txv.text = "手指彈開"
        }

        g.onTouchEvent(event)
        return true
    }

    override fun onDown(e: MotionEvent?): Boolean {

        return true
    }

    override fun onShowPress(e: MotionEvent?) {

    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {

        return true
    }

    override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
        binding.txv.text = "拖曳"
        return true
    }

    override fun onLongPress(e: MotionEvent?) {

    }

    override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {

        return true
    }
}