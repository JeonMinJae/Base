package mj.project.dialog

import android.content.DialogInterface
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AlertDialog
import java.text.SimpleDateFormat
import java.util.*

class MainActivity2 : AppCompatActivity() {
    // SharedPreferences 접근 이름, 저장 데이터 초기화
    var NameSPreferences = "Day"
    var strSDFormatDay = "0"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // '오늘 그만 보기' 기능을 위한 날짜 획득
        val currentTime: Long = System.currentTimeMillis()
        // 현재 시간을 msec 단위로 얻음
        val TodayDate = Date(currentTime) // 현재 시간 Date 변수에 저장
        val SDFormat = SimpleDateFormat("dd")
        strSDFormatDay = SDFormat.format(TodayDate) // 'dd' 형태로 포맷 변경

        // SharedPreferences 획득
        val SPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val strSPreferencesDay = SPreferences.getString(NameSPreferences, "0");
        // 공지사항 알림창 띄움
        if ((Integer.parseInt(strSDFormatDay) - Integer.parseInt(strSPreferencesDay)) != 0) {
            // Dialog Message 설정

            var listener = DialogInterface.OnClickListener { _, i ->
                when (i) {
                    DialogInterface.BUTTON_POSITIVE ->
                        finish()
                    DialogInterface.BUTTON_NEUTRAL -> {
                        var SPreferencesEditor: SharedPreferences.Editor = SPreferences.edit()
                        SPreferencesEditor.putString(
                            NameSPreferences,
                            strSDFormatDay
                        ) // 오늘 '일(day)' 저장
                        SPreferencesEditor.commit() // important to save the preference
                        finish() // dialog 닫기
                    }
                    DialogInterface.BUTTON_NEGATIVE ->
                        finish()
                }
            }

            // AlertDialog 정의
            var MainAlertDialog = AlertDialog.Builder(this);
            MainAlertDialog.setTitle("공지사항"); // Title 설정
            MainAlertDialog.setIcon(android.R.drawable.ic_dialog_info); // Icon 설정
            MainAlertDialog.setMessage("공지사항 샘플입니다."); // 메시지 설정
            // positive 버튼 설정
            MainAlertDialog.setPositiveButton("취소", listener)
            // Negative 버튼 설정
            MainAlertDialog.setNegativeButton("이동", listener)
            // Neutral 버튼 설정
            MainAlertDialog.setNeutralButton("오늘 그만 보기", listener)
            // AlertDialog 화면 출력
            MainAlertDialog.show();

        }
    }

}