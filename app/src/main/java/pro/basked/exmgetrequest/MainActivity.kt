package pro.basked.exmgetrequest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import pro.basked.exmgetrequest.databinding.ActivityMainBinding
import pro.basked.exmgetrequest.repository.Repository

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Init Binding
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponce.observe(this, Observer { response ->
            if (response.isSuccessful) {
                Log.d("Responce", response.body()?.userId.toString())
                Log.d("Responce", response.body()?.id.toString())
                Log.d("Responce", response.body()?.title!!)
                Log.d("Responce", response.body()?.body!!)


                binding.txtView.text = response.body()?.title!!
            } else {

                binding.txtView.text = response.errorBody().toString()
                Log.d("Response", response.errorBody().toString())
            }
        })

    }
}