package com.example.mainexam

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mainexam.databinding.FragmentAccountBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AccountFragment : Fragment(R.layout.fragment_account) {
    private lateinit var binding: FragmentAccountBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var hobbies:MutableList<String> = mutableListOf()
        if(binding.checkone.isChecked){
            hobbies.add(binding.checkone.text.toString())
        }
        if (binding.check2.isChecked){
            hobbies.add(binding.check2.text.toString())
        }
        if (binding.check3.isChecked){
            hobbies.add(binding.check3.text.toString())
        }

        binding.btcr.setOnClickListener {
            val user=User(binding.etname.text.toString(),binding.etfamily.text.toString(),binding.etnacode.text.toString(),hobbies)
            NetworkManager.service.sendaccount(user).enqueue(object :Callback<String>{
                override fun onResponse(call: Call<String>, response: Response<String>) {

                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    Toast.makeText(requireContext(), "fail", Toast.LENGTH_SHORT).show()
                }
            })
        }


    }
}