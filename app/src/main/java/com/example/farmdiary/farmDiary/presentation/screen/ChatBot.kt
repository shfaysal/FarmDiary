import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.farmdiary.R

@Composable
fun ChatbotUI(navController: NavController) {

    var messages by remember { mutableStateOf(mutableListOf<Message>()) }
    var textState by remember { mutableStateOf(TextFieldValue("")) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFFF0F0F0)) // Background color for the entire chat
    ) {

        Spacer(modifier = Modifier.height(80.dp))
        // Chat Messages
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(bottom = 16.dp)
        ) {
            // Display chat messages
            for (message in messages) {
                when (message) {
                    is TextMessage -> TextBubble(message.text, isBot = message.isBot)
                    is ImageMessage -> ImageBubble(message.imageRes)
                    is AudioMessage -> AudioBubble(message.audioDuration)
                    else -> ""
                }
            }
        }

        // Input field and send button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .verticalScroll(rememberScrollState()),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Text Field for input
            OutlinedTextField(
                value = textState,
                onValueChange = { textState = it },
                placeholder = { Text("Message ChatBot") },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            )

            // Send Button
            Button(
                onClick = {
                    if (textState.text.isNotBlank()) {
                        messages.add(TextMessage(textState.text, isBot = false))
                        // Simulate bot response
                        messages.add(TextMessage("Yes of course! Here are some images of your land.", isBot = true))
                        textState = TextFieldValue("") // Clear input field
                    }
                }
            ) {
                Text("Send")
            }
        }

        Spacer(modifier = Modifier.height(120.dp))
    }
}

// Message classes
sealed class Message
data class TextMessage(val text: String, val isBot: Boolean) : Message()
data class ImageMessage(val imageRes: Int) : Message()
data class AudioMessage(val audioDuration: String) : Message()

@Composable
fun TextBubble(text: String, isBot: Boolean) {
    val backgroundColor = if (isBot) Color(0xFFE1F5FE) else Color(0xFFE0F2F1)
    val alignment = if (isBot) Alignment.CenterStart else Alignment.CenterEnd

    Box(
        modifier = Modifier
            .padding(vertical = 4.dp)
            .background(backgroundColor, RoundedCornerShape(16.dp))
            .padding(12.dp),
        contentAlignment = alignment
    ) {
        Text(text = text, fontSize = 16.sp)
    }
}

@Composable
fun ImageBubble(imageRes: Int) {
    Image(
        painter = painterResource(id = R.drawable.img),
        contentDescription = "Image message",
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clip(RoundedCornerShape(12.dp))
    )
}

@Composable
fun AudioBubble(duration: String) {
    Row(
        modifier = Modifier
            .padding(vertical = 4.dp)
            .background(Color(0xFFE0E0E0), RoundedCornerShape(12.dp))
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(text = "Audio message - $duration", modifier = Modifier.weight(1f), fontSize = 16.sp)
        // You can replace the Text with an Icon for playback controls
    }
}

@Preview(showBackground = true)
@Composable
fun ChatbotUIPreview() {
//    ChatbotUI()
}
