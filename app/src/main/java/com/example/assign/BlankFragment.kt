package com.example.assign

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.assign.databinding.FragmentBlankBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class BlankFragment : Fragment() {

    lateinit var binding: FragmentBlankBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentBlankBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("CommitTransaction")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var msg = (binding.Ename.toString().plus("\n").plus(binding.EAddress.toString().plus("\n")).plus(binding.EContact.toString().plus("\n")).plus(binding.EEmail.toString().plus("\n")).plus(binding.EPassword.toString().plus("\n")))

        binding.btnEmail.setOnClickListener {

            if(binding.Ename.text.isNullOrEmpty() || binding.EAddress.text.isNullOrEmpty()||binding.EContact.text.isNullOrEmpty() || binding.EPassword.text.isNullOrEmpty() || binding.ECPassword.text.isNullOrEmpty()){
                Toast.makeText(requireContext(), "Enter full details", Toast.LENGTH_SHORT).show()
                if(binding.Ename.text.isNullOrEmpty()){
                    binding.Ename.error="Enter name"
                }
                if(binding.EAddress.text.isNullOrEmpty()){
                    binding.EAddress.error="Enter Address"
                }
                 if(binding.EContact.text.isNullOrEmpty()){
                    binding.EContact.error="Enter Contact"
                }
                if(binding.EEmail.text.isNullOrEmpty()){
                    binding.EEmail.error="Enter Email"
                }

                if(binding.EPassword.text.isNullOrEmpty()){
                    binding.EPassword.error="Enter Password"
                }
                if(binding.ECPassword.text.isNullOrEmpty()) {
                    binding.ECPassword.error = "Enter Confirm Password"
                }

            }

            else if(binding.EPassword.text.toString() != binding.ECPassword.text.toString()){
                Toast.makeText(requireContext(), "Password Doesn't match", Toast.LENGTH_SHORT).show()
            }

            else {
                    val message = " ${binding.Ename.text} \n ${binding.EAddress.text} \n ${binding.EContact.text} \n  ${binding.EPassword.text} "
                    val email = binding.EEmail.text.toString()
                    val intent = Intent(Intent.ACTION_SEND)
                        intent.setData(Uri.parse("mailto:"))
                        intent.putExtra(Intent.EXTRA_EMAIL,email)
                        intent.putExtra(Intent.EXTRA_SUBJECT,"Testing")
                        intent.putExtra(Intent.EXTRA_TEXT,message)
                startActivity(intent)



//                val BlankFragment = BlankFragment2()
//                val bundle = Bundle().apply {
//                    putString("Name",binding.Ename.text.toString())
//                    putString("Address",binding.EAddress.text.toString())
//                    putString("Contact",binding.EContact.text.toString())
//                    putString("Email",binding.EEmail.text.toString())
//                    putString("Password",binding.EPassword.text.toString())
//                }
//                BlankFragment.arguments = bundle
//                parentFragmentManager.beginTransaction().replace(R.id.host,BlankFragment).addToBackStack(null).commit()
//                findNavController().navigate(R.id.blankFragment2)
                }
            }

        binding.btnSMS.setOnClickListener {

                val intent = Intent(Intent.ACTION_SENDTO)
                 intent.setData(Uri.parse("smsto: 1234567890"))
                intent.putExtra(Intent.EXTRA_TEXT,"this is testing")
            startActivity(intent)




        }
    }
}


