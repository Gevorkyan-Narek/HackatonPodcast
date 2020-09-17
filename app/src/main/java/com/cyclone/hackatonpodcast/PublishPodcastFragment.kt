package com.cyclone.hackatonpodcast

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.publish_a_podcast.*

class PublishPodcastFragment: Fragment(R.layout.publish_a_podcast) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        publishPodcast.setOnClickListener {
            fragmentManager!!.beginTransaction().addToBackStack("publish_podcast")
                .replace(R.id.fragment, AddedPodcast()).commit()
        }
    }
}