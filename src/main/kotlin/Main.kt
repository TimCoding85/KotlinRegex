import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
fun myString(staticText: String, regex: Regex, hasMatch:Boolean) {
    val annotatedString = buildAnnotatedString {
        if (hasMatch) {
            var lastIndex = 0
            var firstIndex = 0
            regex.findAll(staticText).forEach { match ->
                // Text before the match in black
                withStyle(style = SpanStyle(color = Color.Black) ) {
                    append(staticText.substring(lastIndex, match.range.first))
                }
                // Match in black with yellow background
                withStyle(style = SpanStyle(color = Color.Black, background = Color.Yellow)) {
                    append(match.value)
                }
                lastIndex = match.range.last + 1

            }
            // Text after the last match in black
            withStyle(style = SpanStyle(color = Color.Black)) {
                append(staticText.substring(lastIndex))
            }
        } else {
            // All text in black if no match is found
            withStyle(style = SpanStyle(color = Color.Black)) {
                append(staticText)
            }
        }
    }

    BasicText(text = annotatedString)
}

@Composable
fun myTextfield(input: MutableState<String>) {
    OutlinedTextField(
        value = input.value,
        onValueChange = { input.value = it }

    )
}

@Composable
@Preview
fun App() {
    val staticText = "This is a test for Regex"
    val input: MutableState<String> = remember { mutableStateOf("") }

    MaterialTheme {
        Column() {
            myTextfield(input)
            val regex = remember(input.value){
                if (input.value.isNotEmpty()) Regex(input.value, RegexOption.IGNORE_CASE) else Regex("$^", RegexOption.IGNORE_CASE)
            }
            val hasMatch = remember(input.value){
                input.value.isNotEmpty() && regex.containsMatchIn(staticText)
            }
            myString(staticText,regex, hasMatch)
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
