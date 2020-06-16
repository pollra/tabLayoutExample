package com.pollra.rain04.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pollra.rain04.R

class NewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("NewFragment","페이지가 로딩되었습니다")
        return inflater.inflate(R.layout.fragment_new, container, false)
    }
}