package com.example.navapp1

import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.navapp1.databinding.ActivityMain3Binding
import java.util.*

class MainActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      // setContentView(R.layout.activity_main3)

        val binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.myButton3.setOnClickListener {
            val editTextRoutineName=binding.textInputEditText.text.toString()
            val sharedPref=getSharedPreferences("mPrefs", Context.MODE_PRIVATE)
            val editor=sharedPref.edit()
            editor.putString("routeName",editTextRoutineName)
            editor.apply()
            val intent = Intent(this, MainActivity4::class.java)
            startActivity(intent)
        }


        binding.myButton4.setOnClickListener {
            val intent = Intent(this, MainActivity5::class.java)
            startActivity(intent)
        }

        val routineName: EditText = binding.textInputEditText
        routineName.setOnClickListener {
            binding.textView17.visibility = View.VISIBLE
            routineName.text = null
        }

        //time picker dialog
        val myData1:String? = intent.getStringExtra("hello")
        if (myData1 != null){

            var currenttime= Calendar.getInstance()
            var hour=currenttime.get(Calendar.HOUR_OF_DAY)
            var minute=currenttime.get(Calendar.MINUTE)

            TimePickerDialog(this, TimePickerDialog.OnTimeSetListener(){ view, hour, minutes->
                val clockFra=layoutInflater.inflate(R.layout.fragment_clock_fra, null)

                val linear=binding.replaceableTime
                val AddEventText=binding.AddEventText
                linear.removeView(AddEventText)
                linear.addView(clockFra)

                clockFra.findViewById<TextView>(R.id.textNewClock).setText("The time is $hour:$minutes")

            }, hour, minute, true).show()

        }



        val myData2:String? = intent.getStringExtra("backR")
        if(myData2!=null){
            val dialog = DialogFragmentExample()
            dialog.show(supportFragmentManager,"my_dialog_tag")
        }

        val myData3:String? = intent.getStringExtra("progBarLauncher")
        if (myData3!=null){
            val sendNotifFra=layoutInflater.inflate(R.layout.frag, null)
            val replaceable=binding.textAddAc
            val holder=binding.linearAboveAdd

            holder.removeView(replaceable)
            holder.addView(sendNotifFra)

            val replaceabletext=sendNotifFra.findViewById<TextView>(R.id.editableSendNotification)
            replaceabletext.text = "Send Notification:$myData3"

            val dialog2 = Dialog(this)
            dialog2.setContentView(R.layout.dialog_intermediate)
            dialog2.show()

            val handler= Handler(Looper.getMainLooper())
            handler.postDelayed({
                dialog2.dismiss()

                val intent_toMain=Intent(this,MainActivity::class.java)
                intent_toMain.putExtra("toMain","main")
                startActivity(intent_toMain)

            },3000)

        }        }

    }





