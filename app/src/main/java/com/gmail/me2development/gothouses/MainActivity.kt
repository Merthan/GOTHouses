package com.gmail.me2development.gothouses

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*



const val GOT_API_URL="https://anapioficeandfire.com/api/"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val model = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        housesRecyclerView.layoutManager=LinearLayoutManager(this@MainActivity)
        housesRecyclerView.adapter=HouseAdapter(emptyList())

        model.getHouses().observe(this, Observer<List<HouseJsonModel>>{ houses ->
            //Updating recyclerview
            housesRecyclerView.adapter=HouseAdapter(houses)
            //No specific changes like a specific item changed, so this is the easiest solution
        })


    }
}


