package com.example.projetmobile_4a.presentation.second

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.projetmobile_4a.R
import com.example.projetmobile_4a.domain.entity.User
import org.koin.android.ext.android.inject

class SecondActivity : SingleFragmentActivity(){

    override fun createFragment() = SecondFragment.newInstance()

    /*val secondViewModel : SecondViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val user = intent.getSerializableExtra("key") as User

        findViewById<TextView>(R.id.temp).apply {
            val texte: String = user.email + " - " + user.password + " - " + user.nom + " - " + user.prenom
            text = texte
        }

    }*/
}
