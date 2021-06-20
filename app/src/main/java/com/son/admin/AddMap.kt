package com.son.admin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.GeoPoint
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_add_map.*

class AddMap : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_map)
        FirebaseApp.initializeApp(this)
        val db = Firebase.firestore
        btnClearText.setOnClickListener {
            edtName.setText("")
            edtAddress.setText("")
            edtLatitude.setText("")
            edtLongitude.setText("")
            edtPhoneNumber.setText("")
            edtImage.setText("")

        }
        btnSummit.setOnClickListener {
            val name = edtName.text.toString()
            val city = edtCity.text.toString()
            val address = edtAddress.text.toString()
            val latitude = edtLatitude.text.toString()
            val longitude = edtLongitude.text.toString()
            val phoneNumber = edtPhoneNumber.text.toString()
            val imageLink = edtImage.text.toString()
            val type = edtType.text.toString()
            val location = GeoPoint(latitude.toDouble(), longitude.toDouble())
            val map = hashMapOf(
                "address" to address,
                "city" to city,
                "imageCompany" to imageLink,
                "location" to location,
                "name" to name,
                "phoneNumber" to phoneNumber,
                "type" to type.toInt()
            )
            db.collection("company").add(map).addOnCompleteListener {
                Toast.makeText(this, "success", Toast.LENGTH_LONG).show()
            }.addOnFailureListener {
                Toast.makeText(this, "fail" + it.toString(), Toast.LENGTH_LONG).show()

            }
        }
    }
}