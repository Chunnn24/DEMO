package com.example.myappdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.myappdemo.databinding.ActivityMusicBinding
import com.example.myappdemo.fragment.MusicViewPager2Adapter
import com.google.android.material.tabs.TabLayoutMediator

class MusicActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMusicBinding
    private val tabs = arrayOf("Song", "Album", "Artist")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMusicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = MusicViewPager2Adapter(supportFragmentManager, lifecycle)
        binding.viewPager2.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, index ->
            run {
                tab.text = tabs[index]
            }
        }.attach()

        binding.ivMenu.setOnClickListener {
            if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                binding.drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                binding.drawerLayout.openDrawer(GravityCompat.START)
            }
        }

        binding.navigation.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.item_song ->{  binding.viewPager2.currentItem = 0
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.item_album ->{  binding.viewPager2.currentItem = 1
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.item_artist ->{  binding.viewPager2.currentItem = 2
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                else -> true
            }
        }

        binding.dotsIndicator.setViewPager2(binding.viewPager2)
    }
}