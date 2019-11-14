package com.annotation.transitionanimationdemo.compat.transition

import android.view.View
import java.util.*

class TransitionMaterials private constructor(views: Array<out View>) {
    companion object {
        @JvmStatic
        fun createMaterials(vararg views: View): TransitionMaterials {
            return TransitionMaterials(views)
        }
    }

    val viewAttrs: ArrayList<ViewAttrs> = ArrayList()

    init {
        for (view in views) {
            val location = IntArray(2)
            view.getLocationOnScreen(location)
            viewAttrs.add(
                ViewAttrs(
                    view.id,
                    view.alpha,
                    location[0],
                    location[1],
                    view.width,
                    view.height
                )
            )
        }
    }
}
