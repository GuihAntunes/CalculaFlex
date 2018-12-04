package br.com.guilhermeantunes.calculaflex

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.guilhermeantunes.calculaflex.extensions.format
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        calculate()
    }

    private fun calculate() {
        val gasPrice = intent.extras.getDouble("GAS_PRICE")
        val gasAverage = intent.extras.getDouble("GAS_AVERAGE")
        val ethanolPrice = intent.extras.getDouble("ETHANOL_PRICE")
        val ethanolAverage = intent.extras.getDouble("ETHANOL_AVERAGE")

        val myCarPerformance = ethanolAverage / gasAverage
        val priceIndex = ethanolPrice / gasPrice

        if (priceIndex <= myCarPerformance) {
            tvSuggestion.text = getString(R.string.label_ethanol)
        } else {
            tvSuggestion.text = getString(R.string.label_gas)
        }

        tvGasAverageResult.text = (gasPrice / gasAverage).format(2)
        tvEthanolAverageResult.text = (ethanolPrice / ethanolAverage).format(2)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
