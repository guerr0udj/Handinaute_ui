package com.example.handinaute

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddReaction
import androidx.compose.material.icons.outlined.EmojiEmotions
import androidx.compose.material.icons.outlined.MoodBad
import androidx.compose.material.icons.outlined.SentimentNeutral
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.handinaute.custom.AutoResizedText
import com.example.handinaute.destinations.HelpDialogDestination
import com.example.handinaute.destinations.HomeScreenDestination
import com.example.handinaute.ui.theme.BluePrime
import com.example.handinaute.ui.theme.BluePrimery
import com.example.handinaute.ui.theme.HandinauteThemeSingleColorScheme
import com.example.handinaute.ui.theme.OrangeH
import com.example.handinaute.ui.theme.RedErrorPrime
import com.example.handinaute.ui.theme.TurquoisPrime
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

/*

//Activity Class of OnBoard


class Board : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}
 */

/*
@Destination
@Composable
fun ClientRatingDialog(
navigator: DestinationsNavigator?,
modifier: Modifier,
vm:MyDialogViewModel= viewModel(),
){

    Box(

        modifier = Modifier
            .fillMaxSize()
            .background(Color.White.copy(alpha = 0.6f))
            .clickable {
                vm.onDiscardDialog()
            },

        ){

        Card(
            modifier = Modifier.align(Alignment.Center)
                .clip(MaterialTheme.shapes.medium)
                .padding(20.dp)
                .clickable {/*DoNothing*/}
            ,
            //

        ){

        }
    }

}//ClientRatingDialog

 */

