package com.gerpax.heroesavanzado.ui

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gerpax.heroesavanzado.R
import com.gerpax.heroesavanzado.databinding.FragmentHeroLocationBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class HeroLocationFragment: Fragment(), OnMapReadyCallback {

    private lateinit var map: GoogleMap

    private var _binding: FragmentHeroLocationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHeroLocationBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mapFragment = childFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        val puebla = LatLng(19.03793, -98.20346)
        val mexico = LatLng(19.3529, -99.12766)
        map.addMarker(
            MarkerOptions()
                .position(puebla)
                .title("Puebla")
        )

        map.addMarker(
            MarkerOptions()
                .position(mexico)
                .title("México")
        )

        map.addCircle(CircleOptions().center(puebla).radius(10.0).fillColor(Color.BLACK))
        map.moveCamera(CameraUpdateFactory.newLatLng(mexico))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(mexico, 5f))
    }
}