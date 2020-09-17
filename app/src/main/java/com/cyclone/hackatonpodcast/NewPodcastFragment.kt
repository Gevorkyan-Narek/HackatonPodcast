package com.cyclone.hackatonpodcast

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.new_podcast.*

class NewPodcastFragment: Fragment(R.layout.new_podcast) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        nextButton.setOnClickListener {
            fragmentManager!!.beginTransaction().addToBackStack("new_podcast")
                .replace(R.id.fragment, PublishPodcastFragment()).commit()
        }
    }
}