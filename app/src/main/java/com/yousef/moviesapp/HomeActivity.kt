package com.yousef.moviesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yousef.moviesapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private val myAdapter by lazy { MyAdapter(getMoviesList()) }
    private lateinit var binding: ActivityHomeBinding

    private fun getMoviesList(): List<Movie> {
        return listOf(
            Movie(
                "Inception",
                "A mind-bending thriller about dreams within dreams.",
                9.0,
                R.drawable.a,
                "16/07/2010"
            ), Movie(
                "The Matrix",
                "A computer hacker learns from mysterious rebels about the true nature of his reality.",
                8.7,
                R.drawable.b,
                "31/03/1999"
            ), Movie(
                "Titanic",
                "A seventeen-year-old aristocrat falls in love with a kind but poor artist aboard the luxurious, ill-fated R.M.S. Titanic.",
                7.8,
                R.drawable.c,
                "19/12/1997"
            ), Movie(
                "The Dark Knight",
                "When the menace known as The Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham.",
                9.0,
                R.drawable.d,
                "18/07/2008"
            ), Movie(
                "Interstellar",
                "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.",
                8.6,
                R.drawable.e,
                "07/11/2014"
            ), Movie(
                "Avatar",
                "A paraplegic marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.",
                7.8,
                R.drawable.f,
                "18/12/2009"
            ), Movie(
                "The Shawshank Redemption",
                "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
                9.3,
                R.drawable.g,
                "14/10/1994"
            ), Movie(
                "Forrest Gump",
                "The presidencies of Kennedy and Johnson, the Vietnam War, the Watergate scandal and other historical events unfold from the perspective of an Alabama man with an extraordinary life story.",
                8.8,
                R.drawable.h,
                "06/07/1994"
            ), Movie(
                "Gladiator",
                "A former Roman General sets out to exact vengeance against the corrupt emperor who murdered his family and sent him into slavery.",
                8.5,
                R.drawable.l,
                "05/05/2000"
            ), Movie(
                "The Godfather",
                "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",
                9.2,
                R.drawable.m,
                "24/03/1972"
            )
        )
    }

    private fun getNewMovies(): List<Movie> {
        return listOf<Movie>(
            Movie(
                "The Matrix",
                "A computer hacker learns about the true nature of his reality and his role in the war against its controllers.",
                8.7,
                R.drawable.f,
                "31/03/1999"
            ),
            Movie(
                "Fight Club",
                "An insomniac office worker and a devil-may-care soap maker form an underground fight club that evolves into something much, much more.",
                8.8,
                R.drawable.g,
                "15/10/1999"
            ),
            Movie(
                "Pulp Fiction",
                "The lives of two mob hitmen, a boxer, a gangster, and his wife intertwine in a series of stories involving violence and redemption.",
                8.9,
                R.drawable.h,
                "14/10/1994"
            ),
            Movie(
                "The Lord of the Rings: The Return of the King",
                "Gandalf and Aragorn lead the World of Men against Sauron's army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.",
                9.0,
                R.drawable.l,
                "17/12/2003"
            ),
            Movie(
                "Star Wars: Episode V - The Empire Strikes Back",
                "After the Rebels are brutally overpowered by the Empire on the ice planet Hoth, Luke Skywalker begins Jedi training with Yoda.",
                8.7,
                R.drawable.m,
                "21/05/1980"
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
// change status bar color
        window.statusBarColor = resources.getColor(R.color.primary)

//      Setup side menu
        setSupportActionBar(findViewById(R.id.toolbar))


// get name from first screen and set it in ui
        val userName: String? = intent.getStringExtra(Constant.name)
        val nameElement: TextView = findViewById(R.id.userName)
        nameElement.text = userName

// recycle view settings
        val recyclerView = findViewById<RecyclerView>(R.id.rv_movies)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = MyAdapter(getMoviesList())
        recyclerView.adapter = adapter


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                Log.d("momo", myAdapter.itemCount.toString())
                myAdapter.updateList(getNewMovies())
                Log.d("momo", myAdapter.itemCount.toString())
                Toast.makeText(this, "${getNewMovies().size} Movies added", Toast.LENGTH_SHORT)
                    .show()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }


}