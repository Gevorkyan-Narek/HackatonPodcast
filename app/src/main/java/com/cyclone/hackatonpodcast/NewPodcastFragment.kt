package com.cyclone.hackatonpodcast

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.new_podcast.*
import java.io.FileNotFoundException

class NewPodcastFragment : Fragment(R.layout.new_podcast) {

    companion object {
        private const val PICK_PHOTO = 1
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        nextButton.setOnClickListener {
            fragmentManager!!.beginTransaction().addToBackStack("new_podcast")
                .replace(R.id.fragment, PublishPodcastFragment()).commit()
        }

        cover.setOnClickListener {
            val openGallery = Intent().setType("image/*").setAction(Intent.ACTION_PICK)
            startActivityForResult(
                Intent.createChooser(openGallery, "Выберите фото"),
                PICK_PHOTO
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            PICK_PHOTO -> {
                if (resultCode == RESULT_OK && data != null) {
                    try {
                        val path = data.data!!
                        Glide.with(context!!).load(path).apply(
                            RequestOptions().transform(CenterCrop(), RoundedCorners(10))
                        ).into(cover)
                    } catch (e: FileNotFoundException) {
                        e.printStackTrace()
                    }
                }
            }
        }
    }
}