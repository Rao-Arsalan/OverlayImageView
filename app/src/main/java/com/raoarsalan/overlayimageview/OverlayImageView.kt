package com.raoarsalan.overlayimageview


import android.content.Context
import android.graphics.*
import android.util.AttributeSet



/**
 *This class is responsible for drawing the overlay color into image view
 * Just pass color value either in xml attribute {overlayColor}  or setOverlayColor(color) ;
 *
 * @attr ref android.R.styleable#OverlayImageView_overlayColor
 * @see setOverlayColor{Int#mOverlayColor}
 */
class OverlayImageView(context: Context, attrs: AttributeSet) : androidx.appcompat.widget.AppCompatImageView(context, attrs){

    /**
     * Determine which color should be overlay.
     * @see OverlayImageView.setOverlayColor(int)
     * @see OverlayImageView.getOverlayColor
     */
    private var mOverlayColor:Int



    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.OverlayImageView,
            0, 0
        ).apply {

            try {
                mOverlayColor = getColor(R.styleable.OverlayImageView_overlayColor,-1)

            } finally {
                recycle()
            }
        }



    }


    /**
     * by default it's  draw image view without overlay color
     * @see canvas is responsible drawing the image view according to overlay color
     * @see mOverlayColor
     *
     */

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        if (mOverlayColor != -1) {
            canvas?.drawColor(mOverlayColor)
        }
    }

    /**
     *@param color The overlay color used for drawing the color into image view
     * @see android.content.res.TypedArray.getColor
     * @see invalidate
     * @see getOverlayColor
     */
    fun setOverlayColor(color :Int){
        this.mOverlayColor = color
        invalidate()
        requestLayout()
    }

    /**
     * @return The overlay color used for draw the color into image view
     */
    fun getOverlayColor():Int{
        return mOverlayColor
    }
}