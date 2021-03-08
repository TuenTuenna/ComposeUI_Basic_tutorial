package com.example.compostbasic

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compostbasic.ui.theme.CompostBasicTheme
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompostBasicTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("안드입니다?!")
                }
            }
        }
    }
}

// 뷰
@Composable
fun Greeting(name: String) {
    Scaffold(topBar = {
        TopAppBar(title = {Text("정대리 안드 앱!!")}
            ,backgroundColor = Color(0xfff25287))  },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(onClick = {}){
            Text("클릭")
            } },
    ) {
//        Text(text = "안녕하세요?! $name!")
        MyComposableView()
    }
}

@Composable
fun MyRowItem(){
    Log.d("TAG", "MyRowItem: ")
    // 호리젠탈 리니어
    Row(
        Modifier
            .padding(10.dp)
            .background(Color(0xffeaffd0))
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "안녕하세요?!",
            Modifier
                .padding(all = 10.dp)
                .background(Color.Yellow))
        Spacer(modifier = Modifier.size(10.dp))
        Text(text = "안녕하세요?!")
        Spacer(modifier = Modifier.size(10.dp))
        Text(text = "안녕하세요?!")
    }
}

@Composable
fun MyComposableView(){
    Log.d("TAG", "MyComposableView: ")

    // 버티칼 리니어
    Column(
        Modifier
            .background(Color.Green)
            .verticalScroll(rememberScrollState())
    ){
        for (i in 0..30){
            MyRowItem()
        }
    }

}


// 미리보기
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CompostBasicTheme {
        Greeting("안드입니다")
    }
}
