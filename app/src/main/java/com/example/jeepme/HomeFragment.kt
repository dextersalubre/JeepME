package com.example.jeepme

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Each route card opens RouteDetailActivity with data
        val routes = listOf(
            Triple("12G Labangon - SM", "13-20", R.id.route12G),
            Triple("12D Labangon - Colon", "10-15", R.id.route12D),
            Triple("12L Labangon - Ayala", "13-20", R.id.route12L),
            Triple("12I Labangon - SM", "13-20", R.id.route12I),
            Triple("12J Labangon - SM", "13-20", R.id.route12J)
        )

        for ((name, fare, id) in routes) {
            view.findViewById<LinearLayout>(id)?.setOnClickListener {
                val intent = Intent(requireContext(), RouteDetailActivity::class.java)
                intent.putExtra("ROUTE_NAME", name)
                intent.putExtra("ROUTE_FARE", fare)
                intent.putExtra("ROUTE_STOPS",
                    "Punta Prinsesa - Tres de Abril - Labangon - Carlock St. - " +
                            "Taboan Market - Lakandula St. - Pasil Fish Market - " +
                            "Magallanes - USJ-R - Carbon Market - Magellan's Cross - " +
                            "Cebu City Hall - Plaza Independencia - SM City Cebu")
                startActivity(intent)
            }
        }

        return view
    }
}