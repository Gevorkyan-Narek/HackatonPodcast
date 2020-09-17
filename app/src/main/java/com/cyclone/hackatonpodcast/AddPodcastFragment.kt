package com.cyclone.hackatonpodcast

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.add_podcast.*

class AddPodcastFragment: Fragment(R.layout.add_podcast) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        addPodcast.setOnClickListener {
            fragmentManager!!.beginTransaction().addToBackStack("add_podcast")
                .replace(R.id.fragment, NewPodcastFragment()).commit()
        }
    }
}