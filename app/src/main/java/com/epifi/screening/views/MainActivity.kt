package com.epifi.screening.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.URLSpan
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.epifi.screening.R
import com.epifi.screening.databinding.ActivityMainBinding
import com.epifi.screening.interfaces.KycCallbacks
import com.epifi.screening.viewModals.KycViewModalFactory
import com.epifi.screening.viewModals.KycViewModel

class MainActivity : AppCompatActivity(), KycCallbacks {

    override fun onSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun dismissActivity() {
        finish()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = ViewModelProvider(this, KycViewModalFactory(this))[KycViewModel::class.java]

        //Finding and displaying the content that consists a URL as a hyperlink
        binding.footerText.movementMethod = LinkMovementMethod.getInstance()
        binding.footerText.removeLinksUnderline()

    }

    private fun TextView.removeLinksUnderline() {
        val spannable = SpannableString(text)
        for (u in spannable.getSpans(0, spannable.length, URLSpan::class.java)) {
            spannable.setSpan(object : URLSpan(u.url) {
                override fun updateDrawState(ds: TextPaint) {
                    super.updateDrawState(ds)
                    ds.isUnderlineText = false
                }
            }, spannable.getSpanStart(u), spannable.getSpanEnd(u), 0)
        }
        text = spannable
    }
}