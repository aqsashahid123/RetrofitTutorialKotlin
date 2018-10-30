package cod.a1byte.retrofittutorialkotlin

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.support.v7.widget.LinearLayoutManager
import cod.a1byte.retrofittutorialkotlin.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: BreedsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.viewModel = viewModel
     //   rvBreeds.adapter =
//       binding.rvBreeds.adapter
        createViewModel()
        binding.viewModel = viewModel
        binding.rvBreeds.adapter = BreedsAdapter(emptyList())
        binding.rvBreeds.layoutManager = LinearLayoutManager(this)

    }
    fun createViewModel(): BreedsViewModel {
        val retrofit = Retrofit.Builder().baseUrl("http://dog.ceo/api/").addConverterFactory(GsonConverterFactory.create()).build()
        val dogCeoDataSource = DogCeoDataSource(retrofit.create(DogCeoApi::class.java))
        val repository = BreedRepository(dogCeoDataSource)
        return BreedsViewModel(repository, applicationContext)
    }
}
