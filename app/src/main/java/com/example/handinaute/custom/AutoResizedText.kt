package com.example.handinaute.custom


import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.isUnspecified
import androidx.compose.ui.unit.sp

@Composable
fun AutoResizedText(
    text:String,
    maxLine:Int,
    style: TextStyle = MaterialTheme.typography.bodyLarge,
    fontSize: TextUnit = style.fontSize,
    modifier: Modifier=Modifier,
    color: Color= style.color,
) {

    var resizedTextSize by remember {
        mutableStateOf(fontSize)
    }
    val defaultFontSize= MaterialTheme.typography.bodyLarge.fontSize

    var shouldDraw by remember{
        mutableStateOf(false)
    }

    Text(

        text =text,
        color=color,
        style=style,
        fontSize = resizedTextSize,
        textAlign = TextAlign.Center,
        modifier=modifier
            .drawWithContent {
                if(shouldDraw){
                    drawContent()
                }
        },
        onTextLayout = {result ->


            if(result.lineCount>maxLine){
                if(style.fontSize.isUnspecified){
                    resizedTextSize= 16.sp
                }
                resizedTextSize *= 0.95

            }else{
                shouldDraw=true
            }

        }
        )
}