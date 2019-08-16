package com.example.counteractivity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.PointerIcon;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView editText;
    private int flag = 1;
    private  String result;
    private boolean flag1 = false;
    private StringBuilder add = new StringBuilder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.hide();
        }
        Button button0 = (Button) findViewById(R.id.button_0);
        Button button1 = (Button) findViewById(R.id.button_1);
        Button button2 = (Button) findViewById(R.id.button_2);
        Button button3 = (Button) findViewById(R.id.button_3);
        Button button4 = (Button) findViewById(R.id.button_4);
        Button button5 = (Button) findViewById(R.id.button_5);
        Button button6 = (Button) findViewById(R.id.button_6);
        Button button7 = (Button) findViewById(R.id.button_7);
        Button button8 = (Button) findViewById(R.id.button_8);
        Button button9 = (Button) findViewById(R.id.button_9);
        Button buttonDele = (Button) findViewById(R.id.button_delete);
        Button buttonDiv = (Button) findViewById(R.id.button_div);
        Button buttonEqu = (Button) findViewById(R.id.equ);
        Button buttonC = (Button) findViewById(R.id.button_c);
        Button buttonMul = (Button) findViewById(R.id.button_mul);
        Button buttonSum = (Button) findViewById(R.id.button_sum);
        Button buttonSub = (Button) findViewById(R.id.button_sub);
        Button buttonPoint = (Button) findViewById(R.id.button_point);
        Button left = (Button) findViewById(R.id.left);
        Button right = (Button) findViewById(R.id.right);
        editText = (TextView) findViewById(R.id.edit_text);


        buttonPoint.setOnClickListener(this);
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        left.setOnClickListener(this);
        right.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);
        buttonDele.setOnClickListener(this);
        buttonC.setOnClickListener(this);
        buttonMul.setOnClickListener(this);
        buttonSum.setOnClickListener(this);
        buttonSub.setOnClickListener(this);
        buttonEqu.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        int last = 0;
        if(add.length() != 0) {
            last = add.codePointAt(add.length()-1);
        }
        if(add.length() == 1 && add.charAt(0) == '0') {
            add.deleteCharAt(0);
        }
        switch (view.getId()) {
            case R.id.button_0:
                if(flag1) {
                    add.delete(0,add.length());
                    flag1 = false;
                    add = add.append("0");
                }else if(flag1() == ')') {
                    add = add.append("*0");
                }else{
                    add = add.append("0");
                }
                editText.setText(add);
                break;
            case R.id.button_1:

                if(flag1) {
                    add.delete(0,add.length());
                    flag1 = false;
                    add = add.append("1");
                }else if(flag1() == ')') {
                    add = add.append("*1");
                }else{
                    add = add.append("1");
                }

                editText.setText(add);
                break;
            case R.id.button_2:
                if(flag1) {
                    add.delete(0,add.length());
                    flag1 = false;
                    add = add.append("2");
                }else if(flag1() == ')') {
                    add = add.append("*2");
                }else{
                    add = add.append("2");

                }

                editText.setText(add);
                break;
            case R.id.button_3:
                if(flag1) {
                    add.delete(0,add.length());
                    flag1 = false;
                    add = add.append("3");
                }else if(flag1() == ')') {
                    add = add.append("*3");
                }else{
                    add = add.append("3");
                }

                editText.setText(add);
                break;
            case R.id.button_4:
                if(flag1) {
                    add.delete(0,add.length());
                    flag1 = false;
                    add = add.append("4");
                }else if(flag1() == ')') {
                    add = add.append("*4");
                }else{

                    add = add.append("4");
                }

                editText.setText(add);
                break;
            case R.id.button_5:
                if(flag1) {
                    add.delete(0,add.length());
                    flag1 = false;
                    add = add.append("5");
                }else if(flag1() == ')') {
                    add = add.append("*5");
                }else{
                    add = add.append("5");
                }

                editText.setText(add);
                break;
            case R.id.button_6:
                if(flag1) {
                    add.delete(0,add.length());
                    flag1 = false;
                    add = add.append("6");
                }else if(flag1() == ')') {
                    add = add.append("*6");
                }else{
                    add = add.append("6");
                }

                editText.setText(add);
                break;
            case R.id.button_7:
                if(flag1) {
                    add.delete(0,add.length());
                    flag1 = false;
                    add = add.append("7");
                }else if(flag1() == ')') {
                    add = add.append("*7");
                }else{
                    add = add.append("7");
                }

                editText.setText(add);
                break;
            case R.id.button_8:
                if(flag1) {
                    add.delete(0,add.length());
                    flag1 = false;
                    add = add.append("8");
                }else if(flag1() == ')') {
                    add = add.append("*8");
                }else{

                    add = add.append("8");
                }

                editText.setText(add);
                break;

            case R.id.button_9:
                if(flag1) {
                    add.delete(0,add.length());
                    flag1 = false;
                    add = add.append("9");
                }else if(flag1() == ')') {
                    add = add.append("*9");
                }else{
                    add = add.append("9");
                }

                editText.setText(add);
                break;

            case R.id.button_sub:
                if(flag1) {
                    flag1 = false;
                }
                if(Character.isDigit(flag1()) || flag1() == ')' || flag1() == '('|| flag1() == '+' || flag1() == '*' || flag1() == '/' || flag1() == '.' || add.length() == 0){
                    add = add.append("-");
                    flag = 1;
                    editText.setText(add);
                }
                break;
            case R.id.left:
                if(flag1) {
                    add.delete(0, add.length());
                    flag1 = false;
                    add = add.append("(");

                    editText.setText(add);
                }else if((add.length() >1 && last <= '0' && last >= '9' || last != '(' || last == '(' )&& flag1() == '-'){
                    add.insert(add.length() - 1,"-1*(");
                    add.delete(add.length() - 1,add.length());
                    editText.setText(add);
                } else if(Character.isDigit(flag1())){
                    add = add.append("*(");
                    editText.setText(add);
            }else if( last <= '0' && last >= '9' || last != '(' || last == '(') {
                    add = add.append("(");
                    editText.setText(add);
                }
                break;

            case R.id.right:
                if((last >= '0' && last <= '9' || last == ')') && flag2() == 1) {
                    add = add.append(")");

                    editText.setText(add);
                }
                break;
            case R.id.button_div:
                if(flag1) {
                    flag1 = false;
                }
                if (Character.isDigit(flag1()) || flag1() == ')' || flag1() == '.') {
                    add = add.append("/");
                    flag = 1;
                }
                if(add.length() == 0) {
                    add.append("0/");
                }
                editText.setText(add);
                break;

            case R.id.button_sum:
                if(flag1) {
                    flag1 = false;
                }
                if(Character.isDigit(flag1()) || flag1() == ')' || flag1() == '.'){
                    add = add.append("+");
                    flag = 1;
                    editText.setText(add);
            }
                if(add.length() == 0) {
                    add.append("0+");
                    editText.setText(add);
                }
                break;
            case R.id.button_mul:
                if(flag1) {
                    flag1 = false;
                }
                if (Character.isDigit(flag1()) || flag1() == ')' || flag1() == '.') {
                    add = add.append("*");
                    flag = 1;
                }
                if(add.length() == 0) {
                    add.append("0*");
                }
                editText.setText(add);
                break;
            case R.id.button_delete:
                if (add.length() != 0) {
                    flag = 1;
                    add.delete(add.length() - 1, add.length());
                    editText.setText(add);
                }
                break;
            case R.id.button_point:
                char ch;
                if(add.length() == 0) {
                    ch = '$';
                }
                else{
                    ch = add.charAt(add.length() - 1);
                }
                if(flag1) {
                    add.delete(0,add.length());
                    flag1 = false;
                }
                if(ch == '+' || ch == '-' || ch == '*' || ch == '/' || add.length() == 0) {
                    add.append("0.");
                    flag = 0;
                    editText.setText(add);
                }else if(ch != '.' && flag == 1 && flag1() != ')') {
                    add = add.append(".");
                    flag = 0;
                    editText.setText(add);
                }else if(ch == ')') {
                    add.append("*0.");
                    editText.setText(add);
                }
                break;
            case R.id.button_c:
                flag = 1;
                add.delete(0,add.length());
                editText.setText(add);
                break;
            case R.id.equ:
                if(add.length() > 1) {

                    try{
                        while(flag2() != 0) {
                            add.append(")");
                        }
                        Result r = new Result();
                        String a = r.getString(add);
                        result = r.getResult(a);
                        editText.setText(result);
                        add = add.delete(0,add.length());
                        if(Character.isDigit(result.charAt(0)) || Character.isDigit(result.charAt(1))) {
                            flag1 = true;
                            add = add.append(result);
                        }
                    }catch (Exception e) {
                        result = "错误";
                        editText.setText(result);
                    }
                }
                break;
            default:
                break;
        }
    }
    public char flag1() {
        char ch;
        if(add.length() >= 1) {
             ch = add.charAt(add.length() - 1);
        }else {
             ch = '&';
        }
        return ch;
    }
    public int flag2() {
        int a = 0;
        int b = 0;
        for(int i = 0; i < add.length(); i++) {
            if(add.charAt(i) == '(') {
                a++;
            }
            if(add.charAt(i) == ')') {
                b++;
            }
        }
        if(a == b)
            return 0;
        if(a > b)
            return 1;
        return 2;
    }
}
class Result {
    public String getString(StringBuilder add) {
        HashMap<Character,Integer> hm = new HashMap<>();
        hm.put('(',0);
        hm.put('+',1);
        hm.put('-',1);
        hm.put('*',2);
        hm.put('/',2);
        ArrayList<String> al = new ArrayList<>();
        ArrayList<Character> stack = new ArrayList<>();
        char[] arr = add.substring(0, add.length()).toCharArray();
        String show = "+-*/()";
        char ch;
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            ch = arr[i];
            if(ch == '-' && i == 0 ) {
                al.add("0");
            }
            if (Character.isDigit(ch)) {
                ++ len;
            } else if (ch == '.') {
                ++ len;
            }
            else if(ch == '-' && i != 0 && show.indexOf(arr[i - 1])!= -1 && arr[i - 1] != ')') {
                    ++ len;
            }else if (show.indexOf(ch) != -1) {
                if (len > 0) {
                    al.add(String.valueOf(Arrays.copyOfRange(arr, i - len, i)));
                    len = 0;
                }
                if(ch == '(') {
                    stack.add(ch);
                    continue;
                }
                if(!stack.isEmpty()) {
                    int size = stack.size() - 1;
                    boolean flag = false;
                    while (size >= 0 && ch == ')' && stack.get(size) != '(') {
                        al.add(String.valueOf(stack.remove(size)));
                        size --;//保证一直指向栈顶元素
                        flag = true;
                    }
                    if(ch == ')' && stack.get(size) == '(') {
                        flag = true;
                    }
                    while(size >= 0 && !flag && hm.get(stack.get(size)) >= hm.get(ch)) {
                        al.add(String.valueOf(stack.remove(size)));
                        size --;
                    }
                }
                if(ch != ')') {
                    stack.add(ch);
                }else{
                    stack.remove(stack.size() - 1);//'('出栈
                }
            }
            if(i == arr.length - 1) {
                if(len > 0) {
                    al.add(String.valueOf(Arrays.copyOfRange(arr, i - len+1, i+1)));
                }
                int size = stack.size() - 1;
                while(size >= 0) {
                    al.add(String.valueOf(stack.remove(size)));
                    size --;

                }
            }
        }
        String a = al.toString();
        return a.substring(1,a.length() - 1);
    }


    public String getResult(String string) {
        String[] arr = string.split(",");
        ArrayList<String> list = new ArrayList<>();
       for(int i = 0;i < arr.length; i++) {
            int size = list.size();
            switch (arr[i]) {
                case " -" :
                    BigDecimal a = new BigDecimal(list.remove(size - 2)).subtract(new BigDecimal(list.remove(size - 2)));
                    list.add(a.toString());
                    break;
                case " +" :
                    BigDecimal b = new BigDecimal(list.remove(size - 2)).add(new BigDecimal(list.remove(size - 2)));
                    list.add(b.toString());
                    break;
                case " *" :
                    BigDecimal c = new BigDecimal(list.remove(size - 2)).multiply(new BigDecimal(list.remove(size - 2)));
                    list.add(c.toString());
                    break;
                case " /" :
                    BigDecimal d = new BigDecimal(list.remove(size - 2));
                    BigDecimal d1 = new BigDecimal(list.remove(size - 2));
                    list.add(String.valueOf(d.divide(d1,9, BigDecimal.ROUND_HALF_UP).doubleValue()));
                    break;
                    default:
                    list.add(arr[i].trim());
                    break;
            }
        }
        String line;
        if(list.size() == 1 && list.get(0) != "Infinity") {
           line = list.get(0);
        }else{
            line = "错误";
        }
        return line;
    }
}
