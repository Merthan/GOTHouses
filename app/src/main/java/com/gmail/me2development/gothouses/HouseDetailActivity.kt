package com.gmail.me2development.gothouses

import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.TextUtils
import android.text.style.StyleSpan
import android.text.style.UnderlineSpan
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_house_detail.*
import kotlinx.android.synthetic.main.content_house_detail.*

fun String.boldAndUnderline()= SpannableString(this).also {
    it.setSpan(StyleSpan(Typeface.BOLD),0,length,0)
    it.setSpan(UnderlineSpan(),0,length,0)
}
fun String.ifEmptyReplace(replacement:String="None")=if(isNullOrBlank())replacement else this

class HouseDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_house_detail)
        setSupportActionBar(toolbar)

        with(intent){
            //Set activity title
            title=getStringExtra(EXTRA_HOUSE_NAME)

            //No viewmodel, overkill for just showing text in this case

            //ROTATION KEEPS THE TEXT STATE

            //In my opinion there are some cases where this would even be appropriate in real apps,
            // for example screens in the about section (Datenschutzerklärung e.g.)

            //TextUtils.concat is used to append Spannables together
            houseDetailTextView.text=TextUtils.concat(
                "Region:".boldAndUnderline(),//Extension function defined above (project too small for dedicated util class i´d say, this makes it more readable)
                "\n${getStringExtra(EXTRA_HOUSE_REGION).ifEmptyReplace()}\n",
                "Coat of arms:".boldAndUnderline(),
                "\n${getStringExtra(EXTRA_HOUSE_COAT_OF_ARMS).ifEmptyReplace()}"
            )
        }


    }

}
