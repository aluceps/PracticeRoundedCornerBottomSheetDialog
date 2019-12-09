package me.aluceps.practicebottomsheetdialog

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetDialog
import me.aluceps.practicebottomsheetdialog.databinding.ActivityMainBinding
import me.aluceps.practicebottomsheetdialog.databinding.FragmentBottomSheetDialogBinding

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
        return binding.root
    }

    companion object {
        fun newInstance() = BottomSheetDialogFragment()
    }
}