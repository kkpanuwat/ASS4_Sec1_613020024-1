package com.example.asslab4ui
import android.app.DatePickerDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.DatePicker
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import java.text.DateFormat
import android.widget.TextView
import com.example.asslab4ui.R.id.text_date
import java.util.*

class DatePickerFragment: DialogFragment(), DatePickerDialog.OnDateSetListener{
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        return DatePickerDialog(activity!!, 0, this, year, month, day)
//        return super.onCreateDialog(savedInstanceState)
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, day: Int) {
        val tv: TextView? = activity?.findViewById(text_date)
        tv!!.text = formatDate(year,month,day)
    }

    override fun onCancel(dialog: DialogInterface) {
        Toast.makeText(activity,"Please select a date.", Toast.LENGTH_SHORT).show()
        super.onCancel(dialog)
    }

    private fun formatDate(year:Int, month:Int, day:Int):String{
        var calendar: Calendar = Calendar.getInstance();
        // Create a Date variable/object with user chosen date
        calendar.set(year, month, day)
        val chosenDate = calendar.time
        // Format the date picker selected date
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM)
        return df.format(chosenDate)
    }
}
