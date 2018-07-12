package com.example.goku.caculator;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.BaseInputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FragmentActivity extends Fragment implements View.OnClickListener {
    private EditText edtText;
    private TextView tvResult;
    private Button mBtn0;
    private Button mBtn1;
    private Button mBtn2;
    private Button mBtn3;
    private Button mBtn4;
    private Button mBtn5;
    private Button mBtn6;
    private Button mBtn7;
    private Button mBtn8;
    private Button mBtn9;
    private Button mBtnMul;
    private Button mBtnAdd;
    private Button mBtnSub;
    private Button mBtnDiv;
    private Button mBtnResult;
    private Button mBtnAc;
    private Button mBtnClear;

    public static final String ZERO="0";
    public static final String ONE="1";
    public static final String TWO="2";
    public static final String THREE="3";
    public static final String FOUR="4";
    public static final String FIVE="5";
    public static final String SIX="6";
    public static final String SEVEN="7";
    public static final String EIGHT="8";
    public static final String NINE="9";

    public static final String ADD="+";
    public static final String SUB="-";
    public static final String MUL="x";
    public static final String DIV="/";
    public static final String NULL="";

    private  double result=0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view=inflater.inflate(R.layout.fragment_layout,container,false);
        init(view);
        return view;
    }
    public void init(View view) {
        edtText= view.findViewById(R.id.edtText);
        tvResult=view.findViewById(R.id.tvResult);
        mBtn0 = view.findViewById(R.id.button_0);
        mBtn0.setOnClickListener(this);
        mBtn1 = view.findViewById(R.id.button_1);
        mBtn1.setOnClickListener(this);
        mBtn2 = view.findViewById(R.id.button_2);
        mBtn2.setOnClickListener(this);
        mBtn3 = view.findViewById(R.id.button_3);
        mBtn3.setOnClickListener(this);
        mBtn4 =view.findViewById(R.id.button_4);
        mBtn4.setOnClickListener(this);
        mBtn5 =view.findViewById(R.id.button_5);
        mBtn5.setOnClickListener(this);
        mBtn6 =view.findViewById(R.id.button_6);
        mBtn6.setOnClickListener(this);
        mBtn7 =view.findViewById(R.id.button_7);
        mBtn7.setOnClickListener(this);
        mBtn8 =view.findViewById(R.id.button_8);
        mBtn8.setOnClickListener(this);
        mBtn9 =view.findViewById(R.id.button_9);
        mBtn9.setOnClickListener(this);
        mBtnAdd = view.findViewById(R.id.button_Add);
        mBtnAdd.setOnClickListener(this);
        mBtnSub = view.findViewById(R.id.button_Sub);
        mBtnSub.setOnClickListener(this);
        mBtnMul =view.findViewById(R.id.button_Mul);
        mBtnMul.setOnClickListener(this);
        mBtnDiv = view.findViewById(R.id.button_Div);
        mBtnDiv.setOnClickListener(this);
        mBtnAc = view.findViewById(R.id.button_Ac);
        mBtnAc.setOnClickListener(this);
        mBtnResult =view.findViewById(R.id.button_Result);
        mBtnResult.setOnClickListener(this);
        mBtnClear =view.findViewById(R.id.button_Clear);
        mBtnClear.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_0:
                edtText.append(ZERO);
                break;
            case R.id.button_1:
                edtText.append(ONE);
                break;
            case R.id.button_2:
                edtText.append(TWO);
                break;
            case R.id.button_3:
                edtText.append(THREE);
                break;
            case R.id.button_4:
                edtText.append(FOUR);
                break;
            case R.id.button_5:
                edtText.append(FIVE);
                break;
            case R.id.button_6:
                edtText.append(SIX);
                break;
            case R.id.button_7:
                edtText.append(SEVEN);
                break;
            case R.id.button_8:
                edtText.append(EIGHT);
                break;
            case R.id.button_9:
                edtText.append(NINE);
                break;
            case R.id.button_Add:
                edtText.append(ADD);
                if (!tvResult.getText().toString().isEmpty()){
                    result=Double.parseDouble(tvResult.getText().toString());
                    edtText.setText(tvResult.getText().toString()+ADD);
                }
                break;
            case R.id.button_Sub:
                edtText.append(SUB);
                if (!tvResult.getText().toString().isEmpty()){
                    result=Double.parseDouble(tvResult.getText().toString());
                    edtText.setText(tvResult.getText().toString()+SUB);
                }
                break;
            case R.id.button_Mul:
                edtText.append(MUL);
                if (!tvResult.getText().toString().isEmpty()){
                    result=Double.parseDouble(tvResult.getText().toString());
                    edtText.setText(tvResult.getText().toString()+MUL);
                }
                break;
            case R.id.button_Div:
                edtText.append(DIV);
                if (!tvResult.getText().toString().isEmpty()){
                    result=Double.parseDouble(tvResult.getText().toString());
                    edtText.setText(tvResult.getText().toString()+DIV);
                }
                break;
            case R.id.button_Ac:
                edtText.setText(NULL);
                result=0;
                tvResult.setText(NULL);
                break;
            case R.id.button_Result:
                DecimalFormat df=new DecimalFormat("###.#######");
                addOperator(edtText.getText().toString());
                addNumber(edtText.getText().toString());
                for (int i=0;i<(arrNumber.size()-1);i++){
                    switch (arrOperator.get(i)){
                        case "+":
                            if (i==0) {
                                result = arrNumber.get(i) + arrNumber.get(i + 1);
                            }else {
                                result=result+arrNumber.get(i+1);
                            }
                            break;
                        case "-":
                            if (i==0) {
                                result = arrNumber.get(i) - arrNumber.get(i + 1);
                            }else {
                                result=result-arrNumber.get(i+1);
                            }
                            break;
                        case "x":
                            if (i==0) {
                                result = arrNumber.get(i) * arrNumber.get(i + 1);
                            }else {
                                result=result*arrNumber.get(i+1);
                            }
                            break;
                        case "/":
                            if (i==0) {
                                result = arrNumber.get(i) / arrNumber.get(i + 1);
                            }else {
                                result=result/arrNumber.get(i+1);
                            }
                            break;
                        default:
                            break;
                    }
                    tvResult.setText(df.format(result)+NULL);
                }
                break;
            case R.id.button_Clear:
                BaseInputConnection inputConnection=new BaseInputConnection(edtText,true);
                inputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN,KeyEvent.KEYCODE_DEL));
                result=0;
                tvResult.setText("");
                break;
        }
    }

    public ArrayList<String> arrOperator;
    public ArrayList<Double> arrNumber;

    public int addOperator(String input){
        arrOperator=new ArrayList<>();
        char[] cArray=input.toCharArray();
        for (int i=0;i<cArray.length;i++){
            switch (cArray[i]){
                case '+':
                    arrOperator.add(cArray[i]+NULL);
                    break;
                case '-':
                    arrOperator.add(cArray[i]+NULL);
                    break;
                case '/':
                    arrOperator.add(cArray[i]+NULL);
                    break;
                case 'x':
                    arrOperator.add(cArray[i]+NULL);
                    break;
                default:
                    break;
            }
        }
        return 0;
    }
    public void addNumber(String stringInPut){
        arrNumber=new ArrayList<>();
        Pattern pattern=Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher=pattern.matcher(stringInPut);
        while (matcher.find()){
            arrNumber.add(Double.valueOf(matcher.group(1)));
        }
    }
}
