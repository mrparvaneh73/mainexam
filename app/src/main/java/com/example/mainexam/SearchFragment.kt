package com.example.mainexam

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.mainexam.NetworkManager.service
import com.example.mainexam.databinding.FragmentSearchBinding
import okhttp3.MediaType
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.ByteArrayOutputStream

class SearchFragment: Fragment(R.layout.fragment_search) {
    fun Bitmap.toByteArray():ByteArray{
        ByteArrayOutputStream().apply {
            compress(Bitmap.CompressFormat.JPEG,10,this)
            return toByteArray()
        }
    }
    var imageBitmap: Bitmap? = null
    private  val cameraluncher=registerForActivityResult(
        ActivityResultContracts.TakePicturePreview()) {
        imageBitmap=it
        binding.profileimage.setImageBitmap(it)
    }
    private lateinit var binding: FragmentSearchBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.profileimage.setOnClickListener {
            cameraluncher.launch(null)
        }
        binding.upload.setOnClickListener {
            val imageName = binding.idtext.text.toString()
            val body = MultipartBody.create(MediaType.parse("image/*"), imageBitmap?.toByteArray())
            val request = MultipartBody.Part.createFormData("image", "$imageName.jpg", body)
            service.sendImage(imageName, request).enqueue(object : Callback<Any> {
                override fun onResponse(call: Call<Any>, response: Response<Any>) {
                    Toast.makeText(requireContext(), "Your Image uploaded successfully", Toast.LENGTH_SHORT).show()
                }
                override fun onFailure(call: Call<Any>, t: Throwable) {
                    Toast.makeText(requireContext(), "Oops something Went wrong", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}