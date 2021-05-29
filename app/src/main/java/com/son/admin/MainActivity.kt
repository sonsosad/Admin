package com.son.admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FirebaseApp.initializeApp(this);
        val db = Firebase.firestore

        btnSummit.setOnClickListener {
            val name = nameMedicine.text.toString()
            val type = type.text.toString()
            val ulrImage = ulrImage.text.toString()
            val uses = usesMedicin.text.toString()
            val ingredient = ingredientMedicin.text.toString()
            val using = using.text.toString()
            val sideEffects = sideEffects.text.toString()
            val licenseNumber = licenseNumber.text.toString()
            val numberLike = numberLikeMedicin.text.toString().toInt()
            val origin = origin.text.toString()
            val product = hashMapOf(
                "image" to ulrImage,
                "ingredient" to ingredient,
                "licenseNumber" to licenseNumber,
                "likeNumber" to numberLike,
                "name" to name,
                "origin" to origin,
                "sideEfects" to sideEffects,
                "type" to type,
                "userManual" to using,
                "uses" to uses
            )
            db.collection("product").add(product).addOnCompleteListener {
                Toast.makeText(this, "success", Toast.LENGTH_LONG).show()
            }.addOnFailureListener {
                Toast.makeText(this, "fail" + it.toString(), Toast.LENGTH_LONG).show()

            }
        }
        btnClearText.setOnClickListener {
            nameMedicine.setText("")
            ulrImage.setText("")
            usesMedicin.setText("")
            ingredientMedicin.setText("")
            using.setText("")
            sideEffects.setText("")
            licenseNumber.setText("")
            numberLikeMedicin.setText("")
            origin.setText("")
        }
        btnAddVideoShow.setOnClickListener {
            startActivity(Intent(this, AddVideoShow::class.java))
        }
    }
}