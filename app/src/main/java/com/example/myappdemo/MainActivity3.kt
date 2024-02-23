package com.example.myappdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Placeholder

class MainActivity3 : AppCompatActivity() {
    private lateinit var placeholder : Placeholder
    private lateinit var constraintLayout: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        placeholder = findViewById(R.id.placeholder)
        constraintLayout = findViewById(R.id.layout)

    }

    fun swapView(view: View) {
        TransitionManager.beginDelayedTransition(constraintLayout)
        placeholder.setContentId(view.id)
    }
}