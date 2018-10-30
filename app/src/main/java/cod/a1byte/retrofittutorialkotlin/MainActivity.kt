package cod.a1byte.retrofittutorialkotlin

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import cod.a1byte.retrofittutorialkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: BreedsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.viewModel = viewModel
        //binding.rvBreeds.

      //  binding.rvBreeds

//https://medium.com/@soutoss/arquiteturas-em-android-mvvm-kotlin-retrofit-parte-1-2ac77c8a26
//        binding.rvBreeds.adapter = BreedsAdapter(emptyList())
//        binding.rvBreeds.layoutManager = LinearLayoutManager(activity)
//        return binding.root
    }
}
