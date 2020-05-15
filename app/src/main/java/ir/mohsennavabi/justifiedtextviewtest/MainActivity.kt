package ir.mohsennavabi.justifiedtextviewtest

import android.graphics.Paint.Align
import android.os.Bundle
import android.util.TypedValue
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnSeekBarChangeListener {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		initViews()
	}

	private fun initViews() {
		activity_main_sb_size.max = 20
		activity_main_sb_size.progress = 10
		activity_main_sb_size.setOnSeekBarChangeListener(this)

		activity_main_ll_green.setOnClickListener {
			activity_main_jtv.textColor = ContextCompat.getColor(this, R.color.green)
			activity_main_tv.setTextColor(ContextCompat.getColor(this, R.color.green))
		}
		activity_main_ll_red.setOnClickListener {
			activity_main_jtv.textColor = ContextCompat.getColor(this, R.color.red)
			activity_main_tv.setTextColor(ContextCompat.getColor(this, R.color.red))
		}
		activity_main_tv_eng.setOnClickListener {
			activity_main_jtv.alignment = Align.LEFT
			activity_main_jtv.setText(R.string.text_eng)
			activity_main_tv.setText(R.string.text_eng)
		}
		activity_main_tv_fa.setOnClickListener {
			activity_main_jtv.alignment = Align.RIGHT
			activity_main_jtv.setText(R.string.text_fa)
			activity_main_tv.setText(R.string.text_fa)
		}
	}

	/**
	 * Callback from OnSeekBarChangeListener.
	 */
	override fun onStartTrackingTouch(p0: SeekBar?) {}

	/**
	 * Callback from OnSeekBarChangeListener.
	 */
	override fun onStopTrackingTouch(p0: SeekBar?) {}

	/**
	 * Callback from OnSeekBarChangeListener.
	 */
	override fun onProgressChanged(p0: SeekBar?, pos: Int, p2: Boolean) {
		val size = 10
		activity_main_tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, (pos + size).toFloat())
		activity_main_jtv.setTextSize(TypedValue.COMPLEX_UNIT_SP, (pos + size).toFloat())
		activity_main_jtv.setLineSpacing(pos - size)
		activity_main_tv.setLineSpacing((pos - size).toFloat(), 1f)
	}
}
