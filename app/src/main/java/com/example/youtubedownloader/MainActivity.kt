package com.example.youtubedownloader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VideoDownloaderUI()
        }
    }
}

@Composable
fun VideoDownloaderUI() {
    var url by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("Enter YouTube URL") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "YouTube Video Downloader", style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(8.dp))
        
        OutlinedTextField(
            value = url,
            onValueChange = { url = it },
            label = { Text("Enter Video URL") },
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Button(onClick = {
            status = "Downloading..."
            CoroutineScope(Dispatchers.IO).launch {
                val success = downloadVideo(url)
                withContext(Dispatchers.Main) {
                    status = if (success) "Download Complete" else "Download Failed"
                }
            }
        }, modifier = Modifier.fillMaxWidth()) {
            Text("Download Video")
        }
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Text(text = status)
    }
}

fun downloadVideo(url: String): Boolean {
    return try {
        val downloadDir = File("/storage/emulated/0/Download")
        if (!downloadDir.exists()) downloadDir.mkdirs()

        val command = arrayOf("yt-dlp", "-o", "${downloadDir.absolutePath}/%(title)s.%(ext)s", url)
        val process = ProcessBuilder(*command).redirectErrorStream(true).start()
        process.waitFor()
        process.exitValue() == 0
    } catch (e: Exception) {
        false
    }
}

