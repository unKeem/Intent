package com.example.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.intent.databinding.ActivityMemberBinding

class MemberActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMemberBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //*6단계 mainactivity에서 버튼을 누르면 데이터 전송하고 loginactivity로부터 결과값 리턴 요청 (오버라이딩 onactivityResult)
        if (!intent.getStringExtra("id").equals("") && !intent.getStringExtra("pw").equals("")) {
            Toast.makeText(this, "${intent.getStringExtra("id")}", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "id, pwd error", Toast.LENGTH_SHORT).show()
            // 오류나서 다시 화면을 끝내고 돌아가는
            finish()
        }
        binding.memberBtnReturn.setOnClickListener{
            intent.putExtra("result", "${intent.getStringExtra("id")} ")
            setResult(RESULT_OK,intent)
            finish()
        }
        // */


    }
}