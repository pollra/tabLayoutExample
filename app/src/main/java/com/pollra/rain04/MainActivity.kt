package com.pollra.rain04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.pollra.rain04.fragment.HotFragment
import com.pollra.rain04.fragment.NewFragment
import com.pollra.rain04.fragment.PickFragment
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    lateinit var viewPager :ViewPager2
    lateinit var toolbar: Toolbar
    lateinit var tabs: TabLayout
    val tabTitleList:List<String> = listOf(
        "인기", "최신", "보관함"
    )

    var items: List<Fragment> = listOf(
        HotFragment(),
        NewFragment(),
        PickFragment()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setViewPager()
        setToolbar()
        setTabLayout()
        tabLinkPager()
    }

    fun setViewPager(){
        viewPager = findViewById(R.id.view_pager)
        viewPager.adapter = object: FragmentStateAdapter(supportFragmentManager, lifecycle) {
            override fun getItemCount(): Int = items.size
            override fun createFragment(position: Int): Fragment = items[position % items.size]
        }
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }
    fun setToolbar(){
        toolbar = findViewById(R.id.toolBar)
        setSupportActionBar(toolbar)
    }
    fun setTabLayout(){
        tabs = findViewById(R.id.tabs)
        tabs.addTab(tabs.newTab())
        tabs.addTab(tabs.newTab())
        tabs.addTab(tabs.newTab())
    }
    fun tabLinkPager(){
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = tabTitleList[position]
            viewPager.setCurrentItem(tab.position, true)
        }.attach()
    }
}