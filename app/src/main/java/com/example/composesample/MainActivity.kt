package com.example.composesample

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val users = ArrayList<User>()
            users.add(User("Mukesh Yadav",30,"himky02@gmail.com","955xxxxx59"))
            users.add(User("ABC Limited",30,"abc@gmail.com","880xxxxx53"))
            users.add(User("XYZ LTD",30,"xyz@gmail.com","966xxxxx59"))
            users.add(User("Muesh",30,"mukesh@gmail.com","955xxxxx99"))
            users.add(User("Android",30,"android@gmail.com","955xxxxx89"))
            users.add(User("Developer",30,"developer@gmail.com","955xxxxx49"))
            LazyColumnDemo(users)
        }
    }
}

@Composable
fun LazyColumnDemo(users: ArrayList<User>) {
    LazyColumn(modifier = Modifier.fillMaxHeight()) {
        items(items = users, itemContent = { item ->
                ListItemView(item)
        })
    }
}

@Composable
fun ListItemView(user: User) : Unit {
    Card(
        backgroundColor = Color.White,
        elevation = Dp(2F),
        modifier = Modifier.padding(all = 16.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()
            .padding(all = 8.dp)) {
            user.name?.let { Text(text = it,
                 modifier = Modifier.padding(all = 4.dp),
                 textAlign = TextAlign.Start,
                 fontSize = 22.sp,
                color = Color.Black) }
            user.email?.let { Text(text = it,
                modifier = Modifier.padding(all = 4.dp),
                textAlign = TextAlign.Start,
                fontSize = 22.sp,
                color = Color.Blue) }
            user.age?.let { Text(text = it.toString(),
                modifier = Modifier.padding(all = 4.dp),
                textAlign = TextAlign.Start,
                fontSize = 22.sp,
                color = Color.Green) }
            user.phone?.let { Text(text = it,
                modifier = Modifier.padding(all = 4.dp),
                textAlign = TextAlign.Start,
                fontSize = 22.sp,
                color = Color.Gray) }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    LazyColumnDemo(Arrays.asList(User("Mukesh Yadav",30,"himky02@gmail.com","955xxxxx59")) as ArrayList<User>)
}

