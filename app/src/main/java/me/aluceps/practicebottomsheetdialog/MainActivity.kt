package me.aluceps.practicebottomsheetdialog

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import me.aluceps.practicebottomsheetdialog.databinding.ActivityMainBinding
import me.aluceps.practicebottomsheetdialog.databinding.FragmentBottomSheetDialogBinding
import me.aluceps.practicebottomsheetdialog.databinding.FragmentBottomSheetDialogStep1Binding
import me.aluceps.practicebottomsheetdialog.databinding.FragmentBottomSheetDialogStep2Binding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.launch.setOnClickListener {
            launchBottomSheetDialog()
        }
    }

    private fun launchBottomSheetDialog() {
        BottomSheetDialogFragment.newInstance()
                .show(supportFragmentManager, "")
    }
}

class BottomSheetDialogFragment : AppCompatDialogFragment() {

    private lateinit var binding: FragmentBottomSheetDialogBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
            BottomSheetDialog(context!!, theme)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentBottomSheetDialogBinding.inflate(inflater, container, false)
        childFragmentManager.replaceFragment(BottomSheetDialogStep1Fragment.newInstance())
        return binding.root
    }

    companion object {
        fun newInstance() = BottomSheetDialogFragment()
    }
}

class BottomSheetDialogStep1Fragment : Fragment() {

    private lateinit var binding: FragmentBottomSheetDialogStep1Binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentBottomSheetDialogStep1Binding.inflate(inflater, container, false)
        binding.next.setOnClickListener {
            fragmentManager?.replaceFragment(BottomSheetDialogStep2Fragment.newInstance())
        }
        return binding.root
    }

    companion object {
        fun newInstance() = BottomSheetDialogStep1Fragment()
    }
}

class BottomSheetDialogStep2Fragment : Fragment() {

    private lateinit var binding: FragmentBottomSheetDialogStep2Binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentBottomSheetDialogStep2Binding.inflate(inflater, container, false)
        binding.prev.setOnClickListener {
            fragmentManager?.replaceFragment(BottomSheetDialogStep1Fragment.newInstance())
        }
        return binding.root
    }

    companion object {
        fun newInstance() = BottomSheetDialogStep2Fragment()
    }
}

fun FragmentManager.replaceFragment(fragment: Fragment) {
    beginTransaction().replace(R.id.content_area, fragment, null).commit()
}