package org.nevrozq.iosliquid

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource

import composeiosnativeliquid.composeapp.generated.resources.Res
import composeiosnativeliquid.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme(
        colorScheme = if (isSystemInDarkTheme()) darkColorScheme() else with(lightColorScheme()) {
            this.copy(
                surface = this.primaryContainer.copy(alpha = .7f) // like lerp with background
            )
        }
    ) {
        Surface {
            var showContent by remember { mutableStateOf(false) }
            LazyColumn(
                modifier = Modifier
                    .safeContentPadding()
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                item(key = "topPadding") {
                    Spacer(Modifier.height(100.dp))
                }
                item(key = "init") {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Button(onClick = { showContent = !showContent }) {
                            Text("Click me!")
                        }

                        AnimatedVisibility(showContent) {
                            val greeting = remember { Greeting().greet() }
                            Column(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                                Image(painterResource(Res.drawable.compose_multiplatform), null)
                                Text("Compose: $greeting")
                            }
                        }
                    }
                }

                item(key = "white") {
                    Box(Modifier.fillMaxWidth().height(80.dp).background(Color.White))
                }
                item(key = "black") {
                    Box(Modifier.fillMaxWidth().height(80.dp).background(Color.Black))
                    Spacer(Modifier.height(80.dp))
                }

                items(count = 30) {
                    Text("Hello, world!")
                }
                item(key = "bottomPadding") {
                    Spacer(Modifier.height(200.dp))
                }
            }
        }
    }
}