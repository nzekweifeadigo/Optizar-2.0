package com.yourpackage

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.content.Context
import android.view.View
import androidx.core.content.ContextCompat

class ColorManager {
    private val rainbowColors = listOf(
        R.color.rainbow_red,
        R.color.rainbow_orange,
        R.color.rainbow_yellow,
        R.color.rainbow_green,
        R.color.rainbow_blue,
        R.color.rainbow_purple
    )

    private var currentColorIndex = 0

    fun getNextColor(context: Context): Int {
        currentColorIndex = (currentColorIndex + 1) % rainbowColors.size
        return ContextCompat.getColor(context, rainbowColors[currentColorIndex])
    }

    fun animateBackgroundColor(view: View, fromColor: Int, toColor: Int) {
        val colorAnimation = ValueAnimator.ofObject(ArgbEvaluator(), fromColor, toColor)
        colorAnimation.duration = 1000
        colorAnimation.addUpdateListener { animator ->
            view.setBackgroundColor(animator.animatedValue as Int)
        }
        colorAnimation.start()
    }
}
