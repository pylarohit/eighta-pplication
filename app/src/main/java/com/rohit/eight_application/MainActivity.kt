package com.rohit.eight_application

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Telephony.Sms
import android.provider.Telephony.Sms.Intents
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var sms : Button? = null
    var email : Button? =null
    var subject : EditText? =null
    var message: EditText? =null
    var toEmail : EditText? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        sms = findViewById(R.id.sms)
        subject = findViewById(R.id.subject)
        message = findViewById(R.id.message)
        toEmail = findViewById(R.id.toemail)
        email = findViewById(R.id.email)
       email?.setOnClickListener {
               var intent = Intent(Intent.ACTION_SEND)
           var recipient: String, subject: String, message: String
               intent.data = Uri.parse("Rohit:")
               intent.type = "text/plain"
               intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(toEmail))
               intent.putExtra(Intent.EXTRA_SUBJECT, subject)
               intent.putExtra(Intent.EXTRA_TEXT,  message)
               try {
                   startActivity(intent)
               }
               catch (e: Exception){
                   Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
               }

           }
       }
    }
}