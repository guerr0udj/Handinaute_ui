package com.example.handinaute

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ramcosta.composedestinations.DestinationsNavHost

class MainActivity : ComponentActivity() {

    // val vm by viewModels <DialogViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                DestinationsNavHost(
                    navGraph = NavGraphs.root,
                )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview6() {

}