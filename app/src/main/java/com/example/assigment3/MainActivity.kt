package com.example.assigment3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var analytics: FirebaseAnalytics
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        analytics = Firebase.analytics

        val btnSelectContent = findViewById<Button>(R.id.SELECTCONTENTEVENT)
        val btntrackScreenView = findViewById<Button>(R.id.trackScreenView)

        btnSelectContent.setOnClickListener {
            SELECTCONTENTEVENT("user1" , "user name " , "Image")
        }

        btntrackScreenView.setOnClickListener {
            trackScreenView()
        }
    }
    fun SELECTCONTENTEVENT(id:String , name:String , ContentType:String){
        analytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT){
            param(FirebaseAnalytics.Param.ITEM_ID, id);
            param(FirebaseAnalytics.Param.ITEM_NAME, name);
            param(FirebaseAnalytics.Param.ITEM_NAME, ContentType);

        }
    }

    fun trackScreenView(){
        analytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW){
       param(FirebaseAnalytics.Param.SCREEN_NAME , "main")
       param(FirebaseAnalytics.Param.SCREEN_CLASS , "mainActivity")
        }
    }
}