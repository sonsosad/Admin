package com.son.admin

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_add_video_show.*

class AddVideoShow : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_video_show)
        FirebaseApp.initializeApp(this)
        val db = Firebase.firestore
        btnClearText.setOnClickListener {
            edtTitle.setText("")
            edtUrlVideo.setText("")
            edtThumbNail.setText("")
            edtDescription.setText("")
            edtDescription.setText("")
        }
        btnSummit.setOnClickListener {
            val title = edtTitle.text.toString()
            val urlVideo = edtUrlVideo.text.toString()
            val thumbnail = edtThumbNail.text.toString()
            val description = edtDescription.text.toString()
            val createAt = edtCreateAt.text.toString()
            val video = hashMapOf(
                "title" to title,
                "urlVideo" to urlVideo,
                "thumbnail" to thumbnail,
                "description" to description,
                "createAt" to createAt
            )
            db.collection("slides").add(video).addOnCompleteListener {
                Toast.makeText(this, "success", Toast.LENGTH_LONG).show()
            }.addOnFailureListener {
                Toast.makeText(this, "fail" + it.toString(), Toast.LENGTH_LONG).show()

            }
        }
    }
}