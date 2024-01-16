package com.example.handinaute

import androidx.compose.ui.window.DialogProperties
import com.ramcosta.composedestinations.spec.DestinationStyle

object MyDialogStyle:DestinationStyle.Dialog {
    override val properties: DialogProperties
        get() = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true,
           // decorFitsSystemWindows = true,
            //usePlatformDefaultWidth = true,

        )

}
