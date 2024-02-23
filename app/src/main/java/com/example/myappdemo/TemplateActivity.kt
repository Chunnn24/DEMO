package com.example.myappdemo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.View
import android.view.animation.OvershootInterpolator
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class TemplateActivity : AppCompatActivity() {

    private lateinit var layout: ConstraintLayout
    private val oldLayout = ConstraintSet()
    private val newLayout = ConstraintSet()
    private var isAlt = false

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial_placeholder_part1)

        layout = findViewById(R.id.layout)
        oldLayout.clone(layout)
        newLayout.clone(this,R.layout.layout_template)

    }

    fun swapView(view: View){
        val trainsion = ChangeBounds()
        trainsion.setInterpolator(OvershootInterpolator())
        TransitionManager.beginDelayedTransition(layout)
        if (!isAlt){
            isAlt = true
            newLayout.applyTo(layout)
        }else{
            isAlt = false
            oldLayout.applyTo(layout)
        }
    }

}