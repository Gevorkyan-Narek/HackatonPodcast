package com.cyclone.hackatonpodcast

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.publish_podcast.*

class PublishPodcastFragment : Fragment(R.layout.publish_podcast) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        publishPodcast.setOnClickListener {
            fragmentManager!!.beginTransaction().addToBackStack("publish_podcast")
                .replace(R.id.fragment, AddedPodcast()).commit()
        }


        Glide.with(context!!).load(R.mipmap.cover_example).apply(
            RequestOptions().transform(CenterCrop(), RoundedCorners(10))
        ).into(cover)
    }
}