package com.pollra.rain04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.pollra.rain04.fragment.HotFragment
import com.pollra.rain04.fragment.NewFragment
import com.pollra.rain04.fragment.PickFragment

class MainActivity : AppCompatActivity() {
    lateinit var viewPager :ViewPager2
    lateinit var toolbar: Toolbar

    var items: List<Fragment> = listOf(
        HotFragment(),
        NewFragment(),
        PickFragment()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setViewPager()
        toolbar = findViewById(R.id.toolBar)
        setSupportActionBar(toolbar)

        println("'ㅂ '....")
//        supportFragmentManager.beginTransaction().replace(R.id.container, items[0]).commit()

        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.addTab(tabs.newTab().setText("인기"))
        tabs.addTab(tabs.newTab().setText("최신"))
        tabs.addTab(tabs.newTab().setText("보관함"))

        println("ㅇㅅㅇ!!!!")
        tabs.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab) {}

            override fun onTabUnselected(tab: TabLayout.Tab) {}

            override fun onTabSelected(tab: TabLayout.Tab) {
                val position: Int = tab.position
                Log.d("MainActivity", "선택된 탭: $position")
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, items[position]).commit()
            }
        })

    }

    fun setViewPager(){
        viewPager = findViewById(R.id.view_pager)
        viewPager.adapter = object: FragmentStateAdapter(supportFragmentManager, lifecycle) {
            override fun getItemCount(): Int = items.size
            override fun createFragment(position: Int): Fragment = items[position]
        }
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }
}