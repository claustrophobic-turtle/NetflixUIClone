package com.example.netflixclone

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.netflixclone.ui.theme.NetflixCloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
                    .verticalScroll(rememberScrollState())
            ) {
                TopAppSection()
                NetflixContentChooser()
                FeaturedMovieSection()
                AddMovieList(movieType = "Watch It Again")
                AddMovieList(movieType = "New Releases")
                AddMovieList(movieType = "Action Movies")
                AddMovieList(movieType = "Romance Movies")
                AddMovieList(movieType = "Watch It Again")
                AddMovieList(movieType = "New Releases")
                AddMovieList(movieType = "Action Movies")
                AddMovieList(movieType = "Romance Movies")
            }
        }
    }

    @Composable
    fun TopAppSection() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(top = 6.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            androidx.compose.foundation.Image(painter = painterResource(id = R.drawable.netflix_main_icon), contentDescription ="icon", modifier = Modifier.size(60.dp))

            Row() {
                androidx.compose.foundation.Image(painter = painterResource(id = R.drawable.ic_search), contentDescription ="search", modifier = Modifier
                    .padding(end = 12.dp)
                    .size(36.dp))
                androidx.compose.foundation.Image(painter = painterResource(id = R.drawable.ic_profile), contentDescription ="profile", modifier = Modifier
                    .padding(end = 6.dp)
                    .size(36.dp))
            }

        }
    }

    @Composable
    fun NetflixContentChooser() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(horizontal = 30.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "TV Shows", color = Color.LightGray, fontSize = 20.sp)
            Text(text = "Movies", color = Color.LightGray, fontSize = 20.sp)
            Row() {
                Text(text = "Categories", color = Color.LightGray, fontSize = 20.sp)
                androidx.compose.foundation.Image(painter = painterResource(id = R.drawable.ic_drop), contentDescription = "icon_drop")
            }
        }
    }

    @Composable
    fun FeaturedMovieSection() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(top = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            androidx.compose.foundation.Image(painter = painterResource(id = R.drawable.movie_5), contentDescription = "fm5", modifier = Modifier.size(280.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 60.dp, start = 80.dp, end = 80.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Drama", color = Color.White)
                Text(text = "Sport", color = Color.White)
                Text(text = "Romance", color = Color.White)
                Text(text = "Suspense", color = Color.White)
            }

            Row(
                modifier = Modifier
                    .padding(top = 20.dp, start = 80.dp, end = 80.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    androidx.compose.foundation.Image(painter = painterResource(id = R.drawable.ic_add), contentDescription = "add")
                    Text(text = "My List", color = Color.LightGray, fontSize = 10.sp)
                }

                Button(onClick = {},
                    colors = ButtonDefaults.buttonColors(Color.White),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Text(text = "Play", color = Color.Black, fontSize = 18.sp)
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    androidx.compose.foundation.Image(painter = painterResource(id = R.drawable.ic_info), contentDescription = "info")
                    Text(text = "Info", color = Color.LightGray, fontSize = 10.sp)
                }
            }
        }
    }

    @Composable
    fun AddMovieList(movieType: String) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
        ) {
            Text(text = movieType, fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Color.LightGray, modifier = Modifier.padding(top = 20.dp, start = 12.dp))
            LazyRow(
                modifier = Modifier.padding(top = 6.dp)
            ) {
                itemsIndexed(getRandomMovieList()) { index, item ->
                    MovieItemUiModel(imageRes = item.image)
                }
            }
        }
    }

    @Composable
    fun MovieItemUiModel(
        imageRes: Int
    ) {
        androidx.compose.foundation.Image(painter = painterResource(id = imageRes), contentDescription = "m2", modifier = Modifier
            .height(180.dp)
            .width(132.dp))
    }

    fun getRandomMovieList(): List<MovieItemModel> {
        val listOfMovies = mutableListOf<MovieItemModel>()
        listOfMovies.add(MovieItemModel(R.drawable.movie_1))
        listOfMovies.add(MovieItemModel(R.drawable.movie_2))
        listOfMovies.add(MovieItemModel(R.drawable.movie_3))
        listOfMovies.add(MovieItemModel(R.drawable.movie_4))
        listOfMovies.add(MovieItemModel(R.drawable.movie_5))
        listOfMovies.add(MovieItemModel(R.drawable.movie_6))
        listOfMovies.add(MovieItemModel(R.drawable.movie_7))

        listOfMovies.shuffle()

        return listOfMovies
    }
}

data class MovieItemModel(
    val image: Int
)