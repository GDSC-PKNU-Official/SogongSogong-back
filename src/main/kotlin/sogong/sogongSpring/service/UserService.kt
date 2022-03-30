package sogong.sogongSpring.service

import org.springframework.stereotype.Service
import sogong.sogongSpring.dto.user.BusinessAuthDto
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL
import javax.transaction.Transactional

@Service
class UserService {
    @Transactional
    fun validateBusiness(businessAuthDto:BusinessAuthDto) : Boolean{
        val urlStr = "http://api.odcloud.kr/api/nts-businessman/v1/validate?serviceKey=fjtSID3mB9LSl73IcoAJ4F0wrHJy0Q1gF6uixrxW5mJxTdDiTBxRtsgqysKBtjt6YZlPr84Mmj2ernNmKTRWAg=="
        val url = URL(urlStr)

        val urlConnection : HttpURLConnection = url.openConnection() as HttpURLConnection
        urlConnection.requestMethod = "POST"
        urlConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8")
        urlConnection.doOutput = true

        businessAuthDto.startDate = businessAuthDto.startDate.replace(" ", "")
        businessAuthDto.startDate = businessAuthDto.startDate.replace("-","")

        val bw = BufferedWriter(OutputStreamWriter(urlConnection.outputStream))
        bw.write("{\"businesses\": [{\"b_no\" : \"" + businessAuthDto.num + "\"" +
                ",\"start_dt\" : \""+ businessAuthDto.startDate + "\"" +
                ",\"p_nm\" : \""+ businessAuthDto.pName + "\"}]}")
        bw.flush()
        bw.close()

        val br = BufferedReader(InputStreamReader(urlConnection.inputStream, "UTF-8"))
        val str_Filter = br.readLine().split("\"valid\"")[1].startsWith(":\"01\"")
        return str_Filter
    }
}
