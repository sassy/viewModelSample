package io.github.sassy.viewmodelsample

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer


class MainFragment : Fragment() {
    lateinit var root: View

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.main_fragment, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.groupName.observe(this, Observer<String>{ name ->
            val label: TextView = root.findViewById(R.id.groupName)
            label.text = name
        })
        viewModel.members.observe(this, Observer { items ->
            root.findViewById<TextView>(R.id.member1).text = items[0].name
            root.findViewById<TextView>(R.id.member2).text = items[1].name
            root.findViewById<TextView>(R.id.member3).text = items[2].name
            root.findViewById<TextView>(R.id.member4).text = items[3].name
            root.findViewById<TextView>(R.id.member5).text = items[4].name
            root.findViewById<TextView>(R.id.member6).text = items[5].name
        })
        viewModel.loadData()
    }

}
