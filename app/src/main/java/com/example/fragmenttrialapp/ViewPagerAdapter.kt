package com.example.fragmenttrialapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    val contactFragment = ContactFragment()
    val messageFragment = MessageFragment()
    val statusFragment = StatusFragment()

    override fun getCount(): Int { // function ini digunakan untuk mengembalikan jumlah fragment yang ada
        return 3
    }

    override fun getItem(position: Int): Fragment { // function ini digunakan untuk set tampilan fragment yang dibutuhkan
        when(position) {
            0 -> return contactFragment
            1 -> return messageFragment
            2 -> return statusFragment
        }
        return contactFragment
    }

    override fun getPageTitle(position: Int): CharSequence? { // set judul pada tab layout
        when (position) {
            0 -> return "Contact"
            1 -> return "Message"
            2 -> return "Status"
        }
        return null
    }
}