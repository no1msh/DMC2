package com.monthlycoding.dmc2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.monthlycoding.dmc2.databinding.FragmentHomeBinding
import com.monthlycoding.dmc2.recommendation.RecommendationPagerAdapter

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!! // null 안전성을 보장하기 위해 lateint var 대신 nullable var 사용

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewPager = binding.viewPager
        val adapter = RecommendationPagerAdapter(this)
        viewPager.adapter = adapter
        viewPager.isUserInputEnabled = false
        val tabLayout = binding.tabLayout
        TabLayoutMediator(tabLayout, viewPager, true, false) { tab, position ->
            // 탭 제목을 설정합니다.
            when (position) {
                0 -> tab.text = "전체"
                1 -> tab.text = "놀거리"
                2 -> tab.text = "먹거리"
                3 -> tab.text = "학교꿀팁"

            }
        }.attach()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
