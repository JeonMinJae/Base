package mj.project.base

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult

class QrcodeScanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qrcode_scan)

        initQRcodeScanner()
    }

    private fun initQRcodeScanner() {
        val integrator  = IntentIntegrator(this)
        integrator.setBeepEnabled(false) //  QR코드 스캔시 소리 나게 하려면 true 아니면 false로 지정해주시면 됩니다.
        integrator.setOrientationLocked(true) // 세로,가로 모드를 고정 시켜주는 역할
        integrator.setPrompt("QR코드를 인증해주세요.") // 밑에 원하는 문구를 넣어주시면 됩니다
        integrator.initiateScan() // Zxing 라이브러리 QR코드 스캐너가 보여지게 되고, QR코드 스캔의 결과 값은 onActivityResult 함수로 전달
    }

    // qr코드 주소 반환 시에
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result : IntentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)

        if(result !=null) {
            if(result.contents == null) {
                // qr코드에 주소가 없거나, 뒤로가기 클릭 시
                Toast.makeText(this,"QR코드 인증이 취소되었습니다.", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                //qr코드에 주소가 있을때 -> 주소에 관한 Toast 띄우는 함수 호출
                Toast.makeText(this,result.contents,Toast.LENGTH_SHORT).show()
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }

    }
}