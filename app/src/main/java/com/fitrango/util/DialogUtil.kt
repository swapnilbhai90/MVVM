package com.fitrango.util
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import androidx.constraintlayout.widget.ConstraintLayout
import com.fitrango.R

object DialogUtil {

    fun getSuccessfulAcctDialog(context: Context?, title: String?): Dialog? {
        val dialog = Dialog(context!!)
        if (dialog.window != null) {
            dialog.window?.setLayout(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT)
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window!!.requestFeature(Window.FEATURE_NO_TITLE)
        }
        dialog.setContentView(R.layout.dialog_account_successful)
        dialog.setCanceledOnTouchOutside(false)
        dialog.setCancelable(false)
        return dialog
    }
}