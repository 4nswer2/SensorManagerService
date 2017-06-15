package jp.gr.java_conf.atle42.sensormanagerservice

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var start: Button
    private lateinit var stop : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        start = findViewById(R.id.start) as Button
        stop  = findViewById(R.id.stop) as Button

        start.setOnClickListener { startService(Intent(this, SensorManagerService::class.java)) }
        stop.setOnClickListener { stopService(Intent(this, SensorManagerService::class.java)) }
    }
}
