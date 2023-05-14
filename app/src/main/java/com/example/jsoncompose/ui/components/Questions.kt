package com.example.jsoncompose.ui.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jsoncompose.common.AppColors
import com.example.jsoncompose.ui.viewmodel.QuestionsViewModel

/**
 * @author : Mingaleev D
 * @data : 14.05.2023
 */

@Composable
fun Questions(viewModel: QuestionsViewModel) {
   val questions = viewModel.data.value.data?.toMutableList()
   if (viewModel.data.value.loading == true) {
      CircularProgressIndicator()
   } else {
      questions?.forEach { item ->
         Log.d("Result", "Questions: ${item.question}")
      }
   }
}

@Preview
@Composable
fun QuestionDisplay() {
   Surface(modifier = Modifier
      .fillMaxWidth()
      .fillMaxHeight()
      .padding(4.dp),
           color = AppColors.mDarkPurple
   ) {
      Column(modifier = Modifier.padding(12.dp),
             verticalArrangement = Arrangement.Top,
             horizontalAlignment = Alignment.Start
      ) {

      }
   }
}

@Preview
@Composable
fun QuestionsTracker(counter: Int = 10,
                     outOf: Int = 100
) {
   Text(text = buildAnnotatedString {
      withStyle(style = ParagraphStyle(textIndent = TextIndent.None)) {
         withStyle(style = SpanStyle(color = AppColors.mLightGray,
                                     fontWeight = FontWeight.Bold,
                                     fontSize = 27.sp
         )
         ) {
            append("Question $counter/")
            withStyle(style = SpanStyle(color = AppColors.mLightGray,
                                        fontWeight = FontWeight.Light,
                                        fontSize = 14.sp
            )
            ) {
               append("$outOf")
            }

         }
      }
   },
        modifier = Modifier.padding(20.dp)
   )

}
