package com.example.hilt_jetpack.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.example.hilt_jetpack.R
import com.example.hilt_jetpack.databinding.FragmentNavScr2Binding
import com.example.hilt_jetpack.viewModel.NavViewModel
import com.example.hilt_jetpack.worker.CountWorker
import dagger.hilt.android.AndroidEntryPoint

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NavScr2Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */

@AndroidEntryPoint
class NavScr2Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private lateinit var binding: FragmentNavScr2Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNavScr2Binding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val viewmodel : NavViewModel = ViewModelProvider(requireActivity()).get(NavViewModel::class.java)
        val viewmodel : NavViewModel by hiltNavGraphViewModels(R.id.navigation_nav_graph)
        binding.viewModel = viewmodel

        binding.btnStartWork.setOnClickListener {
//            val workRequest = OneTimeWorkRequestBuilder<CountWorker>()   // for more complex work
//                // extra configuration
//                .build()

            val workRequest: WorkRequest = OneTimeWorkRequest.from(CountWorker::class.java)
            WorkManager.getInstance(requireContext()).enqueue(workRequest)
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NavScr2Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NavScr2Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}