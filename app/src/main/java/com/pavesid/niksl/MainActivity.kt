package com.pavesid.niksl

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pavesid.niksl.databinding.ActivityMainBinding
import com.pavesid.niksl.extensions.open
import com.pavesid.niksl.ui.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint
import nl.joery.animatedbottombar.AnimatedBottomBar

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.setOnTabSelectListener(object :
            AnimatedBottomBar.OnTabSelectListener {
            override fun onTabSelected(
                lastIndex: Int,
                lastTab: AnimatedBottomBar.Tab?,
                newIndex: Int,
                newTab: AnimatedBottomBar.Tab
            ) {
                when (newIndex) {
                    0 -> {
                    }
                    1 -> {
                        supportFragmentManager.open {
                            add(R.id.container, HomeFragment.newInstance(), null)
                        }
                    }
                    2 -> {
                    }
                }
            }

            // An optional method that will be fired whenever an already selected tab has been selected again.
            override fun onTabReselected(index: Int, tab: AnimatedBottomBar.Tab) {
            }
        })
    }
}
