package com.example.smartcarapp.ui.fragments_Admin
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TextView
import com.example.smartcarapp.R
class AdminInicioFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {




        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_admin_inicio, container, false)
    }

}