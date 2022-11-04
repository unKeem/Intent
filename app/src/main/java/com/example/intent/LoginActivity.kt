package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.intent.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*2 단계 MainActivity에서 login버튼 클릭했을때 LoginActivity로 값을 넘기고 보여줌
        if (!intent.getStringExtra("id").equals("") && !intent.getStringExtra("pw").equals("")) {
            binding.tvLoginid.text = intent.getStringExtra("id")
            binding.tvLoginpw.text = intent.getStringExtra("pw")
        } else {
            Toast.makeText(this, "id, pwd error", Toast.LENGTH_SHORT).show()
            // 오류나서 다시 화면을 끝내고 돌아가는
            finish()
        }
        // */
        /*3단계 버튼 누르면 데이터 전송(객체로)loginActivity intent 요청
         if (intent.hasExtra("person")) {
            val person = intent.getSerializableExtra("person") as Person
             binding.tvLoginid.text = person.id
             binding.tvLoginpw.text = person.pw

             Log.d("SUB 전달 오류 발생","${person.toString()}")
         } else {
             Toast.makeText(this, "id, pwd error", Toast.LENGTH_SHORT).show()
             // 오류나서 다시 화면을 끝내고 돌아가는
             finish()
         }
         // */
        /*4단계 버튼 누르면 객체 전송(Parcelable)빠름
        if (intent.hasExtra("personParcel")) {
           val personParcel = intent.getParcelableExtra<PersonParcel>("personParcel")
            binding.tvLoginid.text = personParcel?.id
            binding.tvLoginpw.text = personParcel?.pw

            Log.d("intent","${personParcel.toString()}")
        } else {
            Toast.makeText(this, "id, pwd error", Toast.LENGTH_SHORT).show()
            // 오류나서 다시 화면을 끝내고 돌아가는
            finish()
        }
        // */
        /*5단계  메인에서버튼 누르면(serializable) ArrayList전달 LoginActivity 인텐트 요청
        if (intent.hasExtra("personParcelList")) {
            val personParcelList = intent.getParcelableArrayListExtra<PersonParcel>("personParcelList")
            binding.tvLoginid.text = personParcelList?.get(0)?.id
            binding.tvLoginpw.text = personParcelList?.get(0)?.pw

            Log.d("com.example.intent","${personParcelList.toString()}")
        } else {
            Toast.makeText(this, "id, pwd error", Toast.LENGTH_SHORT).show()
            // 오류나서 다시 화면을 끝내고 돌아가는
            finish()
        }
        // */
        //*6단계 mainactivity에서 버튼을 누르면 데이터 전송하고 loginactivity로부터 결과값 리턴 요청 (오버라이딩 onactivityResult)
        if (!intent.getStringExtra("id").equals("") && !intent.getStringExtra("pw").equals("")) {
            binding.tvLoginid.text = intent.getStringExtra("id")
            binding.tvLoginpw.text = intent.getStringExtra("pw")

        } else {
            Toast.makeText(this, "id, pwd error", Toast.LENGTH_SHORT).show()
            // 오류나서 다시 화면을 끝내고 돌아가는
            finish()
        }
        binding.btnReturn.setOnClickListener{
            intent.putExtra("result", "${binding.tvLoginid.text} ")
            setResult(RESULT_OK)
            finish()
        }
        // */

    }
}