@Destination()
//@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientRatingDialog(
    navigator: DestinationsNavigator?,
    onDismissRequest: () -> Unit,
   // onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
    icon: ImageVector,

) {
    val colorIconDefault by remember { mutableStateOf(Color.DarkGray) }
    var clientComment by remember{mutableStateOf("")}
    var colorIconBadMood by remember { mutableStateOf(colorIconDefault) }
    var colorIconNeuralMood by remember { mutableStateOf(colorIconDefault) }
    var colorIconGoodMood by remember { mutableStateOf(colorIconDefault) }
    var idIconClicked by remember {mutableIntStateOf(0)}


    Dialog(
        onDismissRequest = {
            onDismissRequest()
        },
    ){
        Card(
            modifier = Modifier
                .clip(MaterialTheme.shapes.medium)
                .padding(20.dp),

        ){
            Row  (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ){
                Text(
                    text = dialogTitle,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,)

            {
                Text(
                    text = dialogText,
                    fontSize = MaterialTheme.typography.titleMedium.fontSize
                )
            }


            Spacer(modifier = Modifier.size(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                /*TODO : trois box circular shape clickable type selection
                   avec une variable SelectedRating pour enregistrer la selection
                   mettre en evidence visuellement la selection*/
                Box(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(10.dp)
                        .clickable {
                            if (idIconClicked == 1) {
                                idIconClicked = 0
                                colorIconBadMood = colorIconDefault
                            } else {
                                idIconClicked = 1
                                colorIconBadMood = RedErrorPrime
                            }
                            colorIconNeuralMood = colorIconDefault
                            colorIconGoodMood = colorIconDefault
                        },
                    
                ) {
                    Icon(

                        modifier = Modifier
                            .wrapContentSize()
                            .clip(CircleShape)
                            .size(50.dp)
                        ,
                        tint = colorIconBadMood,
                        imageVector = Icons.Outlined.MoodBad,
                        contentDescription ="BadMoodEmoji" )
                }
                Spacer(modifier = Modifier.size(25.dp))

                Box(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(10.dp)
                        .clickable {
                            if (idIconClicked == 2) {
                                idIconClicked = 0
                                colorIconNeuralMood = colorIconDefault
                            } else {
                                idIconClicked = 2
                                colorIconNeuralMood = BluePrime
                            }
                            colorIconBadMood = colorIconDefault
                            colorIconGoodMood = colorIconDefault
                        },


                ){
                    Icon(

                        modifier = Modifier
                            .wrapContentSize()
                            .clip(CircleShape)
                            .size(50.dp)
                            ,
                        tint = colorIconNeuralMood,
                        imageVector = Icons.Outlined.SentimentNeutral,
                        contentDescription ="NeutralMoodEmoji" ,


                        )

                }

                Spacer(modifier = Modifier.size(25.dp))

                Box(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(10.dp)
                        .clickable {
                            if (idIconClicked == 3) {
                                idIconClicked = 0
                                colorIconGoodMood = colorIconDefault
                            } else {
                                idIconClicked = 3
                                colorIconGoodMood = TurquoisPrime
                            }
                            colorIconBadMood = colorIconDefault
                            colorIconNeuralMood = colorIconDefault
                        },
                ){
                    Icon(
                        modifier = Modifier
                            .wrapContentSize()
                            .clip(CircleShape)
                            .size(50.dp)
                        ,
                        tint = colorIconGoodMood,
                        imageVector = Icons.Outlined.EmojiEmotions,
                        contentDescription ="GoodMoodIcon" )

                }
            }

            Spacer(modifier = Modifier.size(10.dp))



            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,)

            {
                TextField(
                    modifier = Modifier
                        .height(100.dp),
                    label = { Text(text ="commentaire" )},
                    placeholder = { Text(text = "avez vous des suggestions?")},
                    value = clientComment,
                    onValueChange ={clientComment=it},

                    //modifier = Modifier.background(color=)
                )
            }

            Divider()

            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ){
                Button(
                    modifier = Modifier
                        .fillMaxWidth(),
                    onClick = {
                        onDismissRequest()
                        navigator?.navigate(HomeScreenDestination)
                              },
                    shape = RectangleShape,

                ) {
                    Text(
                        text ="Terminer"
                    )
                }
            }
        }

    }
}
/*
@Destination
@Composable
fun DialogExamples(
    navigator: DestinationsNavigator?,
    vm:MyDialogViewModel= viewModel(),
) {
    // ...


    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Button(onClick = { vm.onShowDialog() }) {
            Text(text = "DialogExample")

        }
    }

    // ...
    when {
        // ...
        vm.isDialogOpen -> {
            ClientRatingDialog(
                navigator=navigator,
                onDismissRequest = {vm.onDiscardDialog() },
                /*onConfirmation = {
                    vm.onDiscardDialog()
                    navigator?.navigate(HomeScreenDestination)

                },

                 */
                dialogTitle = "Avis Client",
                dialogText = "Votre Avis nous interesse.",
                icon = Icons.Default.AddReaction
            )
        }
    }
}

 */

@Destination(style = MyDialogStyle::class)
@Composable
fun HelpDialog(
navigator: DestinationsNavigator?,
info: String,
){

    Card (
        modifier = Modifier.clip(CircleShape)
    ){
        Text(
            modifier = Modifier.padding(20.dp),
            text = info,
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            fontWeight = FontWeight.ExtraBold,
        )
    }


}



