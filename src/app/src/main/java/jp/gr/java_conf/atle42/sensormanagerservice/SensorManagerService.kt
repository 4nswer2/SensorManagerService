package jp.gr.java_conf.atle42.sensormanagerservice

import android.app.Service
import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Binder
import android.os.IBinder
import android.hardware.SensorEvent
import android.util.Log


class SensorManagerService : Service(), SensorEventListener {

    private lateinit var sensorManager: SensorManager

    override fun onBind(p0: Intent?): IBinder { return Binder() }

    //--------------------------------------------------
    //  life cycle
    //--------------------------------------------------
    override fun onCreate() {
        super.onCreate()

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onDestroy() {
        super.onDestroy()

        sensorManager.unregisterListener(this)
    }

    //--------------------------------------------------
    //  SenserEventListener
    //--------------------------------------------------
    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSensorChanged(event: SensorEvent?) {
        val x = event?.values?.get(0)
        val y = event?.values?.get(1)
        val z = event?.values?.get(2)
        Log.d("__DEBUG__", "[accelerometer] x=$x y=$y z=$z")
    }
}