package com.cyclone.hackatonpodcast

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class EditAudioFragment: Fragment(R.layout.edit_audio) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        fragmentManager!!.beginTransaction().addToBackStack("audio_edit")
            .replace(R.id.fragment, NewPodcastFragment()).commit()
    }
}