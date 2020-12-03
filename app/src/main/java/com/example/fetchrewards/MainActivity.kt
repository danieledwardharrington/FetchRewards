package com.example.fetchrewards

/*
Daniel Harrington
Fetch Rewards Coding Exercise
December 2, 2020
 */

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fetchrewards.ui.ListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.main_activity_frag_container, ListFragment()).commit()
        }
        setContentView(R.layout.activity_main)
    }
}