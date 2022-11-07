package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.intent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*1단계 로그인 버튼을 누르면 LoginActivity로 intent 요청
        binding.mainBtnLogin.setOnClickListener {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        }
        // */
        /*2 단계 mainactivity에서 버튼을 누르면 데이터 전송받는다 로긴액티비티 인텐트 요청
        binding.mainBtnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            //두값이 널이 아닐때만 전송되도록 방어
            if(!binding.mainEdtId.text.toString().equals("")&& !binding.mainEdtPw.text.toString().equals("")) {
                intent.putExtra("id", binding.mainEdtId.text.toString())
                intent.putExtra("pw", binding.mainEdtPw.text.toString())
                startActivity(intent)
            }else{
                Toast.makeText(this, "MAIN ID PW 오류",Toast.LENGTH_SHORT).show()
            }
        }
        // */
        /*3단계 버튼 누르면 데이터 전송(객체로)loginActivity intent 요청
        binding.mainBtnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
           val person:Person? = Person(binding.mainEdtId.text.toString(),binding.mainEdtPw.text.toString())
            //두값이 널이 아닐때만 전송되도록 방어??
            if(person!=null) {
                intent.putExtra("person", person)
                startActivity(intent)
            }else{
                Toast.makeText(this, "MAIN person 객체 오류",Toast.LENGTH_SHORT).show()
            }
        }
        // */
        /*4단계 버튼 누르면 객체 전송(속도빠름)
       binding.mainBtnLogin.setOnClickListener {
           val intent = Intent(this, LoginActivity::class.java)
          val personParcel:PersonParcel? = PersonParcel(binding.mainEdtId.text.toString(),binding.mainEdtPw.text.toString())
           //두값이 널이 아닐때만 전송되도록 방어??
           if(personParcel!=null) {
               intent.putExtra("personParcel", personParcel)
               startActivity(intent)
           }else{
               Toast.makeText(this, "MAIN person 객체 오류",Toast.LENGTH_SHORT).show()
           }
       }
       // */
        /*5단계 버튼 누르면(serializable) ArrayList전달 LoginActivity 인텐트 요청
         binding.mainBtnLogin.setOnClickListener {
             val intent = Intent(this, LoginActivity::class.java)
             val personParcelList = arrayListOf<PersonParcel>()
             personParcelList.add(
                 PersonParcel(
                     binding.mainEdtId.text.toString(),
                     binding.mainEdtPw.text.toString()
                 )
             )
             personParcelList.add(PersonParcel("aaaa", "1111"))
             personParcelList.add(PersonParcel("bbbb", "2222"))
             personParcelList.add(PersonParcel("cccc", "3333"))



             if (personParcelList != null) {
                 intent.putExtra("personParcelList", personParcelList)
                 startActivity(intent)
             } else {
                 Toast.makeText(this, "MAIN personParcelList 객체 오류", Toast.LENGTH_SHORT).show()
             }
         }
         // */
        /*6단계 mainactivity에서 버튼을 누르면 데이터 전송하고 loginactivity로부터 결과값 리턴 요청 (오버라이딩 onactivityResult)
        binding.mainBtnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            //두값이 널이 아닐때만 전송되도록 방어
            if (!binding.mainEdtId.text.toString().equals("") && !binding.mainEdtPw.text.toString()
                    .equals("")
            ) {
                intent.putExtra("id", binding.mainEdtId.text.toString())
                intent.putExtra("pw", binding.mainEdtPw.text.toString())
                //100번에 해당하는 activity를 확인하는 코드
                startActivityForResult(intent, 100)
            } else {
                Toast.makeText(this, "MAIN ID PW 오류", Toast.LENGTH_SHORT).show()
            }
        }
        // */
        /*6?단계 mainactivity에서 버튼을 누르면 데이터 전송하고 loginactivity로부터 결과값 리턴 요청 (오버라이딩 onactivityResult)
        binding.btnLogin2.setOnClickListener {
            val intent = Intent(this, MemberActivity::class.java)
            //두값이 널이 아닐때만 전송되도록 방어
            if (!binding.mainEdtId.text.toString().equals("") && !binding.mainEdtPw.text.toString()
                    .equals("")
            ) {
                intent.putExtra("id", binding.mainEdtId.text.toString())
                intent.putExtra("pw", binding.mainEdtPw.text.toString())
                //100번에 해당하는 activity를 확인하는 코드
                startActivityForResult(intent, 200)
            } else {
                Toast.makeText(this, "MAIN ID PW 오류", Toast.LENGTH_SHORT).show()
            }
        }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)

        if (resultCode == RESULT_OK) {
            when (requestCode) {
                //loginactivity에서 여기로 보낸 인텐트를 인식
                100 -> {
                    Log.d("intent","${intent?.getStringExtra("result")}")
                    binding.mainBtnRegister.text = intent?.getStringExtra("result")
                }
                //memberActivity에서 여기로 보낸 인텐트를 인식
                200 -> {
                    Log.d("intent","${intent?.getStringExtra("result")}")
                    binding.btnLogin2.text = intent?.getStringExtra("result")
                }
                300 -> {}
                else -> {}
            }
        } else{
            Toast.makeText(applicationContext,"인텐트 리턴 오류", Toast.LENGTH_SHORT).show()
        }
    }
        // */

        //* 7단계 onActivityResult콜백기능을 requestLauncher 설계한다 (구조가 다름. 변수 밑에 콜백함수가 붙음)
        val requestLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {//콜백함수
            Log.d("intent", "${it.data?.getStringExtra("result")}")
            binding.mainBtnRegister.text = it.data?.getStringExtra("result")
        }

        val requestLauncher2: ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {//콜백함수
            Log.d("intent", "${it.data?.getStringExtra("result")}")
            binding.mainBtnRegister.text = it.data?.getStringExtra("result")
        }

        binding.mainBtnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            //두값이 널이 아닐때만 전송되도록 방어
            if (!binding.mainEdtId.text.toString().equals("") && !binding.mainEdtPw.text.toString()
                    .equals("")
            ) {
                intent.putExtra("id", binding.mainEdtId.text.toString())
                intent.putExtra("pw", binding.mainEdtPw.text.toString())
                //100번에 해당하는 activity를 확인하는 코드
                requestLauncher.launch(intent)
            } else {
                Toast.makeText(this, "MAIN ID PW 오류", Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnLogin2.setOnClickListener {
            val intent = Intent(this, MemberActivity::class.java)
            //두값이 널이 아닐때만 전송되도록 방어
            if (!binding.mainEdtId.text.toString().equals("") && !binding.mainEdtPw.text.toString()
                    .equals("")
            ) {
                intent.putExtra("id", binding.mainEdtId.text.toString())
                intent.putExtra("pw", binding.mainEdtPw.text.toString())
                //100번에 해당하는 activity를 확인하는 코드
                requestLauncher2.launch(intent)
            } else {
                Toast.makeText(this, "MAIN ID PW 오류", Toast.LENGTH_SHORT).show()
            }
        }
    }
}