    package com.example.calculator20


import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.calculator20.databinding.ActivityMainBinding
import net.objecthunter.exp4j.Expression
import org.mozilla.javascript.Context
import org.mozilla.javascript.Scriptable


    class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding
    var lastNumeric = false
    var stateError = false
    var lastDot = false


    private lateinit var expression: Expression
    var data = ""


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        

        val query : TextView = binding.textView
        val result : TextView =binding.textView2

        val btnAc = binding.btnAC
        val btn0 = binding.btn0
        val btn1 = binding.btn1
        val btn2 = binding.btn2
        val btn3 = binding.btn3
        val btn4 = binding.btn4
        val btn5 = binding.btn5
        val btn6 = binding.btn6
        val btn7 = binding.btn7
        val btn8 = binding.btn8
        val btn9 = binding.btn9
        val btnDot = binding.btnDot

        val btnPlus = binding.btnPlus
        val btnMinus = binding.btnMinus
        val btnDiv = binding.btnDIv
        val btnMulti = binding.btnMul
        val btnPlusMinus = binding.btnPlusMInus
        val btnMod = binding.btnMod
        val btnEquals = binding.btnEquals


        btn0.setOnClickListener(){
            @Override
            data = query.getText().toString()
            query.setText(data+"0")
        }

        btn1.setOnClickListener(){
            @Override
            data = query.getText().toString()
            query.setText(data+"1")
        }

        btn2.setOnClickListener(){
            @Override
            data = query.getText().toString()
            query.setText(data+"2")
        }

        btn3.setOnClickListener(){
            @Override
            data = query.getText().toString()
            query.setText(data+"3")
        }

        btn4.setOnClickListener(){
            @Override
            data = query.getText().toString()
            query.setText(data+"4")
        }

        btn5.setOnClickListener(){
            @Override
            data = query.getText().toString()
            query.setText(data+"5")
        }
        btn6.setOnClickListener(){
            @Override
            data = query.getText().toString()
            query.setText(data+"6")
        }
        btn7.setOnClickListener(){
            @Override
            data = query.getText().toString()
            query.setText(data+"7")
        }
        btn8.setOnClickListener(){
            @Override
            data = query.getText().toString()
            query.setText(data+"8")
        }
        btn9.setOnClickListener(){
            @Override
            data = query.getText().toString()
            query.setText(data+"9")
        }

        btnDot.setOnClickListener(){
            @Override
            data = query.getText().toString()
            query.setText(data+".")
        }
        btnPlus.setOnClickListener(){
            @Override
            data = query.getText().toString()
            query.setText(data+"+")
        }
        btnMinus.setOnClickListener(){
            @Override
            data = query.getText().toString()
            query.setText(data+"-")
        }
        btnDiv.setOnClickListener(){
            @Override
            data = query.getText().toString()
            query.setText(data+"/")
        }
        btnMulti.setOnClickListener(){
            @Override
            data = query.getText().toString()
            query.setText(data+"*")
        }
        btnMod.setOnClickListener() {
            @Override
            data = query.getText().toString()
            query.setText(data + "%")
        }
        btnAc.setOnClickListener(){
            @Override
            data = query.getText().toString()
            query.setText("")
            result.setText("")
        }
        btnPlusMinus.setOnClickListener(){
            @Override
            data = query.getText().toString()
            query.setText("-"+data)
        }
        btnEquals.setOnClickListener(){
            @Override
            data = query.getText().toString()

            data = data.replace("×".toRegex(), "*")
            data = data.replace("%".toRegex(), "/100")
            data = data.replace("÷".toRegex(), "/")

            val rhino: Context = Context.enter()
            rhino.setOptimizationLevel(-1)

            var finalResult = ""

            val scriptable: Scriptable = rhino.initStandardObjects()
            finalResult = rhino.evaluateString(scriptable, data, "Javsscript", 1, null).toString()

            result.setText(finalResult)

        }






    }
}

