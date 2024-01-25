package com.projectkr.shell

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.io.DataOutputStream
import android.widget.TextView

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about)

        val tvAppName: TextView = findViewById(R.id.tvAppName)
        val tvAppVersion: TextView = findViewById(R.id.tvAppVersion)
        val tvAppDescription: TextView = findViewById(R.id.tvAppDescription)
        val btnRestartAdb: Button = findViewById(R.id.btnRestartAdb)
        val btnKillAdb: Button = findViewById(R.id.btnKillAdb)
        val btnOpenBaidu: Button = findViewById(R.id.btnOpenBaidu)
        val btnClose: Button = findViewById(R.id.btnClose)

        // Set your app information
        tvAppName.text = "WearOS管家"
        tvAppVersion.text = "Version 1.0.0"
        tvAppDescription.text = "介绍:\n我也不知道有什么好写的，就这样了，这个工具箱不用Root就可以在手机上给你的WearOS刷机/玩机，说好听点，这个就是WearOS工具箱，说不好听的，就是个OTG工具箱，加上我学习繁忙，做什么酸碱滴定这些，因为我学的是生物专业，有什么bug反馈到我的github，基于pio修改，还有，祝各位新年快乐😆😆😆"

        // Close the activity when the "Close" button is clicked
        btnClose.setOnClickListener {
            finish()
        }

        // Restart ADB when the "Restart ADB" button is clicked
        btnRestartAdb.setOnClickListener {
            executeAdbCommand("start-server")
        }

        // Kill ADB when the "Kill ADB" button is clicked
        btnKillAdb.setOnClickListener {
            executeAdbCommand("kill-server")
        }

        // Open Baidu website when the "Open Baidu" button is clicked
        btnOpenBaidu.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Twmcy/WearOS-Tools/issues"))
            startActivity(intent)
        }
    }

    private fun executeAdbCommand(command: String) {
        try {
            val process = Runtime.getRuntime().exec("su")// 自定义ROOT，比如suu
            val outputStream = DataOutputStream(process.outputStream)
            outputStream.writeBytes("adb $command\n")
            outputStream.writeBytes("exit\n")
            outputStream.flush()
            process.waitFor()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
