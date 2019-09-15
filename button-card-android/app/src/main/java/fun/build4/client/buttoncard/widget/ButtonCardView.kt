package `fun`.build4.client.buttoncard.widget

import `fun`.build4.client.buttoncard.R
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import androidx.cardview.widget.CardView

class ButtonCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {

    init {
        val arr = context.obtainStyledAttributes(
            attrs,
            R.styleable.ButtonCardView,
            defStyleAttr,
            R.style.Widget_App_ButtonCard
        )
        val cardTitle = arr.getString(R.styleable.ButtonCardView_cardTitle)
        arr.recycle()

        LayoutInflater.from(context).inflate(R.layout.button_card_content, this, true)

        findViewById<TextView>(R.id.header_text).apply {
            text = cardTitle
        }
    }

}