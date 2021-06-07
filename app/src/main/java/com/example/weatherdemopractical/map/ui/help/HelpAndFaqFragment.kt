package com.example.weatherdemopractical.map.ui.help

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherdemopractical.R
import com.example.weatherdemopractical.model.faq.Ans
import com.example.weatherdemopractical.model.faq.Faq

import kotlinx.android.synthetic.main.fragment_help_and_faq.*


class HelpAndFaqFragment : Fragment() {

    val arrayList = ArrayList<Faq>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_help_and_faq, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arrayList.add(
            Faq(
                "What is app all about?",
                listOf(Ans("Weather, everybody wants to know how it is going to be during the week. Will it be rainy, windy,\n" +
                        "or sunny? Luckily for us, in the information age, there are open APIs to retrieve information\n" +
                        "about it."))
            )
        )
        arrayList.add(
            Faq(
                "What features does app have",
                listOf(Ans("Explore the Earth Weather forecast "))
            )
        )



        val adapter = HelpAndFaqListAdapter(arrayList)
        helpRv.apply {
            layoutManager = LinearLayoutManager(context)
            helpRv.adapter = adapter
        }
        emailFb.setOnClickListener {
            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_APP_EMAIL)
            startActivity(intent)
            startActivity(Intent.createChooser(intent, getString(R.string.choose_email)))
        }

    }

}

