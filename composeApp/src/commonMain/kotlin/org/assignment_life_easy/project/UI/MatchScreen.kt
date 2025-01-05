package org.assignment_life_easy.project.UI

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage

import org.assignment_life_easy.project.OtherDataClasses.VenueStatsCard
import org.assignment_life_easy.project.ViewModel.MatchState

import org.assignment_life_easy.project.ViewModel.MatchViewModel
import org.assignment_life_easy.project.ViewModel.VenueState
import org.koin.compose.koinInject


@Composable
fun MatchScreen(  viewModel: MatchViewModel = koinInject()) {
    val matchState = viewModel.state.collectAsState().value
    val venueState = viewModel.venueState.collectAsState().value
    val scrollState = rememberScrollState()


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        when (matchState) {
            is MatchState.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.White
                )
            }

            is MatchState.Success -> {
                matchState.data?.let { matchData ->
                    Column(modifier = Modifier.verticalScroll(scrollState)) {
                        // Mini Scorecard
                        MiniScoreCard(miniMatchCard = matchData)

                        Spacer(modifier = Modifier.height(16.dp))

                        // Stadium Image Card
                        when (venueState) {
                            is VenueState.Success -> {
                                VenuePhoto(venueState.data)
                            }
                            is VenueState.Loading -> {
                                CircularProgressIndicator(
                                    modifier = Modifier.align(Alignment.CenterHorizontally),
                                    color = Color.White
                                )
                            }
                            is VenueState.Error -> {
                                Text(
                                    text = "Error: ${venueState.error}",
                                    color = Color.Red,
                                    fontSize = 16.sp,
                                    modifier = Modifier.align(Alignment.CenterHorizontally)
                                )
                            }
                        }


                        Spacer(modifier = Modifier.height(16.dp))



                        // Venue Info Row
                        when (venueState) {
                            is VenueState.Success -> {
                                VenueInfoRow(venueState.data)
                            }
                            is VenueState.Loading -> {
                                CircularProgressIndicator(
                                    modifier = Modifier.align(Alignment.CenterHorizontally),
                                    color = Color.White
                                )
                            }
                            is VenueState.Error -> {
                                Text(
                                    text = "Error: ${venueState.error}",
                                    color = Color.Red,
                                    fontSize = 16.sp,
                                    modifier = Modifier.align(Alignment.CenterHorizontally)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        //umpire card
                        when (venueState) {
                            is VenueState.Success -> {
                                Umpire(venueState.data) // Pass the `VenueStatsCard` to the Umpire composable
                            }
                            is VenueState.Loading -> {
                                CircularProgressIndicator(
                                    modifier = Modifier.align(Alignment.CenterHorizontally),
                                    color = Color.White
                                )
                            }
                            is VenueState.Error -> {
                                Text(
                                    text = "Error: ${venueState.error}",
                                    color = Color.Red,
                                    fontSize = 16.sp,
                                    modifier = Modifier.align(Alignment.CenterHorizontally)
                                )
                            }
                        }

                        //waether card
                        when (venueState) {
                            is VenueState.Success -> {
                                Weather(venueState.data)
                            }
                            is VenueState.Loading -> {
                                CircularProgressIndicator(
                                    modifier = Modifier.align(Alignment.CenterHorizontally),
                                    color = Color.White
                                )
                            }
                            is VenueState.Error -> {
                                Text(
                                    text = "Error: ${venueState.error}",
                                    color = Color.Red,
                                    fontSize = 16.sp,
                                    modifier = Modifier.align(Alignment.CenterHorizontally)
                                )
                            }
                        }


                        // Venue Stats Card
                        when (venueState) {
                            is VenueState.Loading -> {
                                CircularProgressIndicator(
                                    modifier = Modifier.align(Alignment.CenterHorizontally),
                                    color = Color.White
                                )
                            }
                            is VenueState.Success -> {
                                VenueStatsCard(statsCard = venueState.data)
                            }
                            is VenueState.Error -> {
                                Text(
                                    text = "Error: ${venueState.error}",
                                    color = Color.Red,
                                    fontSize = 16.sp,
                                    modifier = Modifier.align(Alignment.CenterHorizontally)
                                )
                            }
                        }
                    }
                }
            }

            is MatchState.Error -> {
                Column(
                    modifier = Modifier.align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Error: ${matchState.error}",
                        color = Color.Red,
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(
                        onClick = { /* Retry logic */ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF001E3C)
                        )
                    ) {
                        Text("Retry")
                    }
                }
            }
        }
    }
}


