package com.son.admin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_add_health_new.*
import kotlinx.android.synthetic.main.activity_add_video_show.*
import kotlinx.android.synthetic.main.activity_add_video_show.btnClearText
import kotlinx.android.synthetic.main.activity_add_video_show.btnSummit
import kotlinx.android.synthetic.main.activity_add_video_show.edtCreateAt
import kotlinx.android.synthetic.main.activity_add_video_show.edtThumbNail
import kotlinx.android.synthetic.main.activity_add_video_show.edtTitle

class AddHealthNew : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_health_new)
        FirebaseApp.initializeApp(this)
        val db = Firebase.firestore
        btnClearText.setOnClickListener {
            edtTitle.setText("")
            edtThumbNailz.setText("")
            edtPrevention.setText("")
            edtSymptom.setText("")
            edtCreateAt.setText("")
        }
        btnSummit.setOnClickListener {
            val title = edtTitle.text.toString()
            val thumbnail = edtThumbNailz.text.toString()
            val prevention = edtPrevention.text.toString()
            val symptom = edtSymptom.text.toString()
            val createAt = edtCreateAt.text.toString()
            val data = hashMapOf(
                "titleNews" to title,
                "imageNews" to thumbnail,
                "prevention" to prevention,
                "symptom" to symptom,
                "createAt" to createAt
            )
            db.collection("healthNews").add(data).addOnCompleteListener {
                Toast.makeText(this, "success", Toast.LENGTH_LONG).show()
            }.addOnFailureListener {
                Toast.makeText(this, "fail" + it.toString(), Toast.LENGTH_LONG).show()

            }
        }
    }
}