package org.nevrozq.iosliquid

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.UIKitInteropProperties
import androidx.compose.ui.viewinterop.UIKitView
import androidx.compose.ui.window.ComposeUIViewController
import kotlinx.cinterop.ExperimentalForeignApi
import platform.UIKit.UIButton
import platform.UIKit.UIButtonConfiguration
import platform.UIKit.UISwitch
import platform.UIKit.UIView

@OptIn(ExperimentalComposeUiApi::class, ExperimentalForeignApi::class)
fun MainViewController() = ComposeUIViewController {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        App()
        Column {

            UIKitView(
                factory = {

                    val container = UIView()

                    val button = UIButton().apply {
                        translatesAutoresizingMaskIntoConstraints = false
                        setConfiguration(
                            UIButtonConfiguration.glassButtonConfiguration().apply {
                                setTitle("Кнопка!")
                            }
                        )
                    }


                    button.layer.masksToBounds = true // removes shadow because of glassButtonConfiguration

                    container.addSubview(button)

                    val verticalPadding = 20.0
                    val horizontalPadding = 20.0
                    button.leadingAnchor.constraintEqualToAnchor(container.leadingAnchor, horizontalPadding).active = true
                    button.trailingAnchor.constraintEqualToAnchor(container.trailingAnchor, -horizontalPadding).active = true
                    button.topAnchor.constraintEqualToAnchor(container.topAnchor, verticalPadding).active = true
                    button.bottomAnchor.constraintEqualToAnchor(container.bottomAnchor, -verticalPadding).active = true



                    container
                },
                properties = UIKitInteropProperties(placedAsOverlay = true)
            )


            UIKitView(
                factory = {
                    UISwitch()
                },
                properties = UIKitInteropProperties(placedAsOverlay = true)
            )
        }
    }
}

