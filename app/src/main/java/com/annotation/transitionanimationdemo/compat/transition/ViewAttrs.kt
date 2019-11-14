package com.annotation.transitionanimationdemo.compat.transition

import android.os.Parcel
import android.os.Parcelable

open class ViewAttrs : Parcelable {
    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ViewAttrs> = object : Parcelable.Creator<ViewAttrs> {
            override fun createFromParcel(source: Parcel): ViewAttrs {
                return ViewAttrs(source)
            }

            override fun newArray(size: Int): Array<ViewAttrs?> {
                return arrayOfNulls(size)
            }
        }
    }

    var id: Int = 0
    var alpha: Float = 0f
    var screenX: Int = 0
    var screenY: Int = 0
    var width: Int = 0
    var height: Int = 0


    constructor(id: Int, alpha: Float, screenX: Int, screenY: Int, width: Int, height: Int) {
        this.id = id
        this.alpha = alpha
        this.screenX = screenX
        this.screenY = screenY
        this.width = width
        this.height = height
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(this.id)
        dest.writeFloat(this.alpha)
        dest.writeInt(this.screenX)
        dest.writeInt(this.screenY)
        dest.writeInt(this.width)
        dest.writeInt(this.height)
    }

    protected constructor(`in`: Parcel) {
        this.id = `in`.readInt()
        this.alpha = `in`.readFloat()
        this.screenX = `in`.readInt()
        this.screenY = `in`.readInt()
        this.width = `in`.readInt()
        this.height = `in`.readInt()
    }
}
