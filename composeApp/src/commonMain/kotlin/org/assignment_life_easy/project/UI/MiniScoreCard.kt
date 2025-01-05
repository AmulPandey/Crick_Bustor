package org.assignment_life_easy.project.UI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import org.assignment_life_easy.project.DataClasses.MiniMatchCard
import androidx.compose.ui.input.key.Key.Companion.R
import assignment_life_easy.composeapp.generated.resources.Res
import assignment_life_easy.composeapp.generated.resources.bat
import assignment_life_easy.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.painterResource

@Composable
fun MiniScoreCard(miniMatchCard: MiniMatchCard) {
    val result = miniMatchCard.responseData?.result

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF001E3C))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Top Row: Team Flags and Score
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Team A Flag
                TeamFlag(
                    code = result?.teams?.a?.shortName ?: "",
                    teamImageUrl = result?.teams?.a?.logo,
                    isBatting = result?.settingObj?.currentTeam == "a",
                    modifier = Modifier.size(54.dp)
                )

                // commentry
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    result?.lastCommentary?.let { com ->
                        Text(
                            text = com.primaryText,
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }

                // Team B Flag
                TeamFlag(
                    code = result?.teams?.b?.shortName ?: "",
                    teamImageUrl = result?.teams?.b?.logo,
                    isBatting = result?.settingObj?.currentTeam == "b",
                    modifier = Modifier.size(54.dp)
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Team A Score and Overs (1st Innings)
                result?.teams?.a?.a_1_score?.let { score ->
                    Column(
                        horizontalAlignment = Alignment.Start
                    ) {

                        Text(
                            text = "${score.runs}/${score.wickets}",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )

                        Text(
                            text = "${score.overs} overs",
                            color = Color.Gray,
                            fontSize = 12.sp
                        )
                    }
                } ?: Text(
                    text = "Match yet to begin",
                    color = Color.White,
                    fontSize = 14.sp
                )


                result?.teams?.b?.b_1_score?.let { score ->
                    Column(
                        horizontalAlignment = Alignment.End
                    ) {

                        Text(
                            text = "${score.runs}/${score.wickets}",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )

                        Text(
                            text = "${score.overs} overs",
                            color = Color.Gray,
                            fontSize = 12.sp
                        )
                    }
                } ?: Text(
                    text = "Match yet to begin",
                    color = Color.White,
                    fontSize = 14.sp
                )
            }


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                result?.now?.run_rate?.let { crr ->
                    Text(
                        text = "CRR: $crr",
                        color = Color.Gray,
                        fontSize = 12.sp
                    )
                }


                result?.settingObj?.currentInning?.let { currentInning ->
                    if (currentInning == 2) {
                        result?.now?.req_run_rate?.let { requiredRunRate ->
                            Text(
                                text = "RRR: $requiredRunRate",
                                color = Color.Gray,
                                fontSize = 12.sp
                            )
                        }
                    }
                }


                Text(
                    text = result?.announcement1?.let { ann ->
                        ann
                    } ?: result?.status ?: "",
                    color = Color.Gray,
                    fontSize = 12.sp,
                    maxLines = 1
                )
            }


        }
    }
}

@Composable
private fun TeamFlag(
    code: String,
    teamImageUrl: String? = null,
    isBatting: Boolean = false,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(24.dp)
                .background(Color(0xFF1E4976), RoundedCornerShape(2.dp))
        ) {
            if (teamImageUrl != null) {
                AsyncImage(
                    model = teamImageUrl,
                    contentDescription = "$code flag",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            } else {
                Text(
                    text = code,
                    color = Color.White,
                    fontSize = 8.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }

        Spacer(modifier = Modifier.width(4.dp))


        Box(
            contentAlignment = Alignment.CenterStart,
            modifier = Modifier.wrapContentSize()
        ) {
            Text(
                text = code,
                color = Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium
            )
        }


        if (isBatting) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 2.dp)
                    .size(18.dp)
            ) {
                Image(
                    painter = painterResource(Res.drawable.bat),
                    contentDescription = "Batting Icon",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}





