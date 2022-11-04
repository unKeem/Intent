package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.intent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
   lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**1단계 로그인 버튼을 누르면 LoginActivity로 intent 요청
        binding.btnLogin.setOnClickListener {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        }
        // */
        /*2 단계 mainactivity에서 버튼을 누르면 데이터 전송받는다 로긴액티비티 인텐트 요청
        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            //두값이 널이 아닐때만 전송되도록 방어
            if(!binding.edtId.text.toString().equals("")&& !binding.edtPw.text.toString().equals("")) {
                intent.putExtra("id", binding.edtId.text.toString())
                intent.putExtra("pw", binding.edtPw.text.toString())
                startActivity(intent)
            }else{
                Toast.makeText(this, "MAIN ID PW 오류",Toast.LENGTH_SHORT).show()
            }
        }
        // */
        /*3단계 버튼 누르면 데이터 전송(객체로)loginActivity intent 요청
        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
           val person:Person? = Person(binding.edtId.text.toString(),binding.edtPw.text.toString())
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
       binding.btnLogin.setOnClickListener {
           val intent = Intent(this, LoginActivity::class.java)
          val personParcel:PersonParcel? = PersonParcel(binding.edtId.text.toString(),binding.edtPw.text.toString())
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
        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            val personParcelList = arrayListOf<PersonParcel>()
            personParcelList.add(
                PersonParcel(
                    binding.edtId.text.toString(),
                    binding.edtPw.text.toString()
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
        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            //두값이 널이 아닐때만 전송되도록 방어
            if (!binding.edtId.text.toString().equals("") && !binding.edtPw.text.toString()
                    .equals("")
            ) {
                intent.putExtra("id", binding.edtId.text.toString())
                intent.putExtra("pw", binding.edtPw.text.toString())
                //100번에 해당하는 activity를 확인하는 코드
                startActivityForResult(intent, 100)
            } else {
                Toast.makeText(this, "MAIN ID PW 오류", Toast.LENGTH_SHORT).show()
            }
        }
        // */
        //*6단계 mainactivity에서 버튼을 누르면 데이터 전송하고 loginactivity로부터 결과값 리턴 요청 (오버라이딩 onactivityResult)
        binding.btnLogin2.setOnClickListener {
            val intent = Intent(this, MemberActivity::class.java)
            //두값이 널이 아닐때만 전송되도록 방어
            if (!binding.edtId.text.toString().equals("") && !binding.edtPw.text.toString()
                    .equals("")
            ) {
                intent.putExtra("id", binding.edtId.text.toString())
                intent.putExtra("pw", binding.edtPw.text.toString())
                //100번에 해당하는 activity를 확인하는 코드
                startActivityForResult(intent, 200)
            } else {
                Toast.makeText(this, "MAIN ID PW 오류", Toast.LENGTH_SHORT).show()
            }
        }
        // */

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)

        if (resultCode == RESULT_OK) {
            when (requestCode) {
                //loginactivity에서 여기로 보낸 인텐트를 인식
                100 -> {
                    Log.d("intent","${intent?.getStringExtra("result")}")
                    binding.btnRegister.text = intent?.getStringExtra("result")
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
}