@Composable
fun VenuePhoto(venueInfo: VenueStatsCard) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF1E1E1E))
        ) {
            // Asynchronous Image Loading with Coil
            AsyncImage(
                model = venueInfo.responseData.result.venueDetails.photo,
                contentDescription = "Stadium Image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun VenueInfoRow(venueInfo: VenueStatsCard) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    )
    {

        venueInfo.responseData.result.venueDetails.venue_info.longName?.let {
            Text(
                text = "$it",
                color = Color.White,
                fontSize = 14.sp,
                modifier = Modifier.padding(bottom = 2.dp)
            )
        }
        venueInfo.responseData.result.venueDetails.venue_info.location?.let {
            Text(
                text = " $it",
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 2.dp)
            )
        }

    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.Start
    ){
        venueInfo.responseData.result.related_name?.let {
            Text(
                text = " $it ",
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 2.dp)
            )
        }
        venueInfo.responseData.result.season.name?.let {
            Text(
                text = " $it ",
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Thin,
                modifier = Modifier.padding(bottom = 2.dp)
            )
        }
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        venueInfo.responseData.result.start_date?.let { startDate ->
            // Format and display the date
            val readableDate = "${startDate.str}"

            Text(
                text = readableDate,
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Thin,
                modifier = Modifier.padding(bottom = 2.dp)
            )
        }

    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max),
        shape = RoundedCornerShape(8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF1E1E1E))
                .padding(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),

            ) {
                venueInfo.responseData.result.toss.won?.let { tossWinner ->
                    Text(
                        text = "$tossWinner won the toss and chose to ",
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Thin
                    )
                }

                venueInfo.responseData.result.toss.decision?.let { tossDecision ->
                    Text(
                        text = "$tossDecision first",
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Thin
                    )
                }
            }
        }
    }


}

@Composable
fun Umpire(umpireInfo: VenueStatsCard) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .background(Color(0xFF1E1E1E))
                .padding(16.dp)
        ) {
            Text(
                text = "Umpires",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(48.dp)
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Umpire",
                        color = Color.Gray,
                        fontSize = 14.sp
                    )
                    umpireInfo.responseData.result.firstUmpire?.let { name ->
                        Text(
                            text = "$name",
                            color = Color.White,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Thin
                        )
                    }
                }
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Umpire",
                        color = Color.Gray,
                        fontSize = 14.sp
                    )
                    umpireInfo.responseData.result.secoundUmpire?.let { name ->
                        Text(
                            text = "$name",
                            color = Color.White,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Thin
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(48.dp)
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Third/TV Umpire",
                        color = Color.Gray,
                        fontSize = 14.sp
                    )
                    umpireInfo.responseData.result.thirdUmpire?.let { name ->
                        Text(
                            text = "$name",
                            color = Color.White,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Thin
                        )
                    }
                }
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Referee",
                        color = Color.Gray,
                        fontSize = 14.sp
                    )
                    umpireInfo.responseData.result.matchReferee?.let { name ->
                        Text(
                            text = "$name",
                            color = Color.White,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Thin
                        )
                    }
                }
            }
        }
    }
}



// Weather Card
@Composable
fun Weather(weatherInfo: VenueStatsCard){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .background(Color(0xFF1E1E1E))
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFF1E1E1E))
                ) {
                    // Asynchronous Image Loading with Coil
                    AsyncImage(
                        model = weatherInfo.responseData.result.weather.condition.icon,
                        contentDescription = "Stadium Image",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                weatherInfo.responseData.result.weather.location?.let { location ->
                    Text(
                        text = location,
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                weatherInfo.responseData.result.weather.temp_c?.let { temp ->
                    Text(
                        text = "$temp°C",
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                weatherInfo.responseData.result.weather.condition?.let { condition ->
                    Text(
                        text = condition.text,
                        color = Color.Gray,
                        fontSize = 14.sp
                    )
                }
            }

            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = "Last Updated",
                    color = Color.Gray,
                    fontSize = 14.sp
                )
                weatherInfo.responseData.result.weather.last_updated?.let { it ->
                    Text(
                        text = "$it",
                        color = Color.Gray,
                        fontSize = 14.sp
                    )
                }
            }
        }
    }

}






