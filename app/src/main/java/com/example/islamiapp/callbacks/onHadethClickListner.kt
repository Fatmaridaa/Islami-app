package com.example.islamiapp.callbacks

import com.example.islamiapp.HadethDataClass

interface onHadethClickListner {

    fun onHadethClick(hadeth : HadethDataClass , position : Int)
}