@Destination
@Composable
fun OnBoard(
    navigator: DestinationsNavigator?,
    vm:MyDialogViewModel= viewModel(),
){
    HandinauteThemeSingleColorScheme {

        Box(modifier = Modifier
            .fillMaxSize()
            .background(color = BluePrimery)

        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                ,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly,

                ) {
                Spacer(modifier = Modifier.size(40.dp))
                Row(
                    modifier = Modifier
                        .wrapContentSize(),

                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.Center
                ) {

                    Text(
                        text = "6.66",
                        fontSize = 140.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,

                        )
                    Spacer(modifier = Modifier.size(20.dp))
                    Text(
                        text = "km/h",
                        fontSize = 50.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                }


                Box(
                    modifier = Modifier
                        .padding(20.dp),
                    contentAlignment = Alignment.Center
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(MaterialTheme.shapes.medium)
                            .background(color = MaterialTheme.colorScheme.primaryContainer)
                            .padding(40.dp),

                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        Column(
                            modifier = Modifier
                                .wrapContentSize()
                                .padding(10.dp)
                                .weight(1f),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,

                            ) {

                            /*
                           Text(
        
                                modifier = Modifier
                                .weight(1f),
                                text = "123 km parcourus",
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                textAlign = TextAlign.Center,
                                softWrap = true,
                                maxLines = 2,
                                )
        
                            */

                            AutoResizedText(
                                text = "123 km parcourus",
                                maxLine = 2,
                                style = MaterialTheme.typography.bodyLarge.copy(
                                    fontSize = 30.sp,
                                    fontWeight = FontWeight.Bold
                                ),
                                modifier = Modifier.widthIn(max = 230.dp),
                            )
                        }




                        Column(
                            modifier = Modifier
                                .wrapContentSize()
                                .weight(2f),

                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,


                            ) {
                            Button(
                                colors = ButtonDefaults.buttonColors(OrangeH),
                                onClick = { vm.onShowDialog()  },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(100.dp),
                                shape = RoundedCornerShape(20),

                                ) {
/*
                      Text(
                          text = "Terminer la session",
                          fontSize = 30.sp,
                          textAlign= TextAlign.Center,
                          fontFamily = FontFamily(Font(R.font.bc_alphapipe_l_regular)),
                          softWrap = true,
                          maxLines = 2,
                        )
*/

                                AutoResizedText(
                                    text = "Terminer la session",
                                    maxLine = 2,
                                    style = MaterialTheme.typography.bodyLarge.copy(
                                        fontWeight = FontWeight.Bold
                                    ),
                                    modifier = Modifier,
                                    fontSize = 30.sp,
                                )

                            }

                        }



                        Column(
                            modifier = Modifier
                                .wrapContentSize()
                                .weight(1f),

                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,


                            ) {

                            Button(

                                onClick = {
                                           navigator?.navigate(HelpDialogDestination("+33 755 15 15 15"))
                                          },

                                modifier = Modifier.height(100.dp),
                                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.errorContainer),
                                // .weight(1f),
                                shape = CircleShape,


                                ) {
                                /*
                                    Text(
                                        text = "Help",
                                        fontSize = 30.sp,
                                        textAlign= TextAlign.Center,
                                        fontFamily = FontFamily(Font(R.font.bc_alphapipe_l_regular)),
                                        softWrap = false,
                                    )
        
                                 */


                                AutoResizedText(
                                    text = "Help",
                                    maxLine = 1,
                                    style = MaterialTheme.typography.bodyLarge.copy(
                                        fontWeight = FontWeight.Bold,
                                    ),
                                    fontSize = 30.sp,
                                    modifier = Modifier,

                                    )


                            }
                        }

                    }
                }
            }
            when {
                // ...
                vm.isDialogOpen -> {
                    ClientRatingDialog(
                        navigator=navigator,
                        onDismissRequest = {vm.onDiscardDialog() },
                       /* onConfirmation = { ->
                            navigator?.navigate(HomeScreenDestination)
                        },

                        */
                        dialogTitle = "Avis Client",
                        dialogText = "Votre Avis nous interesse.",
                        icon = Icons.Default.AddReaction // paramètre Non utiliser pour l'instant
                    )
                }
            }
        }//BoxScreen
    }//MaterialTheme
}//OnBoardScreen


@Preview(showBackground = true , device = "spec:width=950dp,height=500dp,dpi=240")
@Composable
fun GreetingPreview2() {
  //  OnBoard(navigator = null)
    /*
   ClientRatingDialog(
       onDismissRequest = { /*TODO*/ },
      // onConfirmation = { /*TODO*/ },
       dialogTitle = "Avis Client",
       dialogText = "Votre Avis Nous interesse",
       icon = Icons.Outlined.AutoAwesome,
       navigator=null,
   )
     */

    OnBoard(navigator = null)

}


